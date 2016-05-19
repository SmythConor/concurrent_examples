import java.rmi.Naming;
import java.rmi.RMISecurityManager;

import java.rmi.RemoteException;
import java.rmi.NotBoundException;
import java.net.MalformedURLException;

/**
 * Client to call addition server
 */
public class AdditionClient {
	public static void main(String[] args) {
		/* Set up the security manager */
		System.setSecurityManager(new RMISecurityManager() {
				public void checkConnect(String host, int port) {}
				public void checkConnect(String host, int port, Object context) {}
				});

		AdditionInterface addition = null;

		try {
			/* Get the name of the endpoint */
			String name = "rmi://127.0.0.1:9999/add";

			/* Lookup and initialise the interface */
			addition = (AdditionInterface) Naming.lookup(name);
		} catch(NotBoundException e) {
			e.printStackTrace();
		} catch(MalformedURLException e) {
			e.printStackTrace();
		} catch(RemoteException e) {
			e.printStackTrace();
		}

		try {
			/* Call remote method with two params */
			int result = addition.add(420, 420);

			/* Print the result */
			System.out.println(result);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
