/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen;

import javax.swing.JOptionPane;

/**
 *
 * @author dilsh
 */
public class Funcionalidades {

    private Nodo inicio;
    private Nodo fin;

    public void Cola() {
        this.inicio = null;
        this.fin = null;
    }

    public boolean vacia() {
        if (inicio == null) {
            return true;
        } else {
            return false;
        }
    }

    public void intertar() {

        Datos e = new Datos();
        e.setId(Integer.parseInt(JOptionPane.showInputDialog("Ingrese su id: ")));
        e.setDescripcion(JOptionPane.showInputDialog("la descripcion: "));
        e.setPrioridad(JOptionPane.showInputDialog("Ingrese su prioridad: "));

        Nodo nuevo = new Nodo();

        nuevo.setElemento(e);

        if (vacia()) {
            inicio = nuevo;
            fin = nuevo;
        } else {

            fin.setSiguiente(nuevo);

            fin = nuevo;
        }
    }

    public void eliminacion() {
        if (!vacia()) {
            System.out.println("Extrayendo: " + inicio.getElemento().getId());
            inicio = inicio.getSiguiente();
            JOptionPane.showMessageDialog(null, "Elemento extraido", "ya se extrajo",
                    JOptionPane.CLOSED_OPTION);
        } else {
            JOptionPane.showMessageDialog(null, "no se puede extraer", "esta Vacia",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void mostrar() {
        if (!vacia()) {
            String s = "";
            Nodo aux = inicio;
            while (aux != null) {
                s += aux.getElemento().getId() + "|"
                        + aux.getElemento().getDescripcion() + "|"
                        + aux.getElemento().getPrioridad() + " <-- ";
                aux = aux.getSiguiente();
            }
            JOptionPane.showMessageDialog(null, "la informacuon almacenada es: \n" + s, "Mostrar",
                    JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "no se puede", "no hay informacion ",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void Buscar() {
        if (!vacia()) {
            int idBuscado = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la tarea a buscar:")
            );
            Nodo bus = inicio;
            boolean encontrado = false;

            while (bus != null) {
                if (bus.getElemento().getId() == idBuscado) {
                    JOptionPane.showMessageDialog(null,
                            "Tarea encontrada:\nID: " + bus.getElemento().getId()
                            + "\nDescripción: " + bus.getElemento().getDescripcion()
                            + "\nPrioridad: " + bus.getElemento().getPrioridad(),
                            "Buscar",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    encontrado = true;
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "no se puede", "no hay tarea con esa Id ", JOptionPane.ERROR_MESSAGE);
                }
                bus = bus.getSiguiente();
            }

        }

    }

    public void contar() {
        if (!vacia()) {
            int contador = 0;
            Nodo cont = inicio;
            while (cont != null) {
                contador++;
                cont = cont.getSiguiente();
            }
            JOptionPane.showMessageDialog(null, "Total de tareas: " + contador);
        }
    }

}
