package tp03.ejercicio1;

public class ValidadorArbol {
	ArbolBinario<Integer> arbol;
	
	public ValidadorArbol(ArbolBinario<Integer> arbol) {
		super();
		this.arbol = arbol;
	}

	public ArbolBinario<Integer> getArbol() {
		return arbol;
	}

	public void setArbol(ArbolBinario<Integer> arbol) {
		this.arbol = arbol;
	}
}
