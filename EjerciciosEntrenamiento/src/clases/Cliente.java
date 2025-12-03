package clases;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cliente extends Persona {
	private LocalDate fechaAlta;
	private Map<String, Entrenamiento> entrenamientos;
	private int contador = 100;

	public Cliente(String dni, String nombre, LocalDate fechaAlta) {
		super(dni, nombre);
		this.fechaAlta = fechaAlta;
		this.entrenamientos = new LinkedHashMap<>();
	}

	public void addEntrenamiento(LocalDate fecha, String ejercicio, int repeticiones) {
		String codigo = "WOD-" + contador++;
		entrenamientos.put(codigo, new Entrenamiento(fecha, ejercicio, repeticiones));
	}

	public Map<String, Entrenamiento> getEntrenamientos() {
		return entrenamientos;
	}

	@Override
	public void visualizar() {
		System.out.println("===== CLIENTE =====");
		System.out.println(nombre + " - DNI: " + dni);
		System.out.println("Fecha alta: " + fechaAlta);
		System.out.println("-- Entrenamientos --");
		for (Map.Entry<String, Entrenamiento> e : entrenamientos.entrySet()) {
			System.out.println(e.getKey() + ": " + e.getValue());
		}
	}
}