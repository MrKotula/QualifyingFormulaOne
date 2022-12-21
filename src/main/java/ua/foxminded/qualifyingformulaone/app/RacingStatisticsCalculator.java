package ua.foxminded.qualifyingformulaone.app;

import java.util.List;
import ua.foxminded.qualifyingformulaone.domain.Racer;
import ua.foxminded.qualifyingformulaone.exception.InvalidFileContentException;
import ua.foxminded.qualifyingformulaone.view.FileReader;
import ua.foxminded.qualifyingformulaone.view.FileValidator;
import ua.foxminded.qualifyingformulaone.view.RacerParser;
import ua.foxminded.qualifyingformulaone.view.ViewProvider;

public class RacingStatisticsCalculator {
    private static final int LINE_OF_DIVIDER_FOR_WINNERS = 15;
    
    private final FileValidator fileValidator;
    private final FileReader reader;
    private final RacerParser racerParser;
    private final ViewProvider viewProvider;

    public RacingStatisticsCalculator(FileValidator fileValidator, FileReader reader,
                                      RacerParser racerParser, ViewProvider viewProvider) {
        this.fileValidator = fileValidator;
        this.reader = reader;
        this.racerParser = racerParser;
        this.viewProvider = viewProvider;
    }

    public String provideStatics(String abbreviationFilePath, String startsFilePath, String endFilePath) throws InvalidFileContentException {
        fileValidator.validate(abbreviationFilePath, startsFilePath, endFilePath);

        List<String> abbreviations = reader.read(abbreviationFilePath);
        List<String> starts = reader.read(startsFilePath);
        List<String> finish = reader.read(endFilePath);

        List<Racer> racers = racerParser.createRacer(abbreviations, starts, finish);
         
        return viewProvider.format(racers, LINE_OF_DIVIDER_FOR_WINNERS);
    }
}
