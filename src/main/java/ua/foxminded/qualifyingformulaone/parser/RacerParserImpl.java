package ua.foxminded.qualifyingformulaone.parser;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import ua.foxminded.qualifyingformulaone.domain.Racer;
import ua.foxminded.qualifyingformulaone.view.RacerParser;

public class RacerParserImpl implements RacerParser {
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.SSS");
    private static final String TEXT_SEPARATOR = "_";
    private static final int PARAMS_POSITION_ABBREVIATION = 0;
    private static final int PARAMS_POSITION_NAME = 1;
    private static final int PARAMS_POSITION_TEAM_NAME = 2;
    private static final int ABBREVIATION_LENGTH = 3;

    @Override
    public List<Racer> createRacer(List<String> abbreviations, List<String> starts, List<String> finish) {
	
	return abbreviations.stream().map(line ->
			Racer.builder()
			.withAbbreviations(getParamPosition(line, PARAMS_POSITION_ABBREVIATION))
			.withName(getParamPosition(line, PARAMS_POSITION_NAME))
			.withTeamName(getParamPosition(line, PARAMS_POSITION_TEAM_NAME))
			.withStartTime(parseDate(starts, getParamPosition(line, PARAMS_POSITION_ABBREVIATION)))
			.withFinishTime(parseDate(finish, getParamPosition(line, PARAMS_POSITION_ABBREVIATION)))
			.build())
			.collect(Collectors.toList());
    }

    private String getParamPosition(String abbreviationLine, int position) {
	
	return abbreviationLine.split(TEXT_SEPARATOR)[position];
    }

    private LocalDateTime parseDate(List<String> logs, String abbreviation) {
	
	return LocalDateTime.parse(
		logs.stream().filter(line -> line.contains(abbreviation))
			.map(line -> line.substring(ABBREVIATION_LENGTH))
			.collect(Collectors.joining("")), TIME_FORMATTER);
    }
}
