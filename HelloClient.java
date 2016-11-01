import java.net.MalformedURLException;
import java.rmi.RMISecurityManager; 
import java.rmi.Naming; 
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
public class HelloClient 
{ 
    public static void main(String arg[]) 
    { 
        String message = "blank";
        //RMISecurityManager is deprecated
        System.setSecurityManager(new RMISecurityManager());

        try 
        { 
            //objectname in registry 
           Hello obj = (Hello) Naming.lookup( "//localhost/HelloServer");         
           System.out.println(obj.sayHello()); 
        } 
        catch (MalformedURLException | NotBoundException | RemoteException e) 
        { 
           System.out.println("HelloClient exception: " + e.getMessage()); 
           e.printStackTrace(); 
        } 
    } 
} 