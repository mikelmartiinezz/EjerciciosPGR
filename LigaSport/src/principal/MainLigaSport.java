package principal;

import java.util.ArrayList;
import clases.LigaSport;

public class MainLigaSport {

    public static void main(String[] args) {
        
        LigaSport liga = new LigaSport();
        
        liga.añadirCompetidor("Ana");
        liga.añadirCompetidor("Luis");
        liga.añadirCompetidor("Sergio");
        liga.listarCompetidores();

        liga.actualizarCompetidor("Sergio", "SergioPro");
        liga.listarCompetidores();

        liga.eliminarCompetidor("Luis");
        liga.listarCompetidores();

        ArrayList<String> eliminarLista = new ArrayList<>();
        eliminarLista.add("Ana");
        eliminarLista.add("XXX"); // no existe, no pasa nada
        liga.eliminarCompetidores(eliminarLista);
        liga.listarCompetidores();

        liga.añadirCompetidor("Raul");
        liga.añadirCompetidor("Pedro");
        liga.listarCompetidores();

        // -------------------------
        // CRUD PARTIDAS (HashMap)
        // -------------------------
        liga.registrarPartidas("Raul", 5);
        liga.registrarPartidas("Pedro", 3);
        liga.listarPartidas();

        liga.actualizarPartidas("Pedro", 10);
        liga.listarPartidas();

        liga.eliminarRegistro("Raul");
        liga.listarPartidas();

        // -------------------------
        // COMPARAR REGISTROS
        // -------------------------

        System.out.println("¿Todos los competidores tienen registro?");
        System.out.println(liga.compararRegistros()); 
        // Aquí debe dar FALSE porque "Raul" fue eliminado del registro
        // y "Pedro" sí está. Los demás no existen.

    }
}
