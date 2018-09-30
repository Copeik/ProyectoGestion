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
public class Facturas {
    private String codigofac;
    private String nombrecli;
    private double total;

    public Facturas(String codigofac, String nombrecli, double total) {
        this.codigofac = codigofac;
        this.nombrecli = nombrecli;
        this.total = total;
    }

    public String getCodigofac() {
        return codigofac;
    }

    public void setCodigofac(String codigofac) {
        this.codigofac = codigofac;
    }

    public String getNombrecli() {
        return nombrecli;
    }

    public void setNombrecli(String nombrecli) {
        this.nombrecli = nombrecli;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
}
