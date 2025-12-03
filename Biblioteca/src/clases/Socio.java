
package clases;


public class Socio extends Persona {

    private String nombreBiblioteca;
    private int mesAlta;
    private int añoAlta;
    private int numLibros;
    private static int cuotaBase = 12;

    public Socio(String nombreBiblioteca, String dni, String nombreCompleto, int mesAlta, int añoAlta,
            int numLibros) {
        super(dni, nombreCompleto);  // Llama al constructor de Persona
        this.nombreBiblioteca = nombreBiblioteca;
        this.mesAlta = mesAlta;
        this.añoAlta = añoAlta;
        this.numLibros = numLibros;
    }

    public String getNombreBiblioteca() {
        return nombreBiblioteca;
    }

    public void setNombreBiblioteca(String nombreBiblioteca) {
        this.nombreBiblioteca = nombreBiblioteca;
    }

    public int getMesAlta() {
        return mesAlta;
    }

    public void setMesAlta(int mesAlta) {
        this.mesAlta = mesAlta;
    }

    public int getAñoAlta() {
        return añoAlta;
    }

    public void setAñoAlta(int añoAlta) {
        this.añoAlta = añoAlta;
    }

    public int getNumLibros() {
        return numLibros;
    }

    public void setNumLibros(int numLibros) {
        this.numLibros = numLibros;
    }

    public static int getCuotaBase() {
        return cuotaBase;
    }

    public static void setCuotaBase(int cuotaBase) {
        Socio.cuotaBase = cuotaBase;
    }

    public int cuotaFinal() {
        int cuotaFinal = cuotaBase;

        if (numLibros > 3) {
            cuotaFinal += (numLibros - 3);
        }

        int añoActual = 2024;
        int añosAntiguedad = añoActual - añoAlta;

        if (añosAntiguedad >= 8) {
            cuotaFinal -= 2;
        }

        if (cuotaFinal < 0) {
            cuotaFinal = 0;
        }

        return cuotaFinal;
    }

    public void setDatos(String dni) {
        if (this.getDni().equalsIgnoreCase(dni)) {
            System.out.println("--- Modificar datos del socio ---");           
            this.setDni(Util.introducirCadena("Introduce el DNI: "));           
            this.setNombreCompleto(Util.introducirCadena("Introduce el nombre completo: "));            
            this.nombreBiblioteca = Util.introducirCadena("Introduce el nombre de la biblioteca: ");            
            this.mesAlta = Util.leerInt("Introduce el mes de alta (1-12): ", 1, 12);          
            this.añoAlta = Util.leerInt("Introduce el año de alta: ");           
            this.numLibros = Util.leerInt("Introduce el número de libros: ");
            
            System.out.println("Datos actualizados correctamente.");
        } else {
            System.out.println("El DNI no coincide con este socio.");
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Biblioteca: " + nombreBiblioteca + ", Mes alta: " + mesAlta 
                + ", Año alta: " + añoAlta + ", Libros: " + numLibros + ", Cuota final: " + cuotaFinal() + "€";
    }
}
