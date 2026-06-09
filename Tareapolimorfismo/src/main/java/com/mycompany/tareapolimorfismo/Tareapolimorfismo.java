/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tareapolimorfismo;

import java.util.Scanner;

/**
 *
 * @author dilsh
 */
public class Tareapolimorfismo {

    public static void main(String[] args) {
        
     Scanner sc = new Scanner(System.in);

       
        // circulo
        System.out.print("digite el radio del circulo: ");
        double radio = sc.nextDouble();
        Forma cir = new Circulo(radio);
        System.out.println("el area del circulo: " + cir.getArea() + ", el perimetro del circulo: " + cir.getPerimetro());

        // Triángulo
        System.out.print("\ndigite la base del triangulo: ");
        double base = sc.nextDouble();
        System.out.print("digite la altura del triangulo: ");
        double altura = sc.nextDouble();

        Forma tri = new Triangulo(altura, base);
        System.out.println("el area del triangulo es : " + tri.getArea() + ", el perimetro del triangulo es : " + tri.getPerimetro());

        // Cuadrado
        System.out.print("\ndigite el tamano del  lado del cuadrado: ");
        double lado = sc.nextDouble();
        Forma cua = new Cuadrado(lado);
        System.out.println("el area del cuadrado es: " + cua.getArea() + ", el perimetro del cuadrado es: " + cua.getPerimetro());

        sc.close();
        
       
    }

}