package clases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class LigaSport {

    private ArrayList<String> competidores;
    private HashMap<String, Integer> partidasGanadas;

    public LigaSport() {
        competidores = new ArrayList<>();
        partidasGanadas = new HashMap<>();
    }


	public ArrayList<String> getCompetidores() {
		return competidores;
	}


	public void setCompetidores(ArrayList<String> competidores) {
		this.competidores = competidores;
	}


	public HashMap<String, Integer> getPartidasGanadas() {
		return partidasGanadas;
	}


	public void setPartidasGanadas(HashMap<String, Integer> partidasGanadas) {
		this.partidasGanadas = partidasGanadas;
	}

	public void añadirCompetidor(String nombre) {
        if (!competidores.contains(nombre)) {
            competidores.add(nombre);
            System.out.println("Competidor añadido: " + nombre);
        } else {
            System.out.println("El competidor ya existe.");
        }
    }

    public void listarCompetidores() {
        System.out.println("LISTA DE COMPETIDORES");
        for (String c : competidores) {
            System.out.println(c);
        }
    }

    public void actualizarCompetidor(String antiguo, String nuevo) {
        int index = competidores.indexOf(antiguo);
        if (index != -1) {
            competidores.set(index, nuevo);
            System.out.println("Competidor actualizado.");
        } else {
            System.out.println("El competidor no existe.");
        }
    }

    public void eliminarCompetidor(String nombre) {
        if (competidores.remove(nombre)) {
            System.out.println("Competidor eliminado: " + nombre);
        } else {
            System.out.println("No existe ese competidor.");
        }
    }

    // Eliminar varios competidores SIN STREAMS
    public void eliminarCompetidores(ArrayList<String> nombres) {
        for (String n : nombres) {
            competidores.remove(n);
        }
        System.out.println("Competidores eliminados de la lista recibida.");
    }

    public void registrarPartidas(String competidor, int cantidad) {
        partidasGanadas.put(competidor, cantidad);
        System.out.println("Registro añadido/actualizado: " + competidor + " = " + cantidad);
    }

    public void listarPartidas() {
        System.out.println("PARTIDAS GANADAS");
        for (String clave : partidasGanadas.keySet()) {
            System.out.println(clave + " --> " + partidasGanadas.get(clave));
        }
    }

    public void actualizarPartidas(String competidor, int nuevasPartidas) {
        if (partidasGanadas.containsKey(competidor)) {
            partidasGanadas.put(competidor, nuevasPartidas);
            System.out.println("Partidas actualizadas.");
        } else {
            System.out.println("No existe ese competidor en el registro.");
        }
    }

    public void eliminarRegistro(String competidor) {
        if (partidasGanadas.remove(competidor) != null) {
            System.out.println("Registro eliminado.");
        } else {
            System.out.println("Ese competidor no tiene registro.");
        }
    }

    // --------------------------------------
    // MÉTODO ESPECIAL CON DOS ITERATORS
    // --------------------------------------

    public boolean compararRegistros() {

        Iterator<String> itLista = competidores.iterator();
        Iterator<String> itMapa = partidasGanadas.keySet().iterator();

        // Se podría usar itMapa, pero solo se requiere crearlo.
        // La comprobación se hace con el HashMap completo.
        while (itLista.hasNext()) {
            String comp = itLista.next();

            if (!partidasGanadas.containsKey(comp)) {
                return false; // El jugador no está en el mapa
            }
        }
        return true;
    }
}
