package ejercicio5;

public class PuntoC {
	private int maximo;
	private int minimo;
	private double promedio;
	
	public PuntoC() {
		this.maximo = Integer.MIN_VALUE;
		this.minimo = Integer.MAX_VALUE;
		this.promedio = 0;
	}
	
	public int getMaximo() {
		return maximo;
	}
	public void setMaximo(int maximo) {
		this.maximo = maximo;
	}
	public int getMinimo() {
		return minimo;
	}
	public void setMinimo(int minimo) {
		this.minimo = minimo;
	}
	public double getPromedio() {
		return promedio;
	}
	public void setPromedio(double promedio) {
		this.promedio = promedio;
	}
	
	public void recibirArreglo(int[] array){
		for(int i = 0; i < array.length; i++) {
			if(array[i] < getMinimo())
				setMinimo(array[i]);
			if(array[i] > getMaximo())
				setMaximo(array[i]);
			
			setPromedio(getPromedio() + array[i]);
		}
		setPromedio(getPromedio() / array.length);
	}

	@Override
	public String toString() {
		return "PuntoC [maximo=" + maximo + ", minimo=" + minimo + ", promedio=" + promedio + "]";
	}
	
}
