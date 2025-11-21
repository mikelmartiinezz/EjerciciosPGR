package principal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class MainAlumnos {

	public static void main(String[] args) {
		ArrayList<String> alumnos = new ArrayList<>();
		alumnos.add("Ana");
		alumnos.add("Luis");
		alumnos.add("Marta");
		alumnos.add("Juan");
		alumnos.add("Pedro");

		// 1. Crea un Iterator para recorrer la lista.
		Iterator<String> it = alumnos.iterator();
		// 2. Imprime todos los nombres en orden.
		System.out.println("Recorrer elementos:");
		while (it.hasNext()) {
			String valor = it.next();
			System.out.println(valor);

			// Eliminar nombre que tengan menos de 4 letras
			if (valor.length() < 4) {
				it.remove();
			}
		}
		// 4. Imprime la lista después de eliminar.
		System.out.println("Lista después de eliminar los nombres que contengan menos de 4 letras: " + alumnos);

	
		// 1. Crea un ListIterator para recorrer la lista resultante.
		ListIterator<String> listait = alumnos.listIterator();

		// 2. Recorre la lista hacia delante:
		System.out.println("Recorrer y modificar:");
		while (listait.hasNext()) {
			String valor = listait.next();
			System.out.println(valor);
			// a. Si el nombre empieza con “P”, cámbialo a mayúsculas
			if (valor.startsWith("P")) {
				listait.set(valor.toUpperCase());
			}
			// b. Si el nombre empieza con “M”, añade al iterador un nuevo nombre "Marcos"
			// justo después
			if (valor.startsWith("M")) {
				listait.add("Marcos");
			}

		}
		// 3. Imprime la lista después de estas modificaciones.
		
		System.out.println(alumnos);
		System.out.println(listait.nextIndex());
		
		
		// 4. Recorre la lista hacia atrás e imprime todos los nombres.
		System.out.println("Recorrer hacia atrás:");
		while (listait.hasPrevious()) {
			System.out.println(listait.previousIndex());
			System.out.println(listait.previous());
			
		}

	}
}
