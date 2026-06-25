/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen;

/**
 *
 * @author dilsh
 */
public class Nodo {
    private Datos elemento;
    private Nodo siguiente;
    
    public Nodo(){
        this.siguiente=null;
    }

    public Datos getElemento() {
        return elemento;
    }

    public void setElemento(Datos elemento) {
        this.elemento = elemento;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    
}
