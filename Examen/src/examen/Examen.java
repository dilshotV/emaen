/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examen;

import javax.swing.JOptionPane;

/**
 *
 * @author dilsh
 */
public class Examen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Funcionalidades cola = new Funcionalidades(); 
        int opcion;

        do {
            String menu = "Gestión de tareas \n"
                    + "1. Insertar una nueva tarea\n"
                    + "2. Completar la tarea más antigua\n"
                    + "3. Mostrar todas las tareas\n"
                    + "4. Buscar una tarea por ID\n"
                    + "5. Contar tareas pendientes\n"
                    + "6. sumar\n"
                    + "7. Salir\n"
                    + "Seleccione una opción:";

            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcion) {
                case 1:
                    cola.intertar();
                    break;
                case 2:
                    cola.eliminacion();
                    break;
                case 3:
                    cola.mostrar();
                    break;
                case 4:
                    cola.Buscar();
                    break;
                case 5:
                    cola.contar();
                    break;
                case 6:
                    parte1.SumaDigitos();
                    break;
                case 7:
                    JOptionPane.showMessageDialog(null, "adios");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción incorrecta.");
            }
        } while (opcion != 7);
    }

}


