/*
 * File contains:
 * UsdCoinFactory     extends CoinFactory
 * DollarCoin         extends Coin 
 * HalfDollarCoin     extends Coin 
 * QuarterCoin        extends Coin
 * DimeCoin           extends Coin
 * NickelCoin         extends Coin
 * PennyCoin          extends Coin
 */

class UsdCoinFactory extends CoinFactory {
    private UsdCoinFactory() {
	    super("USD: U.S. Coin Factory");
    }
    // Singleton (eager static version)
    private static UsdCoinFactory theInstance = new UsdCoinFactory();
    public static UsdCoinFactory getInstance() { return theInstance; }
   
    public Coin manufactureCoin(double type) {
        if (eq(type,0.01)) return new PennyCoin();
        else if (eq(type,0.05)) return new NickelCoin();
        else if (eq(type,0.10)) return new DimeCoin();
        else if (eq(type,0.25)) return new QuarterCoin();
        else if (eq(type,0.5)) return new HalfDollarCoin();
        else if (eq(type,1.0)) return new DollarCoin();
        else return Coin.NULL; 
    }

    public Coin smelt(Coin c) {
	    return c.getSmelter().smelt(c);
    }

    public Coin imprint(Coin c) {
	    return c.imprint(c);
    }
}

class DollarCoin extends Coin { 
    public DollarCoin() { 
        super("USD", 1.0); 
        setSmelter(UsdSmelter.DOLLAR_SMELTER);
    }
    public Coin imprint(Coin c) {
        System.out.println("Imprinting a USD Dollar coin...");
        return c;
    }
    public void accept(CoinVisitor v) { v.visit(this); }
}

class HalfDollarCoin extends Coin { 
    public HalfDollarCoin() { 
        super("USD", 0.5); 
        setSmelter(UsdSmelter.DQH_SMELTER);
    }
    public Coin imprint(Coin c) {
        System.out.println("Imprinting a USD HalfDollar coin...");
        return c;
    }
    public void accept(CoinVisitor v) { v.visit(this); }
}

class QuarterCoin extends Coin { 
    public QuarterCoin() { 
        super("USD", 0.25); 
        setSmelter(UsdSmelter.DQH_SMELTER);
    }
    public Coin imprint(Coin c) {
        System.out.println("Imprinting a USD Quarter coin...");
        return c;
    }
    public void accept(CoinVisitor v) { v.visit(this); }
}

class DimeCoin extends Coin { 
    public DimeCoin() { 
        super("USD", 0.10); 
        setSmelter(UsdSmelter.DQH_SMELTER);
    }
    public Coin imprint(Coin c) {
        System.out.println("Imprinting a USD Dime coin...");
        return c;
    }
    public void accept(CoinVisitor v) { v.visit(this); }
}

class NickelCoin extends Coin { 
    public NickelCoin() { 
        super("USD", 0.05); 
        setSmelter(UsdSmelter.NICKEL_SMELTER);
    }
    public Coin imprint(Coin c) {
        System.out.println("Imprinting a USD Nickel coin...");
        return c;
    }
    public void accept(CoinVisitor v) { v.visit(this); }
}

class PennyCoin extends Coin { 
    public PennyCoin() { 
        super("USD", 0.01); 
        setSmelter(UsdSmelter.PENNY_SMELTER);
    }
    public Coin imprint(Coin c) {
        System.out.println("Imprinting a USD Penny coin...");
        return c;
    }
    public void accept(CoinVisitor v) { v.visit(this); }
}
