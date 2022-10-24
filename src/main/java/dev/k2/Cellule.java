package dev.k2;


import java.util.*;

public class Cellule {

    private List<Cellule> neighbours;
    private LinkedList<Creeper> creepers;
    private int bacteriaAmount;
    private int addedBacteriaAmount;
    private boolean actionFlag;
    LinkedList<Creeper> newbornCreepers;
    public Cellule(boolean actionFlag) {
        this.actionFlag = actionFlag;
        bacteriaAmount = 0;
        addedBacteriaAmount = 0;
        newbornCreepers = new LinkedList<>();
        creepers = new LinkedList<>();
    }

    public void performCreepersAction(ArtificialLifeParameters parameters) {
        newbornCreepers.clear();
        Iterator<Creeper> it=creepers.iterator();
        Creeper creeper;
        while(it.hasNext()){
            creeper = it.next();
            if(actionFlag == creeper.isActionFlag()) {
                creeper.setActionFlag(!actionFlag);
                performCreeperAction(creeper, parameters, it);
            } else {
                break;
            }
        }
        creepers.addAll(newbornCreepers);
    }

    private void performCreeperAction(Creeper creeper, ArtificialLifeParameters parameters, Iterator<Creeper> it) {
        int bornCreepersAmount = (creeper.getEnergy() - parameters.getCreeperRequiredEnergyReserve()) / parameters.getCreeperEnergyRequiredForMultiplication();

        bornCreepersAmount = Math.max(Math.min(bornCreepersAmount, parameters.getCreeperMaxNumberOfBirths()), 0);

        if(bornCreepersAmount > 0){
            bornCreepers(creeper,bornCreepersAmount - 1, parameters);
        }
        if (creeper.getEnergy() >= (parameters.getCreeperEnergyRequiredForMultiplication() + parameters.getCreeperRequiredEnergyReserve())) {
            bornCreepers(creeper, 1, parameters);
        } else {
            if (bacteriaAmount > 0) {//getTotalBacteriaAmount() > 0
                eatBacteria(creeper, parameters);
            } else {
                if(creeper.getEnergy() > 0){
                    moveOrSurviveCreeper(creeper, it);
                } else {
                    it.remove();
                }
            }
        }

    }

    private void bornCreepers(Creeper parent, int creepersAmount, ArtificialLifeParameters parameters) {
        for (int i = 0; i < creepersAmount; i++) {
            newbornCreepers.add(new Creeper(parameters.getCreeperInitialEnergy(), !actionFlag));
        }
        parent.setEnergy(parent.getEnergy() - (parameters.getCreeperEnergyRequiredForMultiplication() * (creepersAmount)));

    }

    private void eatBacteria(Creeper creeper, ArtificialLifeParameters parameters) {
        //int totalBacteriaAmount = getTotalBacteriaAmount();
        int bacteriaEaten = Math.min(parameters.getCreeperMaxBacteriaEaten(), bacteriaAmount);//totalBacteriaAmount

        creeper.setEnergy(creeper.getEnergy() + bacteriaEaten);
        /*
        if(bacteriaEaten > bacteriaAmount) {
            addedBacteriaAmount -= (bacteriaEaten - bacteriaAmount);
            bacteriaAmount = 0;
        } else {
        }*/

        bacteriaAmount -= bacteriaEaten;
    }
    private  void moveOrSurviveCreeper(Creeper creeper, Iterator<Creeper> it) {
        Cellule cellule = neighbours.stream()
                .max(Comparator.comparingInt(cell -> cell.getTotalBacteriaAmount()))
                .get();
        creeper.setEnergy(creeper.getEnergy() - 1);
        if (cellule.getTotalBacteriaAmount() > 0) {
            cellule.addCreeper(creeper);
            it.remove();
        }
    }

    public int getTotalBacteriaAmount() {
        return this.getAddedBacteriaAmount() + this.getBacteriaAmount();
    }

    public void performBacteriaAction(ArtificialLifeParameters parameters, Random random) {
        if (bacteriaAmount > 0){
            int newBacteria = (int) Math.round(bacteriaAmount * parameters.getBacteriaMultiplicationRate());
            int bacteriaStaying = (int) (newBacteria * parameters.getBacteriaSpreadRate());
            this.bacteriaAmount += bacteriaStaying;
            int bacteriaLeftToAdd = (newBacteria - bacteriaStaying);
            int addedBacteria;
            for (int i = 0; i < neighbours.size() - 1; i++) {
                if(bacteriaLeftToAdd == 0){
                    break;
                }
                addedBacteria = random.nextInt(bacteriaLeftToAdd);
                bacteriaLeftToAdd -= addedBacteria;
                neighbours.get(i).addBacteria(addedBacteria);
            }
            neighbours.get(neighbours.size() - 1).addBacteria(bacteriaLeftToAdd);
        }

    }

    public void getBacteriaToDestinationCellule(){
        bacteriaAmount += addedBacteriaAmount;
        addedBacteriaAmount = 0;
    }

    public void addCreeper(Creeper creeper) {
        this.creepers.add(creeper);
    }

    public void addBacteria(int bacteriaAmount) {
        this.addedBacteriaAmount += bacteriaAmount;
    }
    public void removeBacteria(int bacteriaAmount) {
        this.bacteriaAmount -= bacteriaAmount;
    }

    public LinkedList<Creeper> getCreepers() {
        return creepers;
    }

    public void setCreepers(LinkedList<Creeper> creepers) {
        this.creepers = creepers;
    }

    public int getBacteriaAmount() {
        return bacteriaAmount;
    }

    public void setBacteriaAmount(int bacteriaAmount) {
        this.bacteriaAmount = bacteriaAmount;
    }

    public List<Cellule> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(List<Cellule> neighbours) {
        this.neighbours = neighbours;
    }

    public boolean isActionFlag() {
        return actionFlag;
    }

    public void setActionFlag(boolean actionFlag) {
        this.actionFlag = actionFlag;
    }

    public int getAddedBacteriaAmount() {
        return addedBacteriaAmount;
    }

    public void setAddedBacteriaAmount(int addedBacteriaAmount) {
        this.addedBacteriaAmount = addedBacteriaAmount;
    }

    public int getCreeperAmount() {
        return creepers.size();
    }
}
