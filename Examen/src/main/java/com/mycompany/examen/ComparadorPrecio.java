/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examen;

import java.util.Comparator;

/**
 *
 * @author dilsh
 */
public class ComparadorPrecio implements Comparator<Equipo>{
    @Override
    public int compare(Equipo a1, Equipo a2) {
        return Integer.compare(a1.getCostoReparación(), a2.getCostoReparación());
}
}
