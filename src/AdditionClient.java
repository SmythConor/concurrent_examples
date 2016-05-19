import java.rmi.Naming;
import java.rmi.RMISecurityManager;

import java.rmi.RemoteException;
import java.rmi.NotBoundException;
import java.net.MalformedURLException;

public class AdditionClient {
	public static void main(String[] args) {
		System.setSecurityManager(new RMISecurityManager() {
				public void checkConnect(String host, int port) {}
				public void checkConnect(String host, int port, Object context) {}
				});

		AdditionInterface addition = null;

		try {
			String name = "rmi://127.0.0.1:9999/add";
			addition = (AdditionInterface) Naming.lookup(name);
		} catch(NotBoundException e) {
			e.printStackTrace();
		} catch(MalformedURLException e) {
			e.printStackTrace();
		} catch(RemoteException e) {
			e.printStackTrace();
		}

		try {
			int result = addition.add(420, 420);
			System.out.println(result);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
