package clases;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Universidad {

    private HashMap<String, Profesor> profesores;

    public Universidad() {
        profesores = new HashMap<>();
    }

    public Profesor buscarProfesor(String email) {
        return profesores.get(email);
    }

    public boolean añadirProfesor(String email, String nombre, String dep) {
        if (profesores.containsKey(email)) return false;

        profesores.put(email, new Profesor(email, nombre, dep));
        return true;
    }

    // VALIDAR EMAIL
    public static boolean validarEmail(String email) {
        if (email == null) return false;
        String regex = "^[a-zA-Z0-9._]+@[a-zA-Z]+\\.[a-zA-Z]+$";
        return email.matches(regex);
    }

    // LIBROS PREMIADOS
    public ArrayList<String> librosPremiados(int anio) {

        ArrayList<String> out = new ArrayList<>();

        for (Profesor p : profesores.values()) {
            for (Publicacion pub : p.getPublicaciones()) {
                if (pub instanceof Libro) {
                    Libro l = (Libro) pub;

                    if (l.isPremiado() && l.getAnio() == anio) {
                        out.add(l.getFecha() + " | " + l.getTitulo() +
                                " | ISBN: " + l.getIsbn() +
                                " | Profesor: " + p.getNombre() +
                                " | Departamento: " + p.getDepartamento());
                    }
                }
            }
        }
        return out;
    }

    // LISTADO POR DEPARTAMENTO
    public HashMap<String, ArrayList<Profesor>> listadoPorDepartamento() {

        HashMap<String, ArrayList<Profesor>> mapa = new HashMap<>();

        for (Profesor p : profesores.values()) {

            if (p.getPublicaciones().isEmpty()) continue;

            mapa.putIfAbsent(p.getDepartamento(), new ArrayList<>());
            mapa.get(p.getDepartamento()).add(p);
        }

        for (ArrayList<Profesor> lista : mapa.values()) {

            lista.sort(
                Comparator
                    .comparingInt((Profesor p) -> p.getPublicaciones().size())
                    .reversed()
                    .thenComparing(Profesor::getNombre)
            );
        }

        return mapa;
    }

    public void mostrarProfes() {
        for (Profesor p : profesores.values()) {
            System.out.println(p);
        }
    }
}
