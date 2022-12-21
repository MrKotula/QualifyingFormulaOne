package ua.foxminded.qualifyingformulaone.formatter;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import ua.foxminded.qualifyingformulaone.domain.Racer;
import ua.foxminded.qualifyingformulaone.view.ViewProvider;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

public class ViewProviderImpl implements ViewProvider {
    private static final String HYPHEN_DELIMITER = "-";
    private static final String EMPTY_SYMBOL = " ";
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("mm:ss.SSS");
    private static final int POSITION_FORMAT_FOR_SINGLE_NUMBERS = 9;
    private static final int FORMAT_VIEW_FOR_HYPHEN_DELIMITER = 19;

    @Override
    public String format(List<Racer> racers, int bestRacersNumber) {
	StringBuilder result = new StringBuilder();
	int maxNameLength = getMaxFieldLength(racers, Racer::getName);
	int maxTeamLength = getMaxFieldLength(racers, Racer::getTeamName);
	AtomicInteger number = new AtomicInteger();
	String pattern = "%d. %-" + maxNameLength + "s | %-" + maxTeamLength + "s | %s";
	racers.stream().sorted(Comparator.comparing(Racer::getResultRacing)).forEach(racer -> { 
	    if ((number.get() < POSITION_FORMAT_FOR_SINGLE_NUMBERS)) {
		result.append(EMPTY_SYMBOL);
	    }
	    if ((number.get() == bestRacersNumber)) {
		result.append(repeatChar(maxNameLength + maxTeamLength + FORMAT_VIEW_FOR_HYPHEN_DELIMITER)).append(System.lineSeparator());
	    }
	    result.append(String.format(pattern, number.incrementAndGet(), racer.getName(), racer.getTeamName(),
		    formatToTime(getResultRacing(racer.getStartTime(), racer.getFinishTime())))).append(System.lineSeparator());
	});
	
	return result.toString();
    }
    
    private Duration getResultRacing(LocalDateTime startTime, LocalDateTime finishTime) {
	return Duration.between(startTime, finishTime);
    }

    private String repeatChar(int times) {
	return Stream.generate(() -> HYPHEN_DELIMITER).limit(times).collect(Collectors.joining());
    }

    private int getMaxFieldLength(List<Racer> racers, Function<Racer, String> function) {
	return racers.stream().map(function).mapToInt(String::length).max().orElse(0);
    }

    private String formatToTime(Duration duration) {
	return LocalTime.ofNanoOfDay(duration.toNanos()).format(TIME_FORMATTER);
    }
}
