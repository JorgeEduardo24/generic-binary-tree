package ui;

import model.Number;
import model.NumberTree;

public class Main {
	private static NumberTree numberTree;
	public static void main(String[] args) {
		numberTree = new NumberTree();
		
		numberTree.addNumber(6);
		numberTree.addNumber(4);
		numberTree.addNumber(9);
		numberTree.addNumber(2);
		numberTree.addNumber(1);
		printTreeInOrder();
	}
	
	public static void printTreeInOrder() {
		if(numberTree.getRoot()==null) {
			System.out.println("The tree is empty");
		}else {
			printTreeInOrder(numberTree.getRoot());
		}
	}

	private static void printTreeInOrder(Number<Integer> current) {
		if (current != null) {
			printTreeInOrder(current.getRight());
			System.out.println(current.toString());
			printTreeInOrder(current.getLeft());
		}
	}
}
