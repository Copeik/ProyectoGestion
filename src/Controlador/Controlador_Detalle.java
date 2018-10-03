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
    
    //Creamos los objetos para poder usar los métodos y el de las vistas
        Modelo_Facturas f = new Modelo_Facturas();
        Modelo_Detalles d= new Modelo_Detalles();
        Modelo_Articulos art=new Modelo_Articulos();
        Detalle det;
        Facturas fac;
        
        //Creamos el controlador
    public Controlador_Detalle(Detalle detalle) {
        this.det = detalle;
    }

        //Necesitamos un Enum para la lista de posibles acciones en la vista
        public enum AccionMVC{
        
        //Acciones Vista opciones
        detalleCLIENTES,
        detalleATRAS,
        detalleENVIAR,
        detalleAÑADIR,
        detallesELIMINAR,
        facturasBUSCAR,        
        }

         //Aqui vendrán recogidos todas las posibles acciones de la vista y su estado
    void detalle() {
        det.setLocationRelativeTo(null);
        det.setTitle("Factura");
        det.setVisible(true);

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
        
        //Aqui es donde mediante un método imprimimos la tabla con todos los datos de la base de datos
        this.det.Tabla_stock.addMouseListener(this);
        this.det.Tabla_stock.setModel(art.getTabla());
        
        //Necesitamos otros 2 eventos para otras 2 tablas
        this.setEventMouseCliked(det.Tabla_stock);
        this.setEventMouseCliked(det.listafactura);
        
        //Mostramos en un valor el parámetro que nos viene dado actualizado
        this.det.CodFac.setText(factura_M);
        
        
    }
    //Usamos los siguientes 2 eventos para que cuando clickemos en las tablas nos cojan los datos clickados y podamos darles otro uso
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
    
    //Con estos mouseclicked controlamos que podamos clickar sobre una tabla para poder recoger esos datos y mostrarlos en otro campo
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
        
                //Switch-case para controlar qué hace cada botón en la vista exactamente
        switch (AccionMVC.valueOf(e.getActionCommand())){
            
            //Botón clientes en el cual nos abrirá una ventana con la lista de clientes 
            case detalleCLIENTES:
                new Controlador_TablaCli(new TablaCli()).tablacli();
                break;
                
                //Botón de Atrás que nos cierra la vista actual y nos abre otra vez la de facturas
            case detalleATRAS:
                
                //En este caso también nos borra lo que hayamos ido guardando en la base de datos si no le hemos dado a enviar
                    this.d.DetDelete2(factura_M);
                
                this.det.dispose();
                new Controlador_Facturas(new Facturas()).facturas();
                break;
                
                //Botón Enviar que nos permitirá meter facturas en la base de datos
            case detalleENVIAR:
                if (this.det.nomfac.getText().equals("")) {
                    
                }else{
                    this.f.FacInsert(factura_M, this.det.nomfac.getText(), Double.parseDouble(this.det.Total.getText()));
                    this.det.dispose();
                    new Controlador_Facturas(new Facturas()).facturas();
                }
               
                break;
                
                //Botón Añadir que nos permitirá meter detalles en la base de datos
            case detalleAÑADIR:
                
                if (this.det.CodigoArticulo.getText().equals("")) {
                    
                }else if (art.ArtExists(Integer.parseInt(this.det.CodigoArticulo.getText()))==true) {
                    this.d.DetInsert(Integer.parseInt(this.det.CodigoArticulo.getText()), factura_M, Double.parseDouble(this.det.PrecioArticulo.getText()));
                }
                //Jugamos con las variables para sacar el precio total siempre
            this.det.Total.setText(""+this.d.getTotal(factura_M));
            //Actualizamos la tabla
            det.listafactura.setModel(d.getTabla(factura_M));                 
                break;
                
                //Botón Eliminar que nos permite eliminar un detalle de la base de datos
            case detallesELIMINAR:
                if (this.det.CodArt.getText().equals("")) {
                    
                }else if (art.ArtExists(Integer.parseInt(this.det.CodArt.getText()))==true) {
                    d.DetDelete(factura_M,Integer.parseInt(this.det.CodArt.getText()));
                }
                //Jugamos con las variables para sacar el precio total siempre
                this.det.Total.setText(""+this.d.getTotal(factura_M));
                //Actualizamos la tabla
                det.listafactura.setModel(d.getTabla(factura_M));  
                break;    
          
    }

    
}}
