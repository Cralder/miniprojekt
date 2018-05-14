package miniprojekt;

class MyHashtable {
	
	public String[] table;
	
	public MyHashtable(int initialcapacity) {
		table = new String[initialcapacity];
	}
	
	public MyHashtable() {
		this(64);
	}
	
	public void put(String s, int i) {
		
		
		if(i > table.length) {
			String[] temp = new String[table.length*2];
			for(int j = 0; j<table.length; j++) {
				temp[j] = table[j];
			}
			table = temp;
			put(s, i);
			
		}else{
			if(table[i].equals(null)) {
				table[i] = s;
			}else {
				put(s, i^2);
			}
			
		}
		
		
	}
	
	public void put(String s) {
		put(s, s.hashCode());
	}
	
	public int find(String s, int i) {
		if(i > table.length) {
			return -1;
		}else if(table[i].equals(s)) {
			return i;
		}else {
			return find(s, i^2);
		}
	}
	
	public int find(String s) {
		return find(s, s.hashCode());
	}
	
	public Iterator<String> iterator(){
		return new HashIterator();
	}
	
	
	private class HashIterator implements Iterator{
		
		private int count = 0;
		
		public HashIterator() {
			if(isEmpty()){
				return;
			}
			
		}
		
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
