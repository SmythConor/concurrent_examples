import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.RMISecurityManager;

import java.rmi.NotBoundException;
import java.net.MalformedURLException;

/**
 * Client to handle calls to the factorial server
 */
public class FactorialClient {
	public static void main(String[] args) {
		/* Set up the security manager */
		System.setSecurityManager(new RMISecurityManager() {
			public void checkConnect(String host, int port) {}
			public void checkConnect(String host, int port, Object context) {}
		});

		/* intialist the name and interface */
		String name = "rmi://127.0.0.1:9999/fact";
		FactorialInterface factorialInterface = null;

		try {
			/* Get the interface from the lookup */
			factorialInterface = (FactorialInterface) Naming.lookup(name);
		} catch(NotBoundException e) {
			e.printStackTrace();
		} catch(MalformedURLException e) {
			e.printStackTrace();
		} catch(RemoteException e) {
			e.printStackTrace();
		}

		try {
			int number = 5;

			/* Call the interface */
			int result = factorialInterface.fact(number);

			System.out.println(result);
		} catch(RemoteException e) {
			e.printStackTrace();
		}
	}
}
