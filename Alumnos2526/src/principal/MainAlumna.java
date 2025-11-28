package principal;

import clases.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class MainAlumna {

    static ArrayList<Alumna> alumnos = new ArrayList<>();

    public static void main(String[] args) {

        int opc;

        do {
            menu();
            opc = Util.introduceNumero("Opción: ");

            switch (opc) {
                case 1 :
                    matricular();
                    break;
                case 2 :
                    listado();
                    break;
                case 3: 
                    infoAlumno();
                    break;
                case 4: 
                    modificarAlumno();
                    break;
                case 5:
                    modificarRepetidoresDAW();
                    break;
                case 6: 
                    bajaAlumno();
                    break;
                case 7: 
                    System.out.println("Adiós");
                    break;
                default:
                    System.out.println("Opción incorrecta.");
            }

        } while (opc != 7);
    }

    // ---------------------------------------------------------
    static void menu() {
        System.out.println("\n===== MENÚ =====");
        System.out.println("1. Matricular alumno/a");
        System.out.println("2. Listado de alumnos");
        System.out.println("3. Información de alumno por NIF");
        System.out.println("4. Modificar alumno");
        System.out.println("5. Modificar repetidor de DAW por edad");
        System.out.println("6. Dar de baja alumno");
        System.out.println("7. Salir");
    }

    // ---------------------------------------------------------
    // A. Matricular alumno
    // ---------------------------------------------------------
    static void matricular() {

        String continuar;

        do {
            String nif = Util.introduceCadena("NIF: ");

            boolean tieneDAM = false, tieneDAW = false;

            for (Alumna a : alumnos) {
                if (a.getNif().equalsIgnoreCase(nif)) {
                    if (a.getCiclo() == Ciclo.DAM) tieneDAM = true;
                    if (a.getCiclo() == Ciclo.DAW) tieneDAW = true;
                }
            }

            if (tieneDAM && tieneDAW) {
                System.out.println("Alumno/a ya introducido.");
                return;
            }

            // CONTROL CICLO
            Ciclo ciclo = null;
            boolean correcto = false;

            while (!correcto) {
                String txt = Util.introduceCadena("Ciclo (DAM/DAW): ").toUpperCase();

                if (!txt.equals("DAM") && !txt.equals("DAW")) {
                    System.out.println("ERROR. Escriba DAM o DAW.");
                    continue;
                }

                ciclo = Ciclo.valueOf(txt);
                correcto = true;
            }

            if ((ciclo == Ciclo.DAM && tieneDAM) ||
                (ciclo == Ciclo.DAW && tieneDAW)) {
                System.out.println("Ese ciclo ya está registrado para este NIF.");
                return;
            }

            String nombre = Util.introduceCadena("Nombre: ");

            LocalDate fecha = null;
            boolean fechaOK = false;

            while (!fechaOK) {
                try {
                    fecha = Util.introduceFecha("Fecha nacimiento (AAAA-MM-DD): ");
                    fechaOK = true;
                } catch (Exception e) {
                    System.out.println("Error en la fecha. Inténtelo otra vez.");
                }
            }

            boolean repetidor = Util.introducirBoolean("Repetidor (si/no): ");

            alumnos.add(new Alumna(nif, nombre, fecha, ciclo, repetidor));

            System.out.println("Alumno registrado correctamente.");

            continuar = Util.introduceCadena("¿Deseas introducir otro alumno? (si/no): ");

        } while (continuar.equalsIgnoreCase("si"));
    }

    // ---------------------------------------------------------
    static void listado() {
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos matriculados.");
            return;
        }

        for (Alumna a : alumnos) {
            System.out.println(a);
            System.out.println("---------------------");
        }
    }

    // ---------------------------------------------------------
    static void infoAlumno() {
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos.");
            return;
        }

        String nif = Util.introduceCadena("NIF: ");
        boolean encontrado = false;

        for (Alumna a : alumnos) {
            if (a.getNif().equalsIgnoreCase(nif)) {
                System.out.println(a);
                encontrado = true;
            }
        }

        if (!encontrado)
            System.out.println("Alumno no encontrado.");
    }

    // ---------------------------------------------------------
    static void modificarAlumno() {
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos.");
            return;
        }

        String nif = Util.introduceCadena("NIF: ");

        for (Alumna a : alumnos) {
            if (a.getNif().equalsIgnoreCase(nif)) {

                a.setNombre(Util.introduceCadena("Nuevo nombre: "));
                a.setFechaNacimiento(Util.introduceFecha("Nueva fecha (AAAA-MM-DD): "));
                a.setRepetidor(Util.introducirBoolean("¿Repetidor? (si/no): "));

                System.out.println("Alumno modificado.");
                return;
            }
        }

        System.out.println("Alumno no encontrado.");
    }

    // ---------------------------------------------------------
    static void modificarRepetidoresDAW() {
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos.");
            return;
        }

        int edadBuscada = Util.introduceNumero("Edad: ");
        boolean modificado = false;

        for (Alumna a : alumnos) {
            int edad = LocalDate.now().getYear() - a.getFechaNacimiento().getYear();

            if (a.getCiclo() == Ciclo.DAW && edad == edadBuscada) {
                a.setRepetidor(!a.isRepetidor());
                modificado = true;
            }
        }

        if (!modificado)
            System.out.println("No existen alumnos DAW con esa edad.");
        else
            System.out.println("Repetidores actualizados.");
    }

    // ---------------------------------------------------------
    static void bajaAlumno() {
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos.");
            return;
        }

        String nif = Util.introduceCadena("NIF: ");

        for (int i = 0; i < alumnos.size(); i++) {
            if (alumnos.get(i).getNif().equalsIgnoreCase(nif)) {

                System.out.println("Alumno encontrado:");
                System.out.println(alumnos.get(i));

                boolean conf = Util.introducirBoolean("¿Confirmar baja? (si/no): ");

                if (!conf) return;

                alumnos.remove(i);

                System.out.println("Alumno dado de baja.");
                return;
            }
        }

        System.out.println("No existe alumno con ese NIF.");
    }
}
