package tp04.ejercicio1;

public class RedAguaPotable {
	private ArbolGeneral<Double> arbol; 
	
	public RedAguaPotable(ArbolGeneral<Double> arbol) {
		this.arbol = arbol;
	}

	public ArbolGeneral<Double> getArbol() {
		return arbol;
	}

	public void setArbol(ArbolGeneral<Double> arbol) {
		this.arbol = arbol;
	}
	
	private double minimoCaudal(double caudal, ArbolGeneral<Double> arbol) {
		double min = Double.MAX_VALUE;
		arbol.setDato(caudal);
		double caudalActual = arbol.getDato();
		if(!arbol.esHoja()) {
			int cantHijos = arbol.getHijos().tamanio();
			arbol.getHijos().comenzar();
			while(!arbol.getHijos().fin()) {
				caudalActual = minimoCaudal((caudal/cantHijos), arbol.getHijos().proximo());
				if (caudalActual < min)
					min = caudalActual;
			}
		}else {
			if(min > caudalActual) {
				min = caudalActual;
			}
		}
		return min;
	}
	
	public double minimoCaudal(double caudal) {
		if(!this.getArbol().esVacio()) {
			double minimo = 0;
			minimo = minimoCaudal(caudal, this.getArbol());
			return minimo;			
		}
		return -1;
	}
}
