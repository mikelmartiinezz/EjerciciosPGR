package clases;

class Trabajador extends Persona {
	private String usuario;
	private String contrasenia;
	private String cargo; // monitor o recepcionista

	public Trabajador(String dni, String nombre, String usuario, String contrasenia, String cargo) {
		super(dni, nombre);
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.cargo = cargo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	@Override
	public void visualizar() {
		System.out.println("[TRABAJADOR] " + nombre + " - " + dni + " - " + cargo);
	}
}