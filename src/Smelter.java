
/*
 * All Smelting stuff is aggregated here!
 * Currently, CAD and EUR smelting are not finished
 * These regions will use the unknown smelter
 *
 * public interface Smelter
 * class UnknownSmelter implements Smelter
 * interface UsdSmelter extends Smelter
 * class PennySmelter implements UsdSmelter
 * class NickelSmelter implements UsdSmelter
 * class DQH_Smelter implements UsdSmelter
 * class DollarSmelter implements UsdSmelter
 * interface EurSmelter extends Smelter
 * interface CadSmelter extends Smelter
 * interface GbpSmelter extends Smelter
 * class PenceSmelter implements GbpSmelter
 * class FivePenceSmelter implements GbpSmelter
 * class TwentyPenceSmelter implements GbpSmelter
 * class PoundSmelter implements GbpSmelter
 * class TwoPoundSmelter implements GbpSmelter
 *
 * Note, that the interfaces define static smelter objects. So,
 * all penny coins connect to the same PennySmelter object!
 */


public interface Smelter {
    public Coin smelt(Coin c);
    public static Smelter UNKNOWN_SMELTER = new UnknownSmelter();
}

class UnknownSmelter implements Smelter {
    public Coin smelt(Coin c) {
        System.out.println("Smelting using UNKNOWN formula...");
        return c;
    }
}

interface EurSmelter extends Smelter {}

interface CadSmelter extends Smelter {}

interface UsdSmelter extends Smelter {
    public static Smelter PENNY_SMELTER = new PennySmelter();
    public static Smelter NICKEL_SMELTER = new NickelSmelter();
    public static Smelter DQH_SMELTER = new DQH_Smelter();
    public static Smelter DOLLAR_SMELTER = new DollarSmelter();
}

class PennySmelter implements UsdSmelter { 
    public Coin smelt(Coin c) {
        System.out.println("Smelting using 97.5% Zn 2.5% Cu formula...");
        return c;
    }
}

class NickelSmelter implements UsdSmelter { 
    public Coin smelt(Coin c) {
        System.out.println("Smelting using 25% Ni 75% Cu formula...");
        return c;
    }
}

class DQH_Smelter implements UsdSmelter { 
    public Coin smelt(Coin c) {
        System.out.println("Smelting using 91.67% Cu 8.33% Ni formula...");
        return c;
    }
}

class DollarSmelter implements UsdSmelter { 
    public Coin smelt(Coin c) {
        System.out.println("Smelting using 88.5% Cu 6% Zn 3.5% Mn 2% Ni formula...");
        return c;
    }
}

interface GbpSmelter extends Smelter {
    public static Smelter PENCE_SMELTER = new PenceSmelter();
    public static Smelter FIVE_PENCE_SMELTER = new FivePenceSmelter();
    public static Smelter TWENTY_PENCE_SMELTER = new TwentyPenceSmelter();
    public static Smelter POUND_SMELTER = new PoundSmelter();
    public static Smelter TWO_POUND_SMELTER = new TwoPoundSmelter();
}

class PenceSmelter implements GbpSmelter { 
    public Coin smelt(Coin c) {
        System.out.println("Smelting using Cu-plated steel formula...");
        return c;
    }
}

class FivePenceSmelter implements GbpSmelter { 
    public Coin smelt(Coin c) {
        System.out.println("Smelting using 25% Ni 75% Cu formula...");
        return c;
    }
}

class TwentyPenceSmelter implements GbpSmelter { 
    public Coin smelt(Coin c) {
        System.out.println("Smelting using 84% Cu 16% Ni formula...");
        return c;
    }
}

class PoundSmelter implements GbpSmelter { 
    public Coin smelt(Coin c) {
        System.out.println("Smelting using 70% Cu 24.5% Zn 5.5% Ni formula...");
        return c;
    }
}

class TwoPoundSmelter implements GbpSmelter { 
    public Coin smelt(Coin c) {
        System.out.println("Smelting outer ring using 76% Cu 20% Zn 4% Ni\n\t"
                + "inner ring using 75% Cu 25% Ni formula...");
        return c;
    }
}
