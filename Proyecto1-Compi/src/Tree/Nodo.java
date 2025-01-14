package Tree;

import java.util.ArrayList;
import java.util.List;

public class Nodo {
    private String dato;
    private List<Nodo> hijos;

    public Nodo(String dato) {
        this.dato = dato;
        this.hijos = new ArrayList<>();
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public List<Nodo> getHijos() {
        return hijos;
    }

    public void agregarHijo(Nodo hijo) {
        this.hijos.add(hijo);
    }

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
