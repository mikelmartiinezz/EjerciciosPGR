package clases;

public class Bibliotecario extends Socio {

	private static int plusFijo = 30;
	private String nombreSeccion;

	public Bibliotecario(String nombreBiblioteca, String dni, String nombreCompleto, int mesAlta, int añoAlta,
			int numLibros, String nombreSeccion) {
		super(nombreBiblioteca, dni, nombreCompleto, mesAlta, añoAlta, numLibros);
		this.nombreSeccion = nombreSeccion;
	}

	public static int getPlusFijo() {
		return plusFijo;
	}

	public static void setPlusFijo(int plusFijo) {
		Bibliotecario.plusFijo = plusFijo;
	}

	public String getNombreSeccion() {
		return nombreSeccion;
	}

	public void setNombreSeccion(String nombreSeccion) {
		this.nombreSeccion = nombreSeccion;
	}

	@Override
	public int cuotaFinal() {
		return super.cuotaFinal() + plusFijo;
	}

	@Override
	public String toString() {
		return super.toString() + ", Plus fijo: " + plusFijo + "€, Sección: " + nombreSeccion;
	}

	public void setDatos(String dni) {
		if (this.getDni().equalsIgnoreCase(dni)) {
			super.setDatos(dni);
			this.nombreSeccion = Util.introducirCadena("Introduce la sección del bibliotecario: ");
			System.out.println("Datos del bibliotecario actualizados correctamente.");
		} else {
			System.out.println("El DNI no coincide con este bibliotecario.");
		}
	}
}
