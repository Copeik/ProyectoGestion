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

        //Creación del objeto para usar los métodos de clientes
        //Modelo_Facturas mf = new Metodos_Facturas();
        
    Controlador_Facturas(Facturas facturas) {
        this.facturas = facturas;
    }
        
        public enum AccionMVC{
        
        //Acciones Vista opciones
        facturasCREAR,
        facturasMODIFICAR,
        facturasELIMINAR,
        facturasBUSCAR,
        }
        
        public void facturas()
        {
            facturas.setVisible(true);
            facturas.setLocationRelativeTo(null);
            facturas.setResizable(false);
            
            //Aqui técnicamente te imprimiría la tabla de clientes
            //this.facturas.listafacturas.setModel(this.mf.mostrarF());
            
            this.facturas.crear.setActionCommand("facturasCREAR");
            this.facturas.crear.addActionListener(this);
            
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
            case facturasCREAR:
                /*this.facturas.dispose();
                new Controlador_Factura(new Facturas()).facturas();*/
            break;
            case facturasMODIFICAR:
                /*if (this.mf.FacExist(Integer.parseInt(this.facturas.codfactura.getText())))
                 {
                     if (this.mf.FacExist(Integer.parseInt(this.facturas.codfactura.getText())))
                     {
                     this.facturas.ok.setText("Modificado");
                     //Aqui va que se actualice la tabla sola
                     }
                     else
                     {
                         this.facturas.ok.setText("No modificado");
                     }
                 }
                 else
                 {
                     this.facturas.ok.setText("No modificado");
                 }*/
            break;
            case facturasELIMINAR:
                /*if (this.mf.FacExist(Integer.parseInt(this.facturas.codfactura.getText())))
                {
                    this.facturas.ok.setText("Eliminado");
                    //Aqui va que se actualice la tabla sola
                }
                else
                {
                    this.facturas.ok.setText("No eliminado");
                }*/
            break;
            case facturasBUSCAR:
                //Buscamos el código del usuario y si está 
                /*if (this.mf.FacExist(Integer.parseInt(this.facturas.codfactura.getText())))
                {
                    this.facturas.ok.setText("Encontrado");
                    //Aqui va que se actualice la tabla sola
                }
                else
                {
                    this.facturas.ok.setText("No encontrado");
                }*/
            break;
    }
    
}
}
