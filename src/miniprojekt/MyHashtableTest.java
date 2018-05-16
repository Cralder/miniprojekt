package miniprojekt;

import static org.junit.Assert.*;

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
		assertEquals("Make sure the string is put in the right place",list.table[string.hashCode()].getString(), string);
	}

	@Test
	public void testFindStringInt() {
		String string = "test";
		list.put(string, string.hashCode());
		assertEquals("Make sure the string is put in the right place",list.table[string.hashCode()].getString(), string);
	}

	@Test
	public void testIterator() {
		fail("Not yet implemented");
	}

}
