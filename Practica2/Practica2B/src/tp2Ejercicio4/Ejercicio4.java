package tp2Ejercicio4;

import java.util.Scanner;

import tp02.ejercicio2.*;
import tp02.ejercicio3.*;

public class Ejercicio4 {

	public static boolean esBalanceado(String expr) {
		ListaGenerica<Character> apertura = new ListaEnlazadaGenerica<Character>();
		apertura.agregarFinal('(');
		apertura.agregarFinal('[');
		apertura.agregarFinal('{');
		
		ListaGenerica<Character> cierre = new ListaEnlazadaGenerica<Character>();
		cierre.agregarFinal(')');
		cierre.agregarFinal(']');
		cierre.agregarFinal('}');
		
		PilaGenerica<Character> pila = new PilaGenerica<Character>();
		
		Character actual, elem;
		for(int i=0; i<expr.length(); i++) {
			actual = expr.charAt(i);
			
			if(apertura.incluye(actual))
				pila.apilar(actual);
			else {
				elem = pila.desapilar();
				if(apertura.posicion(elem) != cierre.posicion(actual))
					return false;
			}
		}
		if(!pila.esVacia())
			return false;
		
		return true;
	}
	
	public static void main(String[] args){
		Scanner consola = new Scanner(System.in);
		String s = consola.nextLine();
		consola.close();
		
		if(esBalanceado(s))
			System.out.println("Esta balanceado" + s);
		else
			System.out.println("No esta balanceado" + s);
	}
}
