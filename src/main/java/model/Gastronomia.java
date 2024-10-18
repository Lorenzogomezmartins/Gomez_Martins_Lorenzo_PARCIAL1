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
public class Gastronomia extends Servicio{
    //ATRIBUTOS
    private String gastronomia;
    private double precio;
    private int diaSemDesc;
    
    //CONSTRUCTOR
    public Gastronomia(String codServicio, double porcentajeDescuento, boolean enPromocion, String gastronomia, double precio, int diaSemDesc) throws Exception {
    super(codServicio, porcentajeDescuento, enPromocion);
    this.gastronomia = gastronomia;
    this.precio = precio;
    this.diaSemDesc = diaSemDesc;
}

    @Override
public String toString() {
    return "Gastronomia {codServicio= " + codServicio 
            + ", porcentajeDescuento= " + porcentajeDescuento 
            + "%, enPromocion= " + enPromocion 
            + ", gastronomia= " + gastronomia 
            + ", precio= " + precio 
            + ", diaSemDesc= " + diaSemDesc + "}";
}
    
    
    // Getter y Setter
    public String getGastronomia() {
        return gastronomia;
    }

    public double getPrecio() {
        return precio;
    }

    public int getDiaSemDesc() {
        return diaSemDesc;
    }

    @Override
    public double calcularPrecioFinal(LocalDate dia) {
       if (isEnPromocion() && dia.getDayOfWeek().getValue() == diaSemDesc) {
            return precio * (1 - getPorcentajeDescuento() / 100);
        }
        return precio;
    }
    }
    
    
    
    

