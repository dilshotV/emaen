/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examen;

import java.io.Serializable;

/**
 *
 * @author dilsh
 */
public class Equipo extends Dispositivo implements Serializable,Comparable<Equipo>{
    
   private int CodigoEquipo;
 private String NombreCliente;
 private String TeléfonoCliente;
 private TipoEquipo TipoEquipo;
 private String Marca;
 private String Modelo;
 private String DescripciónProblema;
 private EstadoEquipo Estadodelequipo;
 private int CostoReparación;

    public int getCodigoEquipo() {
        return CodigoEquipo;
    }

    public void setCodigoEquipo(int CódigoEquipo) {
        this.CodigoEquipo = CódigoEquipo;
    }

    public String getNombreCliente() {
        return NombreCliente;
    }

    public void setNombreCliente(String NombreCliente) {
        this.NombreCliente = NombreCliente;
    }

    public String getTeléfonoCliente() {
        return TeléfonoCliente;
    }

    public void setTeléfonoCliente(String TeléfonoCliente) {
        this.TeléfonoCliente = TeléfonoCliente;
    }

    public TipoEquipo getTipoEquipo() {
        return TipoEquipo;
    }

    public void setTipoEquipo(TipoEquipo TipoEquipo) {
        this.TipoEquipo = TipoEquipo;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public String getDescripciónProblema() {
        return DescripciónProblema;
    }

    public void setDescripciónProblema(String DescripciónProblema) {
        this.DescripciónProblema = DescripciónProblema;
    }

    public EstadoEquipo getEstadodelequipo() {
        return Estadodelequipo;
    }

    public void setEstadodelequipo(EstadoEquipo Estadodelequipo) {
        this.Estadodelequipo = Estadodelequipo;
    }

    public int getCostoReparación() {
        return CostoReparación;
    }

    public void setCostoReparación(int CostoReparación) {
        this.CostoReparación = CostoReparación;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Equipo{");
        sb.append("C\u00f3digoEquipo=").append(CodigoEquipo);
        sb.append(", NombreCliente=").append(NombreCliente);
        sb.append(", Tel\u00e9fonoCliente=").append(TeléfonoCliente);
        sb.append(", TipoEquipo=").append(TipoEquipo);
        sb.append(", Marca=").append(Marca);
        sb.append(", Modelo=").append(Modelo);
        sb.append(", Descripci\u00f3nProblema=").append(DescripciónProblema);
        sb.append(", Estadodelequipo=").append(Estadodelequipo);
        sb.append(", CostoReparaci\u00f3n=").append(CostoReparación);
        sb.append('}');
        return sb.toString();
    }
    
     @Override
    public int compareTo(Equipo otro) {
       
        return Integer.compare(this.CodigoEquipo, otro.CodigoEquipo);
    }
    @Override
    public String getDescripcion() {
        return "Equipo tipo: " + TipoEquipo + " - Problema: " + DescripciónProblema;
    }
    
}
