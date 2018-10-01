/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Modelo_Detalles;
import Vistas.Detalle;
import Vistas.Facturas;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

/**
 *
 * @author qiqer
 */
public class Controlador_Detalle {
    
        Modelo_Detalles d= new Modelo_Detalles();
        Detalle detalle;
        
    public Controlador_Detalle(Detalle detalle) {
        this.detalle = detalle;
    }
        
        public enum AccionMVC{
        
        //Acciones Vista opciones
        facturasATRAS,
        facturasCREAR,
        facturasMODIFICAR,
        facturasELIMINAR,
        facturasBUSCAR,
        }


    
    /*Factura detalle;
    
     Controlador_Detalles(Factura detalle) implements ActionListener, MouseListener{
        this.detalle = detalle;
    }*/

    void detalle() {
        /*detalle.setLocationRelativeTo(null);
        detalle.setTitle("Factura");
        detalle.setVisible(true);

        //Declaramos una acción utilizando los Enum para asignarle un evento
        this.detalle.admclientes.setActionCommand("principalADMCLIENTES");
        this.detalle.admclientes.addActionListener(this);
        
        this.detalle.admarticulos.setActionCommand("principalADMARTICULOS");
        this.detalle.admarticulos.addActionListener(this);
        
        this.detalle.admfacturas.setActionCommand("principalADMFACTURAS");
        this.detalle.admfacturas.addActionListener(this);
        
    }
    
            public void mouseClicked(MouseEvent e) {}

            public void mousePressed(MouseEvent e) {}

            public void mouseReleased(MouseEvent e) {}

            public void mouseEntered(MouseEvent e) {}

            public void mouseExited(MouseEvent e) {}

            public void actionPerformed(ActionEvent e) {
        
        switch (AccionMVC.valueOf(e.getActionCommand())){
            case principalADMCLIENTES:
                this.principal.dispose();
                new Controlador_Clientes(new Clientes()).clientes();
                break;
            case principalADMARTICULOS:
                this.principal.dispose();
                new Controlador_Articulos(new Articulos()).articulos();
                break;
            case principalADMFACTURAS:
                this.principal.dispose();
                new Controlador_Facturas(new Facturas()).facturas();
             //   new Controlador_Facturas(new Factura()).factura();
                break;
         */   
    }

    
}
