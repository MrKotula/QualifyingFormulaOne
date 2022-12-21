package ua.foxminded.qualifyingformulaone.app;

import ua.foxminded.qualifyingformulaone.exception.InvalidFileContentException;
import ua.foxminded.qualifyingformulaone.formatter.ViewProviderImpl;
import ua.foxminded.qualifyingformulaone.parser.RacerParserImpl;
import ua.foxminded.qualifyingformulaone.reader.FileReaderImpl;
import ua.foxminded.qualifyingformulaone.validator.ValidatorImpl;

public class FormulaOneConsoleApplication {
    private static final String ABBREVIATIONS_PATH = "src/main/resources/abbreviations.txt";
    private static final String START_LOG_PATH = "src/main/resources/start.log";
    private static final String FINISH_LOG_PATH = "src/main/resources/end.log";

    public static void main(String[] args) throws InvalidFileContentException {
	RacingStatisticsCalculator racingStatisticsCalculator = new RacingStatisticsCalculator(new ValidatorImpl(),
		new FileReaderImpl(), new RacerParserImpl(), new ViewProviderImpl());

	System.out.println(racingStatisticsCalculator.provideStatics(ABBREVIATIONS_PATH, START_LOG_PATH, FINISH_LOG_PATH));
}
}
