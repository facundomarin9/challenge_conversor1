package proyect.utilities;



public class Temperaturas {
	final double TEM = 273.15;
	
	
	private int id;
	private String nombreTemp;
	private String abrevTemp;
	
	public Temperaturas(){
	}
	
	public Temperaturas(int id, String nombreTemp, String abrevTemp) {
		this.id = id;
		this.nombreTemp = nombreTemp;
		this.abrevTemp = abrevTemp;
		
	}
	
	public Double convert (Double inputTemp, int comboBox1, int comboBox2) {
		
		
		
		if(comboBox1 == 0 && comboBox2 == 1) {
			return inputTemp - TEM;
		}else if(comboBox1 == 0 && comboBox2 == 2) {
			return (inputTemp - TEM) * 9/5 + 32;
		}else if(comboBox1 == 1 && comboBox2 == 0) {
			return inputTemp + TEM;
		}else if(comboBox1 == 1 && comboBox2 == 2) {
			return (inputTemp * 9/5) + 32;
		}else if(comboBox1 == 2 && comboBox2 == 0){
			return (inputTemp - 32) * 5/9 + TEM;	
		}else if(comboBox1 == 2 && comboBox2 == 1) {
			return (inputTemp - 32) * 5/9;
		}else {
			return 0.0;
		}
	
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreTemp() {
		return nombreTemp;
	}
	public void setNombreTemp(String nombreTemp) {
		this.nombreTemp = nombreTemp;
	}
	public String getAbrevTemp() {
		return abrevTemp;
	}
	public void setAbrevTemp(String abrevTemp) {
		this.abrevTemp = abrevTemp;
	}
	
	
	
}
