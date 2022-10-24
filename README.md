# Artificial Life
Lotka-Volterra model also known as prey-predator model implement with bacteria as prey and creepers as predators.

## Example
```java
public class Main {
    public static void main(String[] args) {
        ArtificialLifeParameters parameters = new ArtificialLifeParameters(
                233,    // creepers initial amount
                300,   // bacteria initial amount
                4,     // creeper energy required for multiplication
                15,    // creepers initial energy
                16,    // creeper required energy reserve
                11,    // creeper max number of births in one tact
                16,    // creeper max number of bacteria eaten in one tact
                0.6029521347370408,    // bacteria multiplication rate
                0.40283479642322084    // bacteria spread rate

        );
        World world = new World(
                10,     // world size
                1000000,// critical bacteria limit
                10000,  // critical creeper limit
                0       // seed
        );
        ArtificialLife artificialLife = new ArtificialLife(
                parameters,
                world,
                100     // number of tacts
        );
        ArtificialLifeStatistics statistics = artificialLife.simulate();
    }
}
```