package clases;

//Clase Producto
public class Producto {
	private double precio;
	private int stock; // Usamos int, no puede ser null

	// Constructor
	public Producto(double precio, int stock) {
		this.precio = precio;
		this.stock = stock;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Producto [precio=" + precio + ", stock=" + stock + "]";
	}

}