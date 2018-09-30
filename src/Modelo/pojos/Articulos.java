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
public class Articulos {
    private int codart;
    private String nombreart;
    private double precioini;

    public Articulos(int codart, String nombreart, double precioini) {
        this.codart = codart;
        this.nombreart = nombreart;
        this.precioini = precioini;
    }

    public int getCodart() {
        return codart;
    }

    public void setCodart(int codart) {
        this.codart = codart;
    }

    public String getNombreart() {
        return nombreart;
    }

    public void setNombreart(String nombreart) {
        this.nombreart = nombreart;
    }

    public double getPrecioini() {
        return precioini;
    }

    public void setPrecioini(double precioini) {
        this.precioini = precioini;
    }
    
    
}
