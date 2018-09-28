/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vistas.Clientes;
import Vistas.Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author qiqer
 */
public class Controlador_Clientes implements ActionListener, MouseListener{
    
        Clientes clientes;

    Controlador_Clientes(Clientes clientes) {
        this.clientes = clientes;
    }
        
        public enum AccionMVC{
        
        //Acciones Vista opciones
        clientesGUARDAR,
        clientesMODIFICAR,
        clientesELIMINAR,
        clientesBUSCAR,
        }
        
        public void clientes()
        {
            clientes.setVisible(true);
            clientes.setLocationRelativeTo(null);
            clientes.setResizable(false);
            
            //Aqui va la llamada al método para que nos impirma la tabla
            //this.clientes.listaclientes.setModel(this.mg.mostrarDC(Metodos_empleado.getIdlogueado()));
            
            this.clientes.guardar.setActionCommand("clientesGUARDAR");
            this.clientes.guardar.addActionListener(this);
            
            this.clientes.modificar.setActionCommand("clientesMODIFICAR");
            this.clientes.modificar.addActionListener(this);
            
            this.clientes.eliminar.setActionCommand("clientesELIMINAR");
            this.clientes.eliminar.addActionListener(this);
            
            this.clientes.buscar.setActionCommand("clientesBUSCAR");
            this.clientes.buscar.addActionListener(this);
        }
        
    public void mouseClicked(MouseEvent e) {}

    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}
    
    public void actionPerformed(ActionEvent e) {
        
        switch (Controlador_Clientes.AccionMVC.valueOf(e.getActionCommand())){
            case clientesGUARDAR:
                //Llamada al método para guardar una nueva tupla y actualizar la tabla
            break;
            case clientesMODIFICAR:
                //Llamada al método para modificar la tupla y actualizar la tabla
            break;
            case clientesELIMINAR:
                //Llamada al método para borrar de la lista y actualizarla
            break;
            case clientesBUSCAR:
                //Llamada al método para buscar en la tabla
            break;
    }
    
}
}
