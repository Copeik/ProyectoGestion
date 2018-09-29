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
import javax.swing.JOptionPane;

/**
 *
 * @author qiqer
 */
public class Controlador_Clientes implements ActionListener, MouseListener{
    
        Clientes clientes;
        
        //Creación del objeto para usar los métodos de clientes
        //Modelo_Clientes mc = new Metodos_Clientes();

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
            
            //Aqui técnicamente te imprimiría la tabla de clientes
            //this.clientes.listaclientes.setModel(this.mc.mostrarC());
            
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
                //Aqui va cómo se guarda el cliente
                /*if(this.mc.crearC(this.clientes.nombre.getText(),
                        this.clientes.dni.getText())){                    
                    this.clientes.ok.setText("Creado");
                    //Aqui va que se actualice la tabla sola
                }else{
                    this.clientes.ok.setText("No creado");
                }*/
            break;
            case clientesMODIFICAR:
                /*if (this.mc.ClientExist(this.clientes.dni.getText()))
                {
                    if (this.mc.ClientUpdate(this.clientes.dni.getText()))
                    {
                    this.clientes.ok.setText("Modificado");
                    //Aqui va que se actualice la tabla sola
                    }
                    else
                    {
                        this.clientes.ok.setText("No modificado");
                    }
                }
                else
                {
                    this.clientes.ok.setText("No modificado");
                }*/
            break;
            case clientesELIMINAR:
                /*if (this.mc.eliminarC(this.clientes.dni.getText()))
                {
                    this.clientes.ok.setText("Eliminado");
                    //Aqui va que se actualice la tabla sola
                }
                else
                {
                    this.clientes.ok.setText("No eliminado");
                }*/
            break;
            case clientesBUSCAR:
                //Buscamos el DNI del usuario y si está 
                /*if (this.mc.ClientExist(this.clientes.dni.getText()))
                {
                    this.clientes.ok.setText("Encontrado");
                    //Aqui va que se actualice la tabla sola
                }
                else
                {
                    this.clientes.ok.setText("No encontrado");
                }*/
            break;
    }
    
}
}
