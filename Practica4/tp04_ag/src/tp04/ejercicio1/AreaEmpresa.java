package tp04.ejercicio1;

public class AreaEmpresa {
	private String identificacion;
	private Integer tardanzaTransmision;
	
	public AreaEmpresa(String identificacion, Integer tardanzaTransmision) {
		this.identificacion = identificacion;
		this.tardanzaTransmision = tardanzaTransmision;
	}
	
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	public Integer getTardanzaTransmision() {
		return tardanzaTransmision;
	}
	public void setTardanzaTransmision(Integer tardanzaTransmision) {
		this.tardanzaTransmision = tardanzaTransmision;
	}

	@Override
	public String toString() {
		return "AreaEmpresa [identificacion=" + identificacion + ", tardanzaTransmision=" + tardanzaTransmision + "]";
	}
	
	
}
