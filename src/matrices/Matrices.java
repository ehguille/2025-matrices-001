package matrices;

import java.util.Random;

public abstract class Matrices {
	
	//TODO: Excepción si filas o columnas <1....
	public static int[][] crearMatrizAleatoria(int filas, int columnas, int valorMinimo, int valorMaximo){
		int[][] m=new int[filas][columnas];
		for(int i=0;i<m.length;i++) 
			for(int j=0;j<m[i].length;j++)	{
				try {
					m[i][j]=generarAleatorio(valorMinimo,valorMaximo);
				} catch(Exception e) {
					System.err.println(e.getMessage());
					System.err.println("La aplicación sigue ejecutándose a pesar del error (algo que es un error desde el punto de vista de diseño de la aplicación.");
				}
			}
		return m;
	}
	
	public static void imprimirMatriz(int[][] m) {
		for(int i=0;i<m.length;i++) {
			for(int j=0;j<m[i].length;j++)
				System.out.print(m[i][j]+" ");
			System.out.println("");
		}
	}
	
	/**
	 * Método para sumar matrices de enteros
	 * @param a Matriz a sumar
	 * @param b Matriz a sumar
	 * @return m[i][j]=a[i][j]+b[i][j]; 
	 * @throws Exception Si las matrices no tienen el mismo tamaño.
	 */
	public static int[][] sumar(int[][] a, int[][] b) throws Exception {
		if(a.length!=b.length||a[0].length!=b[0].length)
			throw new Exception("Ambas matrices deben tener el mismo tamaño");
		int[][] m=new int[a.length][a[0].length];
		for(int i=0;i<m.length;i++) 
			for(int j=0;j<m[i].length;j++)
				m[i][j]=a[i][j]+b[i][j];
		return m;
	}
	
	public static int[][] multiplicar(int[][] matrizA, int[][] matrizB){
		int[][] resultado=new int[matrizA.length][matrizB[0].length];
		//Dos bucles para recorrer la matriz resultado
		for(int i=0;i<resultado.length;i++) {
			for(int j=0;j<resultado[0].length;j++) {
				for(int k=0;k<matrizA.length;k++) {
					resultado[i][j]+=matrizA[i][k]*matrizB[k][j];
				}				
			}
		}
		Depurador.imprimirTraza("Resultado de la multiplicación:");
		imprimirMatriz(resultado);
		return resultado;
	}
	
	//TODO: Excepción si valorMinimo>valorMaximo.
	private static int generarAleatorio(int valorMinimo, int valorMaximo) throws Exception {
		if(valorMinimo>=valorMaximo)
			throw new Exception("El mínimo no puede ser mayor que el máximo");
		Random r=new Random();
		return r.nextInt(valorMinimo,valorMaximo);
	}
	
	public static int[][] poblarMatriz(int filas, int columnas, int probabilidad) {
		int[][] resultado=new int[filas][columnas];
		int numeroCeros=0;
		int numeroUnos=0;
		for(int i=0;i<resultado.length;i++)
			for(int j=0;j<resultado[0].length;j++) {
				try {
					int numeroAleatorio=generarAleatorio(0,100);
					if(numeroAleatorio<probabilidad) {
						resultado[i][j]=1;
						numeroUnos++;
					}					
					else {
						resultado[i][j]=0;
						numeroCeros++;
					}
				} catch(Exception e) {
					System.err.println(e.getMessage());
				}
			}
		Depurador.imprimirTraza("Número de ceros: "+numeroCeros);
		Depurador.imprimirTraza("Número de unos: "+numeroUnos);
		return resultado;
	}	

}
