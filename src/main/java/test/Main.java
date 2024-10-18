/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;
import model.Gastronomia;
import model.Hospedaje;
import model.Sistema;
import java.time.LocalDate;
import java.util.List;
import model.Servicio;
/**
 *
 * @author valer
 */
public class Main {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        Sistema sistema2 = new Sistema();
        
        // 1-1) Intentar crear el objeto Gastronomia con código inválido
        System.out.println("1-1");
        try {
            Gastronomia g1 = new Gastronomia("4892", 15.0, true, "Hamburguesa criolla", 180.0, 4);
            System.out.println("SE creo exitosamente");
            System.out.println("Codigo: " + g1.getCodServicio());
            System.out.println("Porcentaje del descuento: " + g1.getPorcentajeDescuento() + "%");
            System.out.println("Hamburguesa: " + g1.getGastronomia());
            System.out.println("Precio: $" + g1.getPrecio());
            System.out.println("Dia: " + g1.getDiaSemDesc());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        ///////////////////////////////////////////////////////////////////////////////
        // 1-2) Crear el objeto Gastronomia con código válido
        System.out.println("1-2");
        try {
            Gastronomia g2 = new Gastronomia("489235", 15.0, true, "Hamburguesa criolla", 180.0, 4);
            sistema.agregarGastronomia("489235", 15.0, true, "Hamburguesa criolla", 180-0, 4);
            System.out.println("SE creo exitosamente");
            System.out.println("Codigo: " + g2.getCodServicio());
            System.out.println("Porcentaje del descuento: " + g2.getPorcentajeDescuento() + "%");
            System.out.println("Hamburguesa: " + g2.getGastronomia());
            System.out.println("Precio: $" + g2.getPrecio());
            System.out.println("Dia: " + g2.getDiaSemDesc());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        ///////////////////////////////////////////////////////////////////////////////
        //Intentar crear el objeto Hospedaje
        System.out.println("1-3");
        try {
            Hospedaje h1 = new Hospedaje("2872", 10.0, true, "Cabaña 3 personas", 1500.0);
            System.out.println("Codigo: " + h1.getCodServicio());
            System.out.println("Porcentaje del descuento: " + h1.getPorcentajeDescuento() + "%");
            System.out.println("Hospedaje: " + h1.getHospedaje());
            System.out.println("Precio por noche: $" + h1.getPrecioPorNoche());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        ///////////////////////////////////////////////////////////////////////////////
        

        //Crear el objeto Hospedaje
        System.out.println("1-4");
        try {
             Hospedaje h2 = new Hospedaje("287282", 10.0, true, "Cabaña 3 personas", 1500.0);
            sistema.agregarHospedaje("287282", 10.0, true, "Cabaña 3 personas", 1500.0);
            System.out.println("SE creo exitosamente");
             System.out.println("Codigo: " + h2.getCodServicio());
            System.out.println("Porcentaje del descuento: " + h2.getPorcentajeDescuento() + "%");
            System.out.println("Hospedaje: " + h2.getHospedaje());
            System.out.println("Precio por noche: $" + h2.getPrecioPorNoche());
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        ///////////////////////////////////////////////////////////////////////////////
        //Calcular e imprimir precio final del servicio
        System.out.println("2-1");
        try {
            Gastronomia g3 = (Gastronomia) sistema.traerServicio("489235");
             double precioFinal = g3.calcularPrecioFinal(LocalDate.of(2020, 10, 28));
             System.out.println("El precio final: " + precioFinal);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        ///////////////////////////////////////////////////////////////////////////////
        //Calcular e imprimir precio final del servicio
        System.out.println("2-2");
        try {
            Servicio hospedaje = sistema.traerServicio("287282");
        System.out.println(hospedaje.calcularPrecioFinal(LocalDate.of(2020, 10, 27)));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        ///////////////////////////////////////////////////////////////////////////////
        //Agregar los siguientes objetos e imprimir la lista de servicios
        System.out.println("3");
        try {
            sistema2.agregarGastronomia("858927", 15.0, true, "Milanesa con puré", 350.0, 3);
            sistema2.agregarHospedaje("489259", 10.0, true, "Habitación triple", 2200.0);
            sistema2.agregarGastronomia("182835", 20.0, false, "Gaseosa", 120.0, 3);
            sistema2.agregarHospedaje("758972", 15.0, false, "Habitación simple", 1000.0);

        // Imprimir lista de servicios
        List<Servicio> servicios = sistema2.lstServicio;
        for (Servicio servicio : servicios) {
            System.out.println(servicio);
            }
        } catch (Exception e) {
            System.out.println("Error al agregar servicios: " + e.getMessage());
        }
        
        ///////////////////////////////////////////////////////////////////////////////
        //Traer todos los objetos Servicios en enPromocion=true
        System.out.println("4-1");
        try {
            List<model.Servicio> serviciosEnPromocion = sistema.traerServicio(true);
        System.out.println("Servicios en promoción:");
        for (model.Servicio s : serviciosEnPromocion) {
            System.out.println(s);
        }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        ///////////////////////////////////////////////////////////////////////////////
        //Traer todos los objetos Servicios del día 2020-10-28 y enPromocion=true
        System.out.println("4-2");
        try {
            List<model.Servicio> serviciosPromocionDia = sistema2.traerServicio(true, LocalDate.of(2020, 10, 28));
        System.out.println("Servicios en promoción para el día 2020-10-28:");
        for (model.Servicio s : serviciosPromocionDia) {
            System.out.println(s);
        }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
