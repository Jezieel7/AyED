package tp03.Ejercicio5;

import tp02.ejercicio2.ColaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class ProfundidadDeArbolBinario {
	ArbolBinario<Integer> arbol;

	public ProfundidadDeArbolBinario(ArbolBinario<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public ProfundidadDeArbolBinario() {
	}

	public ArbolBinario<Integer> getArbol() {
		return arbol;
	}

	public void setArbol(ArbolBinario<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public int sumaElementosProfundidad(int p) {
		int suma = 0;
		ArbolBinario<Integer> arbol = null;
		ColaGenerica<ArbolBinario<Integer>> cola = new ColaGenerica<ArbolBinario<Integer>>();
		cola.encolar(this.getArbol());
		cola.encolar(null);
		int nivel = 0;
		while(!cola.esVacia() && (nivel <= p)) {
			arbol = cola.desencolar();
			if(arbol != null) {
				if(nivel == p)
					suma += arbol.getDato();
				if(arbol.tieneHijoIzquierdo())
					cola.encolar(arbol.getHijoIzquierdo());
				if(arbol.tieneHijoDerecho())
					cola.encolar(arbol.getHijoDerecho());
			}else if(!cola.esVacia()) {
				nivel++;
				System.out.println();
				cola.encolar(null);
			}
		}
		return suma;
	}
	
}
