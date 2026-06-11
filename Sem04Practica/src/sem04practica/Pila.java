
package sem04practica;
import javax.swing.JOptionPane;

public class Pila {
    private Nodo cima;

    public Pila() {
        this.cima = null;
    }

    public boolean vacia() {
        if (cima == null) {
            return true;
        } else {
            return false;
        }
    }

    public void apilar() {
       
        Pagina nuevaPagina = new Pagina();
        nuevaPagina.setNombre(JOptionPane.showInputDialog("Ingrese el título o la URL de la página web:"));

        
        Nodo nuevo = new Nodo();
        nuevo.setElemento(nuevaPagina);

       
        if (vacia()) {
            cima = nuevo;
        } else {
            nuevo.setSiguiente(cima);
            cima = nuevo;
        }
    }

    public void desapilar() {
        if (!vacia()) {
          
            System.out.println("Regresando de la página: " + cima.getElemento().getNombre());
            
            
            cima = cima.getSiguiente();
            
            JOptionPane.showMessageDialog(null, "Se ha retrocedido a la página anterior con éxito", "Retroceder", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "El historial está vacío ", "Pila Vacía", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void mostrarHistorial() {
        if (!vacia()) {
            String s = "";
            Nodo aux = cima;
            
           while (aux!=null){
                s+=aux.getElemento().getNombre()+"\n    ⬇️    \n" ;
                aux=aux.getSiguiente();
            
            }
            
            JOptionPane.showMessageDialog(null, "Historial de Navegación:\n\n" + s, "Historial Completo", JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No hay páginas registradas en el historial", "Pila Vacía", JOptionPane.ERROR_MESSAGE);
        }
    }
}