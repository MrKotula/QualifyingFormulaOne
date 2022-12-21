package ua.foxminded.qualifyingformulaone.validator;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import ua.foxminded.qualifyingformulaone.exception.InvalidFileContentException;
import ua.foxminded.qualifyingformulaone.view.FileValidator;

public class ValidatorImpl implements FileValidator {
    
    @Override
    public void validate(String abbreviationFilePath, String startLogFilePath, String finishLogFilePath) throws InvalidFileContentException {
        final File abbreviation = getPath(abbreviationFilePath).toFile();
        final File startLog = getPath(startLogFilePath).toFile();
        final File finishLog = getPath(finishLogFilePath).toFile();
        
        if (!abbreviation.exists() ||
                !startLog.exists() ||
                !finishLog.exists()) {
            throw new InvalidFileContentException("file was not found. Please check path.");
        } 
    }

    private Path getPath(String fileName) {
        return Paths.get(fileName);
    }
}
