package dev.k2;

public class ArtificialLifeParameters {
    private int creepersInitialAmount;
    private int bacteriaInitialAmount;
    private int creeperEnergyRequiredForMultiplication;
    private int creeperInitialEnergy;
    private int creeperRequiredEnergyReserve;
    private int creeperMaxNumberOfBirths;
    private int creeperMaxBacteriaEaten;
    private double bacteriaMultiplicationRate;
    private double bacteriaSpreadRate;

    public ArtificialLifeParameters(
            int creepersInitialAmount,
            int bacteriaInitialAmount,
            int creeperEnergyRequiredForMultiplication,
            int creeperInitialEnergy,
            int creeperRequiredEnergyReserve,
            int creeperMaxNumberOfBirths,
            int creeperMaxBacteriaEaten,
            double bacteriaMultiplicationRate,
            double bacteriaSpreadRate
    ) {
        this.creepersInitialAmount = creepersInitialAmount;
        this.bacteriaInitialAmount = bacteriaInitialAmount;
        this.creeperEnergyRequiredForMultiplication = creeperEnergyRequiredForMultiplication;
        this.creeperInitialEnergy = creeperInitialEnergy;
        this.creeperRequiredEnergyReserve = creeperRequiredEnergyReserve;
        this.creeperMaxNumberOfBirths = creeperMaxNumberOfBirths;
        this.creeperMaxBacteriaEaten = creeperMaxBacteriaEaten;
        this.bacteriaMultiplicationRate = bacteriaMultiplicationRate;
        this.bacteriaSpreadRate = bacteriaSpreadRate;

    }

    public ArtificialLifeParameters() {
    }

    public int getCreepersInitialAmount() {
        return creepersInitialAmount;
    }

    public void setCreepersInitialAmount(int creepersInitialAmount) {
        this.creepersInitialAmount = creepersInitialAmount;
    }

    public int getBacteriaInitialAmount() {
        return bacteriaInitialAmount;
    }

    public void setBacteriaInitialAmount(int bacteriaInitialAmount) {
        this.bacteriaInitialAmount = bacteriaInitialAmount;
    }

    public int getCreeperEnergyRequiredForMultiplication() {
        return creeperEnergyRequiredForMultiplication;
    }

    public void setCreeperEnergyRequiredForMultiplication(int creeperEnergyRequiredForMultiplication) {
        this.creeperEnergyRequiredForMultiplication = creeperEnergyRequiredForMultiplication;
    }

    public int getCreeperInitialEnergy() {
        return creeperInitialEnergy;
    }

    public void setCreeperInitialEnergy(int creeperInitialEnergy) {
        this.creeperInitialEnergy = creeperInitialEnergy;
    }

    public int getCreeperRequiredEnergyReserve() {
        return creeperRequiredEnergyReserve;
    }

    public void setCreeperRequiredEnergyReserve(int creeperRequiredEnergyReserve) {
        this.creeperRequiredEnergyReserve = creeperRequiredEnergyReserve;
    }

    public int getCreeperMaxNumberOfBirths() {
        return creeperMaxNumberOfBirths;
    }

    public void setCreeperMaxNumberOfBirths(int creeperMaxNumberOfBirths) {
        this.creeperMaxNumberOfBirths = creeperMaxNumberOfBirths;
    }

    public int getCreeperMaxBacteriaEaten() {
        return creeperMaxBacteriaEaten;
    }

    public void setCreeperMaxBacteriaEaten(int creeperMaxBacteriaEaten) {
        this.creeperMaxBacteriaEaten = creeperMaxBacteriaEaten;
    }

    public double getBacteriaMultiplicationRate() {
        return bacteriaMultiplicationRate;
    }

    public void setBacteriaMultiplicationRate(double bacteriaMultiplicationRate) {
        this.bacteriaMultiplicationRate = bacteriaMultiplicationRate;
    }

    public double getBacteriaSpreadRate() {
        return bacteriaSpreadRate;
    }

    public void setBacteriaSpreadRate(double bacteriaSpreadRate) {
        this.bacteriaSpreadRate = bacteriaSpreadRate;
    }


    @Override
    public String toString() {
        return "ArtificialLifeParams{" +
                creepersInitialAmount +
                "," + bacteriaInitialAmount +
                "," + creeperEnergyRequiredForMultiplication +
                "," + creeperInitialEnergy +
                "," + creeperRequiredEnergyReserve +
                "," + creeperMaxNumberOfBirths +
                "," + creeperMaxBacteriaEaten +
                "," + bacteriaMultiplicationRate +
                "," + bacteriaSpreadRate +
                '}';
    }
}