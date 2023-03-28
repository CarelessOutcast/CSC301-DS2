package setup;

public class Adder {
	private int sum;
	
	public void add(int i) {
		sum += i;
	}
	
	public void divideBy(int i) {
		sum /= i;
	}
	
	public int getTotal() {
		return sum;
	}
	
}
