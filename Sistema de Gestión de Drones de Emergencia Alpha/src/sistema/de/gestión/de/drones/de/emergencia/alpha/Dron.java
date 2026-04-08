/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.de.gestión.de.drones.de.emergencia.alpha;

/**
 *
 * @author dilsh
 */
public class Dron {
    
    private int ID;
    private String Nombre;
    private int nivelEnergia;
    private TipoDeMision tipodemision;

    public Dron(int ID, String Nombre, int nivelEnergia, TipoDeMision tipodemision) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.nivelEnergia = nivelEnergia;
        this.tipodemision = tipodemision;
    }

    public TipoDeMision getTipodemision() {
        return tipodemision;
    }

    public void setTipodemision(TipoDeMision tipodemision) {
        this.tipodemision = tipodemision;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getNivelEnergia() {
        return nivelEnergia;
    }

    public void setNivelEnergia(int nivelEnergia) {
        if(nivelEnergia>=0 && nivelEnergia<=100){
        this.nivelEnergia = nivelEnergia;
        }
    }

    @Override
    public String toString() {
        return "ID = " + ID + "\n"+
               "Nombre = "+ Nombre + "\n"+
               "NivelEnergia = "+nivelEnergia+"\n"+
               "tipodemision = "+tipodemision;
    }
    
            
    
    
}
