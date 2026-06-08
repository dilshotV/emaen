/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareapolimorfismo;

/**
 *
 * @author dilsh
 */
public class Cuadrado extends Forma {

    private double lado;

    public Cuadrado(double lado) {
        this.lado = lado;
    }

    @Override
    public Double Area() {
        return lado * lado;
    }

    @Override
    public Double Perimetro() {
        return 4 * lado;
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cuadrado{");
        sb.append("lado=").append(lado);
        sb.append('}');
        return sb.toString();
    }

}
