package ua.foxminded.qualifyingformulaone.view;

import ua.foxminded.qualifyingformulaone.exception.InvalidFileContentException;

public interface FileValidator {
    void validate(String abbreviationFilePath, String startLogFilePath, String endLogFilePath) throws InvalidFileContentException;
}
