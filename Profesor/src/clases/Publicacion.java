package clases;

public abstract class Publicacion {

    protected String fecha;
    protected String titulo;

    public Publicacion(String fecha, String titulo) {
        this.fecha = fecha;
        this.titulo = titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAnio() {
        String[] p = fecha.split("[/\\-]");
        return Integer.parseInt(p[2]);
    }

    @Override
    public String toString() {
        return fecha + " - " + titulo;
    }
}
