/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import static Controlador.Controlador_Facturas.factura_M;
import Modelo.Modelo_Articulos;
import Modelo.Modelo_Detalles;
import static Modelo.Modelo_Detalles.Completo;
import Modelo.Modelo_Facturas;
import Vistas.Detalle;
import Vistas.Facturas;
import Vistas.TablaCli;

import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;


/**
 *
 * @author qiqer
 */
public class Controlador_Detalle implements ActionListener, MouseListener{
    
        Modelo_Facturas f = new Modelo_Facturas();
        Modelo_Detalles d= new Modelo_Detalles();
        Modelo_Articulos art=new Modelo_Articulos();
        Detalle det;
        
    public Controlador_Detalle(Detalle detalle) {
        this.det = detalle;
    }


        
        public enum AccionMVC{
        
        //Acciones Vista opciones
        detalleCLIENTES,
        detalleATRAS,
        detalleENVIAR,
        detalleAÑADIR,
        detallesELIMINAR,
        facturasBUSCAR,        
        }

    void detalle() {
        det.setLocationRelativeTo(null);
        det.setTitle("Factura");
        det.setVisible(true);

        //Declaramos una acción utilizando los Enum para asignarle un evento
        this.det.Clientes.setActionCommand("detalleCLIENTES");
        this.det.Clientes.addActionListener(this);
        
        this.det.atras.setActionCommand("detalleATRAS");
        this.det.atras.addActionListener(this);
        
        this.det.eliminar_articulo.setActionCommand("detallesELIMINAR");
        this.det.eliminar_articulo.addActionListener(this);
        
        this.det.enviar_factura.setActionCommand("detalleENVIAR");
        this.det.enviar_factura.addActionListener(this);
        
        this.det.añadir_articulo.setActionCommand("detalleAÑADIR");
        this.det.añadir_articulo.addActionListener(this);        
              
        this.det.listafactura.addMouseListener(this);
        this.det.listafactura.setModel(d.getTabla(factura_M));   
        
        this.det.Tabla_stock.addMouseListener(this);
        this.det.Tabla_stock.setModel(art.getTabla());
        
        this.setEventMouseCliked(det.Tabla_stock);
        this.setEventMouseCliked(det.listafactura);
        
        this.det.CodFac.setText(factura_M);
        
        
    }
    private void setEventMouseCliked(JTable tbl){
        this.det.Tabla_stock.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override 
            public void mouseClicked(MouseEvent e) {
                tablaproductos(e);
             }
});
    }
        private void setEventMouseCliked2(JTable tbl){
        this.det.listafactura.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override 
            public void mouseClicked(MouseEvent e) {
                tabladetalles(e);
             }
});
    }
    
    public void tablaproductos(MouseEvent e){
        
             int fila = this.det.Tabla_stock.rowAtPoint(e.getPoint());
             if (fila > -1){                
             this.det.CodigoArticulo.setText( String.valueOf( this.det.Tabla_stock.getValueAt(fila, 0) ));
             this.det.NombreArticulo.setText( String.valueOf( this.det.Tabla_stock.getValueAt(fila, 1) ));
             this.det.PrecioArticulo.setText( String.valueOf( this.det.Tabla_stock.getValueAt(fila, 2) ));
    }}
        public void tabladetalles(MouseEvent e){
             int fila = this.det.listafactura.rowAtPoint(e.getPoint());
             if (fila > -1){                
             this.det.CodArt.setText( String.valueOf( this.det.listafactura.getValueAt(fila, 0) ));

    }}
        @Override
             public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}

            public void mouseReleased(MouseEvent e) {}

            public void mouseEntered(MouseEvent e) {}

            public void mouseExited(MouseEvent e) {}

            public void actionPerformed(ActionEvent e) {
        
        switch (AccionMVC.valueOf(e.getActionCommand())){
            
            case detalleCLIENTES:
                new Controlador_TablaCli(new TablaCli()).tablacli();
                break;
                
            case detalleATRAS:

                    this.d.DetDelete2(factura_M);
                
                this.det.dispose();
                new Controlador_Facturas(new Facturas()).facturas();
                break;
            case detalleENVIAR:
                if (this.det.nomfac.getText().equals("")) {
                    
                }else{
                    this.f.FacInsert(factura_M, this.det.nomfac.getText(), Double.parseDouble(this.det.Total.getText()));
                }
               
                break;
            case detalleAÑADIR:
                
                if (this.det.CodigoArticulo.getText().equals("")) {
                    
                }else if (art.ArtExists(Integer.parseInt(this.det.CodigoArticulo.getText()))==true) {
                    this.d.DetInsert(Integer.parseInt(this.det.CodigoArticulo.getText()), factura_M, Double.parseDouble(this.det.PrecioArticulo.getText()));
                }
            this.det.Total.setText(""+this.d.getTotal(factura_M));
            det.listafactura.setModel(d.getTabla(factura_M));  
                

             //   new Controlador_Facturas(new Factura()).factura();
                break;
            case detallesELIMINAR:
                if (this.det.CodArt.getText().equals("")) {
                    
                }else if (art.ArtExists(Integer.parseInt(this.det.CodArt.getText()))==true) {
                    d.DetDelete(factura_M,Integer.parseInt(this.det.CodArt.getText()));
                }
                this.det.Total.setText(""+this.d.getTotal(factura_M));
                det.listafactura.setModel(d.getTabla(factura_M));  
                
             //   new Controlador_Facturas(new Factura()).factura();
                break;
           case facturasBUSCAR:
                
                
             //   new Controlador_Facturas(new Factura()).factura();
                break;     
          
    }

    
}}
