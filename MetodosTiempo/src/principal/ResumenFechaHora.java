package principal;

import java.time.*;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

/**
 * Clase resumen con ejemplos de todas las clases importantes del API de fechas de Java 8:
 * LocalDate, LocalTime, LocalDateTime, Instant, Duration y Period.
 *
 * Sirve como guía completa para estudiar para el examen.
 * 
 * Toda la teoría y ejemplos completos del API
 */
public class ResumenFechaHora {

    public static void main(String[] args) {
        ejemplosLocalDate();
        ejemplosLocalTime();
        ejemplosLocalDateTime();
        ejemplosInstant();
        ejemplosDuration();
        ejemplosPeriod();
    }

    // ----------------------------------------------------------
    // LOCALDATE
    // ----------------------------------------------------------
    private static void ejemplosLocalDate() {
        System.out.println("\n=== LOCALDATE ===");

        // Crear LocalDate con año, mes y día
        LocalDate fecha1 = LocalDate.of(1989, 11, 11);
        System.out.println("Fecha1: " + fecha1);
        System.out.println("Año: " + fecha1.getYear());
        System.out.println("Mes: " + fecha1.getMonth());
        System.out.println("Día: " + fecha1.getDayOfMonth());

        // Crear LocalDate usando enum Month
        LocalDate fecha2 = LocalDate.of(1989, Month.NOVEMBER, 11);
        System.out.println("Fecha2 (con Month): " + fecha2);

        // Capturar la fecha actual
        LocalDate hoy = LocalDate.now();
        System.out.println("Fecha actual: " + hoy);
    }

    // ----------------------------------------------------------
    // LOCALTIME
    // ----------------------------------------------------------
    private static void ejemplosLocalTime() {
        System.out.println("\n=== LOCALTIME ===");

        // Crear un LocalTime con hora, minuto, segundo y nanosegundo
        LocalTime hora = LocalTime.of(5, 30, 45, 35);
        System.out.println("Hora completa: " + hora);
        System.out.println("Hora: " + hora.getHour());
        System.out.println("Minutos: " + hora.getMinute());
        System.out.println("Segundos: " + hora.getSecond());
        System.out.println("Nanosegundos: " + hora.getNano());

        // Hora actual
        LocalTime ahora = LocalTime.now();
        System.out.println("Hora actual: " + ahora);
    }

    // ----------------------------------------------------------
    // LOCALDATETIME
    // ----------------------------------------------------------
    private static void ejemplosLocalDateTime() {
        System.out.println("\n=== LOCALDATETIME ===");

        // Crear LocalDateTime con todos los campos
        LocalDateTime dt1 = LocalDateTime.of(1989, 11, 11, 5, 30, 45, 35);
        System.out.println("LocalDateTime completo: " + dt1);

        // Crear usando LocalDate + LocalTime
        LocalDate date = LocalDate.of(1989, 11, 11);
        LocalTime time = LocalTime.of(5, 30, 45, 35);
        LocalDateTime dt2 = LocalDateTime.of(date, time);
        System.out.println("LocalDateTime desde LocalDate + LocalTime: " + dt2);

        // Actual fecha/hora
        LocalDateTime ahora = LocalDateTime.now();
        System.out.println("LocalDateTime actual: " + ahora);
    }

    // ----------------------------------------------------------
    // INSTANT
    // ----------------------------------------------------------
    private static void ejemplosInstant() {
        System.out.println("\n=== INSTANT ===");

        // Instant desde segundos desde epoch
        Instant instant1 = Instant.ofEpochSecond(120);
        System.out.println("Instant desde epoch: " + instant1);

        // Instant actual
        Instant instant2 = Instant.now();
        System.out.println("Instant actual: " + instant2);
    }

    // ----------------------------------------------------------
    // DURATION
    // ----------------------------------------------------------
    private static void ejemplosDuration() {
        System.out.println("\n=== DURATION ===");

        // Duration entre dos LocalTime
        LocalTime t1 = LocalTime.of(12, 25);
        LocalTime t2 = LocalTime.of(17, 35);
        Duration d1 = Duration.between(t1, t2);
        System.out.println("Duration entre horas: " + d1);

        // Duration entre LocalDateTime
        LocalDateTime dt1 = LocalDateTime.of(2016, Month.JULY, 18, 14, 13);
        LocalDateTime dt2 = LocalDateTime.of(2016, Month.JULY, 20, 12, 25);
        Duration d2 = Duration.between(dt1, dt2);
        System.out.println("Duration entre fechas-horas: " + d2);

        // Duration creado con of()
        Duration unDia = Duration.of(1, ChronoUnit.DAYS);
        System.out.println("Un día (Duration.of): " + unDia);

        // Duration ofDays()
        Duration unDia2 = Duration.ofDays(1);
        System.out.println("Un día (ofDays): " + unDia2);
    }

    // ----------------------------------------------------------
    // PERIOD
    // ----------------------------------------------------------
    private static void ejemplosPeriod() {
        System.out.println("\n=== PERIOD ===");

        // Period entre dos LocalDate
        LocalDate ld1 = LocalDate.of(2016, Month.JULY, 18);
        LocalDate ld2 = LocalDate.of(2016, Month.JULY, 20);
        Period p1 = Period.between(ld1, ld2);
        System.out.println("Period entre fechas: " + p1);

        // Period con of()
        Period p2 = Period.of(1, 2, 3);
        System.out.println("Period 1 año 2 meses 3 días: " + p2);

        // Period con atajos
        Period p3 = Period.ofYears(1);
        System.out.println("Period 1 año: " + p3);
    }
}
