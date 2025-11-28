package clases;

public abstract class Vehiculo {
    private static int contador = 1;

    protected int idVehiculo;
    protected String marca;
    protected String modelo;
    protected double precioPorHora;

    public Vehiculo(String marca, String modelo, double precioPorHora) {
        this.idVehiculo = contador++;
        this.marca = marca;
        this.modelo = modelo;
        this.precioPorHora = precioPorHora;
    }

    public static int getContador() {
		return contador;
	}

	public static void setContador(int contador) {
		Vehiculo.contador = contador;
	}

	public int getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public double getPrecioPorHora() {
		return precioPorHora;
	}

	public void setPrecioPorHora(double precioPorHora) {
		this.precioPorHora = precioPorHora;
	}

	public double calcularPrecioAlquiler(int horas) {
        return precioPorHora * horas;
    }

    public String descripcion() {
        return "ID: " + idVehiculo + ", Marca: " + marca + ", Modelo: " + modelo +
               ", Precio/hora: " + precioPorHora;
    }
}
