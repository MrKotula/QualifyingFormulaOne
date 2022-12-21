package ua.foxminded.qualifyingformulaone.validator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import ua.foxminded.qualifyingformulaone.exception.InvalidFileContentException;
import ua.foxminded.qualifyingformulaone.view.FileValidator;

class ValidatorImplTest {
    private static final String ABBREVIATIONS_PATH = "src/test/java/resources/test_abbreviations.txt";
    private static final String START_LOG_PATH = "src/test/java/resources/test_start.log";
    private static final String FINISH_LOG_PATH = "src/test/java/resources/test_end.log";
    private static final String WRONG_ABBREVIATIONS_PATH = "src/test/java/resources/Wwwrong_abbreviations.txt";

    FileValidator validator = new ValidatorImpl();
    
    @Test
    void validatorShouldThrowsAnExceptionIfFinishArgumentWrong() throws InvalidFileContentException {
	Throwable throwable = assertThrows(InvalidFileContentException.class, () -> validator.validate(ABBREVIATIONS_PATH, START_LOG_PATH, WRONG_ABBREVIATIONS_PATH));
	assertEquals("file was not found. Please check path.", throwable.getMessage());
    }
    
    @Test
    void validatorShouldThrowsAnExceptionIfStartArgumentWrong() throws InvalidFileContentException {
	Throwable throwable = assertThrows(InvalidFileContentException.class, () -> validator.validate(ABBREVIATIONS_PATH, WRONG_ABBREVIATIONS_PATH, FINISH_LOG_PATH));
	assertEquals("file was not found. Please check path.", throwable.getMessage());
    }
    
    @Test
    void validatorShouldThrowsAnExceptionIfAbbreviatoinsArgumentWrong() throws InvalidFileContentException {
	Throwable throwable = assertThrows(InvalidFileContentException.class, () -> validator.validate(WRONG_ABBREVIATIONS_PATH, START_LOG_PATH, FINISH_LOG_PATH));
	assertEquals("file was not found. Please check path.", throwable.getMessage());
    }
    
    @Test
    void validatorShouldNotThrowsAnExceptionIfFilesCorrectValidatorImpls() throws InvalidFileContentException {
	assertDoesNotThrow(() -> validator.validate(ABBREVIATIONS_PATH, START_LOG_PATH, FINISH_LOG_PATH));
    }
}
