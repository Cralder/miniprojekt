package miniprojekt;

import java.util.Iterator;

class MyHashtable {
	
	public CountNode[] table;
	private int size;
	
	public MyHashtable(int initialcapacity) {
		table = new CountNode[initialcapacity];
	}
	
	public MyHashtable() {
		this(127);
	}
	
	public CountNode getNode(int i) {
		return table[i];
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
			if(table[i] == null) {
				table[i] = new CountNode(s, 1);
				size++;
			}else if(table[i].getString().equals(s)) {
				table[i].inc();
				size++;
			}else {
				put(s, i^2);
			}
			
		}
		
	}
	
	public int size() {
		return size;
	}
	
	public void put(String s) {
		put(s, new CountNode(s,1).hashCode());
	}
	
	public int find(String s, int i) {
		if(i > table.length) {
			return -1;
		}else if(table[i].getString().equals(s)) {
			return i;
		}else {
			return find(s, i^2);
		}
	}
	
	public int find(String s) {
		return find(s, new CountNode(s,1).hashCode());
	}
	
	public Iterator<CountNode> iterator(){
		return new HashIterator();
	}
	
	public boolean findBool(String s, int i) {
		if(i > table.length) {
			return false;
		}else if(table[i].getString().equals(s)) {
			return true;
		}else {
			return findBool(s, i^2);
		}
	}
	
	public boolean findBool(String s) {
		return findBool(s,new CountNode(s,1).hashCode());
	}
	
	
	
	
	private class HashIterator implements Iterator<CountNode>{
		
		private int count = 0;
		
		public HashIterator(){
			if(table.length == 0){
				throw new InvalidSizeException();
			}
		}
		
		public boolean hasNext() {
			
			for(int i = count; i < table.length; i++) {
				if(table[i] != null) {
					return true;
				}
			}
			
			return false;
		}
	
		public CountNode next() {
			CountNode out = null;
			
			while(out == null && count<table.length) {
				out = table[count];
				count++;
			}
			return out;
		}
	
		public void remove() {}
	
	}
	
	
}
