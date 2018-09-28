/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vistas.Articulos;
import Vistas.Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author qiqer
 */
public class Controlador_Articulos implements ActionListener, MouseListener{
    
        Articulos articulos;

    Controlador_Articulos(Articulos articulos) {
        this.articulos = articulos;
    }
        
        public enum AccionMVC{
        
        //Acciones Vista opciones
        articulosGUARDAR,
        articulosMODIFICAR,
        articulosELIMINAR,
        articulosBUSCAR,
        }
        
        public void articulos()
        {
            articulos.setVisible(true);
            articulos.setLocationRelativeTo(null);
            articulos.setResizable(false);
            
            //Aqui va la llamada al método para que nos impirma la tabla
            //this.clientes.listaclientes.setModel(this.mg.mostrarDC(Metodos_empleado.getIdlogueado()));
            
            this.articulos.guardar.setActionCommand("articulosGUARDAR");
            this.articulos.guardar.addActionListener(this);
            
            this.articulos.modificar.setActionCommand("articulosMODIFICAR");
            this.articulos.modificar.addActionListener(this);
            
            this.articulos.eliminar.setActionCommand("articulosELIMINAR");
            this.articulos.eliminar.addActionListener(this);
            
            this.articulos.buscar.setActionCommand("articulosBUSCAR");
            this.articulos.buscar.addActionListener(this);
        }
        
    public void mouseClicked(MouseEvent e) {}

    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}
    
    public void actionPerformed(ActionEvent e) {
        
        switch (Controlador_Articulos.AccionMVC.valueOf(e.getActionCommand())){
            case articulosGUARDAR:
                //Llamada al método para guardar una nueva tupla y actualizar la tabla
            break;
            case articulosMODIFICAR:
                //Llamada al método para modificar la tupla y actualizar la tabla
            break;
            case articulosELIMINAR:
                //Llamada al método para borrar de la lista y actualizarla
            break;
            case articulosBUSCAR:
                //Llamada al método para buscar en la tabla
            break;
    }
    
}
}
