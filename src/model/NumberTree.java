package model;

public class NumberTree {
	private Number<Integer> root;
	
	public NumberTree() {
		
	}
	
	public void removeNumber(int number) {
		Number<Integer> num = searchNumber(number);
		removeNumber(num);
	}
	
	
	public Number<Integer> getRoot() {
		return root;
	}

	public void setRoot(Number<Integer> root) {
		this.root = root;
	}

	private void removeNumber(Number<Integer> number) {
		if(number != null) {
			//CASE 1: EL NODO A ELIMINAR ES UNA HOJA
			if(number.getLeft() == null && number.getRight() == null) { 
				if(number == root) { 
					root = null;
				}else if(number == number.getUp().getLeft()) {
					number.getUp().setLeft(null);
				}else {
					number.getUp().setRight(null);
				}
				
				//CASE 2: EL NODO A ELIMINAR TIENE 1 HIJO
			}else if(number.getLeft()==null || number.getRight()==null) {
				Number<Integer> child;
				if(number.getLeft()!=null) {
					child = number.getLeft();
				}else {
					child = number.getRight();
				}
				child.setUp(number.getUp());
				if(number==root) {
					root = child;
				}else if(number==number.getUp().getLeft()) { 
					number.getUp().setLeft(child); 
				}else {
					number.getUp().setRight(child);
				}
			}
			
			//CASE 3: EL NODO A ELIMINAR TIENE 2 HIJOS:
			else {
				Number<Integer> succesor = getMin(number.getRight());
				number.setNumber(succesor.getNumber());
				removeNumber(succesor);
			}
		}
	}
	
	public Number<Integer> getMin(Number<Integer> current) {
		if(current.getLeft()==null) {
			return current;
		}else {
			return getMin(current.getLeft());
		}
	}
	
	public Number<Integer> getMax(Number<Integer> current) {
		if(current.getRight()==null) {
			return current;
		}else {
			return getMax(current.getRight());
		}
	}
	
	
	public void addNumber(int number) {
		Number<Integer> newNumber = new Number<Integer>(number);
		if(root==null) {
			root = newNumber;
		}else {
			addNumber(root, newNumber);
		}
	}
	
	
	private void addNumber(Number<Integer> current, Number<Integer> newNumber) {
		if(newNumber.getNumber() <= current.getNumber()) {
			if(current.getLeft()==null) {
				current.setLeft(newNumber);
				newNumber.setUp(current);
			}else {
				addNumber(current.getLeft(), newNumber);
			}
		}else {
			if(current.getRight()==null) {
				current.setRight(newNumber);
				newNumber.setUp(current);
			}else {
				addNumber(current.getRight(), newNumber);
			}
		}
	}
	
	
	public Number<Integer> searchNumber(int number) {
		if(root==null) {
			return null;
		}else {
			return searchNumberIterative(root, number);
		}
	}

	private Number<Integer> searchNumberIterative(Number<Integer> current, int numberToSearch) {
		Number<Integer> found = null;
		while(current!=null && found==null) {
			if(current.getNumber()==numberToSearch) {
				found = current;
			}else if(numberToSearch > current.getNumber()) {
				current = current.getRight();
			}else {
				current = current.getLeft();
			}
		}
		return found;
	}
	
	public String printTreeInOrder() {
		String message="";
		if(getRoot()==null) {
			return "El árbol está vacío.";
		}else {
			message=printTreeInOrder(getRoot(),"");
			return message;
		}
	}

	private String printTreeInOrder(Number<Integer> current,String message) {
		if (current != null) {
			message=printTreeInOrder(current.getLeft(),message);
			message+=(current.toString()+"\n");
			message=printTreeInOrder(current.getRight(),message);
		}
		else {
			return message;
		}
		return message;
	}
}
