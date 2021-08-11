package tp03.ejercicio1;

import tp02.ejercicio2.ColaGenerica;

public class Parcial {
	public Integer sumaImparesMayorA(ArbolBinario<Integer> ab, int  limite, int nivel) {
		int sumatoria = -1;
		if(!ab.esVacio()) {
			sumatoria = 0;
			ArbolBinario<Integer> arbol = null;
			ColaGenerica<ArbolBinario<Integer>> cola = new ColaGenerica<ArbolBinario<Integer>>();
			cola.encolar(ab);
			cola.encolar(null);
			int nivelActual = 0;
			while(!cola.esVacia()) {
				arbol = cola.desencolar();
				if(arbol != null) {
					if(nivelActual > nivel) { //Controla que el nivelActual sea mayor al nivel pasado por parámetro
						if(((arbol.getDato() % 2) != 0) && (arbol.getDato() > limite)) { //Si el dato en el arbol es impar y es superior al limite
							sumatoria += arbol.getDato(); //suma el elemento
						}					
					}
					if(arbol.tieneHijoIzquierdo())
						cola.encolar(arbol.getHijoIzquierdo());
					if(arbol.tieneHijoDerecho())
						cola.encolar(arbol.getHijoDerecho());
				}else if(!cola.esVacia()) {
					nivelActual++;
					cola.encolar(null);
				}
			}
			return sumatoria;
		}else
			return sumatoria; //Si el arbol es vacio, retorna -1, ya que no tenia numeros que sumar
	}
}
