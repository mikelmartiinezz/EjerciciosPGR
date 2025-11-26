package principal;

import java.util.ArrayList;

public class MainMetodosArrayList {

    public static void main(String[] args) {

        // Creamos un ArrayList de ejemplo
        ArrayList<String> lista = new ArrayList<>();

        // 1. add() → Añade un elemento al final
        lista.add("Manzana");
        lista.add("Pera");
        System.out.println("Lista tras add(): " + lista);

        // 2. addAll() → Añade todos los elementos de otra colección
        ArrayList<String> otrasFrutas = new ArrayList<>();
        otrasFrutas.add("Banana");
        otrasFrutas.add("Kiwi");

        lista.addAll(otrasFrutas);
        System.out.println("Lista tras addAll(): " + lista);

        // 3. clear() → Elimina todos los elementos
        ArrayList<String> lista2 = new ArrayList<>(lista); 
        lista2.clear();
        System.out.println("Lista tras clear(): " + lista2);

        // 4. contains() → Comprueba si un elemento está en la lista
        System.out.println("¿La lista contiene 'Pera'? " + lista.contains("Pera"));

        // 5. get() → Devuelve el elemento de una posición
        System.out.println("Elemento en posición 1: " + lista.get(1));

        // 6. isEmpty() → Verifica si está vacía
        System.out.println("¿Lista2 está vacía? " + lista2.isEmpty());

        // 7. remove() → Elimina un elemento (por valor)
        lista.remove("Banana");
        System.out.println("Lista tras remove(\"Banana\"): " + lista);

        // remove por índice
        lista.remove(0);  
        System.out.println("Lista tras remove(0): " + lista);

        // 8. size() → Número de elementos
        System.out.println("Tamaño de la lista: " + lista.size());

        // 9. toArray() → Devuelve la lista como array
        Object[] array = lista.toArray();
        System.out.println("Array convertido desde la lista:");
        for (Object elemento : array) {
            System.out.println(elemento);
        }
    }
}

