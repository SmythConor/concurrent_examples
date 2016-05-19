import java.io.Serializable;

public class Addition implements AdditionInterface, Serializable {
	static final long serialVersionUID = 42L;

	public Addition() {}

	@Override
	public int add(int x, int y) throws Exception {
		return x + y;
	}
}
