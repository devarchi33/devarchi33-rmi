import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by donghoon on 2016. 3. 23..
 */
public interface IHello extends Remote {

    String sayHello() throws RemoteException;
}
