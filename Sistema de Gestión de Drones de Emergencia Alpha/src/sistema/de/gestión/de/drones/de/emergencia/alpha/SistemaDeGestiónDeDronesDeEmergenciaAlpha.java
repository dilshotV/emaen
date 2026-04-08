/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistema.de.gestión.de.drones.de.emergencia.alpha;

import java.util.Random;
import javax.swing.JOptionPane;

public class SistemaDeGestiónDeDronesDeEmergenciaAlpha {

    public static Dron[] dron = new Dron[12];
    public static Random rand = new Random();
    public static int contador = 0;

    public static void inicialisadron() {
        for (int i = 0; i < dron.length; i++) {

            int id = i + 1;
            char letra = (char) ('A' + rand.nextInt(26));
            int numero = rand.nextInt(9) + 1;
            String modelo = "Alpha " + letra + numero;
            int energia = rand.nextInt(75) + 20;
            TipoDeMision tipo = TipoDeMision.values()[rand.nextInt(4)];
            dron[i] = new Dron(id, modelo, energia, tipo);

        }
    }

    public static void main(String[] args) {
        inicialisadron();
        menuPrincipal();
    }

    private static void menuPrincipal() {
        int opcion;
        do {
            opcion = JOptionPane.showOptionDialog(null,
                    "Menú Principal" + "\n" + "1. Gestión de drones" + "\n " + "2. Operaciones" + "\n" + "3. Reportes " + "\n" + "4. Salir",
                    "",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                    null, new Object[]{"Gestión", "Operaciones", "Reportes", "Salir"}, "Gestión");

            switch (opcion) {
                case 0:
                    menuGestiondron();
                    break;
                case 1:
                    menudOperaciones();
                    break;
                case 2:

                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "adios");
                    break;
            }
        } while (opcion != 3);
    }

    private static void menuGestiondron() {
        int opcion;
        do {
            opcion = JOptionPane.showOptionDialog(null,
                    "Gestión de Drones" + "\n" + "1 Editar dron" + "\n" + "2 Buscar dron por id" + "\n" + "3. Volver",
                    "Gestión",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                    null, new Object[]{"Editar", "Buscar", "Volver"}, "Editar");

            switch (opcion) {
                case 0:
                    editarDron();
                    break;
                case 1:
                    buscarDron();
                    break;
            }
        } while (opcion != 2);
    }

    public static void buscarDron() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Digite el ID del dron"));
        Dron d = null;

        // Buscar el dron en el arreglo
        for (int i = 0; i < dron.length; i++) {
            if (dron[i].getID() == id) {
                d = dron[i];
                break;
            }
        }

        if (d != null) {
            // Mostrar información directamente
            JOptionPane.showMessageDialog(null, d.toString());
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el dron con ese ID");
        }
    }

    private static void editarDron() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Digite el ID del dron"));
        Dron d = null;

        for (int i = 0; i < dron.length; i++) {
            if (dron[i].getID() == id) {
                d = dron[i];
                break;
            }
        }

        if (d != null) {

            String modelo = JOptionPane.showInputDialog("Nuevo modelo:", d.getNombre());
            d.setNombre(modelo);

            int energia = Integer.parseInt(JOptionPane.showInputDialog("Nueva energía :", d.getNivelEnergia()));
            d.setNivelEnergia(energia);

            int mision = JOptionPane.showOptionDialog(null, "nueva misión", "Tipo Misión",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                    null, TipoDeMision.values(), TipoDeMision.VIGILANCIA);
            d.setTipodemision(TipoDeMision.values()[mision]);

            JOptionPane.showMessageDialog(null, "Dron actualizado correctamente:" + d.toString());
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el dron");
        }
    }

    private static void menudOperaciones() {
        int opcion;
        do {
            opcion = JOptionPane.showOptionDialog(null,
                    "Operaciones" + "\n" + "1 Recargar drones" + "\n" + "2 Simular misión" + "\n" + "3. Volver",
                    "Gestión",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                    null, new Object[]{"recargar", "simular", "Volver"}, "recargar");

            switch (opcion) {
                case 0:
                    recargarCriticos();
                    break;
                case 1:
                    simularMision();
                    break;
            }
        } while (opcion != 2);

    }

    private static void recargarCriticos() {
        for (int i = 0; i < dron.length; i++) {
            if (dron[i].getNivelEnergia() < 40) {
                int recarga = rand.nextInt(21) + 15;
                int nuevaEnergia = dron[i].getNivelEnergia() + recarga;
                dron[i].setNivelEnergia(nuevaEnergia);
                JOptionPane.showMessageDialog(null, "Dron " + dron[i].getNombre() + " recargado +" + recarga);
            }
        }
    }

    private static void simularMision() {
        for (int i = 0; i < dron.length; i++) {
            int consumo = 0;
            switch (dron[i].getTipodemision()) {
                case VIGILANCIA:
                    consumo = rand.nextInt(6) + 5;
                    break;    
                case SUMINISTROS:
                    consumo = rand.nextInt(11) + 15;
                    break;  
                case RESCATE:
                    consumo = rand.nextInt(16) + 20;
                    break;      
                case MONITOREO:
                    consumo = rand.nextInt(11) + 10;
                    break;    
            }

            if (dron[i].getNivelEnergia() >= consumo) {
                
                dron[i].setNivelEnergia(dron[i].getNivelEnergia() - consumo);
                JOptionPane.showMessageDialog(null,
                        "El dron " + dron[i].getNombre()
                        + " completó misión de " + dron[i].getTipodemision()
                        + ". Energía consumida: " + consumo);
            } else {
                JOptionPane.showMessageDialog(null,
                        "El dron " + dron[i].getNombre()
                        + " no tiene suficiente energía. Requiere recarga.");
            }
        }
    }

}
