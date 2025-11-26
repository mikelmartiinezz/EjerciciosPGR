package principal;

import clases.Bicicleta;
import clases.Coche;
import clases.Patinete;
import clases.Vehiculo;

public class MainVehiculosCompartidos{

    public static void main(String[] args) {

        Vehiculo bici = new Bicicleta("Trek", "FX 3", 5.0, "Disco");
        Vehiculo coche = new Coche("Tesla", "Model 3", 20.0, 4, true);
        Vehiculo patinete = new Patinete("Xiaomi", "Mi Electric", 7.0, 25);

        Vehiculo[] vehiculos = {bici, coche, patinete};

        int horas = 3;

        for (Vehiculo v : vehiculos) {
            System.out.println(v.descripcion());
            System.out.println("Precio por " + horas + " horas: " + v.calcularPrecioAlquiler(horas));
            System.out.println("-----------------------------------");
        }

    }
}
