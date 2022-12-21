package ua.foxminded.qualifyingformulaone.reader;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

import ua.foxminded.qualifyingformulaone.view.FileReader;

class FileReaderImplTest {
    FileReader reader = new FileReaderImpl();
  
        @Test
        void readShouldReturnExceptionIfInputFileIsNull() {
            Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
                  reader.read(null);
                });
            assertEquals("the file can't be null", exception.getMessage());
        }

        @Test
        void readShouldReturnExceptionIfInputFileIsDoesNotExist(){
            Throwable exception = assertThrows(IllegalArgumentException.class, () ->{
                reader.read("");
            });
            assertEquals("Bad filePath. Please check it.", exception.getMessage());
        }

        @Test
        void readShouldReturnListWithStringExpected() throws IOException {
            List<String> expected = Arrays.asList("NHR_Nico Hulkenberg_RENAULT");
            List<String> result = reader.read("src/test/java/resources/test_abbreviations.txt");
            assertEquals(expected, result);
        }
}
