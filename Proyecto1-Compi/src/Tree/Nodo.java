package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase: Nodo
 * Objetivo: Representar un nodo en un árbol sintáctico, con un dato asociado y una lista de hijos.
 */
public class Nodo {
    private String dato;
    private List<Nodo> hijos;

    /**
     * Constructor: Nodo
     * Objetivo: Crear un nodo con un dato específico y una lista vacía de hijos.
     * Entradas:
     *   - dato: Cadena de texto que representa el valor asociado al nodo.
     * Salida: Instancia de la clase Nodo.
     */
    public Nodo(String dato) {
        this.dato = dato;
        this.hijos = new ArrayList<>();
    }

    /**
     * Método: getDato
     * Objetivo: Obtener el dato asociado al nodo.
     * Entradas: Ninguna.
     * Salida: Cadena de texto que representa el dato del nodo.
     */
    public String getDato() {
        return dato;
    }

    /**
     * Método: setDato
     * Objetivo: Establecer un nuevo valor para el dato del nodo.
     * Entradas:
     *   - dato: Cadena de texto que será el nuevo valor del nodo.
     * Salida: Ninguna.
     */
    public void setDato(String dato) {
        this.dato = dato;
    }

    /**
     * Método: getHijos
     * Objetivo: Obtener la lista de hijos del nodo.
     * Entradas: Ninguna.
     * Salida: Lista de nodos hijos.
     */
    public List<Nodo> getHijos() {
        return hijos;
    }

    /**
     * Método: agregarHijo (Nodo)
     * Objetivo: Agregar un nodo hijo a la lista de hijos del nodo actual.
     * Entradas:
     *   - hijo: Nodo que se agregará como hijo.
     * Salida: Ninguna.
     * Restricciones: El nodo hijo debe ser válido.
     */
    public void agregarHijo(Nodo hijo) {
        this.hijos.add(hijo);
    }

    /**
     * Método: agregarHijo (Object)
     * Objetivo: Agregar un hijo al nodo actual, permitiendo tanto nodos como otros objetos.
     * Entradas:
     *   - dato: Objeto que representa el hijo. Si es un Nodo, se agrega directamente; si es otro tipo, se convierte a String.
     * Salida: Ninguna.
     * Restricciones: Si el dato es nulo, no se agrega al nodo.
     */
    public void agregarHijo(Object dato) {
        if (dato == null) {
            System.err.println("Error: Se intentó agregar un hijo nulo al nodo " + this.dato);
            return; // No agregar un nodo nulo
        }
        // Si el dato es un Nodo, lo agrega directamente
        if (dato instanceof Nodo) {
            this.hijos.add((Nodo) dato);
        } else {
            // Si no es un Nodo, crea un nodo con el dato convertido a String
            this.hijos.add(new Nodo(dato.toString()));
        }
    }
}

