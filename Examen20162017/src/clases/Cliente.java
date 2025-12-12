package clases;

import java.time.LocalDate;
import java.util.ArrayList;

public class Cliente extends Persona {

	// ------- ATRIBUTOS -------
	private String codigoCliente;
	private float altura;
	private ArrayList<Medicion> mediciones;

	// ------- CONSTRUCTOR -------
	public Cliente(String nombre, LocalDate fechaNacimiento, String codigoCliente, float altura,
			ArrayList<Medicion> mediciones) {
		super(nombre, fechaNacimiento);
		this.codigoCliente = codigoCliente;    
		this.altura = altura;
		this.mediciones = mediciones;
		generarCodigo();                          // <-- importante para que salga "AN-59"
	}
	
	public String getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public ArrayList<Medicion> getMediciones() {
		return mediciones;
	}

	public void setMediciones(ArrayList<Medicion> mediciones) {
		this.mediciones = mediciones;
	}

	private void generarCodigo(){
		String letras = nombre.substring(0,2).toUpperCase();
		String year = String.valueOf(fechaNacimiento.getYear());
		year = year.substring(year.length()-2);
		this.codigoCliente = letras + "-" + year;
	}

	public void addMedicion(Medicion m){ mediciones.add(m); }

	public float getUltimoPeso(){
		return mediciones.get(mediciones.size()-1).getPeso();
	}

	public double getIMC(){
		if(altura == 0) return 0;
		return getUltimoPeso() / (altura*altura);
	}

	@Override
	public String toString() {
		return "Cliente [Nombre=" + nombre + ", Código=" + codigoCliente + ", Altura=" + altura + "]";
	}


}
