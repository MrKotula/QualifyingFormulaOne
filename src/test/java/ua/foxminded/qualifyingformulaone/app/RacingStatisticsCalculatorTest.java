package ua.foxminded.qualifyingformulaone.app;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.foxminded.qualifyingformulaone.domain.Racer;
import ua.foxminded.qualifyingformulaone.exception.InvalidFileContentException;
import ua.foxminded.qualifyingformulaone.view.FileReader;
import ua.foxminded.qualifyingformulaone.view.FileValidator;
import ua.foxminded.qualifyingformulaone.view.RacerParser;
import ua.foxminded.qualifyingformulaone.view.ViewProvider;

@ExtendWith(MockitoExtension.class)
class RacingStatisticsCalculatorTest {
    private static final String ABBREVIATIONS_PATH = "src/test/java/resources/test_abbreviations.txt";
    private static final String START_LOG_PATH = "src/test/java/resources/test_start.log";
    private static final String FINISH_LOG_PATH = "src/test/java/resources/test_end.log";
    private static final String TEST_RACER = "1. Sebastian Vettel  | FERRARI                   | 01:04.415";
    private static final String WRONG_ABBREVIATIONS_PATH = "src/test/java/resources/wrong_abbreviations.txt";

    @Mock
    FileValidator mockedValidator;
    
    @Mock
    FileReader mockedReader;

    @Mock
    RacerParser mockedParser;

    @Mock
    ViewProvider mockedViewProvider;

    @InjectMocks
    RacingStatisticsCalculator raceCalculator;
    
    List<String> abbreviations;
    List<String> starts;
    List<String> finish;
    List<Racer> racers;

    @Test
    void provideStaticsTestRacingStatisticsCalculator() throws InvalidFileContentException {
        abbreviations = mockedReader.read(ABBREVIATIONS_PATH);
        starts = mockedReader.read(START_LOG_PATH);
        finish = mockedReader.read(FINISH_LOG_PATH);
        racers = mockedParser.createRacer(abbreviations, starts, finish);

        when(raceCalculator.provideStatics(ABBREVIATIONS_PATH, START_LOG_PATH, FINISH_LOG_PATH)).thenReturn(TEST_RACER);
        assertEquals(TEST_RACER, raceCalculator.provideStatics(ABBREVIATIONS_PATH, START_LOG_PATH, FINISH_LOG_PATH));
        
        InOrder inOrder = inOrder(mockedValidator, mockedReader, mockedParser, mockedViewProvider);
        inOrder.verify(mockedReader).read(ABBREVIATIONS_PATH);
        inOrder.verify(mockedValidator).validate(ABBREVIATIONS_PATH, START_LOG_PATH, FINISH_LOG_PATH);
        inOrder.verify(mockedParser).createRacer(abbreviations, starts, finish);
        inOrder.verify(mockedViewProvider).format(racers, 15);
    }
    
    @Test
    void validateShouldThrowsAnExceptionFileNotExistsValidatorImpl() throws InvalidFileContentException {
       doThrow(InvalidFileContentException.class).when(mockedValidator).validate(WRONG_ABBREVIATIONS_PATH, START_LOG_PATH, FINISH_LOG_PATH);
       assertThrows(InvalidFileContentException.class, () -> raceCalculator.provideStatics(WRONG_ABBREVIATIONS_PATH, START_LOG_PATH, FINISH_LOG_PATH));
       verify(mockedValidator).validate(WRONG_ABBREVIATIONS_PATH, START_LOG_PATH, FINISH_LOG_PATH);
       verify(mockedReader, never()).read(START_LOG_PATH);
       verify(mockedParser, never()).createRacer(abbreviations, starts, finish);
       verify(mockedViewProvider, never()).format(racers, 15);
    }
}
