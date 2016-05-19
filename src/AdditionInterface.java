import java.rmi.Remote;

public interface AdditionInterface extends Remote {
	public int add(int x, int y) throws Exception;
}
