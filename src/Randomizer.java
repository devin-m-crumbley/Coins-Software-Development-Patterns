
import java.util.Random;

class Randomizer {
    // Singleton!
    private static Randomizer instance;
    private Random generator;

    public static Randomizer getInstance() {
        if (instance == null) 
            instance = new Randomizer();
        return instance;
    }

    private Randomizer() { generator = new Random(); }

    // accessors
    public int nextInt(int bound) {
	    return generator.nextInt(bound);
    }

    public boolean oneIn(int upperBound) {
	    double randomNum = generator.nextDouble();
	
        // randomNum is random, uniformly distributed between 0.0 and 1.0
        // 25% of the randomNums will be below 0.25=1/4
        // if asked for oneIn(4) then we want it succeed about 25% of the time
        return randomNum < 1.0 / upperBound;
    }
}
