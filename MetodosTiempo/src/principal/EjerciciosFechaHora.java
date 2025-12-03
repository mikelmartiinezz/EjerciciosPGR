package principal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;
import clases.Util;

public class EjerciciosFechaHora {

    public static void main(String[] args) {
    	// EJERCICIOS CON FORMATO Y LocalDateTime
        // ---------------------------------------------------------------
        // 1. Pedir una fecha al usuario (formato dd/MM/yyyy)
        // ---------------------------------------------------------------

        System.out.print("Introduce una fecha en formato dd/MM/yyyy: ");
        String fechaString = Util.introducirCadena();

        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fecha = LocalDate.parse(fechaString, formateador);

        // ---------------------------------------------------------------
        // 2. Mostrar la fecha en distintos formatos
        // ---------------------------------------------------------------

        formateador = DateTimeFormatter.ofPattern("d-M-yy");
        System.out.println(fecha.format(formateador));

        formateador = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println(fecha.format(formateador));

        formateador = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        System.out.println(fecha.format(formateador));

        formateador = DateTimeFormatter.ofPattern("yyyy-MMMM-dd");
        System.out.println(fecha.format(formateador));

        // ---------------------------------------------------------------
        // 3. Obtener elementos sueltos de la fecha
        // ---------------------------------------------------------------

        System.out.println(
            fecha.getDayOfMonth() + " de " +
            fecha.getMonth().toString() + " de " +
            fecha.getYear()
        );

        System.out.println(
            fecha.getDayOfMonth() + " de " +
            fecha.getMonth().getDisplayName(TextStyle.FULL, new Locale("es", "ES")) + " de " +
            fecha.getYear()
        );

        // ---------------------------------------------------------------
        // 4. Trabajar con LocalDateTime.now()
        // ---------------------------------------------------------------

        LocalDateTime hoy = LocalDateTime.now();

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        System.out.println(hoy.format(formato));

        formato = DateTimeFormatter.ofPattern("dd/MM/yyyy KK:mm a");
        System.out.println(hoy.format(formato));

        formato = DateTimeFormatter.ofPattern("dd/MMM/yyyy KK:mm a");
        System.out.println(hoy.format(formato));

        formato = DateTimeFormatter.ofPattern("dd/MMMM/yyyy KK:mm a");
        System.out.println(hoy.format(formato));

        // ---------------------------------------------------------------
        // 5. Semana del año y semana del mes
        // ---------------------------------------------------------------

        formato = DateTimeFormatter.ofPattern("w");
        System.out.println("Semana del año: " + hoy.format(formato));

        formato = DateTimeFormatter.ofPattern("W");
        System.out.println("Semana del mes: " + hoy.format(formato));

        // ---------------------------------------------------------------
        // 6. Más datos sobre la fecha actual
        // ---------------------------------------------------------------

        System.out.println("Día del año:     " + hoy.getDayOfYear());
        System.out.println("Día de la semana en inglés:   " + hoy.getDayOfWeek());
        System.out.println("Día de la semana en francés:  " +
                hoy.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.FRANCE));

        System.out.println("Número del día de la semana: " + hoy.getDayOfWeek().getValue());

        // ---------------------------------------------------------------
        // 7. Añadir un año y mostrar el día de la semana
        // ---------------------------------------------------------------

        hoy = hoy.plusYears(1);

        System.out.println(
            "Día de la semana el próximo año en inglés (corto): " +
            hoy.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.UK)
        );

        formato = DateTimeFormatter.ofPattern("dd/MMMM/yyyy hh:mm");
        System.out.println("Fecha completa el próximo año: " + hoy.format(formato));
    }
}
