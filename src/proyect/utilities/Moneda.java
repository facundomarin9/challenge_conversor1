package proyect.utilities;

import java.util.ArrayList;

public class Moneda {

	private int id;
	private String nombreMoneda;
	private String abreviacion;
	private Double valorDelMercado;
	
	public Moneda() {
		
	}
	
	public Moneda(int id, String nombreMoneda, String abreviacion, Double valorDelMercado) {
		
		this.id = id;
		this.nombreMoneda = nombreMoneda;
		this.abreviacion = abreviacion;
		this.valorDelMercado = valorDelMercado;
		
	}
	
	
	
	public double convertir(Double cantidadIngresa, Moneda moneda, boolean toArs) {
		
		if(!toArs) {
			
			return cantidadIngresa / moneda.getValorDelMercado();
			
		}else {
			
			return cantidadIngresa * moneda.getValorDelMercado();
			
		}
		
		

	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreMoneda() {
		return nombreMoneda;
	}

	public void setNombreMoneda(String nombreMoneda) {
		this.nombreMoneda = nombreMoneda;
	}
	

	public String getAbreviacion() {
		return abreviacion;
	}

	public void setAbreviacion(String abreviacion) {
		this.abreviacion = abreviacion;
	}

	public Double getValorDelMercado() {
		return valorDelMercado;
	}

	public void setValorDelMercado(Double valorDelMercado) {
		this.valorDelMercado = valorDelMercado;
	}
	
	@Override
	public String toString() {
		return "Moneda("+"id="+id+", nombreMoneda="+ nombreMoneda+", valorDelMercado="+valorDelMercado+')';
	}
	
	
}
