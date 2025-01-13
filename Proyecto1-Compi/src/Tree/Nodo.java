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
}

