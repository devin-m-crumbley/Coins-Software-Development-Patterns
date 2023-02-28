/*
 * This one source file has all generic coin stuff in it.
 * abstract class Coin
 * abstract class CoinFactory
 *
 * For concrete USD coin stuff look in USDCoin file.
 * Similarly for other countries...
 */

import java.util.Currency;
import java.util.Locale;
import java.text.DecimalFormat;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.NotBoundException;

abstract class Coin {
    // Basic coin attributes, and constructor that uses them.
    private double multiplier;
    //protected so other classes can access the currency methods
    protected Currency currency;
    // Smelting strategy delegate
    private Smelter smelter;

    Coin(String code, double m) { 
        multiplier = m; 
        currency = Currency.getInstance(code);
                
    }

    // Basic accessor / mutator methods
    public double value() { return multiplier; }
    public Smelter getSmelter() { return smelter; }
    public void setSmelter(Smelter s) { smelter = s; }
    public String getCode() {return currency.getCurrencyCode();}

    public String toString() {
        // uses some private helper methods for currency symbols...
        String symbol = 
            currency.getSymbol(getLocale(currency.getCurrencyCode()));
        String className = this.getClass().getName();
        return "(" + className + ")" + symbol + stringValue();
    }


    // abstract methods
    //   Each coin does a unique imprinting
    //   Each coin must have an accept for the polymorphic dispatch resolution
    public abstract Coin imprint(Coin c);
    public abstract void accept(CoinVisitor v);

    private Locale getLocale(String code) {
	    if ("USD".equals(code)) return Locale.US;
	    else if ("GBP".equals(code)) return Locale.UK;
	    else if ("EUR".equals(code)) return Locale.FRANCE;
	    else if ("CAD".equals(code)) return Locale.CANADA;
	    else return Locale.getDefault();
    }

    private String stringValue() {
	    DecimalFormat df = new DecimalFormat();
	    df.setMaximumFractionDigits(2);
	    df.setMinimumFractionDigits(2);
	    return df.format(multiplier);
    }

    // Null object design pattern for Coins
    static class NullCoin extends Coin {
        private NullCoin() { super("USD", 0.0); }
        public String toString() { return ""; }
        public void accept(CoinVisitor v) { v.visit(this); }
        public Coin imprint(Coin c) { return this; }
    }
    public static final Coin NULL = new NullCoin();
}

/**************************** CoinFactory ***************************/

abstract class CoinFactory {
    // private so no one outside the class can have access to the raw
    //  variable and must go through the method
    private String name;

    // No access to outside programs.
    protected CoinFactory(String name) {
	    this.name = name;
    }

    //public to allow programs to access the names of the coins outside the class

    public String getName() { return name; }

    // doubles don't compare nicely sometimes, so this method is available
    // to all subclasses
    protected boolean eq(double a, double b) {
	    // Because doubles don't == nicely
	    return (Math.abs(a-b) < 0.00001);
    }
    
    // Factory method! (used by makeCoin public method)
    //  Pattern says: "Let the subclasses decide." 
    //  So here the USDFactory knows how to manufacture USD coins...
    public abstract Coin manufactureCoin(double type);

    // Coin mutators; concrete coins do these specific to themselves.
    //  Abstract because each coin does/has these set differently based on
    //  What they are made of/what is imprinted on them
    public abstract Coin smelt(Coin c);
    public abstract Coin imprint(Coin c);

    // Common part of making all coins
    //  Leaving as proctected to allow other classes to make the desired coins.
    protected Coin makeCoin(double type) {
        // Use mint-specific factory method manufacture to get "raw" coin, 
        //  then finish processing of it
        Coin c = manufactureCoin(type); 
        if (c != Coin.NULL) {

            // smelting and imprinting processes are specific to coin type
            c = smelt(c);
            c = imprint(c);
            c = getserialNumber(c);

            // common coin production processes
            if (! (inspect(c) && smooth(c) && polish(c))) {
                System.out.println("Failed to manufacture coin.");
                c = Coin.NULL;
            }
        }
        return c;
    }

    private Coin getserialNumber(Coin c){
        System.out.print("Stamping " + c.getClass().getName() + "...");

        try {
            IMF_Coin_SN service = (IMF_Coin_SN) Naming.lookup("//152.10.10.77/IMF_Coin_SN");
            String s = service.getUniqueSN(c.getCode(), c.getClass().getName());
            System.out.println(s);
            return c;
        }
        catch(MalformedURLException | RemoteException | NotBoundException e){ e.printStackTrace();}
        return c;
}
    
    // Different steps in internal coin production process...
    //  Private to only allow methods in this class to pull from it
    //  ie the make coin method.
    private boolean smooth(Coin c) {
	    System.out.print("Smoothing " + c.getClass().getName() + "...");
	    if (Randomizer.getInstance().oneIn(1000)) {
	        System.out.println("failed.");	   
	        return false;
	    }
	    else {
	        System.out.println("completed.");
	        return true;
	    }
    }

    // Private to only allow methods in this class to pull from it
    //  ie the make coin method.
    private boolean inspect(Coin c) {
	    System.out.print("Inspecting " + c.getClass().getName() + "...");
	    if (Randomizer.getInstance().oneIn(1000)) {
	        System.out.println("failed.");	   
	        return false;
	    }
	    else {
	        System.out.println("completed.");
	        return true;
	    }
    }

    // Private to only allow methods in this class to pull from it
    //  ie the make coin method.
    private boolean polish(Coin c) {
	    System.out.print("Polishing " + c.getClass().getName() + "...");
	    if (Randomizer.getInstance().oneIn(5)) {
	        System.out.println("failed.");	   
	        return false;
	    }
	    else {
	        System.out.println("completed.");
	        return true;
	    }
    }
    
}
