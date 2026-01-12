package matrices;

import java.util.Random;

public abstract class Matrices {
	
	//TODO: Excepción si filas o columnas <1...
	public static int[][] crearMatrizAleatoria(int filas, int columnas, int valorMinimo, int valorMaximo){
		int[][] m=new int[filas][columnas];
		for(int i=0;i<m.length;i++) 
			for(int j=0;j<m[i].length;j++)	
				m[i][j]=generarAleatorio(valorMinimo,valorMaximo);
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
	
	//TODO: Excepción si valorMinimo>valorMaximo.
	private static int generarAleatorio(int valorMinimo, int valorMaximo) {
		//Ignorad la siguiente línea.
		assert valorMinimo<valorMaximo : "El mínimo no puede ser mayor que el máximo";
		Random r=new Random();
		return r.nextInt(valorMinimo,valorMaximo);
	}
	

}
