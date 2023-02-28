/*
 * CoinPurse is a coin collection.
 * 
 * As such it basically "wraps" a simple base collection (ArrayList) 
 * of Coin objects. But then adds some unique features like:
 *   fill - to place some random coins in the purse for testing
 *   iterator - to assist clients with "traversing" the collection
 */

import java.util.ArrayList;
import java.util.Iterator;

public class CoinPurse {
    // base collection we are "wrapping"
    private ArrayList<Coin> coins;
    public CoinPurse() {
	    coins = new ArrayList<Coin>();
    }

    // accessors
    public int size() { return coins.size(); }
    public void add(Coin c) {
            // System.out.println(c);
            // System.out.println(coins.size());
            // System.out.println("****** Added (" + c + ") to coin purse.\n");

	    coins.add(c);
    }

    // for testing purposes
    public void fill() {
        // will randomly choose from any/all factories!
        CoinFactory[] factories = new CoinFactory[4];
        factories[0] = UsdCoinFactory.getInstance();
        factories[1] = GbpCoinFactory.getInstance();
        factories[2] = CadCoinFactory.getInstance();
        factories[3] = EurCoinFactory.getInstance();

        // will randomly choose from any/all coin denominations
        double[] coinValues = 
            {5.00, 2.00, 1.00, 0.50, 0.25, 0.20, 0.10, 0.05, 0.02, 0.01 };

        // add something between 30-60 coins
        int numIterations = 30 + Randomizer.getInstance().nextInt(30); 

        // time to start making random coins!
        for (int i = 0; i < numIterations; i++) {
            // randomly choose a factory and a coin denomination
            int f = Randomizer.getInstance().nextInt(factories.length);
            int v = Randomizer.getInstance().nextInt(coinValues.length);
            
            // if "bad" coin value then factory returns a NULL coin
            Coin c = factories[f].makeCoin(coinValues[v]); 

            // Add it
            this.add(c);

            // just keeping user informed...
            
            System.out.println("****** Added (" + c + ") to coin purse.\n");
        }
    }

    // Provide a way for clients to "traverse" or "iterate" over our collection
    Iterator<Coin> iterator() {
	    return new CoinPurseIterator();
    }

    // nested class has access to outer class fields (eg, our coins collection)
    public class CoinPurseIterator implements Iterator<Coin> {
	    private int currIndex = -1;
	    public boolean hasNext() {
	        return (currIndex+1) < coins.size();
	    }
	    public Coin next() {
            
	        return coins.get(++currIndex);
	    }
    }
}
