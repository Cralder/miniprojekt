package miniprojekt;

class CountNode {
	private String s;
	private int count;
	
	/**
	 * Class constructor with initial value and counter
	 */
	
	public CountNode(String value, int c) {
		s = value;
		count = c;
	}
	/**
	 * Returns this node's number of occurences
	 * @return Returns counter for this node
	 */
	public int getCount() {
		return count;
	}
	
	/**
	 * increases the count value of this node by 1
	 */
	public void inc() {
		count++;
	}
	
	/**
	 * Increases this nodes total occurances
	 * * @param i The amount to increase count by
	 * @return Returns counter for this node
	 */
	public void inc(int i) {
		count = count + i;
	}
	
	/**
	 * returns the string of this node
	 * @return Returns this node's string
	 */
	public String getString() {
		return s;
	}
	/**
	 * returns the hashcode of this node
	 * @return Returns the hashcode for this node
	 */
	@Override
	public int hashCode() {
		double hash = Math.abs(s.hashCode());
		
		hash = hash % 541;
		
		if(hash < 2) {
			hash = 2;
		}
		
		return (int) hash;
		
		
	}
}
