/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author valer
 */
public abstract class Servicio {
    ///ATRIBUTOS
    protected String codServicio;
    protected double porcentajeDescuento;
    protected boolean enPromocion;
    
    //CONSTRCUCTOR
    public Servicio(String codServicio, double porcentajeDescuento, boolean enPromocion) throws Exception {
        setCodServicio(codServicio);
        this.porcentajeDescuento = porcentajeDescuento;
        this.enPromocion = enPromocion;   
}
//GETTERS Y SETTERS
    public String getCodServicio() {
        return codServicio;
    }
    
public void setCodServicio(String codServicio) throws Exception{
    if(codServicio == null || codServicio.length() != 6){
    throw new Exception("El codigo debe tener una longitud de 6 caracteres");
    }
 this.codServicio = codServicio;   
}

public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public boolean isEnPromocion() {
        return enPromocion;
    }

    @Override
public String toString() {
    return "Servicio {codServicio= " + codServicio 
            + ", porcentajeDescuento= " + porcentajeDescuento 
            + "%, enPromocion= " + enPromocion + "}";
}
    
    
    
    //METODO ABSTRACTO
    public abstract double calcularPrecioFinal(LocalDate dia);
}
