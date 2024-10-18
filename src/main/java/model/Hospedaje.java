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
public class Hospedaje extends Servicio{
    //ATRIBUTOS
    private String hospedaje;
    private double precioPorNoche;

    //CONSTRECUTOR
    public Hospedaje(String codServicio, double porcentajeDescuento, boolean enPromocion, String hospedaje, double precioPorNoche) throws Exception {
    super(codServicio, porcentajeDescuento, enPromocion);
    this.hospedaje = hospedaje;
    this.precioPorNoche = precioPorNoche;
}

    @Override
public String toString() {
    return "Hospedaje {codServicio= " + codServicio 
            + ", porcentajeDescuento= " + porcentajeDescuento 
            + "%, enPromocion= " + enPromocion 
            + ", hospedaje= " + hospedaje 
            + ", precioPorNoche= " + precioPorNoche + "}";
}
    
    
    //GETTERS Y SETTERS
    public String getHospedaje() {
        return hospedaje;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

public double calcularPrecioFinal(LocalDate dia) {
        if (enPromocion && dia.getDayOfWeek().getValue() <= 5) {  
            return precioPorNoche * (1 - porcentajeDescuento / 100);
        }
        return precioPorNoche;
    }
}
    
    
    

