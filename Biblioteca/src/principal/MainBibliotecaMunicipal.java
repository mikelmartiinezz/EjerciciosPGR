package principal;

import java.util.ArrayList;

import clases.Bibliotecario;
import clases.Socio;
import clases.Util;

public class MainBibliotecaMunicipal{

	public static void main(String[] args) {
		ArrayList<Socio> socios = new ArrayList<>();
		int opc = 0;


		do {
			opc = menu(opc);
			opc = Util.leerInt("Introduce una opcion");

			switch (opc) {
			case 0:
				introducirDatos(socios);
				break;
			case 1:
				visualizarTodosSocios(socios);
				break;
			case 2:
				visualizarBibliotecarios(socios);
				break;
			case 3:
				visualizarBibliotecariosPorSeccion(socios);
				break;
			case 4:
				buscarPorNombre(socios);
				break;
			case 5:
				buscarPorCuota(socios);
				break;
			case 6:
				buscarBibliotecariosPorAntiguedad(socios);
				break;
			case 7:
				darDeBaja(socios);
				break;
			case 8:
				System.out.println("\nCerrando el sistema...");
				break;
			default:
				System.out.println("Error: opción no válida");
			}
		} while (opc != 8);

	}

	private static void darDeBaja(ArrayList<Socio> socios) {
		System.out.println("\n=== Dar de baja a un socio/bibliotecario ===");

		String dni = Util.introducirCadena("Introduce el DNI de la persona a dar de baja: ");

		boolean encontrado = false;

		for (int i = 0; i < socios.size(); i++) {
			if (socios.get(i).getDni().equalsIgnoreCase(dni)) {
				String nombre = socios.get(i).getNombreCompleto();
				socios.remove(i);
				System.out.println("Baja realizada correctamente.");
				System.out.println("Se ha dado de baja a: " + nombre);
				encontrado = true;
				break;
			}
		}

		if (!encontrado) {
			System.out.println("Error: No existe ninguna persona con ese DNI.");
		}
		
	}

	private static void buscarBibliotecariosPorAntiguedad(ArrayList<Socio> socios) {
		int añosMinimos = Util.leerInt("Introduce el número de años mínimo: ");

		boolean encontrado = false;
		int añoActual = 2024;

		System.out.println(
				"\n=== Bibliotecarios con " + añosMinimos + " años o más de antigüedad ===");

		for (Socio s : socios) {
			if (s instanceof Bibliotecario) {
				int añosAntiguedad = añoActual - s.getAñoAlta();
				if (añosAntiguedad >= añosMinimos) {
					Bibliotecario b = (Bibliotecario) s;
					System.out.println("Nombre: " + b.getNombreCompleto());
					System.out.println("Años de antigüedad: " + añosAntiguedad);
					System.out.println("Sección: " + b.getNombreSeccion());
					encontrado = true;
				}
			}
		}

		if (!encontrado) {
			System.out.println("No se encontraron bibliotecarios con " + añosMinimos + " años o más.");
		}
		
	}

	private static void buscarPorCuota(ArrayList<Socio> socios) {
		int cuotaMinima = Util.leerInt("Introduce la cuota mensual mínima: ");

		boolean encontrado = false;

		System.out.println("\n=== Socios con cuota igual o superior a " + cuotaMinima + "€ ===");

		for (Socio s : socios) {
			if (s.cuotaFinal() >= cuotaMinima) {
				System.out.println("Nombre: " + s.getNombreCompleto());
				System.out.println("Cuota final: " + s.cuotaFinal() + "€");
				if (s instanceof Bibliotecario) {
					System.out.println("*** Es bibliotecario ***");
				}
				encontrado = true;
			}
		}

		if (!encontrado) {
			System.out.println("No se encontraron socios con cuota igual o superior a " + cuotaMinima + "€");
		}
		
	}

	private static void buscarPorNombre(ArrayList<Socio> socios) {
		String nombre = Util.introducirCadena("Introduce el nombre: ");

		boolean encontrado = false;
		int añoActual = 2024;

		System.out.println("\n=== Resultados de la búsqueda ===");

		for (Socio s : socios) {
			if (s.getNombreCompleto().toLowerCase().contains(nombre.toLowerCase())) {
				int añosAntiguedad = añoActual - s.getAñoAlta();
				boolean esBibliotecario = s instanceof Bibliotecario;

				System.out.println("DNI: " + s.getDni());
				System.out.println("Años en la biblioteca: " + añosAntiguedad);
				System.out.println("Es bibliotecario: " + (esBibliotecario ? "Sí" : "No"));
				System.out.println("---------------------------------------------------");
				encontrado = true;
			}
		}

		if (!encontrado) {
			System.out.println("Error: No se encontraron coincidencias con ese nombre.");
		}
		
	}

