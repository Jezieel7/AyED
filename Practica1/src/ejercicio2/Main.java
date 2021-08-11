package ejercicio2;
import java.util.Scanner;

public class Main {
	
	public static int[] arreglos(int n) {
		int[] arreglo = new int[n];
		for(int i = 1; i <= n; i++)
			arreglo[i-1] = n * i;
		return arreglo;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int cantidad = s.nextInt();
		if(cantidad >= 1) {
			int[] arr = new int[cantidad];
			arr = arreglos(cantidad);
	
			for(int i = 0; i < cantidad; i++)
				System.out.println(arr[i]);
		
			s.close();
		}
	}
}
