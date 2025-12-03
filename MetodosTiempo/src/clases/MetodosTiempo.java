package clases;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

public class MetodosTiempo {
	// Proyecto de referencia: Métodos de fechas y horas en Java
			// Clase con ejemplos claros, organizados y comentados de los métodos:
			// of, from, parse, format, get, is, with
			// Usando las clases de java.time


			    // ==============================
			    // MÉTODOS STATIC
			    // ==============================

			    // Ejemplo de "of": crear una instancia con datos concretos
			    public static LocalDate exampleOf() {
			        return LocalDate.of(2025, 12, 3); // año, mes, día
			    }

			    // Ejemplo de "from": convertir un objeto temporal en otro
			    public static LocalDate exampleFrom() {
			        LocalDateTime dateTime = LocalDateTime.of(2025, 12, 3, 10, 30);
			        return LocalDate.from(dateTime); // extrae solo la fecha
			    }

			    // Ejemplo de "parse": construir un objeto a partir de texto
			    public static LocalDate exampleParse() {
			        return LocalDate.parse("2025-12-03");
			    }

			    // ==============================
			    // MÉTODOS DE INSTANCIA
			    // ==============================

			    // Ejemplo de "format": convertir una fecha a texto con un patrón
			    public static String exampleFormat() {
			        LocalDate date = LocalDate.of(2025, 12, 3);
			        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			        return date.format(formatter);
			    }

			    // Ejemplo de "get": obtener una parte del objeto de fecha/hora
			    public static int exampleGet() {
			        LocalDate date = LocalDate.of(2025, 12, 3);
			        return date.get(ChronoField.DAY_OF_MONTH); // devuelve 3
			    }

			    // Ejemplo de "is": comprobar un estado
			    public static boolean exampleIs() {
			        LocalDate date = LocalDate.of(2025, 12, 3);
			        return date.isLeapYear(); // true o false
			    }

			    // Ejemplo de "with": modificar uno o varios valores devolviendo una nueva instancia
			    public static LocalDate exampleWith() {
			        LocalDate date = LocalDate.of(2025, 12, 3);
			        return date.withDayOfMonth(1); // cambia el día al 1
			    }
}
