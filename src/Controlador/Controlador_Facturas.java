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
    
        Modelo_Facturas f= new Modelo_Facturas();
        Facturas facturas;
        
    Controlador_Facturas(Facturas facturas) {
        this.facturas = facturas;
    }
        
        public enum AccionMVC{
        
        //Acciones Vista opciones
        facturasATRAS,
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
            
            this.facturas.listafacturas.addMouseListener(this);
            this.facturas.listafacturas.setModel(f.getTabla());
        }
        
    public void mouseClicked(MouseEvent e) {
        if( e.getButton()== 1)//boton izquierdo
        {
             int fila = this.facturas.listafacturas.rowAtPoint(e.getPoint());
             if (fila > -1){                
                this.facturas.codfactura.setText( String.valueOf( this.facturas.listafacturas.getValueAt(fila, 0) ));
                this.facturas.precio.setText( String.valueOf( this.facturas.listafacturas.getValueAt(fila, 1) ));
                this.facturas.dni.setText( String.valueOf( this.facturas.listafacturas.getValueAt(fila, 2) ));
             }
        }
    }

    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}
    
    public void actionPerformed(ActionEvent e) {
        
        switch (Controlador_Facturas.AccionMVC.valueOf(e.getActionCommand())){
            case facturasATRAS:                
                this.facturas.dispose();
                new Controlador_Principal( new Principal() ).principal() ;
            break;
            case facturasCREAR:
                if (this.facturas.codfacturabuscar.getText().equals("")) {
                    
                }else if(f.FacExists(Integer.parseInt(this.facturas.codfacturabuscar.getText()))==false){
                    factura_M=this.facturas.codfacturabuscar.getText();
                    this.facturas.dispose();
                    new Controlador_Detalle(new Detalle()).detalle();
                }
                
                
                
                //new Controlador_Detalle(new Detalle()).detalle();
            break;
            case facturasMODIFICAR:
                if (f.FacExists(Integer.parseInt(this.facturas.codfactura.getText())))
                 {
                     if (f.FacExists(Integer.parseInt(this.facturas.codfactura.getText())))
                     {
                     this.facturas.ok.setText("Modificada");
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
            case facturasELIMINAR:
                if (f.FacExists(Integer.parseInt(this.facturas.codfactura.getText())))
                {
                    this.facturas.ok.setText("Eliminada");
                    this.facturas.listafacturas.setModel(f.getTabla());
                }
                else
                {
                    this.facturas.ok.setText("No eliminada");
                }
            break;
            case facturasBUSCAR:
                if (this.facturas.codfacturabuscar.getText().equals("")) {
                    this.facturas.dni.setText("");
                    this.facturas.precio.setText("");
                    this.facturas.codfactura.setText("");
                }else{
                   Factura fact= f.FacSearch(this.facturas.codfacturabuscar.getText());
                    this.facturas.codfactura.setText(fact.getCodigofac());
                    this.facturas.dni.setText(fact.getdni());
                    this.facturas.precio.setText(""+fact.getTotal());
                    
                }
            break;
    }
    
}
}
