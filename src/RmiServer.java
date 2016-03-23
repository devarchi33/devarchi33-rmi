import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by donghoon on 2016. 3. 23..
 */
public class RmiServer implements IHello {

    @Override
    public String sayHello() throws RemoteException {
        return "Hello, calling rmi is success!";
    }

    public static void main(String[] args) {
        try {
            RmiServer rs = new RmiServer();

            // stub 이 검색했을 때, 객체 전달할 객체 생성.
            IHello stub = (IHello) UnicastRemoteObject.exportObject(rs, 0);

            // registry 에 stub 객체 바인딩.
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("IHello", stub);

            System.out.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
