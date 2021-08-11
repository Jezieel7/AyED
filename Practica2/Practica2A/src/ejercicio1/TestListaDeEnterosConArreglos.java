package ejercicio1;
import tp02.ejercicio1.*;

public class TestListaDeEnterosConArreglos {

	public static void imprimirSentidoInverso(ListaDeEnteros l) {
		if(!l.fin()) {
			int num = l.proximo();
			imprimirSentidoInverso(l);
			System.out.print(num + " | ");
		}
	}
	
	public static void main(String[] args) {
		ListaDeEnterosConArreglos l = new ListaDeEnterosConArreglos();
		for(int i=0; i < 5; i++)
			l.agregarFinal(i);
		l.comenzar();
		while(!l.fin())
			System.out.println(l.proximo());
		l.comenzar();
		imprimirSentidoInverso(l);
	}

}
