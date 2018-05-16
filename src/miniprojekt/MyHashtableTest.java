package miniprojekt;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

public class MyHashtableTest {
	
	MyHashtable list;

	@Before
	public void setUp() throws Exception {
		list = new MyHashtable();
	}

	@Test
	public void testPutStringInt() {
		String string = "test";
		list.put(string, string.hashCode());
		assertEquals("The object is not put in the corresponding place",list.table[string.hashCode()].getString(), string);
	}

	@Test
	public void testFindStringInt() {
		String string = "test";
		list.put(string, string.hashCode());
		assertEquals("Check that return retruns the correct int value",list.find(string), string.hashCode());
	}

	@Test
	public void testIterator() {
		String test = null;
		String string = "test";
		list.put(string);
		Iterator<CountNode> itr = list.iterator();
		if(itr.hasNext()) {
			test = itr.next().getString();
		}
		
		assertEquals("Check that return retruns the correct int value",test, string);
	}
	
	@Test
	public void testSize() {
		String test = "test";
		list.put(test);
		assertEquals("Check if the size has increased",list.size(),1);
	}
	
	@Test
	public void testgetNode() {
		CountNode testnode = new CountNode("hi",1);
		list.put("hi",1);
		assertEquals("Check if testnode is equal to node in list",list.getNode(1).getString(),testnode.getString());
		assertEquals("Check if testnode is equal to node in list",list.getNode(1).getCount(),testnode.getCount());
	}
	
}
