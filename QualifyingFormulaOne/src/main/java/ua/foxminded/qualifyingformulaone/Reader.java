package ua.foxminded.qualifyingformulaone;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Reader {
    private static final String ABBREVIATIONS_PATH = "src/main/resources/abbreviations.txt";
    private static final String START_LOG_PATH = "src/main/resources/start.log";
    private static final String END_LOG_PATH = "src/main/resources/end.log";
    private static final String TEXT_SEPARATOR = "_";
    private static final StringBuilder RESULT = new StringBuilder();

    public static String readFile(String path) throws IOException {
	try (BufferedReader reader = new BufferedReader(new FileReader(new File(path)))) {
	    return reader.lines().collect(Collectors.joining(System.lineSeparator()));
	}
    }

    public static <T> List<T> convertToList(T[] arr) {
	return Stream.of(arr).collect(Collectors.toList());
    }

    public static String getRacersNames(String content) {
	String[] contentFromFile = content.split(TEXT_SEPARATOR);
	int lineCounter = 0;
	List<String> list = convertToList(contentFromFile);
	List<String> racers = new ArrayList<>();
	List<String> others = new ArrayList<>();

	for (String word : list) {
	    lineCounter++;
	    if (lineCounter % 2 == 0) {
		racers.add(word);
	    } else {
		others.add(word);
		
	    }

	}
	//String[] otherArr = others.toArray(new String[others.size()]);

	for (String word : others) {
	    
	    System.out.println(word + " " + word.length());
	}

	return racers.toString();
    }

    public Map<String, LocalTime> getStartTime(String content) {
	Map<String, LocalTime> startTime = new LinkedHashMap<>();
	return startTime;
    }

    public static void main(String[] args) throws IOException {
	// System.out.println(readFile(ABBREVIATIONS_PATH) + "\n");
	getRacersNames(readFile(ABBREVIATIONS_PATH));

    }
}