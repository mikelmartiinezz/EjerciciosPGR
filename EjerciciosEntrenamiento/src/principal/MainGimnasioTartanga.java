package principal;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.Map;

import clases.Cliente;
import clases.Entrenamiento;
public class MainGimnasioTartanga {

	public static void main(String[] args) {
		Cliente c = new Cliente("12345678A", "Jon", LocalDate.now());
		c.addEntrenamiento(LocalDate.of(2025, 1, 1), "Sentadillas", 20);
		c.addEntrenamiento(LocalDate.of(2025, 1, 2), "Flexiones", 15);
		c.addEntrenamiento(LocalDate.of(2025, 1, 3), "Burpees", 10);


		System.out.println("--- Cliente inicial ---");
		c.visualizar();


		// Modificar fechas con iterator
		Iterator<Map.Entry<String, Entrenamiento>> it = c.getEntrenamientos().entrySet().iterator();
		while (it.hasNext()) {
		Map.Entry<String, Entrenamiento> entry = it.next();
		Entrenamiento ent = entry.getValue();
		ent.setFecha(ent.getFecha().plusDays(1));
		}


		System.out.println("\n--- Cliente tras modificar fechas ---");
		c.visualizar();
		}
		}
