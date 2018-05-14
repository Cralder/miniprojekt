package miniprojekt;

class MyHashtable {
	
	public String[] table;
	
	public MyHashtable(int initialcapacity) {
		table = new String[initialcapacity];
	}
	
	public MyHashtable() {
		this(100);
	}
	
	public void put(String s, int i) {
		
		
		
		if(table[i].equals(null)) {
			table[i] = s;
		}else{
			put(s, i^2);
		}
		
	}
	
}
