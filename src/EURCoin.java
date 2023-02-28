/*
 * File contains:
 * EurCoinFactory       extends Coin Factory
 * EuroCentCoint        extends Coin
 * TwoEuroCentCoin      extends Coin
 * FiveEuroCentCoin     extends Coin
 * TenEuroCentCoin      extends Coin
 * TwentyEuroCentCoin   extends Coin
 * FiftyEuroCentCoin    extends Coin
 * EuroCoin             extends Coin
 * TwoEuroCoin          extends Coin
 */

class EurCoinFactory extends CoinFactory {
    private EurCoinFactory() {
	    super("EUR: Euro Coin Factory");
    }
    // Singleton (eager static version)
    private static EurCoinFactory theInstance = new EurCoinFactory();
    public static EurCoinFactory getInstance() { return theInstance; }

    public Coin manufactureCoin(double type) {
        if (eq(type,0.01)) return new EuroCentCoin();
        else if (eq(type,0.02)) return new TwoEuroCentCoin();
        else if (eq(type,0.05)) return new FiveEuroCentCoin();
        else if (eq(type,0.10)) return new TenEuroCentCoin();
        else if (eq(type,0.20)) return new TwentyEuroCentCoin();
        else if (eq(type,0.5)) return new FiftyEuroCentCoin();
        else if (eq(type,1.0)) return new EuroCoin();
        else if (eq(type,2.0)) return new TwoEuroCoin();
        else return Coin.NULL; 
    }
    public Coin smelt(Coin c) {
	    return c.getSmelter().smelt(c);
    }
    public Coin imprint(Coin c) {
	    return c.imprint(c);
    }
}

class EuroCentCoin extends Coin {
    public EuroCentCoin() {
        super("EUR", 0.01);    
        setSmelter(Smelter.UNKNOWN_SMELTER);
    }
    public Coin imprint(Coin c) {
        System.out.println("Imprinting a one cent Euro coin...");
        return c;
    }
    public void accept(CoinVisitor v) { v.visit(this); }
}

class TwoEuroCentCoin extends Coin {
    public TwoEuroCentCoin() {
        super("EUR", 0.02);    
        setSmelter(Smelter.UNKNOWN_SMELTER);
    }
    public Coin imprint(Coin c) {
        System.out.println("Imprinting a two cent Euro coin...");
        return c;
    }
    public void accept(CoinVisitor v) { v.visit(this); }
}

class FiveEuroCentCoin extends Coin {
    public FiveEuroCentCoin() {	
        super("EUR", 0.05);    
        setSmelter(Smelter.UNKNOWN_SMELTER);
    }
    public Coin imprint(Coin c) {
        System.out.println("Imprinting a five cent Euro coin...");
        return c;
    }
    public void accept(CoinVisitor v) { v.visit(this); }
}

class TenEuroCentCoin extends Coin {
    public TenEuroCentCoin() {
        super("EUR", 0.10);    
        setSmelter(Smelter.UNKNOWN_SMELTER);
    }
    public Coin imprint(Coin c) {
        System.out.println("Imprinting a ten cent Euro coin...");
        return c;
    }
    public void accept(CoinVisitor v) { v.visit(this); }
}

class  TwentyEuroCentCoin extends Coin {
    public TwentyEuroCentCoin() {
        super("EUR", 0.20);    
        setSmelter(Smelter.UNKNOWN_SMELTER);
    }
    public Coin imprint(Coin c) {
        System.out.println("Imprinting a twentty cent Euro coin...");
        return c;
    }
    public void accept(CoinVisitor v) { v.visit(this); }
}

class FiftyEuroCentCoin extends Coin {
    public FiftyEuroCentCoin() {
        super("EUR", 0.50);    
        setSmelter(Smelter.UNKNOWN_SMELTER);
    }
    public Coin imprint(Coin c) {
        System.out.println("Imprinting a fifty cent Euro coin...");
        return c;
    }
    public void accept(CoinVisitor v) { v.visit(this); }
}

class EuroCoin extends Coin {
    public EuroCoin() {	
        super("EUR", 1.0);    
        setSmelter(Smelter.UNKNOWN_SMELTER);
    }
    public Coin imprint(Coin c) {
        System.out.println("Imprinting a One Euro coin...");
        return c;
    }
    public void accept(CoinVisitor v) { v.visit(this); }
}
class TwoEuroCoin extends Coin {
    public TwoEuroCoin() {	
        super("EUR", 2.0);    
        setSmelter(Smelter.UNKNOWN_SMELTER);
    }
    public Coin imprint(Coin c) {
        System.out.println("Imprinting a Two Euro coin...");
        return c;
    }
    public void accept(CoinVisitor v) { v.visit(this); }
}
