/*
 * File contains:
 * GbpCoinFactory       extends Coin Factory
 * PenceCoin            extends Coin
 * TwoPenceCoin         extends Coin
 * FivePenceCoin        extends Coin
 * TenPenceCoin         extends Coin
 * TwentyPenceCoin      extends Coin
 * FiftyPenceCoin       extends Coin
 * PoundCoin            extends Coin
 * TwoPoundCoin         extends Coin
 * FivePoundCoin        extends Coin
 */

class GbpCoinFactory extends CoinFactory {
    private GbpCoinFactory() {
	    super("GBP: Great Britain Coin Factory");
    }
    // Singleton (eager static version)
    private static GbpCoinFactory theInstance = new GbpCoinFactory();
    public static GbpCoinFactory getInstance() { return theInstance; }

    public Coin manufactureCoin(double type) {
        if (eq(type,0.01)) return new PenceCoin();
        else if (eq(type,0.02)) return new TwoPenceCoin();
        else if (eq(type,0.05)) return new FivePenceCoin();
        else if (eq(type,0.10)) return new TenPenceCoin();
        else if (eq(type,0.20)) return new TwentyPenceCoin();
        else if (eq(type,0.5)) return new FiftyPenceCoin();
        else if (eq(type,1.0)) return new PoundCoin();
        else if (eq(type,2.0)) return new TwoPoundCoin();
        else if (eq(type,5.0)) return new FivePoundCoin();
        else return Coin.NULL; 
    }
    public Coin smelt(Coin c) {
	    return c.getSmelter().smelt(c);
    }
    public Coin imprint(Coin c) {
	    return c.imprint(c);
    }
}

class PenceCoin extends Coin {
    public PenceCoin() {
        super("GBP", 0.01);    
        setSmelter(GbpSmelter.PENCE_SMELTER);
    }
    public Coin imprint(Coin c) {
        System.out.println("Imprinting a GBP one pence coin...");
        return c;
    }
    public void accept(CoinVisitor v) { v.visit(this); }
}

class TwoPenceCoin extends Coin {
    public TwoPenceCoin() {
        super("GBP", 0.02);    
        setSmelter(GbpSmelter.PENCE_SMELTER);
    }
    public Coin imprint(Coin c) {
        System.out.println("Imprinting a GBP two pence coin...");
        return c;
    }
    public void accept(CoinVisitor v) { v.visit(this); }
}

class FivePenceCoin extends Coin {
    public FivePenceCoin() {
        super("GBP", 0.05);    
        setSmelter(GbpSmelter.FIVE_PENCE_SMELTER);
    }
    public Coin imprint(Coin c) {
        System.out.println("Imprinting a GBP five pence coin...");
        return c;
    }
    public void accept(CoinVisitor v) { v.visit(this); }
}

class TenPenceCoin extends Coin {
    public TenPenceCoin() {
        super("GBP", 0.10);    
        setSmelter(GbpSmelter.FIVE_PENCE_SMELTER);
    }
    public Coin imprint(Coin c) {
        System.out.println("Imprinting a GBP ten pence coin...");
        return c;
    }
    public void accept(CoinVisitor v) { v.visit(this); }
}

class TwentyPenceCoin extends Coin {
    public TwentyPenceCoin() {
        super("GBP", 0.20);    
        setSmelter(GbpSmelter.TWENTY_PENCE_SMELTER);
    }
    public Coin imprint(Coin c) {
        System.out.println("Imprinting a GBP twenty pence coin...");
        return c;
    }
    public void accept(CoinVisitor v) { v.visit(this); }
}

class FiftyPenceCoin extends Coin {
    public FiftyPenceCoin() {
	super("GBP", 0.50);    
	    setSmelter(GbpSmelter.FIVE_PENCE_SMELTER);
    }
    public Coin imprint(Coin c) {
        System.out.println("Imprinting a GBP fifty pence coin...");
        return c;
    }
    public void accept(CoinVisitor v) { v.visit(this); }
}

class PoundCoin extends Coin {
    public PoundCoin() {
        super("GBP", 1.0);    
        setSmelter(GbpSmelter.POUND_SMELTER);
    }
    public Coin imprint(Coin c) {
        System.out.println("Imprinting a GBP One Pound coin...");
        return c;
    }
    public void accept(CoinVisitor v) { v.visit(this); }
}

class TwoPoundCoin extends Coin {
    public TwoPoundCoin() {
        super("GBP", 2.0);    
        setSmelter(GbpSmelter.TWO_POUND_SMELTER);
    }
    public Coin imprint(Coin c) {
        System.out.println("Imprinting a GBP Two Pound coin...");
        return c;
    }
    public void accept(CoinVisitor v) { v.visit(this); }
}

class FivePoundCoin extends Coin {
    public FivePoundCoin() {
        super("GBP", 5.0);    
        setSmelter(GbpSmelter.FIVE_PENCE_SMELTER);
    }
    public Coin imprint(Coin c) {
        System.out.println("Imprinting a GBP Five Pound coin...");
        return c;
    }
    public void accept(CoinVisitor v) { v.visit(this); }
}
