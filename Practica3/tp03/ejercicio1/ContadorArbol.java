package tp03.ejercicio1;

import tp02.ejercicio2.ColaGenerica;
import tp02.ejercicio2.ListaEnlazadaGenerica;

public class ContadorArbol {
	ArbolBinario<Integer> arbol;

	public ContadorArbol(ArbolBinario<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public ContadorArbol() {
		
	}

	public ArbolBinario<Integer> getArbol() {
		return arbol;
	}

	public void setArbol(ArbolBinario<Integer> arbol) {
		this.arbol = arbol;
	}
	
	private void numerosParesPostOrdenAux(ArbolBinario<Integer> ab, ListaEnlazadaGenerica<Integer> lista) {
		if(ab.tieneHijoIzquierdo()) {
			numerosParesPostOrdenAux(ab.getHijoIzquierdo(), lista);
		}
		if(ab.tieneHijoDerecho()) {
			numerosParesPostOrdenAux(ab.getHijoDerecho(), lista);
		}
		if((ab.getDato() % 2) == 0)
			lista.agregarInicio(ab.getDato());
	}
	
	public ListaEnlazadaGenerica<Integer> numerosParesPostOrden() {
		ListaEnlazadaGenerica<Integer> listaEnteros = new ListaEnlazadaGenerica<Integer>();
		numerosParesPostOrdenAux(this.getArbol(), listaEnteros);
		return listaEnteros;
	}
	
	private void numerosParesInOrdenAux(ArbolBinario<Integer> ab, ListaEnlazadaGenerica<Integer> lista) {
		if(ab.tieneHijoIzquierdo()) {
			numerosParesPostOrdenAux(ab.getHijoIzquierdo(), lista);
		}
		
		if((ab.getDato() % 2) == 0)
			lista.agregarInicio(ab.getDato());
		
		if(ab.tieneHijoDerecho()) {
			numerosParesPostOrdenAux(ab.getHijoDerecho(), lista);
		}
	}
	
	public ListaEnlazadaGenerica<Integer> numerosParesInOrden() {
		ListaEnlazadaGenerica<Integer> listaEnteros = new ListaEnlazadaGenerica<Integer>();
		numerosParesInOrdenAux(this.getArbol(), listaEnteros);
		return listaEnteros;
	}
	
	private boolean esMonodistante(ArbolBinario <Integer> arbol, int k) {
		Boolean ok = true;
		if(arbol.esHoja())
			return arbol.getDato()-k == 0;
		else { 
			if (arbol.tieneHijoIzquierdo() && k > 0){
				ok = esMonodistante(arbol.getHijoIzquierdo(), k - arbol.getDato());
			}
			if (ok && arbol.tieneHijoDerecho() && k > 0){
				ok = esMonodistante(arbol.getHijoDerecho(), k - arbol.getDato());
			}
		}
		return ok;
	}
	
	public boolean esMonodistante(int k){
		if (this.getArbol().esVacio())
			return false;
		return esMonodistante(this.getArbol(), k);
	}
	
	private int contadorOcurrencias(ArbolBinario<Integer> arbol, int elem) {
		int ocurrencias = 0;
		if(arbol.tieneHijoIzquierdo())
			ocurrencias += contadorOcurrencias(arbol.getHijoIzquierdo(), elem);
		if(arbol.tieneHijoDerecho())
			ocurrencias = contadorOcurrencias(arbol.getHijoDerecho(), elem);
		if(elem == arbol.getDato())
			ocurrencias++;
		return ocurrencias;
	}
	
	public int contadorOcurrencias(int elem) {
		if(!this.getArbol().esVacio()) {
			int ocurrencias = 0;
			ocurrencias = contadorOcurrencias(this.getArbol(), elem);
			return ocurrencias;
		}
		return -1;
	}
	
	private void buscar(ArbolBinario<Integer> arbol, int minimo) {
		if(arbol.tieneHijoIzquierdo())
			buscar(arbol.getHijoIzquierdo(), minimo);
		
		if(arbol.getDato() < minimo)
			minimo = arbol.getDato();
		
		if(arbol.tieneHijoDerecho())
			buscar(arbol.getHijoDerecho(), minimo);
	}
	
	public int buscar() {
		int min = Integer.MAX_VALUE;
		if(!this.getArbol().esVacio()) {
			buscar(this.getArbol(), min);
			return min;
		}
		return min;
	}
	
	public int buscarPrimerElementoUltimoNivel() {
		if(!this.getArbol().esVacio()) {
			ArbolBinario<Integer> arbol = null;
			ColaGenerica<ArbolBinario<Integer>> cola = new ColaGenerica<ArbolBinario<Integer>>();
			ArbolBinario<Integer> arbolBinarioClase = new ArbolBinario<Integer>(this.getArbol().getDato());
			if(this.getArbol().tieneHijoIzquierdo())
				arbolBinarioClase.agregarHijoIzquierdo(this.getArbol().getHijoIzquierdo());
			if(this.getArbol().tieneHijoDerecho())
				arbolBinarioClase.agregarHijoDerecho(this.getArbol().getHijoDerecho());
			cola.encolar(arbolBinarioClase);
			cola.encolar(null);
			boolean podes = true;
			int datazo = 0;
			while(!cola.esVacia()) {
				arbol = cola.desencolar();
				if(arbol != null) {
					if(podes) {
						datazo = arbol.getDato();
						podes = false;
					}
					if(arbol.tieneHijoIzquierdo())
						cola.encolar(arbol.getHijoIzquierdo());
					if(arbol.tieneHijoDerecho())
						cola.encolar(arbol.getHijoDerecho());
				}else if(!cola.esVacia()) {
					cola.encolar(null);
					podes = true;
				}
			}
			return datazo;
		}
		return -1;
	}
	
	public boolean esPrimo(Integer num) {
		int contador = 2;
		boolean primo = true;
		while((primo)&& (contador != num)) {
			if((num % contador) == 0)
				primo = false;
			contador++;
		}
		return primo;
	}
	
	public Integer buscarNumeroPrimo() {
		ArbolBinario<Integer> arbol = null;
		ColaGenerica<ArbolBinario<Integer>> cola = new ColaGenerica<ArbolBinario<Integer>>();
		ArbolBinario<Integer> arbolBinarioClase = new ArbolBinario<Integer>(this.getArbol().getDato());
		if(this.getArbol().tieneHijoIzquierdo())
			arbolBinarioClase.agregarHijoIzquierdo(this.getArbol().getHijoIzquierdo());
		if(this.getArbol().tieneHijoDerecho())
			arbolBinarioClase.agregarHijoDerecho(this.getArbol().getHijoDerecho());
		cola.encolar(arbolBinarioClase);
		cola.encolar(null);
		int datazo = 0;
		boolean fin = true;
		while((!cola.esVacia()) && (fin)) {
			arbol = cola.desencolar();
			if(arbol != null) {
				if(esPrimo(arbol.getDato())) {
					datazo = arbol.getDato();
					fin = false;
				}else {
					if(arbol.tieneHijoIzquierdo())
						cola.encolar(arbol.getHijoIzquierdo());
					if(arbol.tieneHijoDerecho())
						cola.encolar(arbol.getHijoDerecho());
				}
			}else if(!cola.esVacia()) {
				cola.encolar(null);
			}
		}
		if(fin) {
			System.out.println("No se encontro el dato, el int devuelto, es basura");
			return -1;
		}
		return datazo;
	}
	

	public void colorearArbol (ArbolBinario<String> arbol, Integer maxColor ){
		if(!(arbol.esVacio())) { //si el arbol es vacio no es necesario colorear la raiz
			int n=0;
			String neg="negro", ro="rojo", ver="verde";
			ColaGenerica<ArbolBinario<String>> cola = new ColaGenerica<ArbolBinario<String>>();
			cola.encolar(arbol);     //encola raiz del arbol
			cola.encolar(null);     //marca (terminaste de procesar nivel)
			System.out.print("Nivel " + n + ": ");
			arbol.setDato(neg);  //colorea la raiz de negro
			int i = 0;  //para llevar la cuenta de los nodos pintados en el nivel
			while (!cola.esVacia()) {  
				arbol = cola.desencolar();  //desencola el nodo(cada nodo tiene HI e HD)
				if (arbol != null){
					//cambio raiz
					if((n % 2) != 0) {  //el nivel es impar y colorea rojo
						if((i < maxColor)) {  //&& ()
							arbol.setDato(ro);
						}else {
							arbol.setDato(ver);
						}
					}else {  //el nivel es par y colorea negro
						if((i < maxColor)) {  //&& ()
							arbol.setDato(neg);
						}else {
							arbol.setDato(ver);
						}  
					}
					i++; //se incrementa i xq se coloreo un nodo
					if (arbol.tieneHijoIzquierdo())
						cola.encolar(arbol.getHijoIzquierdo()); //encola hijo izq
					if (arbol.tieneHijoDerecho())
						cola.encolar(arbol.getHijoDerecho()); //encola hijo derecho
				}
				else if (!cola.esVacia()) {  //si no se pone se hace bucle
					System.out.println();
					n=n+1;
					i = 0; //"reinicio" el contador xq el nuevo nivel
					System.out.print("Nivel " + n + ": ");
					cola.encolar(null); //marca de fin de nivel
				}
       		}
		}
	}
}
    	
	
