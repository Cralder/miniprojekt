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
	
	
	private class HashIterator {
		
		private int count = 0;
		
		
		public boolean hasNext() {
			
			return count < table.length;
		}
	
		public String next() {
			String out = table[count];
			count++;
			return out;
		}
	
		public void remove() {}
	
	}
	
}
