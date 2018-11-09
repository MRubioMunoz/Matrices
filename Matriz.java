import java.util.*;
public class Matriz {
	
	private int mat [][];
	private int tam1, tam2;
	
	public Matriz(int t1, int t2){
		mat = new int[t1][t2];
		tam1 = t1;
		tam2 =  t2;
	}
		
	public  int getMatriz(int i, int j) {
		return mat[i][j];
	}
	
	public int getTamFila() {
		return tam1;
	}
	
	public int getTamColumna() {
		return tam2;
	}

	public void setMatriz(int [][] _mat) {
		for(int i = 0; i<tam1;i++) {
			for(int j = 0; j<tam2; j++) {
		this.mat[i][j]=_mat[i][j];
			}
		}
	}
	
	public void mostrarMatriz() {
		for(int i = 0; i<tam1;i++) {
			for(int j = 0; j<tam2; j++) {
				System.out.print(mat [i][j] + " "); 
				if(j==tam2-1) {
					System.out.print("\n"); 
				}
			}
		}
	}
	
	public void rellenarMatriz() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca los valores de la matriz, se rellena por filas:");
		 for(int i = 0; i<tam1;i++) {
			for(int j = 0; j<tam2; j++) {
				mat[i][j] = sc.nextInt();
				}	
		 }
		 
	}
		
	public  int matrizDeterminante2x2( ) {
		int resultado = 0;
		if(tam1 == 2 && tam2 == 2) {
		resultado=mat[0][0]*mat[1][1]-mat[1][0]*mat[0][1];
		}else {
			System.out.println("La matriz no es 2x2 con lo que no puede realizarse el metodo matrizDeterminante2x2(matriz) ");
		}
		return resultado;
	}
	
	public int matrizDeterminante3x3() {
		int resultado = 0;
		if(tam1 == 3 && tam2 == 3) {
		resultado = mat[0][0]*mat[1][1]*mat[2][2]+mat[0][1]*mat[1][2]*mat[2][0]+mat[1][0]*mat[2][1]*mat[0][2]-
				mat[0][2]*mat[1][0]*mat[2][0]-mat[0][1]*mat[1][0]*mat[2][2]-mat[1][2]*mat[2][1]*mat[0][0];
		}else{
			System.out.println("La matriz no es 3x3 con lo que no puede realizarse el metodo matrizDeterminante3x3(matriz) ");
		}
		return resultado;
	}
	
	public int [][] multiplicarMatrices3x3X3x1 (Matriz ma1, Matriz ma2 ) {
		 int resultado [][];
		 resultado = new int[3][1];
		 if(ma1.getTamFila()==3 && ma1.getTamColumna()== 3 && ma2.getTamFila()==3 && ma2.getTamColumna()== 1) {
		for(int i = 0; i<3; i++) {
			for(int j = 0; j<3; j++) {
				resultado[i][0] += ma1.getMatriz(i,j)*ma2.getMatriz(i,0);
				
			}
		}
		}else{
			System.out.println("Las matrices dadas no pueden ser multiplicadas");
		}
		return resultado;
	}
	

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Introduzca el valor de la fila y de la columna para la matriz: ");
		int tFila = sc.nextInt();
		int tColumna = sc.nextInt();

		Matriz matriz;
		matriz = new Matriz(tFila,tColumna);
		matriz.rellenarMatriz();
		System.out.println("Ahora rellene la matriz 3x1");
		Matriz ma3x1= new Matriz(3,1);
		ma3x1.rellenarMatriz();

		System.out.println(matriz.matrizDeterminante2x2());
		System.out.println(matriz.matrizDeterminante3x3());
		Matriz matrizMultiplicada;
		matrizMultiplicada = new Matriz(3,1);
		matrizMultiplicada.setMatriz(matriz.multiplicarMatrices3x3X3x1(matriz, ma3x1));
		matrizMultiplicada.mostrarMatriz();
		
		sc.close();
}
}
