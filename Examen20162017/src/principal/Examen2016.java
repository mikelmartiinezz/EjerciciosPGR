package principal;

import clases.Cliente;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

import clases.Cliente;
import clases.Empleado;
import clases.Medicion;
import clases.Persona;
import clases.Util;

public class Examen2016 {

	public static void main(String[] args) {

		ArrayList<Persona> lista = new ArrayList<>();
		int opcion = 0;

		do {
			opcion = menu(opcion);

			opcion = Util.leerInt();

			switch (opcion) {

			case 1:
				alta(lista);
				break;

			case 2:
				listarClientes(lista);
				break;

			case 3:
				anadirMedicion(lista);
				break;

			case 4:
				estadisticas(lista);
				break;

			case 5:
				System.out.println("Fin del programa.");
				break;

			default:
				System.out.println("Opción no válida");
			}

		} while (opcion != 5);
	}

	private static int menu(int opcion) {
		System.out.println(" MENU EMPRESA");
		System.out.println("1. Alta Cliente/Empleado");
		System.out.println("2. Listado de Clientes");
		System.out.println("3. Añadir medición a cliente y ver evolución");
		System.out.println("4. Estadística de Gordis");
		System.out.println("5. Salir");
		System.out.println("Elige una opción: ");
		return opcion;
	}

	private static void alta(ArrayList<Persona> lista) {

		System.out.println("¿Qué desea dar de alta? (C)liente / (E)mpleado:");
		char tipo = Util.leerChar('C', 'E');

		System.out.println("Introduce nombre:");
		String nombre = Util.introducirCadena();

		System.out.println("Introduce fecha nacimiento (dd/MM/yyyy):");
		LocalDate fechaNac = Util.leerFechaDMA();

		if (tipo == 'C') { // --- CLIENTE ---
			System.out.println("Introduce altura en metros:");
			float altura = Util.leerFloat();

			ArrayList<Medicion> mediciones = new ArrayList<>();

			System.out.println("Introduce la primera medición de peso:");
			registrarMedicion(mediciones);

			Cliente c = new Cliente(nombre, fechaNac, "", altura, mediciones);
			c.setCodigoCliente(generarCodigo(nombre, fechaNac));

			lista.add(c);

			System.out.println("Cliente registrado con código: " + c.getCodigoCliente());

			System.out.println("¿Desea añadir otra medición? (S/N):");
			char res = Character.toUpperCase(Util.leerChar());

			while (res == 'S') {
				registrarMedicion(mediciones);
				System.out.println("¿Añadir otra? (S/N):");
				res = Character.toUpperCase(Util.leerChar());
			}

		} else {
			System.out.println("Introduce fecha alta (dd/MM/yyyy):");
			LocalDate fechaAlta = Util.leerFechaDMA();

			lista.add(new Empleado(nombre, fechaNac, fechaAlta));
			System.out.println("Empleado registrado con éxito.");
		}

	}
		private static void registrarMedicion(ArrayList<Medicion> mediciones) {

		    LocalDate f;
		    float p;

		    if (!mediciones.isEmpty()) {
		        LocalDate ultimaFecha = mediciones.get(mediciones.size() - 1).getFecha();

		        do {
		            System.out.println("Fecha medición (dd/MM/yyyy) (Debe ser posterior a " + ultimaFecha + "):");
		            f = Util.leerFechaDMA();
		            if (!f.isAfter(ultimaFecha)) {
		                System.out.println("La fecha debe ser posterior a la última medición.");
		            }
		        } while (!f.isAfter(ultimaFecha));

		    } else { 
		        System.out.println("Fecha medición (dd/MM/yyyy):");
		        f = Util.leerFechaDMA();
		    }

		    System.out.println("Peso:");
		    p = Util.leerFloat();

		    mediciones.add(new Medicion(f, p));
		    System.out.println("Medición registrada correctamente.\n");
		}


	private static String generarCodigo(String nombre, LocalDate fecha) {
		String letras = nombre.substring(0, 2).toUpperCase();
		String anio = String.valueOf(fecha.getYear());
		anio = anio.substring(anio.length() - 2);
		return letras + "-" + anio;
	}

	private static void listarClientes(ArrayList<Persona> lista) {

		boolean hayClientes = false;

		for (Persona p : lista) {
			if (p instanceof Cliente) {
				hayClientes = true;
				Cliente c = (Cliente) p;

				double imc = c.getIMC();

				String imcTxt = (c.getAltura() == 0) ? "ALTURA INVALIDA" : String.format("%.2f", imc);

				System.out.println("\nNombre: " + c.getNombre() + " | Edad: " + c.getEdad() + " | Código: "
						+ c.getCodigoCliente() + " | IMC: " + imcTxt);
			}
		}

		if (!hayClientes)
			System.out.println("No hay clientes en la lista.");
	}

	private static void anadirMedicion(ArrayList<Persona> lista) {

		System.out.println("Nombre del cliente:");
		String nombre = Util.introducirCadena();

		for (Persona p : lista) {
			if (p instanceof Cliente && p.getNombre().equalsIgnoreCase(nombre)) {
				Cliente c = (Cliente) p;

				System.out.println("Mediciones actuales:");
				for (Medicion m : c.getMediciones())
					System.out.println(m);

				registrarMedicion(c.getMediciones());

				System.out.println("\nÚltimos pesos:");
				for (Medicion m : c.getMediciones())
					System.out.println(m);

				float dif = c.getMediciones().get(c.getMediciones().size() - 1).getPeso()
						- c.getMediciones().get(0).getPeso();

				System.out.println(
						"\nEvolución: " + (dif > 0 ? "Ha subido " + dif + "kg" : "Ha bajado " + Math.abs(dif) + "kg"));

				return;
			}
		}

		System.out.println("Cliente no encontrado.");
	}

	private static void estadisticas(ArrayList<Persona> lista) {

		int[] cont = new int[8];
		for (Persona p : lista) {
			if (p instanceof Cliente) {
				double imc = ((Cliente) p).getIMC();
				if (imc < 16)
					cont[0]++;
				else if (imc < 17)
					cont[1]++;
				else if (imc < 18.5)
					cont[2]++;
				else if (imc < 25)
					cont[3]++;
				else if (imc < 30)
					cont[4]++;
				else if (imc < 35)
					cont[5]++;
				else if (imc < 40)
					cont[6]++;
				else
					cont[7]++;
			}
		}

		System.out.println("ESTADÍSTICA DE GORDIS");
		System.out.println("Infrapeso severo: " + cont[0]);
		System.out.println("Infrapeso moderado: " + cont[1]);
		System.out.println("Infrapeso aceptable: " + cont[2]);
		System.out.println("Peso normal: " + cont[3]);
		System.out.println("Sobrepeso: " + cont[4]);
		System.out.println("Obeso I: " + cont[5]);
		System.out.println("Obeso II: " + cont[6]);
		System.out.println("Obeso III: " + cont[7]);
	}

}
