package ua.foxminded.qualifyingformulaone.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import ua.foxminded.qualifyingformulaone.view.FileReader;

public class FileReaderImpl implements FileReader {
    private static final String EXCEPTION_WRONG_FILE_PATH = "Bad filePath. Please check it.";

    @Override
    public List<String> read(String fileName) {
	try {
	    if (fileName == null){
	            throw new IllegalArgumentException("the file can't be null");
	        }
	    
	    return Files.lines(Paths.get(fileName)).collect(Collectors.toList());
	} catch (IOException e) {
	    throw new IllegalArgumentException(EXCEPTION_WRONG_FILE_PATH, e);
	}
    }
}
