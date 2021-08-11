package ejercicio1;

import tp02.ejercicio1.*;

public class TestListaDeEnterosEnlazada {

	public static void imprimirSentidoInverso(ListaDeEnteros l) {
		if(!l.fin()) {
			int num = l.proximo();
			imprimirSentidoInverso(l);
			System.out.print(num + " | ");
		}
	}
	
	public static void main(String[] args) {
		ListaDeEnterosEnlazada l = new ListaDeEnterosEnlazada();
		for(int i=0; i< 5; i++)
			l.agregarFinal(i);
		l.comenzar();
		while(!l.fin())
			System.out.println(l.proximo());
		l.comenzar();
		imprimirSentidoInverso(l);

	}

}
