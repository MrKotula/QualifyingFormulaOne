package ua.foxminded.qualifyingformulaone.view;

import java.util.List;
import ua.foxminded.qualifyingformulaone.domain.Racer;

public interface ViewProvider {
    String format(List<Racer> racers, int bestRacersNumber);
}
