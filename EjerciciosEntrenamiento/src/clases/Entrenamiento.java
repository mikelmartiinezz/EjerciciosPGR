package clases;

import java.time.LocalDate;

public class Entrenamiento {
	private LocalDate fecha;
	private String ejercicio;
	private int repeticiones;

	public Entrenamiento(LocalDate fecha, String ejercicio, int repeticiones) {
		super();
		this.fecha = fecha;
		this.ejercicio = ejercicio;
		this.repeticiones = repeticiones;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getEjercicio() {
		return ejercicio;
	}

	public void setEjercicio(String ejercicio) {
		this.ejercicio = ejercicio;
	}

	public int getRepeticiones() {
		return repeticiones;
	}

	public void setRepeticiones(int repeticiones) {
		this.repeticiones = repeticiones;
	}

	@Override
	public String toString() {
		return "Entrenamiento [fecha=" + fecha + ", ejercicio=" + ejercicio + ", repeticiones=" + repeticiones + "]";
	}

}
