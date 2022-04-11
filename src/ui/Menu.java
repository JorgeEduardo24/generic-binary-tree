package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import model.NumberTree;

public class Menu {
	private NumberTree numberTree;
	
	public Menu() {
		numberTree = new NumberTree();
	}
	
	public void showMenu() {
		System.out.println("=========================================================\n"+
						   "    Ingrese la opci�n que desee realizar: \n");
		System.out.println("    [1] Agregar valores al �rbol binario.\n"+
		                   "    [2] Eliminar un valor del �rbol binario.\n"+
		                   "    [3] Ver los valores de �rbol binario por pantalla.\n"+
		                   "    [4] Salir del programa.\n"+
		                   "=========================================================\n");
	}
	
	public int readOption(BufferedReader br) throws NumberFormatException, IOException {
		int option = Integer.parseInt(br.readLine());
		return option;
	}
	
	public void doOption(int option, BufferedReader br) throws NumberFormatException, IOException {
		switch(option) {
		
		case 1:
			System.out.println("-----------------------------------------------------");
			System.out.println("          AGREGAR VALORES AL �RBOL DE N�MEROS");
			System.out.println("-----------------------------------------------------");
			readData(br);

			break;
				
		case 2:
			System.out.println("-----------------------------------------------------");
			System.out.println("         ELIMINAR UN VALOR DEL �RBOL DE N�MEROS");
			System.out.println("-----------------------------------------------------");
			remove(br);
			break;
			
		case 3:
			System.out.println("-----------------------------------------------------");
			System.out.println("              VALORES DEL �RBOL DE N�MEROS");
			System.out.println("-----------------------------------------------------");
			System.out.println(numberTree.printTreeInOrder());
			break;
			
		case 4:
			System.out.println("Bye!");
			break;
		}
	}
	
	public void startProgram() throws NumberFormatException, IOException {
		int option = 0;
		int exit = 4;
		do {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			showMenu();
			option = readOption(br);
			doOption(option, br);
		}while(option != exit);
	}
	
	public void readData(BufferedReader br) throws NumberFormatException, IOException {
		System.out.println("Escriba la cantidad de valores (en enteros) que quiere agregar al �rbol binario:");
		int numberOfValues = Integer.parseInt(br.readLine());
		System.out.println(" ---> El programa trabaja con valores enteros.");
		
		for (int i = 0; i < numberOfValues; i++) {
			System.out.println("Escribe el valor del n�mero entero "+(i+1)+":");
			int value = Integer.parseInt(br.readLine());
			numberTree.addNumber(value);
		}	
	}
	
	public void remove(BufferedReader br) throws NumberFormatException, IOException {
		System.out.println("Escribe el n�mero que desee borrar del �rbol: ");
		int number = Integer.parseInt(br.readLine());
		
		if(numberTree.searchNumber(number)!=null) {
			numberTree.removeNumber(number);
			System.out.println("�Elemento eliminado satisfactoriamente! :)");
		}else {
			System.out.println("Error. El elemento que desea eliminar no existe en el �rbol de n�meros. :(");
		}
	}
	
	
}
