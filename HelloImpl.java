
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloImpl extends UnicastRemoteObject implements Hello {

    public HelloImpl() throws RemoteException {
    }

    @Override
    public String sayHello() throws RemoteException {
        System.out.println("Who Ask!!");
        return "Serwer Say: Hello world!";
    }

    public static void main(String args[]) {
        try {
            HelloImpl obj = new HelloImpl();
            Naming.rebind("HelloServer", obj);
        } catch (MalformedURLException | RemoteException e) {
            System.out.println("HelloImpl err: " + e.getMessage());

        }
    }
}
