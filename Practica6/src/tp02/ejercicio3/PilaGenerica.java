package tp02.ejercicio3;

import tp02.ejercicio2.*;

public class PilaGenerica<T> {
	
	private ListaGenerica<T> datos = new ListaEnlazadaGenerica<T>();
	
	public PilaGenerica() {
		
	}
	
	public void apilar(T elem) {
		datos.agregarInicio(elem);
	}
	
	public T desapilar() {
		T e = this.tope();
		datos.eliminarEn(1);
		return e;
	}
	
	public T tope(){
		return datos.elemento(1);
	}
	
	public boolean esVacia() {
		return datos.esVacia();
	}
}
