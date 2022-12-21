package ua.foxminded.qualifyingformulaone.view;

import java.util.List;
import ua.foxminded.qualifyingformulaone.domain.Racer;

public interface RacerParser {
    List<Racer> createRacer(List<String> abbreviationsRacers, List<String> startList, List<String> finishList);
}
