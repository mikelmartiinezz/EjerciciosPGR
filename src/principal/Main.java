package principal;

import clases.Producto;

public class Main {
	public static void main(String[] args) {
		// Crear array de 10 productos (algunas posiciones null)
		Producto[] inventario = new Producto[10];
		inventario[0] = new Producto(10.5, 3);
		inventario[1] = new Producto(15.0, 6);
		inventario[2] = null;
		inventario[3] = new Producto(7.25, 2);
		inventario[4] = new Producto(12.0, 5);
		inventario[5] = null;
		inventario[6] = new Producto(20.0, 8);
		inventario[7] = new Producto(5.0, 1);
		inventario[8] = null;
		inventario[9] = new Producto(8.5, 7);
		//1
		double totalImpar = sumarPreciosStockImpar(inventario);
		System.out.println("Total precios stock impar: " + totalImpar);
		//2
		Producto masCaro = productoMasCaroStockMayorQue(inventario, 5);
		System.out.println("Producto más caro con stock > 5: " + masCaro);
		//3		
		desplazarNullsAlFinal(inventario);
		System.out.println("Array con null al final:");
		imprimirInventario(inventario);
		//4
		intercambiarExtremos(inventario);
		System.out.println("Array después de intercambiar productos extremos:");
		imprimirInventario(inventario);
	}

	public static double sumarPreciosStockImpar(Producto[] inventario) {
		double total = 0;
		for (Producto p : inventario) {
			if (p != null && p.getStock() % 2 != 0) {
				total += p.getPrecio();
			}
		}
		return total;
	}

	public static Producto productoMasCaroStockMayorQue(Producto[] inventario, int stockMin) {
		Producto masCaro = null;
		for (Producto p : inventario) {
			if (p != null && p.getStock() > stockMin) {
				if (masCaro == null || p.getPrecio() > masCaro.getPrecio()) {
					masCaro = p;
				}
			}
		}
		return masCaro;
	}

	public static void desplazarNullsAlFinal(Producto[] inventario) {
		Producto[] temp = new Producto[inventario.length];
		int index = 0;
		for (Producto p : inventario) {
			if (p != null) {
				temp[index++] = p;
			}
		}

		for (int i = 0; i < inventario.length; i++) {
			inventario[i] = temp[i];
		}
	}

	public static void intercambiarExtremos(Producto[] inventario) {
		int indexMin = -1, indexMax = -1;
		double minPrecio = Double.MAX_VALUE;
		double maxPrecio = -Double.MAX_VALUE;

		for (int i = 0; i < inventario.length; i++) {
			Producto p = inventario[i];
			if (p != null) {
				if (p.getPrecio() < minPrecio) {
					minPrecio = p.getPrecio();
					indexMin = i;
				}
				if (p.getPrecio() > maxPrecio) {
					maxPrecio = p.getPrecio();
					indexMax = i;
				}
			}
		}

		if (indexMin != -1 && indexMax != -1) {
			Producto temp = inventario[indexMin];
			inventario[indexMin] = inventario[indexMax];
			inventario[indexMax] = temp;
		}
	}

	public static void imprimirInventario(Producto[] inventario) {
		for (Producto p : inventario) {
			System.out.println(p);
		}
	}
}