	private static void visualizarBibliotecariosPorSeccion(ArrayList<Socio> socios) {
		String seccion = Util.introducirCadena("Introduce el nombre de la sección: ");

		boolean encontrado = false;

		for (Socio s : socios) {
			if (s instanceof Bibliotecario) {
				Bibliotecario b = (Bibliotecario) s;
				if (b.getNombreSeccion().equalsIgnoreCase(seccion)) {
					if (!encontrado) {
						System.out.println("\nBibliotecario/s de la sección " + seccion.toUpperCase());
						encontrado = true;
					}
					System.out.println("- " + b.getNombreCompleto());
				}
			}
		}

		if (!encontrado) {
			System.out.println("No hay bibliotecarios en la sección " + seccion);
		}
		
	}

	private static void visualizarBibliotecarios(ArrayList<Socio> socios) {
		System.out.println("\n=== Listado de bibliotecarios ===");

		boolean hayBibliotecarios = false;

		for (Socio s : socios) {
			if (s instanceof Bibliotecario) {
				System.out.println(s.toString());
				hayBibliotecarios = true;
			}
		}

		if (!hayBibliotecarios) {
			System.out.println("No hay bibliotecarios registrados en el sistema.");
		}
		
	}

	private static void visualizarTodosSocios(ArrayList<Socio> socios) {
		System.out.println("\n=== Listado de todos los socios ===");

		if (socios.isEmpty()) {
			System.out.println("No hay socios registrados en el sistema.");
			return;
		}

		for (Socio s : socios) {
			System.out.println(s.toString());
		}
		System.out.println("Total de socios: " + socios.size());
		
	}

	private static void introducirDatos(ArrayList<Socio> socios) {
		System.out.println("\n=== Alta de nuevos socios ===");

	    String dni = Util.introducirCadena("Introduce el DNI del socio: ");
	    
	    if (existeDni(socios, dni)) {
	        System.out.println("Error: Ya existe una persona con ese DNI en el sistema.");
	        return;
	    }

	    String nombreCompleto = Util.introducirCadena("Introduce el nombre completo: ");
	    String nombreBiblioteca = Util.introducirCadena("Introduce el nombre de la biblioteca: ");
	    int mesAlta = Util.leerInt("Introduce el mes de alta (1-12): ", 1, 12);
	    int añoAlta = Util.leerInt("Introduce el año de alta: ");
	    int numLibros = Util.leerInt("Introduce el número de libros permitidos: ");

	    	System.out.println("¿Es bibliotecario? (S/N): ");
	    	char esBibliotecario = Util.leerChar('S', 'N');

	    if (Character.toUpperCase(esBibliotecario) == 'S') {
	        String nombreSeccion = Util.introducirCadena("Introduce la sección del bibliotecario: ");
	        Bibliotecario bibliotecario = new Bibliotecario(nombreBiblioteca, dni, nombreCompleto, 
	                                                         mesAlta, añoAlta, numLibros, nombreSeccion);
	        socios.add(bibliotecario);
	        System.out.println("Bibliotecario dado de alta correctamente.");
	    } else {
	        Socio socio = new Socio(nombreBiblioteca, dni, nombreCompleto, mesAlta, añoAlta, numLibros);
	        socios.add(socio);
	        System.out.println("Socio dado de alta correctamente.");
	    }
	}

	private static boolean existeDni(ArrayList<Socio> socios, String dni) {
	    for (Socio s : socios) {
	        if (s.getDni().equalsIgnoreCase(dni)) {
	            return true;
	        }
	    }
	    return false;
		
	}

	private static int menu(int opc) {
		 System.out.println("\n╔════════════════════════════════════════════════════════════════╗");
		    System.out.println("║          SISTEMA DE GESTIÓN DE BIBLIOTECA                     ║");
		    System.out.println("╚════════════════════════════════════════════════════════════════╝");
		    System.out.println("  0. Introducir datos de socios y/o bibliotecarios");
		    System.out.println("  1. Visualizar todos los socios (con cuota final)");
		    System.out.println("  2. Visualizar únicamente los bibliotecarios");
		    System.out.println("  3. Visualizar bibliotecarios de una sección concreta");
		    System.out.println("  4. Buscar persona por nombre");
		    System.out.println("  5. Buscar socios por cuota mensual");
		    System.out.println("  6. Buscar bibliotecarios por años de antigüedad");
		    System.out.println("  7. Dar de baja a un socio/bibliotecario");
		    System.out.println("  8. Salir");
		    System.out.println("════════════════════════════════════════════════════════════════");
		    
		    return opc;
	}

}


