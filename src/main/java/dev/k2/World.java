package dev.k2;

import model.ArtificialLifeParameters;

import java.util.*;

public class World {

    private Cellule[][] world;
    private int worldSize;
    private int bacteriaAmount;
    private int creeperAmount;
    private boolean currentActionFlagValue;
    private Random random;
    private ArtificialLifeParameters parameters;
    private boolean criticalLimitReached;
    private int criticalBacteriaLimit;
    private int criticalCreeperLimit;
    private final int seed;

    public World(int worldSize, int criticalBacteriaLimit, int criticalCreeperLimit, int seed) {
        this.currentActionFlagValue = true;
        this.worldSize = worldSize;
        this.world = new Cellule[worldSize][worldSize];
        initCellules();
        setCellulesNeighbours();
        this.seed = seed;
        random = new Random(seed);
        this.criticalBacteriaLimit = criticalBacteriaLimit;
        this.criticalCreeperLimit = criticalCreeperLimit;
    }

    public void setSimulatonParameters(ArtificialLifeParameters parameters) {
        this.parameters = parameters;
    }

    public void initializeNewWorld() {
        random = new Random(seed);
        criticalLimitReached = false;
        bacteriaAmount = 0;
        creeperAmount = 0;
        int randomBacteria;
        for (int i = 0; i < worldSize; i++) {
            for (int j = 0; j < worldSize; j++) {
                world[i][j].setBacteriaAmount(0);
                world[i][j].setAddedBacteriaAmount(0);
                world[i][j].setCreepers(new LinkedList<>());
            }
        }
        int i = 0;
        int j = 0;
        while (this.bacteriaAmount < parameters.getBacteriaInitialAmount()) {
            i = random.nextInt(worldSize);
            j = random.nextInt(worldSize);
            randomBacteria = random.nextInt(worldSize);
            world[i][j].addBacteria(randomBacteria);
            bacteriaAmount += randomBacteria;
        }
        while (this.creeperAmount < parameters.getCreepersInitialAmount()) {
            i = random.nextInt(worldSize);
            j = random.nextInt(worldSize);
            world[i][j].addCreeper(new Creeper(parameters.getCreeperInitialEnergy(), currentActionFlagValue));
            creeperAmount++;
        }
    }

    public void nextTact() {

        LinkedList<Cellule> cellules = new LinkedList<>();

        for(Cellule[] cellulesArray : world){
            cellules.addAll(Arrays.asList(cellulesArray));
        }

        Collections.shuffle(cellules);

        Cellule cellule;

        while (!cellules.isEmpty()) {
            cellule = cellules.pop();
            if(random.nextBoolean()) {
                cellule.performBacteriaAction(parameters, random);
                cellule.performCreepersAction(parameters);
                cellule.setActionFlag(!currentActionFlagValue);

            } else {
                cellule.performCreepersAction(parameters);
                cellule.performBacteriaAction(parameters, random);
                cellule.setActionFlag(!currentActionFlagValue);
            }
            cellule.getBacteriaToDestinationCellule();
        }

        currentActionFlagValue = !currentActionFlagValue;
        updateBacteriaAndCreepersAmounts();
        if(bacteriaAmount > criticalBacteriaLimit || bacteriaAmount == 0 || creeperAmount == 0 || creeperAmount > criticalCreeperLimit) {
            criticalLimitReached = true;
        }
    }

    private void initCellules() {
        for (int i = 0; i < worldSize; i++) {
            for (int j = 0; j < worldSize; j++) {
                world[i][j] = new Cellule(currentActionFlagValue);
            }
        }
    }

    private void setCellulesNeighbours() {
        for (int i = 0; i < worldSize; i++) {
            for (int j = 0; j < worldSize; j++) {
                List<Cellule> neighbours = new ArrayList<>();
                if(i>0) {
                    neighbours.add(world[i - 1][j]);
                }
                if(i<worldSize-1) {
                    neighbours.add(world[i + 1][j]);
                }
                if(j>0) {
                    neighbours.add(world[i][j - 1]);
                }
                if(j<worldSize-1) {
                    neighbours.add(world[i][j + 1]);
                }
                world[i][j].setNeighbours(neighbours);
            }
        }
    }

    public TactStatistics getTactStatistics() {
        return new TactStatistics(bacteriaAmount, creeperAmount, criticalLimitReached);
    }
    private  void updateBacteriaAndCreepersAmounts() {
        bacteriaAmount = 0;
        creeperAmount = 0;
        for (int i = 0; i < worldSize; i++) {
            for (int j = 0; j < worldSize; j++) {
                bacteriaAmount += world[i][j].getBacteriaAmount();
                creeperAmount += world[i][j].getCreeperAmount();
            }
        }

    }

}
