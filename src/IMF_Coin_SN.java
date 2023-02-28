/*
  Sample client usage:
     To get remote object proxy:
         IMF_Coin_SN service = (IMF_Coin_SN) Naming.lookup("//152.10.10.77/IMF_Coin_SN");

     To use proxy to get unique serial number:
         String s = service.getUniqueSN("USD", "Quarter");
  
 */
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IMF_Coin_SN extends Remote {
    public String getUniqueSN(String countryCode, String coinType) throws RemoteException;
}
