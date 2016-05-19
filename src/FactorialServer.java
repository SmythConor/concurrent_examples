import java.rmi.Naming;

import java.rmi.RemoteException;
import java.rmi.AlreadyBoundException;
import java.net.MalformedURLException;

/**
 * Factorial server to handle calls to factorial
 */
public class FactorialServer {
	public static void main(String[] args) {
		/* Create and instance of the object */
		Factorial factorial = new Factorial();

		/* Create the name */
		String name = "rmi://127.0.0.1:9999/fact";

		try {
			/* bind the name to the object */
			Naming.bind(name, factorial);

			System.out.println("Server started");
		} catch(AlreadyBoundException e) {
			e.printStackTrace();
		} catch(MalformedURLException e) {
			e.printStackTrace();
		} catch(RemoteException e) {
			e.printStackTrace();
		}
	}
}
