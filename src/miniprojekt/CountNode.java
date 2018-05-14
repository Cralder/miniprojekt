package miniprojekt;

class CountNode {
	private String s;
	private int count;
	
	public CountNode(String value, int c) {
		s = value;
		count = c;
	}
	
	public int getCount() {
		return count;
	}
	
	public void inc() {
		count++;
	}
	
	public void inc(int i) {
		count = count + i;
	}
	public String getString() {
		return s;
	}
}
