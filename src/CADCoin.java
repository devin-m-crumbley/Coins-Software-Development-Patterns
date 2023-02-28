/*
 * File contains:
 * CadCoinFactory       extends Coin Factory
 * CadDimeCoin          extends Coin
 * CadQuarterCoin       extends Coin
 * FiftyCentCoin        extends Coin
 * LoonieCoin           extends Coin
 * ToonieCoin           extends Coin
 */

class CadCoinFactory extends CoinFactory {
    private CadCoinFactory() {
	    super("CAD: Canadian Coin Factory");
    }
    // Singleton (eager static version)
    private static CadCoinFactory theInstance = new CadCoinFactory();
    public static CadCoinFactory getInstance() { return theInstance; }

    public Coin manufactureCoin(double type) {
	if (eq(type,0.05)) return new CadNickelCoin();
        else if (eq(type,0.10)) return new CadDimeCoin();
        else if (eq(type,0.25)) return new CadQuarterCoin();
        else if (eq(type,0.5)) return new FiftyCentCoin();
        else if (eq(type,1.0)) return new LoonieCoin();
        else if (eq(type,2.0)) return new ToonieCoin();
        else return Coin.NULL; 
    }
    public Coin smelt(Coin c) {
	    return c.getSmelter().smelt(c);
    }
    public Coin imprint(Coin c) {
	    return c.imprint(c);
    }
}

class CadNickelCoin extends Coin {
    public CadNickelCoin() {
        super("CAD", 0.05);    
        setSmelter(Smelter.UNKNOWN_SMELTER);
    }
    public Coin imprint(Coin c) {
        System.out.println("Imprinting a CAD nickel coin...");
        return c;
    }
    public void accept(CoinVisitor v) { v.visit(this); }
}
class CadDimeCoin extends Coin {
    public CadDimeCoin() {
        super("CAD", 0.10);    
        setSmelter(Smelter.UNKNOWN_SMELTER);
    }
    public Coin imprint(Coin c) {
        System.out.println("Imprinting a CAD dime coin...");
        return c;
    }
    public void accept(CoinVisitor v) { v.visit(this); }
}
class CadQuarterCoin extends Coin {
    public CadQuarterCoin() {
        super("CAD", 0.25);    
        setSmelter(Smelter.UNKNOWN_SMELTER);
    }
    public Coin imprint(Coin c) {
        System.out.println("Imprinting a CAD quarter coin...");
        return c;
    }
    public void accept(CoinVisitor v) { v.visit(this); }
}
class FiftyCentCoin extends Coin {
    public FiftyCentCoin() {
        super("CAD", 0.5);    
        setSmelter(Smelter.UNKNOWN_SMELTER);
    }
    public Coin imprint(Coin c) {
        System.out.println("Imprinting a CAD fifty cent coin...");
        return c;
    }
    public void accept(CoinVisitor v) { v.visit(this); }
}
class LoonieCoin extends Coin {
    public LoonieCoin() {
        super("CAD", 1.0);    
        setSmelter(Smelter.UNKNOWN_SMELTER);
    }
    public Coin imprint(Coin c) {
        System.out.println("Imprinting a CAD Loonie coin...");
        return c;
    }
    public void accept(CoinVisitor v) { v.visit(this); }
}

class ToonieCoin extends Coin {
    public ToonieCoin() { 
        super("CAD", 2.0);    
        setSmelter(Smelter.UNKNOWN_SMELTER);
    }
    public Coin imprint(Coin c) {
        System.out.println("Imprinting a CAD Toonie coin...");
        return c;
    }
    public void accept(CoinVisitor v) { v.visit(this); }
}
