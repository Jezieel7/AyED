package ejercicio5;

import java.util.Scanner;

public class Main {
	
	public static int[] maxMinProm(int[] array) {
		int min = 9999; int max = -9999; int prom = 0;
		for(int i = 0; i < array.length; i++) {
			if(array[i] < min)
				min = array[i];
			if(array[i] > max)
				max = array[i];
			
			prom += array[i];
			
		}
		int[] resultados = new int[3];
		resultados[0] = max;
		resultados[1] = min;
		resultados[2] = (prom / array.length);
		return resultados;
	}
	
	public void recibirArreglo(int[] array, PuntoC objeto){
		for(int i = 0; i < array.length; i++) {
			if(array[i] < objeto.getMinimo())
				objeto.setMinimo(array[i]);
			if(array[i] > objeto.getMaximo())
				objeto.setMaximo(array[i]);
			
			objeto.setPromedio(objeto.getPromedio() + array[i]);
			
		}
		objeto.setPromedio(objeto.getPromedio() / array.length);
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[] vector = new int[5];
		
		for(int i = 0; i < 5; i++) {
			vector[i] = i+5;
		}
		
		int[] r = new int[3];
		r = maxMinProm(vector);
		
		for(int i = 0; i < r.length; i++)
			System.out.println(r[i]);
		
		s.close();
	}
}
