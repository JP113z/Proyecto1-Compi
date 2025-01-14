package Tree;

/**
 * Clase: Arbol
 * Objetivo: Representar un árbol sintáctico con una raíz y permitir su impresión en formato jerárquico.
 */
public class Arbol {
    private Nodo raiz;

    /**
     * Constructor: Arbol
     * Objetivo: Crear un árbol inicializando su raíz como nula.
     * Entradas: Ninguna.
     * Salida: Instancia de la clase Arbol con raíz nula.
     */
    public Arbol() {
        this.raiz = null;
    }

    /**
     * Método: setRaiz
     * Objetivo: Establecer la raíz del árbol.
     * Entradas:
     *   - raiz: Nodo que será la nueva raíz del árbol.
     * Salida: Ninguna.
     * Restricciones: El nodo proporcionado debe ser válido.
     */
    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    /**
     * Método: getRaiz
     * Objetivo: Obtener la raíz del árbol.
     * Entradas: Ninguna.
     * Salida: Nodo que representa la raíz del árbol.
     */
    public Nodo getRaiz() {
        return raiz;
    }

    /**
     * Método: imprimirArbol
     * Objetivo: Imprimir el árbol sintáctico en formato jerárquico, mostrando cada nodo con su respectivo nivel de profundidad.
     * Entradas: Ninguna.
     * Salida: Imprime en consola la estructura jerárquica del árbol.
     * Restricciones: El árbol debe tener al menos un nodo para ser impreso.
     */
    public void imprimirArbol() {
        imprimirNodo(raiz, 0);
    }

    /**
     * Método: imprimirNodo
     * Objetivo: Imprimir un nodo y sus hijos de forma recursiva, mostrando la estructura jerárquica del árbol.
     * Entradas:
     *   - nodo: Nodo actual que se imprimirá.
     *   - nivel: Nivel de profundidad del nodo en el árbol (para la indentación).
     * Salida: Imprime en consola la información del nodo y sus hijos.
     * Restricciones: Si el nodo es nulo, no se realiza ninguna operación.
     */
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



