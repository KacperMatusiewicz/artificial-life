package dev.k2;

public class TactStatistics {
    private int bacteriaAmount;
    private int creeperAmount;
    private boolean criticalBacteriaLimitReached;

    public TactStatistics(int bacteriaAmount, int creeperAmount, boolean criticalBacteriaLimitReached) {
        this.bacteriaAmount = bacteriaAmount;
        this.creeperAmount = creeperAmount;
        this.criticalBacteriaLimitReached = criticalBacteriaLimitReached;
    }

    public int getBacteriaAmount() {
        return bacteriaAmount;
    }

    public int getCreeperAmount() {
        return creeperAmount;
    }

    public boolean isCriticalBacteriaLimitReached() {
        return criticalBacteriaLimitReached;
    }

}
