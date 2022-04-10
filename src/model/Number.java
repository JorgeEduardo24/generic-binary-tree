package model;

public class Number<Integer> {
	private Integer number;
	
	//Relaciones del árbol binario
	private Number<Integer> left;
	private Number<Integer> right;
	private Number<Integer> up;
	
	public Number(Integer number) {
		this.number = number;
	}
	
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Number<Integer> getLeft() {
		return left;
	}

	public void setLeft(Number<Integer> left) {
		this.left = left;
	}

	public Number<Integer> getRight() {
		return right;
	}

	public void setRight(Number<Integer> right) {
		this.right = right;
	}

	public Number<Integer> getUp() {
		return up;
	}

	public void setUp(Number<Integer> up) {
		this.up = up;
	}
	
	@Override
	public String toString() {
		return "Número: "+getNumber();
	}
}
