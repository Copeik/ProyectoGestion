/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.pojos;

/**
 *
 * @author elabu
 */
public class Factura {
    private String codigofac;
    private String dni;
    private double total;

    public Factura(String codigofac, String dni, double total) {
        this.codigofac = codigofac;
        this.dni = dni;
        this.total = total;
    }

    public String getCodigofac() {
        return codigofac;
    }

    public void setCodigofac(String codigofac) {
        this.codigofac = codigofac;
    }

    public String getdni() {
        return dni;
    }

    public void setDni(String fdni) {
        this.dni = dni;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
}
