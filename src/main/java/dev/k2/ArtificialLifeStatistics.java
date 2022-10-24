package dev.k2;

import java.util.List;

public class ArtificialLifeStatistics {
    private List<TactStatistics> tactStatistics;
    private boolean prematureEndOfSimulation;

    public ArtificialLifeStatistics(List<TactStatistics> tactStatistics, boolean prematureEndOfSimulation) {
        this.tactStatistics = tactStatistics;
        this.prematureEndOfSimulation = prematureEndOfSimulation;
    }

    public List<TactStatistics> getTactStatistics() {
        return tactStatistics;
    }

    public boolean isPrematureEndOfSimulation() {
        return prematureEndOfSimulation;
    }

}
