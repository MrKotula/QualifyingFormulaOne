package ua.foxminded.qualifyingformulaone.parser;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import ua.foxminded.qualifyingformulaone.domain.Racer;
import ua.foxminded.qualifyingformulaone.view.RacerParser;

class RacerParserTest {
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.SSS");

    RacerParser parser = new RacerParserImpl();

    @Test
    void createRacerShouldCorrectParsingLogString() {
        List<Racer> racersTest = parser.createRacer(
        	Arrays.asList("CSR_Carlos Sainz_RENAULT", "DRR_Daniel Ricciardo_RED BULL RACING TAG HEUER", "VBM_Valtteri Bottas_MERCEDES"),
                Arrays.asList("CSR2018-05-24_12:03:15.145", "DRR2018-05-24_12:14:12.054", "VBM2018-05-24_12:00:00.000"),
                Arrays.asList("CSR2018-05-24_12:04:28.095", "DRR2018-05-24_12:15:24.067", "VBM2018-05-24_12:01:12.434"));
        List<Racer> racers = new ArrayList<>();
        
        racers.add(Racer.builder().withAbbreviations("CSR").withName("Carlos Sainz")
                .withTeamName("RENAULT")
                .withStartTime(LocalDateTime.parse("2018-05-24_12:03:15.145", TIME_FORMATTER))
                .withFinishTime(LocalDateTime.parse("2018-05-24_12:04:28.095", TIME_FORMATTER))
                .build());
        racers.add(Racer.builder().withAbbreviations("DRR").withName("Daniel Ricciardo")
                .withTeamName("RED BULL RACING TAG HEUER")
                .withStartTime(LocalDateTime.parse("2018-05-24_12:14:12.054", TIME_FORMATTER))
                .withFinishTime(LocalDateTime.parse("2018-05-24_12:15:24.067", TIME_FORMATTER))
                .build());
        racers.add(Racer.builder().withAbbreviations("VBM").withName("Valtteri Bottas")
                .withTeamName("MERCEDES")
                .withStartTime(LocalDateTime.parse("2018-05-24_12:00:00.000", TIME_FORMATTER))
                .withFinishTime(LocalDateTime.parse("2018-05-24_12:01:12.434", TIME_FORMATTER))
                .build());
        assertEquals(racersTest, racers);
    }
}
