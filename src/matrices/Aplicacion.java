package matrices;

import java.util.Scanner;

public class Aplicacion {
	
	private int valorMinimo=0;
	private int valorMaximo=3;
	
	public Aplicacion() {
		Scanner s=new Scanner(System.in);
		int opcion=0;
		do {
			System.out.println("[Aplicación para operar con matrices]");
			System.out.println("1: Sumar matrices.");
			System.out.println("2: Multiplicar matrices.");
			System.out.println("3: Poblar matriz aleatoriamente.");
			System.out.println("99: Ejemplo excepciones");
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
			case 2:
				System.out.println("Introduce el número de filas de la matriz A.");
				int filasMatrizA=s.nextInt();
				System.out.println("Introduce el número de columnas de la matriz A.");
				int columnasMatrizA=s.nextInt();
				
				int[][] matrizAMultiplicando=Matrices.crearMatrizAleatoria(filasMatrizA, columnasMatrizA, valorMinimo, valorMaximo);
				System.out.println("Matriz A:");
				Matrices.imprimirMatriz(matrizAMultiplicando);
				
				System.out.println("Introduce el número de filas de la matriz B.");
				int filasMatrizB=s.nextInt();
				System.out.println("Introduce el número de columnas de la matriz B.");
				int columnasMatrizB=s.nextInt();
				
				int[][] matrizBMultiplicando=Matrices.crearMatrizAleatoria(filasMatrizB, columnasMatrizB, valorMinimo, valorMaximo);
				System.out.println("Matriz B:");
				Matrices.imprimirMatriz(matrizBMultiplicando);
				
				Matrices.multiplicar(matrizAMultiplicando, matrizBMultiplicando);
				break;
			case 3:
				//TODO: Pedir parámetros
			//	System.out.println("Introduce la probabilidad con la que quieres que se poble con 1:");
			//	int probabilidad=s.nextInt();
				Matrices.poblarMatriz(1000,1000,50);
				break;
			case 99:
				System.out.println("Voy a crear un array de 10 posiciones. Introduce un valor fuera del array:");
				int[] arrayExcepcion= {0,0,0,0,0,0,0,0,0,0};
				int i=s.nextInt();
				System.out.println("Accediendo a la posición "+i);
				try {
					System.out.println(arrayExcepcion[i]);
				} catch(Exception e) {
					System.err.println("El valor está fuera de los límites del array.");
					e.printStackTrace();
				}				
				break;
			}
		} while(opcion==1||opcion==2||opcion==3||opcion==99);

	}
	
	public static void main(String[] args) {
		Aplicacion a=new Aplicacion();
		
	}

}
