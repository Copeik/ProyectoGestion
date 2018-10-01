/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Modelo_Facturas;
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
    
        Modelo_Facturas f= new Modelo_Facturas();
        Facturas facturas;
        
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
                this.facturas.dni.setText( String.valueOf( this.facturas.listafacturas.getValueAt(fila, 1) ));
             }
        }
    }

    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}
    
    public void actionPerformed(ActionEvent e) {
        
        switch (Controlador_Facturas.AccionMVC.valueOf(e.getActionCommand())){
            case facturasCREAR:
                this.facturas.dispose();
                new Controlador_Factura(new Facturas()).facturas();
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
                     this.facturas.ok.setText("No modificado");
                 }
            break;
            case facturasELIMINAR:
                if (f.FacExists(Integer.parseInt(this.facturas.codfactura.getText())))
                {
                    this.facturas.ok.setText("Eliminado");
                    this.facturas.listafacturas.setModel(f.getTabla());
                }
                else
                {
                    this.facturas.ok.setText("No eliminado");
                }
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
