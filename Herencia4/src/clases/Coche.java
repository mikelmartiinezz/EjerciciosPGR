package clases;

public class Coche extends Vehiculo {

    private int numPuertas;
    private boolean esElectrico;

    public Coche(String marca, String modelo, double precioPorHora, int numPuertas, boolean esElectrico) {
        super(marca, modelo, precioPorHora);
        this.numPuertas = numPuertas;
        this.esElectrico = esElectrico;
    }

    public int getNumPuertas() {
		return numPuertas;
	}

	public void setNumPuertas(int numPuertas) {
		this.numPuertas = numPuertas;
	}

	public boolean isEsElectrico() {
		return esElectrico;
	}

	public void setEsElectrico(boolean esElectrico) {
		this.esElectrico = esElectrico;
	}

	@Override
    public double calcularPrecioAlquiler(int horas) {
        double precio = super.calcularPrecioAlquiler(horas);
        if (esElectrico) {
            precio *= 0.90; // 10% de descuento
        }
        return precio;
    }

    @Override
    public String descripcion() {
        return super.descripcion() +
               ", Puertas: " + numPuertas +
               ", Tipo: " + (esElectrico ? "Eléctrico" : "Combustión");
    }
}
