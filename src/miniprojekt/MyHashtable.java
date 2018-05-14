package miniprojekt;

class MyHashtable {
	
	public CountNode[] table;
	
	public MyHashtable(int initialcapacity) {
		table = new CountNode[initialcapacity];
	}
	
	public MyHashtable() {
		this(64);
	}
	
	public void put(String s, int i) {
		
		
		if(i > table.length) {
			CountNode[] temp = new CountNode[table.length*2];
			for(int j = 0; j<table.length; j++) {
				temp[j] = table[j];
			}
			table = temp;
			put(s, i);
			
		}else{
			if(table[i].equals(null)) {
				table[i] = new CountNode(s, 1);
			}else if(table[i].getString().equals(s)) {
				table[i].inc();
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
	
	
	private class HashIterator {
		
		private int count = 0;
		
		
		public boolean hasNext() {
			
			return count < table.length;
		}
	
		public CountNode next() {
			CountNode out = table[count];
			count++;
			return out;
		}
	
		public void remove() {}
	
	}
	
}
