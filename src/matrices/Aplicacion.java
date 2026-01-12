package matrices;

import java.util.Scanner;

public class Aplicacion {
	
	private int valorMinimo=0;
	private int valorMaximo=10;
	
	public Aplicacion() {
		Scanner s=new Scanner(System.in);
		int opcion=0;
		do {
			System.out.println("[Aplicación para operar con matrices]");
			System.out.println("1: Sumar matrices.");
			System.out.println("2: Multiplicar matrices.");
			System.out.println("Otra opción: salir.");
			System.out.println("Escoja una opción del menú:");
			opcion=s.nextInt();
			switch(opcion) {
			case 1:
				System.out.println("Introduce el número de filas de la matriz.");
				int filas=s.nextInt();
				System.out.println("Introduce el número de columnas de la matriz.");
				int columnas=s.nextInt();
				
				int[][] matrizA=Matrices.crearMatrizAleatoria(filas, columnas, valorMinimo, valorMaximo);
				System.out.println("Matriz A:");
				Matrices.imprimirMatriz(matrizA);
				
				int[][] matrizB=Matrices.crearMatrizAleatoria(filas, columnas, valorMinimo, valorMaximo);
				System.out.println("Matriz B:");
				Matrices.imprimirMatriz(matrizB);
				
				try {
					int[][] matrizR=Matrices.sumar(matrizA,matrizB);
					System.out.println("Matriz R (resultado):");
					Matrices.imprimirMatriz(matrizR);
				} catch(Exception e) {
					System.err.println("Error al sumar las matrices.");
					System.err.println(e.getMessage());
				}				

				break;		
			}
		} while(opcion==1||opcion==2);

	}
	
	public static void main(String[] args) {
		Aplicacion a=new Aplicacion();
		
	}

}
