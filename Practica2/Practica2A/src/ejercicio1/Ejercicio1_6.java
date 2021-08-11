package ejercicio1;

import tp02.ejercicio1.*;

public class Ejercicio1_6 {	
	public static void calcularSucesionRec(ListaDeEnterosEnlazada l, int n) {
		int e=0;
		if(n==1)
			l.agregarFinal(n);
		else {
			l.agregarFinal(n);
			if(n%2==0)
				e=n/2;
			else
				e=3*n+1;
			
			calcularSucesionRec(l, e);
		}
	}
	
	public static ListaDeEnterosEnlazada calcularSucesion(int n) {
		ListaDeEnterosEnlazada l = new ListaDeEnterosEnlazada();
		calcularSucesionRec(l, n);
		return l;
	}
	
	public static void main(String[] args) {
		ListaDeEnterosEnlazada l = Ejercicio1_6.calcularSucesion(6);
		if(!(l.esVacia()))
			for(int i=1; i<=l.tamanio(); i++)
				System.out.println(l.elemento(i));
	}

}
