package tp03.ejercicio1;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio2.ColaGenerica;

public class ArbolBinario<T> {
	private T dato;
	private ArbolBinario<T> hijoIzquierdo;   
	private ArbolBinario<T> hijoDerecho; 

	
	public ArbolBinario() {
		super();
	}

	public ArbolBinario(T dato) {
		this.dato = dato;
	}

	/*
	 * getters y setters
	 * 
	 */
	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}
	
	/**
	 * Preguntar antes de invocar si tieneHijoIzquierdo()
	 * @return
	 */	
	
	public ArbolBinario<T> getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}

	public ArbolBinario<T> getHijoDerecho() {
		return this.hijoDerecho;

	}

	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.hijoIzquierdo = hijo;
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.hijoDerecho = hijo;
	}

	public void eliminarHijoIzquierdo() {
		this.hijoIzquierdo = null;
	}

	public void eliminarHijoDerecho() {
		this.hijoDerecho = null;
	}

	public boolean esVacio() {
		return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
	}

	public boolean esHoja() {
		return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());

	}

	@Override
	public String toString() {
		return this.getDato().toString();
	}

	 
	public boolean tieneHijoIzquierdo() {
		return this.hijoIzquierdo!=null;
	}

	 
	public boolean tieneHijoDerecho() {
		return this.hijoDerecho!=null;
	}
	
	public boolean esLleno() {
		boolean condicion = true;
		int nivel = 0;
		int sumaNodos = 1;
		ArbolBinario<T> arbol = null;
		ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<ArbolBinario<T>>();
		cola.encolar(this);
		cola.encolar(null);
		while(!cola.esVacia() && (condicion)) {
			arbol = cola.desencolar();
			if(arbol != null) {
				System.out.println(arbol.getDato());
				if(arbol.esHoja()) {
					sumaNodos++;
				}else {
					if(arbol.tieneHijoIzquierdo() && (arbol.tieneHijoDerecho())){
						cola.encolar(arbol.getHijoIzquierdo());
						sumaNodos++;
						cola.encolar(arbol.getHijoDerecho());
						sumaNodos++;
					}else {
						condicion = false;
					}
				}
			}else if(!cola.esVacia()) {
				System.out.println();
				nivel++;
				cola.encolar(null);
			}
		}
		if(!(((Math.pow(2, (nivel+1))-1)) == sumaNodos)) {
			condicion = false;
		}
		return condicion;
	}

	public boolean esCompleto() {
		return true;
	}

	
	// imprime el árbol en preorden  
	public void printPreorden() {
		System.out.println(this.getDato() + " ");
		if(this.tieneHijoIzquierdo())
			this.getHijoIzquierdo().printPreorden();
		if(this.tieneHijoDerecho())
			this.getHijoDerecho().printPreorden();	
	}

	// imprime el �rbol en postorden
	public void printPostorden() {
		if(this.tieneHijoIzquierdo())
			this.getHijoIzquierdo().printPostorden();
		if(this.tieneHijoDerecho())
			this.getHijoDerecho().printPostorden();
		System.out.println(this.getDato() + " ");
	}

	public void inOrden() {
		if(this.tieneHijoIzquierdo())
			this.getHijoIzquierdo().inOrden();
		
		System.out.println(this.getDato() + " ");
		
		if(this.tieneHijoDerecho())
			this.getHijoDerecho().inOrden();
	}
	
	public void recorridoPorNiveles() {
		ArbolBinario<T> arbol = null;
		ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<ArbolBinario<T>>();
		cola.encolar(this);
		cola.encolar(null);
		while(!cola.esVacia()) {
			arbol = cola.desencolar();
			if(arbol != null) {
				System.out.println(arbol.getDato());
				if(arbol.tieneHijoIzquierdo())
					cola.encolar(arbol.getHijoIzquierdo());
				if(arbol.tieneHijoDerecho())
					cola.encolar(arbol.getHijoDerecho());
			}else if(!cola.esVacia()) {
				System.out.println();
				cola.encolar(null);
			}
		}
	}
	
	public void entreNiveles(int n, int m) {
		ArbolBinario<T> arbol = null;
		ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<ArbolBinario<T>>();
		cola.encolar(this);
		cola.encolar(null);
		int nivel = 0;
		while(!cola.esVacia()) {
			arbol = cola.desencolar();
			if(arbol != null) {
				if((nivel >= n) && (nivel <= m))
					System.out.println(arbol.getDato());
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
	}
	
    public int ancho(){
        int cantMax=-1; int cantAct=0;
        if(!this.esVacio()){ 
            ColaGenerica <ArbolBinario<T>> cola = new ColaGenerica<ArbolBinario <T>> ();
            cola.encolar(this);
            cola.encolar(null);
            //Inicia primer nivel
            while(!cola.esVacia()){
                ArbolBinario<T> arbol = cola.desencolar();
                if(arbol != null){
                    cantAct++;
    				if(arbol.tieneHijoIzquierdo())
    					cola.encolar(arbol.getHijoIzquierdo());
    				if(arbol.tieneHijoDerecho())
    					cola.encolar(arbol.getHijoDerecho());
                    }
                else{
                    if(!cola.esVacia()){
                        if (cantAct>cantMax){
                            cantMax=cantAct; 
                        }
                        cantAct=0;
                        cola.encolar(null);
                     
                    }
                }
            }
        
        }  
        return cantMax;
    }
    
	
	public ListaGenerica<T> frontera() {
		ListaGenerica<T> l = new ListaEnlazadaGenerica<T>();

		return l;
	}

	
	
	public int contarHojas() {
		int hojasIzq = 0; int hojasDer= 0;
		if(this.esVacio()) return 0;
		else if(this.esHoja()) return 1;
		else{
			if(this.tieneHijoIzquierdo())
				hojasIzq = this.getHijoIzquierdo().contarHojas();
			if(this.tieneHijoDerecho())
				hojasDer = this.getHijoDerecho().contarHojas();
		return hojasIzq + hojasDer;
		}
	}
	
	public ArbolBinario<T> espejo() {
		ArbolBinario<T> nuevoArbol = new ArbolBinario<T>(this.getDato());
		if(this.tieneHijoIzquierdo())
			nuevoArbol.agregarHijoDerecho(this.getHijoIzquierdo().espejo());
		if(this.tieneHijoDerecho())
			nuevoArbol.agregarHijoIzquierdo(this.getHijoDerecho().espejo());
		return nuevoArbol;
	}
	
	public int contarNodosConDosHijos() {
		int cant = 0;
		if(!this.esVacio()) {
			if(this.tieneHijoIzquierdo())
				cant += this.getHijoIzquierdo().contarNodosConDosHijos();
			if(this.tieneHijoDerecho())
				cant += this.getHijoDerecho().contarNodosConDosHijos();	
			if((this.tieneHijoIzquierdo()) && (this.tieneHijoDerecho()))
				cant++;
		}
		return cant;
	}
	
	public int cantidadHijosPares() {
		int cant = 0;
		if(this.tieneHijoIzquierdo())
			cant += this.getHijoIzquierdo().cantidadHijosPares();
		
		if((this.tieneHijoIzquierdo() && this.tieneHijoDerecho()) || (this.esHoja()))
			cant++;
		
		if(this.tieneHijoDerecho())
			cant += this.getHijoDerecho().cantidadHijosPares();
		
		return cant;
	}
	
	public ListaEnlazadaGenerica<Integer> resolver(ArbolBinario<Integer> arbol) {
		  ListaEnlazadaGenerica<Integer> l = new ListaEnlazadaGenerica<>();
		  this.armarLista(arbol, l);
		  return l;
	}
	
	private Integer armarLista(ArbolBinario<Integer> arbol, ListaEnlazadaGenerica<Integer> l) {
		int izqDesc = 0, derDesc = 0;
		if (!arbol.esVacio()) {
			if (arbol.tieneHijoDerecho()) {
				derDesc += this.armarLista(arbol.getHijoDerecho(), l);
			}
			if (arbol.tieneHijoIzquierdo()) {
				izqDesc += this.armarLista(arbol.getHijoIzquierdo(), l);
			}
			if (izqDesc == derDesc) {
				l.agregarInicio(arbol.getDato());
			}
		}
		return izqDesc + derDesc + 1;
	}
}
