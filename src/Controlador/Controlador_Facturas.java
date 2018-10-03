/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Modelo_Facturas;
import Modelo.pojos.Factura;
import Vistas.Detalle;
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
    
    public static String factura_M;
    
    //Creamos los objetos para poder usar los métodos y el de la vista
        Modelo_Facturas f= new Modelo_Facturas();
        Facturas facturas;
        
        //Creamos el controlador
    Controlador_Facturas(Facturas facturas) {
        this.facturas = facturas;
    }
        
    //Necesitamos un Enum para la lista de posibles acciones en la vista
        public enum AccionMVC{
        facturasATRAS,
        facturasCREAR,
        facturasMODIFICAR,
        facturasELIMINAR,
        facturasBUSCAR,
        }
        
        //Aqui vendrán recogidos todas las posibles acciones de la vista y su estado
        public void facturas()
        {
            facturas.setVisible(true);
            facturas.setLocationRelativeTo(null);
            facturas.setResizable(false);
            
            this.facturas.atras.setActionCommand("facturasATRAS");
            this.facturas.atras.addActionListener(this);
            
            this.facturas.crear.setActionCommand("facturasCREAR");
            this.facturas.crear.addActionListener(this);
            
            this.facturas.modificar.setActionCommand("facturasMODIFICAR");
            this.facturas.modificar.addActionListener(this);
            
            this.facturas.eliminar.setActionCommand("facturasELIMINAR");
            this.facturas.eliminar.addActionListener(this);
            
            this.facturas.buscar.setActionCommand("facturasBUSCAR");
            this.facturas.buscar.addActionListener(this);
            
            //Aqui es donde mediante un método imprimimos la tabla con todos los datos de la base de datos
            this.facturas.listafacturas.addMouseListener(this);
            this.facturas.listafacturas.setModel(f.getTabla());
        }
        
        //Con este mouseclicked controlamos que podamos clickar sobre una tabla para poder recoger esos datos y mostrarlos en otro campo
    public void mouseClicked(MouseEvent e) {
        if( e.getButton()== 1)//boton izquierdo
        {
             int fila = this.facturas.listafacturas.rowAtPoint(e.getPoint());
             if (fila > -1){                
                this.facturas.codfactura.setText( String.valueOf( this.facturas.listafacturas.getValueAt(fila, 0) ));
                this.facturas.dni.setText( String.valueOf( this.facturas.listafacturas.getValueAt(fila, 1) ));
                this.facturas.precio.setText( String.valueOf( this.facturas.listafacturas.getValueAt(fila, 2) ));
             }
        }
    }

    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}
    
    public void actionPerformed(ActionEvent e) {
        
        //Switch-case para controlar qué hace cada botón en la vista exactamente
        switch (Controlador_Facturas.AccionMVC.valueOf(e.getActionCommand())){
            case facturasATRAS:                
                this.facturas.dispose();
                new Controlador_Principal( new Principal() ).principal() ;
            break;
            
            //Botón Crear que nos llevará a la vista de detalles para crear la factura
            case facturasCREAR:
                if (this.facturas.codfacturabuscar.getText().equals("")) {
                    this.facturas.ok.setText("Introduce un codigo nuevo abajo");
                }else if(f.FacExists(this.facturas.codfacturabuscar.getText())==false){
                    factura_M=this.facturas.codfacturabuscar.getText();
                    this.facturas.dispose();
                    new Controlador_Detalle(new Detalle()).detalle();
                }
                
                
                
                //new Controlador_Detalle(new Detalle()).detalle();
            break;
            
            //Botón Modificar que nos permitirá modificar los datos de una factura
            case facturasMODIFICAR:
                if (f.FacExists(this.facturas.codfactura.getText()))
                 {
                     if (f.FacExists(this.facturas.codfactura.getText()))
                     {
                     //Usamos un update para actualizar la tabla cogiendo los datos metidos en los campos
                     this.f.FacUpdate(this.facturas.codfactura.getText(), this.facturas.dni.getText(),Double.parseDouble(this.facturas.precio.getText()));
                     this.facturas.ok.setText("Modificada");
                     //Actualizamos la tabla
                     this.facturas.listafacturas.setModel(f.getTabla());
                     }
                     else
                     {
                         this.facturas.ok.setText("No modificada");
                     }
                 }
                 else
                 {
                     this.facturas.ok.setText("No modificada");
                 }
            break;
            
            //Botón Eliminar que nos permite eliminar una factura de la base de datos
            case facturasELIMINAR:
                if (f.FacExists(this.facturas.codfactura.getText()))
                {
                    //Usamos un Delete para eliminar la factura de la base de datos
                    this.f.FacDelete(this.facturas.codfactura.getText());
                    this.facturas.ok.setText("Eliminada");
                    //Actualizamos la tabla
                    this.facturas.listafacturas.setModel(f.getTabla());
                }
                else
                {
                    this.facturas.ok.setText("No eliminada");
                }
            break;
            
            //Botón Buscar que nos permite buscar una factura en la base de datos
            case facturasBUSCAR:
                if (this.facturas.codfacturabuscar.getText().equals("")) {
                    this.facturas.dni.setText("");
                    this.facturas.precio.setText("");
                    this.facturas.codfactura.setText("");
                }else if(this.f.FacExists(this.facturas.codfacturabuscar.getText())){
                    //Usamos un método llamado FacSearch para buscar la factura en la base de datos
                   Factura fact= f.FacSearch(this.facturas.codfacturabuscar.getText());
                    this.facturas.codfactura.setText(fact.getCodigofac());
                    this.facturas.dni.setText(fact.getdni());
                    this.facturas.precio.setText(""+fact.getTotal());
                    
                }
            break;
    }
    
}
}
