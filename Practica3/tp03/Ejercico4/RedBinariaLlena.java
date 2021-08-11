package tp03.Ejercico4;

import tp03.ejercicio1.ArbolBinario;

public class RedBinariaLlena {
	
	ArbolBinario<Integer> arbol;
	
	public RedBinariaLlena(ArbolBinario<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public RedBinariaLlena() {
		
	}

	public ArbolBinario<Integer> getArbol() {
		return arbol;
	}

	public void setArbol(ArbolBinario<Integer> arbol) {
		this.arbol = arbol;
	}
	
	private int retardoReenvioAux(ArbolBinario<Integer> arbol) {
		int izq = 0; int der = 0; // int mayor = 0;
		if(!arbol.esHoja()) {
			if(arbol.tieneHijoIzquierdo())
				izq = retardoReenvioAux(arbol.getHijoIzquierdo());
			
			if(arbol.tieneHijoDerecho())
				der = retardoReenvioAux(arbol.getHijoDerecho());
			
			return (izq > der)?izq+arbol.getDato():der+arbol.getDato();
		}
		return arbol.getDato();
	}
	
	public int retardoReenvio() {
		int mayor = 0;
		mayor = retardoReenvioAux(this.getArbol());
		return mayor;
	}
	
//	public int retardoEnvio(ArbolBinario<Integer> arbol):
//	    if arbol.esHoja(){
//	        return arbol.getDato()
//	    } else {
		
//	        rHI = retardoEnvio(arbol.HI())
//	        rHD = retardoEnvio(arbol.HD())
//	        max = Math.max(rHI, rHD)
//	        return max + arbol.getDato()
//	    }
}
