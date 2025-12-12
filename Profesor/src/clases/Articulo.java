package clases;

public class Articulo extends Publicacion {

    private String medio;

    public Articulo(String fecha, String titulo, String medio) {
        super(fecha, titulo);
        this.medio = medio;
    }

    public String getMedio() {
		return medio;
	}

	public void setMedio(String medio) {
		this.medio = medio;
	}

	@Override
    public String toString() {
        return super.toString() + " | Medio: " + medio;
    }
}
