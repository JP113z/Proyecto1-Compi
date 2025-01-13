package Tree;

import java.util.ArrayList;
import java.util.List;

public class Arbol {
    private Nodo raiz;

    public Arbol() {
        this.raiz = null;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void imprimirArbol() {
        imprimirNodo(raiz, 0);
    }

    private void imprimirNodo(Nodo nodo, int nivel) {
        if (nodo == null) return;

        // Imprimir nodo actual con indentación
        System.out.println("  ".repeat(nivel) + nodo.getDato());

        // Imprimir hijos recursivamente
        for (Nodo hijo : nodo.getHijos()) {
            imprimirNodo(hijo, nivel + 1);
        }
    }
}


