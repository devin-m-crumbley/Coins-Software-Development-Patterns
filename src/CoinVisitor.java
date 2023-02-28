/*
 * All Coin Visitor stuff aggregates here.
 *
 * Your visitor should extend this class (see below). 
 * Notice that each coin type has an empty default implementation here.
 * Thus, you only need to override those coins that may be of interest 
 * to you for your specific reason for visiting.
 */

public abstract class CoinVisitor {

    public abstract String report();

    public void visit(Coin.NullCoin c) { }

    public void visit(DollarCoin c) { }
    public void visit(HalfDollarCoin c) { }
    public void visit(QuarterCoin c) { }
    public void visit(DimeCoin c) { }
    public void visit(NickelCoin c) { }
    public void visit(PennyCoin c) { }

    public void visit(FivePoundCoin c) { }
    public void visit(TwoPoundCoin c) { }
    public void visit(PoundCoin c) { }
    public void visit(FiftyPenceCoin c) { }
    public void visit(TwentyPenceCoin c) { }
    public void visit(TenPenceCoin c) { }
    public void visit(FivePenceCoin c) { }
    public void visit(TwoPenceCoin c) { }
    public void visit(PenceCoin c) { }

    public void visit(ToonieCoin c) { }
    public void visit(LoonieCoin c) { }
    public void visit(FiftyCentCoin c) { }
    public void visit(CadQuarterCoin c) { }
    public void visit(CadDimeCoin c) { }
    public void visit(CadNickelCoin c) { }
    
    public void visit(TwoEuroCoin c) { }
    public void visit(EuroCoin c) { }
    public void visit(FiftyEuroCentCoin c) { }
    public void visit(TwentyEuroCentCoin c) { }
    public void visit(TenEuroCentCoin c) { }
    public void visit(FiveEuroCentCoin c) { }
    public void visit(TwoEuroCentCoin c) { }
    public void visit(EuroCentCoin c) { }
    
}
//visitor to count the null coins
class countNull extends CoinVisitor {
    private int count = 0;

    int getCount() {
        return count;
    }

    public void visit (Coin.NullCoin c) {
        count++;
    }
    public String report(){
        return ("null coins: " + count);
    }
}
//visitor to count all of the USD coins
class countUSD extends CoinVisitor {
    private int count = 0;

    int getCount() {
        return count;
    }

    public void visit(DollarCoin c) {count++;}
    public void visit(HalfDollarCoin c) {count++;}
    public void visit(QuarterCoin c) {count++;}
    public void visit(DimeCoin c) {count++;}
    public void visit(NickelCoin c) {count++;}
    public void visit(PennyCoin c) {count++;}

    public String report(){
        return ("USD coins: " + count);
    }
}