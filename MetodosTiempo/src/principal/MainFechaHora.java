package principal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

public class MainFechaHora {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Método main opcional para probarlo todo
		System.out.println("of: " + exampleOf());
		System.out.println("from: " + exampleFrom());
		System.out.println("parse: " + exampleParse());
		System.out.println("format: " + exampleFormat());
		System.out.println("get: " + exampleGet());
		System.out.println("is: " + exampleIs());
		System.out.println("with: " + exampleWith());
		System.out.println("plus: " + examplePlus());
	    System.out.println("minus: " + exampleMinus());
	    System.out.println("to: " + exampleTo());
	    System.out.println("at: " + exampleAt());
	}
	// Proyecto de referencia: Métodos de fechas y horas en Java
	// Clase con ejemplos claros, organizados y comentados de los métodos:

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

	// Ejemplo de "with": modificar uno o varios valores devolviendo una nueva
	// instancia
	public static LocalDate exampleWith() {
		LocalDate date = LocalDate.of(2025, 12, 3);
		return date.withDayOfMonth(1); // cambia el día al 1
	}
	// ==============================
	// MÉTODOS DE INSTANCIA (plus, minus, to, at)
	// ==============================


	// Ejemplo de "plus": añadir tiempo y devolver una nueva instancia
	public static LocalDate examplePlus() {
	LocalDate date = LocalDate.of(2025, 12, 3);
	return date.plusDays(5); // suma 5 días
	}


	// Ejemplo de "minus": restar tiempo y devolver una nueva instancia
	public static LocalDate exampleMinus() {
	LocalDate date = LocalDate.of(2025, 12, 3);
	return date.minusMonths(1); // resta un mes
	}


	// Ejemplo de "to": convertir el objeto en otro tipo
	public static LocalDateTime exampleTo() {
	LocalDate date = LocalDate.of(2025, 12, 3);
	return date.atStartOfDay(); // convierte LocalDate -> LocalDateTime
	}


	// Ejemplo de "at": combinar el objeto con otro
	public static LocalDateTime exampleAt() {
	LocalDate date = LocalDate.of(2025, 12, 3);
	LocalTime time = LocalTime.of(10, 30);
	return date.atTime(time); // combina fecha y hora
	}


	}

