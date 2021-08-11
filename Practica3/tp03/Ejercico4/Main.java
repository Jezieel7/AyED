package tp03.Ejercico4;

import tp03.ejercicio1.ArbolBinario;

public class Main {

	public static void main(String[] args) {
			ArbolBinario<Integer> ab = new ArbolBinario<Integer>(1);
			ab.agregarHijoIzquierdo(new ArbolBinario<Integer>(2));
			ab.agregarHijoDerecho(new ArbolBinario<Integer>(3));
			ab.getHijoIzquierdo().agregarHijoIzquierdo(new ArbolBinario<Integer>(4));
			ab.getHijoIzquierdo().agregarHijoDerecho(new ArbolBinario<Integer>(5));
			ab.getHijoDerecho().agregarHijoIzquierdo(new ArbolBinario<Integer>(6));
			
			RedBinariaLlena red = new RedBinariaLlena(ab);
			
			System.out.println(red.retardoReenvio());
	
	}

}
