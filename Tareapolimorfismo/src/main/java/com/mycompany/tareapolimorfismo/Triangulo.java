/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareapolimorfismo;

/**
 *
 * @author dilsh
 */
public class Triangulo extends Forma {

    private Double altura;
    private Double base;
    public Triangulo(double altura,Double base) {
        this.altura = altura;
        this.base = base;
    }

    @Override
    public Double getArea() {
       return base * altura / 2;
    }

    @Override
    public Double getPerimetro() {
        return 3 * altura;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getBase() {
        return base;
    }

    public void setBase(Double base) {
        this.base = base;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Triangulo{");
        sb.append("altura=").append(altura);
        sb.append(", base=").append(base);
        sb.append('}');
        return sb.toString();
    }

   

    
}
