package model;


import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
public class NumberTreeTest {

	private NumberTree numberTree;
	

	public void setupScene1() {
	}
	
	public void setupScene2() {
		numberTree=new NumberTree();
		numberTree.addNumber(10);
	}
	
	public void setupScene3() {
		numberTree=new NumberTree();
		numberTree.addNumber(10);
		numberTree.addNumber(7);
		numberTree.addNumber(12);
	}
	
	public void setupScene4() {
		numberTree=new NumberTree();
		numberTree.addNumber(10);
		numberTree.addNumber(7);
		numberTree.addNumber(12);
		numberTree.addNumber(5);
		numberTree.addNumber(11);
		numberTree.addNumber(15);
	}
	
	@Test
	public void testnumberTree() {
		setupScene1();
		
		NumberTree nt = new NumberTree();

		assertTrue(nt.getRoot()==null);
		nt.addNumber(10);
		assertTrue(nt.getRoot()!=null);
	}
	
	@Test
	public void testAddNumber() {
		setupScene2();
		numberTree.addNumber(7);
		numberTree.addNumber(12);
		assertTrue(numberTree.searchNumber(7).getNumber()==7);
		assertTrue(numberTree.searchNumber(12).getNumber()==12);
	}
	
	@Test
	public void testGetValues() {
		setupScene3();
		assertTrue(numberTree.getMin(numberTree.getRoot()).getNumber()==7);
		assertTrue(numberTree.getMax(numberTree.getRoot()).getNumber()==12);
		assertTrue(numberTree.getRoot().getNumber()==10);
	}
	
	@Test
	public void test() {
		setupScene4();
		String message1="5\n7\n10\n11\n12\n15\n";
		String message2="5\n7\n10\n11\n15\n";
		assertTrue(numberTree.searchNumber(11).getNumber()==11);
		assertEquals(numberTree.printTreeInOrder(),message1);
		numberTree.removeNumber(12);
		assertTrue(numberTree.printTreeInOrder().equals(message2));
		assertTrue(numberTree.searchNumber(12)==null);

	}

}
