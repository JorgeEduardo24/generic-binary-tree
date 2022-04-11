package model;

public class Number<T> {
	private T number;
	
	//Relaciones del árbol binario
	private Number<T> left;
	private Number<T> right;
	private Number<T> up;
	
	public Number(T number) {
		this.number = number;
	}
	
	public T getNumber() {
		return number;
	}

	public void setNumber(T number) {
		this.number = number;
	}

	public Number<T> getLeft() {
		return left;
	}

	public void setLeft(Number<T> left) {
		this.left = left;
	}

	public Number<T> getRight() {
		return right;
	}

	public void setRight(Number<T> right) {
		this.right = right;
	}

	public Number<T> getUp() {
		return up;
	}

	public void setUp(Number<T> up) {
		this.up = up;
	}
	
	@Override
	public String toString() {
		return getNumber()+"";
	}
}
