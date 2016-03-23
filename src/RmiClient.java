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
            System.out.println("Host: " + host);
            Registry registry = LocateRegistry.getRegistry(host);

            // 원격 객체 검색
            IHello stub = (IHello) registry.lookup("IHello");

            // 원격 객체로 부터 인터페이스 사용
            String response = stub.sayHello();

            System.out.println("response: " + response);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
