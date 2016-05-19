import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.AlreadyBoundException;
import java.net.MalformedURLException;

public class AdditionServer {
	public static void main(String[] args) {
		Addition addition = new Addition();

		String name = "rmi://127.0.0.1:9999/add";

		try {
			Naming.bind(name, addition);

			System.out.println("Started");
		} catch(AlreadyBoundException e) {
			e.printStackTrace();
		} catch(MalformedURLException e) {
			e.printStackTrace();
		} catch(RemoteException e) {
			e.printStackTrace();
		}
	}
}
