package dev.k2;

import java.util.ArrayList;
import java.util.List;

public class ArtificialLife {



    private ArtificialLifeParameters parameters;
    private World world;
    private int tactNumber;
    private boolean prematureEndOfSimulation;

    List<TactStatistics> tactStatistics;

    public ArtificialLife(ArtificialLifeParameters parameters, World world, int tactNumber) {
        this.parameters = parameters;
        this.world = world;
        this.tactNumber = tactNumber;
        tactStatistics = new ArrayList<>(tactNumber);
        prematureEndOfSimulation = false;
    }

    public ArtificialLifeStatistics simulate() {
        tactStatistics.clear();
        world.setSimulatonParameters(parameters);
        world.initializeNewWorld();
        tactStatistics.add(world.getTactStatistics());

        for(int i = 1; i < tactNumber; i++) {

            world.nextTact();
            tactStatistics.add(world.getTactStatistics());

            if(tactStatistics.get(i).isCriticalBacteriaLimitReached()) {
                return new ArtificialLifeStatistics(tactStatistics, true);
            }
        }

        return new ArtificialLifeStatistics(tactStatistics, false);

    }
}
