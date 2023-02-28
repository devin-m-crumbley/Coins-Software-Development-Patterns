import java.util.Scanner;
import java.util.Iterator;

/*
  Compile: make compile
  To run with default coin factory (USD): make demo
  To run with other coin factory: java CoinClient GBP
                etc...
 */
public class CoinClient{
    public static void main(String[] args) {
        CoinFactory cf = processCommandLine(args);
        CoinPurse purse = new CoinPurse();

        // get coins specified by the user and add them to the purse
        Scanner keyboard = new Scanner(System.in);
        double val = 1.0;
        while (val > 0.0) {
            System.out.print("Enter coin denomination (0.25 = a quarter, 0 to quit): ");
            try {
                val = keyboard.nextDouble();
            } catch (Exception e) {
                String msg = e.getMessage();
                System.out.println("Error reading your entry" 
                        + (msg == null ? "" : msg));
                keyboard.nextLine();
                continue;
            }
            //for some reason when typing 0 the coin purse would gain an extra null coin mitigates that
            if(val > 0) {
               Coin c = cf.makeCoin(val);
                System.out.println(c);
                purse.add(c); 
            }
            
        }
        keyboard.close();

        /*************************************** *************/
        /*********************** VISITOR SECTION *************/
        /*************************************** *************/
        purse.fill(); // put a bunch more random coins in the purse
        System.out.println("\nCoin Purse contains " + purse.size() + " coins.");
        // Create concrete visitor objects
        CoinVisitor nullCoin = new countNull();
        CoinVisitor USDCoin = new countUSD();
        
        Iterator<Coin> purseTraverser = purse.iterator();
        while (purseTraverser.hasNext()) {
            Coin c = (Coin) purseTraverser.next();
            c.accept(USDCoin);
            c.accept(nullCoin);
        }
        // When done, have each visitor "report"
        System.out.println(USDCoin.report());
        System.out.println(nullCoin.report());
    }
    
    private static CoinFactory processCommandLine(String[] args) {
        CoinFactory cf = null;
        if (args.length == 1 && "USD".equals(args[0])) {
            cf = UsdCoinFactory.getInstance();
        }
        else if (args.length == 1 && "GBP".equals(args[0])) {
            cf = GbpCoinFactory.getInstance();
        }
        else if (args.length == 1 && "CAD".equals(args[0])) {
            cf = CadCoinFactory.getInstance();
        }
        else if (args.length == 1 && "EUR".equals(args[0])) {
            cf = EurCoinFactory.getInstance();
        }
        else {
            System.out.println("\nProblem with command line coin factory argument.");
            System.out.println("Possible coin factories include: USD, GBP, CAD, EUR");
            cf = UsdCoinFactory.getInstance();
        }
        System.out.println("Using " + cf.getName());
        System.out.println();
        return cf;
    }
}
