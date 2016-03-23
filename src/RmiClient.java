import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by donghoon on 2016. 3. 23..
 */
public class RmiClient {
    private RmiClient() {
    }

    public static void main(String[] args) {

        String host = (args.length < 1) ? null : args[0];
        try {
            Registry registry = LocateRegistry.getRegistry(host);
            IHello stub = (IHello) registry.lookup("IHello");
            String response = stub.sayHello();
            System.out.println("response: " + response);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
