/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vistas.Facturas;
import Vistas.Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author qiqer
 */
public class Controlador_Facturas implements ActionListener, MouseListener{
    
        Facturas facturas;

    Controlador_Facturas(Facturas facturas) {
        this.facturas = facturas;
    }
        
        public enum AccionMVC{
        
        //Acciones Vista opciones
        facturasGUARDAR,
        facturasMODIFICAR,
        facturasELIMINAR,
        facturasBUSCAR,
        }
        
        public void articulos()
        {
            facturas.setVisible(true);
            facturas.setLocationRelativeTo(null);
            facturas.setResizable(false);
            
            //Aqui va la llamada al método para que nos impirma la tabla
            //this.clientes.listaclientes.setModel(this.mg.mostrarDC(Metodos_empleado.getIdlogueado()));
            
            this.facturas.guardar.setActionCommand("facturasGUARDAR");
            this.facturas.guardar.addActionListener(this);
            
            this.facturas.modificar.setActionCommand("facturasMODIFICAR");
            this.facturas.modificar.addActionListener(this);
            
            this.facturas.eliminar.setActionCommand("facturasELIMINAR");
            this.facturas.eliminar.addActionListener(this);
            
            this.facturas.buscar.setActionCommand("facturasBUSCAR");
            this.facturas.buscar.addActionListener(this);
        }
        
    public void mouseClicked(MouseEvent e) {}

    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}
    
    public void actionPerformed(ActionEvent e) {
        
        switch (Controlador_Facturas.AccionMVC.valueOf(e.getActionCommand())){
            case facturasGUARDAR:
                //Llamada al método para guardar una nueva tupla y actualizar la tabla
            break;
            case facturasMODIFICAR:
                //Llamada al método para modificar la tupla y actualizar la tabla
            break;
            case facturasELIMINAR:
                //Llamada al método para borrar de la lista y actualizarla
            break;
            case facturasBUSCAR:
                //Llamada al método para buscar en la tabla
            break;
    }
    
}
}
