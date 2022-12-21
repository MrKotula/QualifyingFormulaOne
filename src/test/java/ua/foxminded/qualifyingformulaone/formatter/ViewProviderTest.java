package ua.foxminded.qualifyingformulaone.formatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import ua.foxminded.qualifyingformulaone.domain.Racer;
import ua.foxminded.qualifyingformulaone.view.ViewProvider;

class ViewProviderTest {
    private static final String NEW_LINE = System.getProperty("line.separator");
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.SSS");
    
    ViewProvider formatter = new ViewProviderImpl();
    
    @Test
    void formatShouldReturnResult() {
        List<Racer> racers = new ArrayList<>();
        racers.add(Racer.builder()
        	.withAbbreviations("CSR")
        	.withName("Carlos Sainz")
        	.withTeamName("RENAULT")
        	.withStartTime(LocalDateTime.parse("2018-05-24_12:03:15.145", TIME_FORMATTER))
        	.withFinishTime(LocalDateTime.parse("2018-05-24_12:04:28.095", TIME_FORMATTER))
        	.build());
        racers.add(Racer.builder()
        	.withAbbreviations("DRR")
        	.withName("Daniel Ricciardo")
        	.withTeamName("RED BULL RACING TAG HEUER")
        	.withStartTime(LocalDateTime.parse("2018-05-24_12:14:12.054", TIME_FORMATTER))
        	.withFinishTime(LocalDateTime.parse("2018-05-24_12:15:24.067", TIME_FORMATTER))
        	.build());
        racers.add(Racer.builder()
        	.withAbbreviations("NHR")
        	.withName("Nico Hulkenberg")
        	.withTeamName("RENAULT")
        	.withStartTime(LocalDateTime.parse("2018-05-24_12:02:49.914", TIME_FORMATTER))
        	.withFinishTime(LocalDateTime.parse("2018-05-24_12:04:02.979", TIME_FORMATTER))
        	.build());
        racers.add(Racer.builder()
        	.withAbbreviations("NHR")
        	.withName("Nico Hulkenberg")
        	.withTeamName("RENAULT")
        	.withStartTime(LocalDateTime.parse("2018-05-24_12:02:49.914", TIME_FORMATTER))
        	.withFinishTime(LocalDateTime.parse("2018-05-24_12:04:02.979", TIME_FORMATTER))
        	.build());
        racers.add(Racer.builder()
        	.withAbbreviations("NHR")
        	.withName("Nico Hulkenberg")
        	.withTeamName("RENAULT")
        	.withStartTime(LocalDateTime.parse("2018-05-24_12:02:49.914", TIME_FORMATTER))
        	.withFinishTime(LocalDateTime.parse("2018-05-24_12:04:02.979", TIME_FORMATTER))
        	.build());
        racers.add(Racer.builder()
        	.withAbbreviations("NHR")
        	.withName("Nico Hulkenberg")
        	.withTeamName("RENAULT")
        	.withStartTime(LocalDateTime.parse("2018-05-24_12:02:49.914", TIME_FORMATTER))
        	.withFinishTime(LocalDateTime.parse("2018-05-24_12:04:02.979", TIME_FORMATTER))
        	.build());
        racers.add(Racer.builder()
        	.withAbbreviations("NHR")
        	.withName("Nico Hulkenberg")
        	.withTeamName("RENAULT")
        	.withStartTime(LocalDateTime.parse("2018-05-24_12:02:49.914", TIME_FORMATTER))
        	.withFinishTime(LocalDateTime.parse("2018-05-24_12:04:02.979", TIME_FORMATTER))
        	.build());
        racers.add(Racer.builder()
        	.withAbbreviations("NHR")
        	.withName("Nico Hulkenberg")
        	.withTeamName("RENAULT")
        	.withStartTime(LocalDateTime.parse("2018-05-24_12:02:49.914", TIME_FORMATTER))
        	.withFinishTime(LocalDateTime.parse("2018-05-24_12:04:02.979", TIME_FORMATTER))
        	.build());
        racers.add(Racer.builder()
        	.withAbbreviations("NHR")
        	.withName("Nico Hulkenberg")
        	.withTeamName("RENAULT")
        	.withStartTime(LocalDateTime.parse("2018-05-24_12:02:49.914", TIME_FORMATTER))
        	.withFinishTime(LocalDateTime.parse("2018-05-24_12:04:02.979", TIME_FORMATTER))
        	.build());
        racers.add(Racer.builder()
        	.withAbbreviations("NHR")
        	.withName("Nico Hulkenberg")
        	.withTeamName("RENAULT")
        	.withStartTime(LocalDateTime.parse("2018-05-24_12:02:49.914", TIME_FORMATTER))
        	.withFinishTime(LocalDateTime.parse("2018-05-24_12:04:02.979", TIME_FORMATTER))
        	.build());
        racers.add(Racer.builder()
        	.withAbbreviations("NHR")
        	.withName("Nico Hulkenberg")
        	.withTeamName("RENAULT")
        	.withStartTime(LocalDateTime.parse("2018-05-24_12:02:49.914", TIME_FORMATTER))
        	.withFinishTime(LocalDateTime.parse("2018-05-24_12:04:02.979", TIME_FORMATTER))
        	.build());
        
        StringBuilder expected = new StringBuilder();
        expected.append(" 1. Daniel Ricciardo | RED BULL RACING TAG HEUER | 01:12.013" + NEW_LINE);
        expected.append(" 2. Carlos Sainz     | RENAULT                   | 01:12.950" + NEW_LINE);
        expected.append(" 3. Nico Hulkenberg  | RENAULT                   | 01:13.065" + NEW_LINE);
        expected.append(" 4. Nico Hulkenberg  | RENAULT                   | 01:13.065" + NEW_LINE);
        expected.append(" 5. Nico Hulkenberg  | RENAULT                   | 01:13.065" + NEW_LINE);
        expected.append(" 6. Nico Hulkenberg  | RENAULT                   | 01:13.065" + NEW_LINE);
        expected.append(" 7. Nico Hulkenberg  | RENAULT                   | 01:13.065" + NEW_LINE);
        expected.append(" 8. Nico Hulkenberg  | RENAULT                   | 01:13.065" + NEW_LINE);
        expected.append(" 9. Nico Hulkenberg  | RENAULT                   | 01:13.065" + NEW_LINE);
        expected.append("10. Nico Hulkenberg  | RENAULT                   | 01:13.065" + NEW_LINE);
        expected.append("------------------------------------------------------------" + NEW_LINE);
        expected.append("11. Nico Hulkenberg  | RENAULT                   | 01:13.065" + NEW_LINE);
     
        assertEquals(expected.toString(), formatter.format(racers, 10));
    }
}
