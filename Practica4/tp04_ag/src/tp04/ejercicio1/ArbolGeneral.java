package tp04.ejercicio1;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;

public class ArbolGeneral<T> {

	private T dato;

	private ListaGenerica<ArbolGeneral<T>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public void setHijos(ListaGenerica<ArbolGeneral<T>> hijos) {
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ArbolGeneral(T dato) {
		this.dato = dato;
	}

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {
		this(dato);
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ListaGenerica<ArbolGeneral<T>> getHijos() {
		return this.hijos;
	}

	public void agregarHijo(ArbolGeneral<T> unHijo) {

		this.getHijos().agregarFinal(unHijo);
	}

	public boolean esHoja() {

		return !this.tieneHijos();
	}
	
	public boolean tieneHijos() {
		return !this.hijos.esVacia();
	}
	
	public boolean esVacio() {

		return this.dato == null && !this.tieneHijos();
	}

	public void eliminarHijo(ArbolGeneral<T> hijo) {
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			if (hijos.incluye(hijo)) 
				hijos.eliminar(hijo);
		}
	}
	
	private void preOrden(ListaEnlazadaGenerica<T> lista) {
		ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
		hijos.comenzar();
		
		lista.agregarFinal(this.getDato());
		
		while(!hijos.fin())
			hijos.proximo().preOrden(lista);
	}
	
	public ListaEnlazadaGenerica<T> preOrden() {
		ListaEnlazadaGenerica<T> lista = new ListaEnlazadaGenerica<T>();
		if(!this.esVacio()) {
			this.preOrden(lista);
		}
		return lista;
	}
	
	private void inOrden(ListaEnlazadaGenerica<T> lista) {
		ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
		hijos.comenzar();
		
		if(!this.esHoja()) {
			hijos.proximo().inOrden(lista);
		}

		
		lista.agregarFinal(this.getDato());
		
		while(!hijos.fin())
			hijos.proximo().inOrden(lista);
	}
	
	public ListaEnlazadaGenerica<T> inOrden() {
		ListaEnlazadaGenerica<T> lista = new ListaEnlazadaGenerica<T>();
		if(!this.esVacio()) {
			this.inOrden(lista);
		}
		return lista;
	}
	
	private void postOrden(ListaEnlazadaGenerica<T> lista) {
		ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
		hijos.comenzar();
		
		while(!hijos.fin())
			hijos.proximo().postOrden(lista);
		
		lista.agregarFinal(this.getDato());
	}
	
	public ListaEnlazadaGenerica<T> postOrden() {
		ListaEnlazadaGenerica<T> lista = new ListaEnlazadaGenerica<T>();
		if(!this.esVacio()) {
			this.postOrden(lista);
		}
		return lista;
	}
	
	public ListaEnlazadaGenerica<T> recorridoPorNiveles (){
		ListaEnlazadaGenerica<T> l=new ListaEnlazadaGenerica<T>();
        ColaGenerica <ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral <T>> ();
        cola.encolar(this);
        cola.encolar(null);
        while(!cola.esVacia()){
            ArbolGeneral<T> arbol = cola.desencolar();
            if(arbol != null){
                l.agregarFinal (arbol.getDato());
                ListaGenerica<ArbolGeneral<T>> hijos = arbol.getHijos();
                hijos.comenzar();
                while(!hijos.fin()){
                    ArbolGeneral<T> hijo = hijos.proximo();
                    if(!hijo.esVacio())
                        cola.encolar(hijo);
                }
            }
            else if(!cola.esVacia())
                    cola.encolar(null);
        }
        return l;
    }

	
    public void PorNiveles(){
        if(!this.esVacio()){
            ColaGenerica <ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral <T>> ();
            cola.encolar(this);
            cola.encolar(null);
            while(!cola.esVacia()){
                ArbolGeneral<T> arbol = cola.desencolar();
                if(arbol != null){
                    System.out.print(arbol.getDato()+" ");
                    ListaGenerica<ArbolGeneral<T>> hijos = arbol.getHijos();
                    hijos.comenzar();
                    while(!hijos.fin()){
                        ArbolGeneral<T> hijo = hijos.proximo();
                        if(!hijo.esVacio())
                            cola.encolar(hijo);
                    }
                }
                else if(!cola.esVacia())
                        cola.encolar(null);
            }
        }
    }
	
	public Integer altura2() {
		if(!this.esVacio()) {
			if(this.esHoja()) {
				return 0;
			}else {
				ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
				ArbolGeneral<T> unHijo = null;
				int maximo = 0;
				int altCalc = 0;
				hijos.comenzar();
				while(!hijos.fin()) {
					unHijo = hijos.proximo();
					altCalc = unHijo.altura2();
					if(maximo < altCalc)
						maximo = altCalc;
				}
				return 1 + maximo;
			}
		}
		return 0;
	}
	
	public Integer altura() {
		ArbolGeneral<T> arbol;
		ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
		int max = 0;
		int alturaArbol = 0;
		if(!hijos.esVacia()) {
			hijos.comenzar();
			while(!hijos.fin()) {
				arbol = hijos.proximo();
				alturaArbol = 1 + arbol.altura();
				max = Math.max(max, alturaArbol);
			}
		}
		return max;
	}
	

	public Integer nivel(T dato) {
            int altura = 0;
            if (this.getDato() == dato){
                return altura;           
            }
            else {
                if (this.esHoja()){
                    return -1;
                }
                else {
                    ListaGenerica <ArbolGeneral<T>> hijos= this.getHijos();
                    hijos.comenzar();
                    boolean encontrado = false;
                    while ((!hijos.fin()) && (!encontrado)){
                        ArbolGeneral <T> hijo = hijos.proximo();
                        altura = hijo.nivel(dato);
                        if (altura != -1)
                            encontrado=true;
                    }
                }
                if (altura != -1)
                	altura++;   
                return altura;
            }
	}

    public int ancho(){
        int cantMax=-1; int cantAct=0;
        if(!this.esVacio()){ 
            ColaGenerica <ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral <T>> ();
            cola.encolar(this);
            cola.encolar(null);
            //Inicia primer nivel
            while(!cola.esVacia()){
                
                ArbolGeneral<T> arbol = cola.desencolar();
                if(arbol != null){
                    cantAct=cantAct+1;
                    ListaGenerica<ArbolGeneral<T>> hijos = arbol.getHijos();
                    hijos.comenzar();
                    while(!hijos.fin()){
                        
                        ArbolGeneral<T> hijo = hijos.proximo();
                        if(!hijo.esVacio())
                            cola.encolar(hijo);
                    }
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
    
    public boolean esAncestro(T a, T b){
    	boolean es = false;
    	if(a != null){
    		if(this.getDato() != a){
    			if(this.tieneHijos()){
    				ListaGenerica<ArbolGeneral<T>> lista;
    				lista = this.getHijos();
    				lista.comenzar();
    				while(!lista.fin() && !es)
    					es = lista.proximo().esAncestro(a,b);
    			}
    		}else{
    			if(this.tieneHijos()){
    				ListaGenerica<ArbolGeneral<T>> lista;
    				lista = this.getHijos();
    				lista.comenzar();
    				while(!lista.fin() && !es)
    					es = lista.proximo().esAncestro(null, b);
    			}
    		return es;
    		}
    	}else {
    		if(this.getDato () == b)
    			return true;
    		else
    			if(this.tieneHijos()){
    				ListaGenerica<ArbolGeneral<T>> lista;
    				lista = this.getHijos();
    				lista.comenzar();
    				while(!lista.fin() && !es)
    					es = lista.proximo().esAncestro(a, b);
    				return es;
    			}
    			else
    				return false;
    	}
    	return es;
    }

}