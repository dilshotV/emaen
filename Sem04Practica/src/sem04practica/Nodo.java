
package sem04practica;


public class Nodo {
    private Pagina elemento;
    private Nodo siguiente;

    public Nodo() {
        this.siguiente = null;
    }

    public Pagina getElemento() {
        return elemento;
    }

    public void setElemento(Pagina elemento) {
        this.elemento = elemento;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}