/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareapolimorfismo;

/**
 *
 * @author dilsh
 */
public class Circulo extends Forma {

    private Double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    public Double getRadio() {
        return radio;
    }

    public void setRadio(Double radio) {
        this.radio = radio;
    }

    @Override
    public Double Area() {
        return 3.14 * radio * radio;
    }

    @Override
    public Double Perimetro() {
       return 2 * 3.14 * radio;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Circulo{");
        sb.append("radio=").append(radio);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
