package principal;

import clases.*;
import java.util.ArrayList;

public class MainProfesor {

	private static Universidad uni = new Universidad();

	public static void main(String[] args) {

		int opcion;

		do {
			mostrarMenu();
			opcion = Utilidades.leerInt("Elige opción: ");

			switch (opcion) {
			case 1:
				introducirProfesor();
				break;
			case 2:
				añadirPublicacion();
				break;
			case 3:
				mostrarLibrosPremiados();
				break;
			case 4:
				mostrarListadoPorDepartamento();
				break;
			case 5:
				listarProfesores();
				break;
			case 6:
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Opción incorrecta.");
			}

		} while (opcion != 6);
	}

	// ---------------- MÉTODOS DEL MENÚ --------------------

	private static void mostrarMenu() {
		System.out.println("""
				==== MENÚ ====
				1. Introducir profesor
				2. Añadir publicación
				3. Libros premiados por año
				4. Listado por departamento
				5. Listado de profesores
				6. Salir
				""");
	}

	private static void introducirProfesor() {

		String email = Utilidades.introducirCadena("Introduce email:");

		if (!Universidad.validarEmail(email)) {
			System.out.println("Email inválido.");
			return;
		}

		if (uni.buscarProfesor(email) != null) {
			System.out.println("Ese profesor ya existe.");
			return;
		}

		String nombre = Utilidades.introducirCadena("Nombre del profesor:");
		String dep = Utilidades.introducirCadena("Departamento:");

		uni.añadirProfesor(email, nombre, dep);
		System.out.println("Profesor añadido.");
	}

	private static void añadirPublicacion() {
		String email = Utilidades.introducirCadena("Email del profesor:");

		Profesor p = uni.buscarProfesor(email);

		if (p == null) {
			System.out.println("Ese profesor no existe.");
			return;
		}

		String seguir = "s";

		while (seguir.equalsIgnoreCase("s")) {

			int tipo = Utilidades.leerInt(1, 2, "1 = Libro | 2 = Artículo: ");

			String fecha = Utilidades.introducirCadena("Fecha (dd/mm/aaaa):");
			String titulo = Utilidades.introducirCadena("Título:");

			if (tipo == 1) {
				String isbn = Utilidades.introducirCadena("ISBN:");
				boolean premiado = Utilidades.leerRespuesta("¿Premiado? (s/n):");
				p.añadirPublicacion(new Libro(fecha, titulo, isbn, premiado));

			} else {
				String medio = Utilidades.introducirCadena("Medio de publicación:");
				p.añadirPublicacion(new Articulo(fecha, titulo, medio));
			}

			seguir = Utilidades.introducirCadena("¿Añadir otra publicación? (s/n):");
		}
	}

	private static void mostrarLibrosPremiados() {
		int anio = Utilidades.leerInt("Introduce año:");

		ArrayList<String> lista = uni.librosPremiados(anio);

		if (lista.isEmpty()) {
			System.out.println("No hay libros premiados ese año.");
			return;
		}

		lista.forEach(System.out::println);
	}

	private static void mostrarListadoPorDepartamento() {

		var mapa = uni.listadoPorDepartamento();

		if (mapa.isEmpty()) {
			System.out.println("No hay publicaciones registradas.");
			return;
		}

		for (String dep : mapa.keySet()) {
			System.out.println("\nDepartamento: " + dep);

			for (Profesor p : mapa.get(dep)) {
				System.out.println(p.getNombre() + " | Publicaciones: " + p.getPublicaciones().size());
			}
		}
	}

	private static void listarProfesores() {
		uni.mostrarProfes();
	}
}
