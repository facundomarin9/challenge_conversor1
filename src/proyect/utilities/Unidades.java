package proyect.utilities;

public class Unidades {
	
	private int id;
	private String unidadNombre;
	private String medida;
	private Double valor;
	
	public Unidades () {
		
	}
	
	public Unidades (int id, String unidadNombre, String medida, Double valor) {
		this.id = id;
		this.unidadNombre = unidadNombre;
		this.medida = medida;
		this.valor = valor;
	}
	
	public Double convertir(Double texField, Unidades unidad) {
		
		if(this.id == unidad.getId()) {	
			return texField;	
		}else if(this.id == 0) {
			return texField / unidad.getValor();	
		}else {	
			return (texField * this.valor) / unidad.getValor();	
		}
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUnidadNombre() {
		return unidadNombre;
	}
	public void setUnidadNombre(String unidadNombre) {
		this.unidadNombre = unidadNombre;
	}
	public String getMedida() {
		return medida;
	}
	public void setMedida(String medida) {
		this.medida = medida;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
	
	
}
