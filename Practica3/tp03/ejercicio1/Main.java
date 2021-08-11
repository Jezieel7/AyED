package tp03.ejercicio1;

import tp02.ejercicio2.ListaEnlazadaGenerica;

public class Main {
//	public static ArbolBinario<Integer> agregarDato(ArbolBinario<Integer> arbol, int dato) {
//	    if(arbol.getDato() == null)
//	    	arbol.setDato(dato);
//	    else {
//	    	if (dato < arbol.getDato()) {
//		        if (arbol.tieneHijoIzquierdo())
//		        	if(arbol.getHijoIzquierdo().getDato() == null) {
//		        		arbol.getHijoIzquierdo().setDato(dato);
//		        	} else {
//		        		ArbolBinario<Integer> hijoIzq = new ArbolBinario<Integer>();
//		        		arbol.agregarHijoIzquierdo(hijoIzq);
//		        		agregarDato(arbol.getHijoIzquierdo(), dato);
//		        	}
//		    } else
//		        if (arbol.tieneHijoDerecho())
//		        	if(arbol.getHijoDerecho().getDato() == null)
//		        		arbol.getHijoDerecho().setDato(dato);
//		        	else {
//		        		ArbolBinario<Integer> hijoDer = new ArbolBinario<Integer>();
//		        		arbol.agregarHijoIzquierdo(hijoDer);
//		        		agregarDato(arbol.getHijoDerecho(), dato);
//		        	}
//	    }
//	    return arbol;
//	}
//	
	public static void main(String[] args) {
		ArbolBinario<Integer> ab = new ArbolBinario<Integer>();
		ab.agregarHijoIzquierdo(new ArbolBinario<Integer>(2));
		ab.agregarHijoDerecho(new ArbolBinario<Integer>(3));
		ab.getHijoIzquierdo().agregarHijoIzquierdo(new ArbolBinario<Integer>(7));
		ab.getHijoIzquierdo().agregarHijoDerecho(new ArbolBinario<Integer>(5));
		ab.getHijoDerecho().agregarHijoIzquierdo(new ArbolBinario<Integer>(7));
		ab.getHijoIzquierdo().getHijoIzquierdo().agregarHijoIzquierdo(new ArbolBinario<Integer>(100));
		
		
		
//		System.out.println(ab.contarHojas());
//		
//		ab.entreNiveles(1, 2);
//		System.out.println();
//		System.out.println("Fin del recorrido entre niveles");
//		
		Parcial contador = new Parcial();
		
		System.out.println(contador.sumaImparesMayorA(ab, 3, 2));
//		ListaEnlazadaGenerica<Integer> listaEnteros = new ListaEnlazadaGenerica<Integer>();
//		listaEnteros = contador.numerosParesPostOrden();
//		
//		listaEnteros.comenzar();
//		for(int i=0; i < listaEnteros.tamanio(); i++)
//			System.out.println(listaEnteros.proximo());
//		
//		System.out.println();
//		System.out.println("Fin del recorrido de la lista Post Orden");
//		
//		listaEnteros = contador.numerosParesInOrden();
//		listaEnteros.comenzar();
//		for(int i=0; i < listaEnteros.tamanio(); i++)
//			System.out.println(listaEnteros.proximo());
	}

}
