/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;
import  textgen.MyLinkedList;
/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester extends MyLinkedList{

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int si=list1.size;
		 list1.remove(0);
		 int a =list1.get(0);
		assertEquals("Remove: check data is remove",21,a);
		assertEquals("Remove: check size is correct ", si-1,list1.size );
		//assertEquals("Remove: check  node config",list1.Getprev(),list1.head);
		//assertEquals("Remove: check value at index: ",,);
		// TODO: Add more tests here
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test
		int siz=list1.size;
		list1.add(44);
		Boolean ret=(list1.get(list1.size-1)==44)?true:false;
		Boolean size=(list1.size>siz)?true:false;
		assertEquals("AddEnd: check a is correct",true,ret);
		assertEquals("AddEnd: check a is correct",true,size);
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test
		int siz=list1.size();
		boolean d=(siz>0)?true:false;
		assertEquals("size: check  is a correct",true,d);
		
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
		int si=list1.size;
		list1.add(1,34);
        // TODO: implement this test
	     assertEquals("AddAtIndex: check is correct",0<list1.size,true);
	     assertEquals("AddAtIndex: check is correct",34==list1.get(1),true);
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // TODO: implement this test
		 int size1=list1.size;
		list1.set(0, 1);
		int size2=list1.size;
		int get =list1.get(0);
		boolean assume=(size1==size2)?true:false;
		assertEquals("Set: check is a correct",1,get);
		assertEquals("Set: check is a correct",true,assume);
	}
	
	
	// TODO: Optionally add more test methods.
	
}
