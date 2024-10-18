/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author valer
 */
public class Sistema {
    public List<Servicio> lstServicio;

    public Sistema() {
        this.lstServicio = new ArrayList<>();
    }
    
    //METODOS
    public Servicio traerServicio(String codServicio){
    for (Servicio servicio : lstServicio){
    if(servicio.getCodServicio().equals(codServicio)){
    return servicio;
    }
    }
    return null;
    }
    
    public List<Servicio> traerServicio(boolean enPromocion) {
        List<Servicio> serviciosEnPromocion = new ArrayList<>();
        for (Servicio servicio : lstServicio) {
            if (servicio.isEnPromocion() == enPromocion) {
                serviciosEnPromocion.add(servicio);
            }
        }
        return serviciosEnPromocion;
    }
    
    public List<Servicio> traerServicio(boolean enPromocion, LocalDate dia) {
        List<Servicio> serviciosEnPromocion = new ArrayList<>();
        for (Servicio servicio : lstServicio) {
            if (servicio.isEnPromocion() == enPromocion) {
                double precioFinal = servicio.calcularPrecioFinal(dia);
                if (precioFinal != servicio.calcularPrecioFinal(LocalDate.now())) {
                    serviciosEnPromocion.add(servicio);
                }
            }
        }
        return serviciosEnPromocion;
    }
    
    
    public boolean agregarGastronomia(String codServicio, double porcentajeDescuento, boolean enPromocion, String gastronomia, double precio, int diaSemDesc)throws Exception{
        if(traerServicio(codServicio) != null){
        throw new Exception("El servicio con el codigo ya existe");
        }
        Gastronomia nuevoServicio = new Gastronomia(codServicio, porcentajeDescuento, enPromocion, gastronomia, precio, diaSemDesc);
         lstServicio.add(nuevoServicio);
        return true;
    }
    
    public boolean agregarHospedaje(String codServicio, double porcentajeDescuento, boolean enPromocion, String hospedaje,double precioPorNoche)throws Exception{
    if(traerServicio(codServicio) != null){
    throw new Exception("El servicio con ese codigo ya existe");
    }
    Hospedaje nuevoServicio = new Hospedaje(codServicio, porcentajeDescuento, enPromocion, hospedaje, precioPorNoche);
        lstServicio.add(nuevoServicio);
        return true;
    }

    public List<Servicio> getLstServicio() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
