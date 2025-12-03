package principal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Clase resumen dedicada a LocalDateTime y DateTimeFormatter.
 * Contiene los métodos más importantes para comparar, sumar/restar
 * y trabajar con parseo y formateo.
 */
public class LocalDateTimeCompleto {

    public static void main(String[] args) {

        ejemploActual();
        ejemploConcreto();
        ejemploComparaciones();
        ejemploSumarRestar();
        ejemploParseFormat();
        notasImportantes();
    }

    // ----------------------------------------------------------
    // LOCALDATETIME ACTUAL
    // ----------------------------------------------------------
    private static void ejemploActual() {
        System.out.println("\n=== LOCALDATETIME NOW ===");

        LocalDateTime hoy = LocalDateTime.now();

        int anio = hoy.getYear();
        int mes = hoy.getMonthValue();
        int dia = hoy.getDayOfMonth();
        int hora = hoy.getHour();
        int minuto = hoy.getMinute();
        int segundo = hoy.getSecond();

        System.out.println("Fecha-hora actual: " + hoy);
        System.out.println("Año: " + anio);
        System.out.println("Mes: " + mes);
        System.out.println("Día: " + dia);
        System.out.println("Hora: " + hora);
        System.out.println("Minuto: " + minuto);
        System.out.println("Segundo: " + segundo);
    }

    // ----------------------------------------------------------
    // LOCALDATETIME ESTABLECIDO POR EL PROGRAMADOR
    // ----------------------------------------------------------
    private static void ejemploConcreto() {
        System.out.println("\n=== LOCALDATETIME CONCRETO ===");

        int anno = 1999;
        int mes = 7;
        int dia = 30;
        int hora = 18;
        int minuto = 55;
        int segundo = 50;

        LocalDateTime miFecha = LocalDateTime.of(anno, mes, dia, hora, minuto, segundo);

        System.out.println("Fecha concreta creada: " + miFecha);
    }

    // ----------------------------------------------------------
    // MÉTODOS PARA COMPARAR
    // ----------------------------------------------------------
    private static void ejemploComparaciones() {
        System.out.println("\n=== COMPARAR LOCALDATETIME ===");

        LocalDateTime d1 = LocalDateTime.of(2025, 1, 1, 10, 0);
        LocalDateTime d2 = LocalDateTime.of(2025, 1, 1, 12, 0);

        System.out.println("d1: " + d1);
        System.out.println("d2: " + d2);

        System.out.println("equals: " + d1.equals(d2));
        System.out.println("compareTo: " + d1.compareTo(d2));
        System.out.println("isBefore: " + d1.isBefore(d2));
        System.out.println("isAfter: " + d1.isAfter(d2));
    }

    // ----------------------------------------------------------
    // SUMAR Y RESTAR TIEMPO
    // ----------------------------------------------------------
    private static void ejemploSumarRestar() {
        System.out.println("\n=== SUMAR y RESTAR TIEMPO ===");

        LocalDateTime fecha = LocalDateTime.of(2025, 1, 1, 10, 0);

        System.out.println("Original: " + fecha);

        System.out.println("plusYears(1): " + fecha.plusYears(1));
        System.out.println("plusMonths(2): " + fecha.plusMonths(2));
        System.out.println("plusDays(10): " + fecha.plusDays(10));
        System.out.println("plusHours(5): " + fecha.plusHours(5));
        System.out.println("plusMinutes(30): " + fecha.plusMinutes(30));
        System.out.println("plusSeconds(45): " + fecha.plusSeconds(45));

        System.out.println("minusYears(1): " + fecha.minusYears(1));
        System.out.println("minusMonths(2): " + fecha.minusMonths(2));
        System.out.println("minusDays(10): " + fecha.minusDays(10));
        System.out.println("minusHours(5): " + fecha.minusHours(5));
        System.out.println("minusMinutes(30): " + fecha.minusMinutes(30));
        System.out.println("minusSeconds(45): " + fecha.minusSeconds(45));
    }

    // ----------------------------------------------------------
    // PARSE Y FORMAT CON DATETIMEFORMATTER
    // ----------------------------------------------------------
    private static void ejemploParseFormat() {
        System.out.println("\n=== PARSE y FORMAT ===");

        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Parseando texto
        LocalDateTime fecha = LocalDateTime.parse("2018-02-12 15:30:20", formateador);
        System.out.println("Parseado: " + fecha);

        // Formateando
        String texto = fecha.format(formateador);
        System.out.println("Formateado: " + texto);
    }

    // ----------------------------------------------------------
    // NOTAS IMPORTANTES (como en el documento)
    // ----------------------------------------------------------
    private static void notasImportantes() {
        System.out.println("\n=== NOTAS IMPORTANTES ===");

        System.out.println("► Para representar solo FECHA se usa LocalDate.");
        System.out.println("► Para representar solo HORA se usa LocalTime.");
        System.out.println("► Para bases de datos existen: java.sql.Date, java.sql.Time y java.sql.Timestamp.");
        System.out.println("► Clases antiguas como Date, Calendar y GregorianCalendar están en desuso.");
        System.out.println("► LocalDateTime NO tiene información de zona horaria (timezone).");
    }
}
