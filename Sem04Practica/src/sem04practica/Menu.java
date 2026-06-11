
package sem04practica;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class Menu {
    Pila p = new Pila();
//COTO BENAVENT MOISES
//HERNANDEZ CARRANZA DERLIS
//SANCHO VALVERDE NICOLE
//VARGAS GRANADOS DILSHOT
    //
    public void menu() {
        String obj[] = {"Agregar página al historial", "Retroceder a la página anterior", "Ver el historial completo", "Salir"};
        
        String op = (String) JOptionPane.showInputDialog(null, "Seleccione la opcion deseada: ",
                "Historial de Navegación", JOptionPane.PLAIN_MESSAGE,
                new ImageIcon("src/sem04practica/historial1.png"), obj, obj[0]);
        
        
        if (op == null) {
            JOptionPane.showMessageDialog(null, "Usted está saliendo del sistema, gracias.");
            System.exit(0);
        }

        switch (op) {
            case "Agregar página al historial":
                p.apilar();
                p.mostrarHistorial();
                menu();
                break;
                
            case "Retroceder a la página anterior":
                p.desapilar();
                p.mostrarHistorial();
                menu();
                break;
                
            case "Ver el historial completo":
                p.mostrarHistorial();
                menu();
                break;
                
            case "Salir del programa":
                JOptionPane.showMessageDialog(null, "Usted está saliendo del sistema, gracias.");
                System.exit(0);
                break;
        }
    }
}

