package dev.k2;

public class Creeper {

    int energy;
    boolean actionFlag;

    public Creeper(int energy, boolean actionFlag) {
        this.energy = energy;
        this.actionFlag = actionFlag;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public boolean isActionFlag() {
        return actionFlag;
    }

    public void setActionFlag(boolean actionFlag) {
        this.actionFlag = actionFlag;
    }
}
