/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Modelo_Clientes;
import Modelo.pojos.Cliente;
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
    
    //Creamos los objetos para poder usar los métodos y el de la vista
        Modelo_Clientes a= new Modelo_Clientes();    
        Clientes clientes;

        //Creamos el controlador
    Controlador_Clientes(Clientes clientes) {
        this.clientes = clientes;
    }
        
    //Necesitamos un Enum para la lista de posibles acciones en la vista
        public enum AccionMVC{       
        clientesATRAS,
        clientesGUARDAR,
        clientesMODIFICAR,
        clientesELIMINAR,
        clientesBUSCAR,
        }
        
        //Aqui vendrán recogidos todas las posibles acciones de la vista y su estado
        public void clientes()
        {
            clientes.setVisible(true);
            clientes.setLocationRelativeTo(null);
            clientes.setResizable(false);
            
            this.clientes.atras.setActionCommand("clientesATRAS");
            this.clientes.atras.addActionListener(this);
            
            this.clientes.guardar.setActionCommand("clientesGUARDAR");
            this.clientes.guardar.addActionListener(this);
            
            this.clientes.modificar.setActionCommand("clientesMODIFICAR");
            this.clientes.modificar.addActionListener(this);
            
            this.clientes.eliminar.setActionCommand("clientesELIMINAR");
            this.clientes.eliminar.addActionListener(this);
            
            this.clientes.buscar.setActionCommand("clientesBUSCAR");
            this.clientes.buscar.addActionListener(this);
            
            //Aqui es donde mediante un método imprimimos la tabla con todos los datos de la base de datos
            this.clientes.listaclientes.addMouseListener(this);
            this.clientes.listaclientes.setModel(a.getTabla());
        }
        
        //Con este mouseclicked controlamos que podamos clickar sobre una tabla para poder recoger esos datos y mostrarlos en otro campo
    public void mouseClicked(MouseEvent e) {
        if( e.getButton()== 1)//boton izquierdo
        {
             int fila = this.clientes.listaclientes.rowAtPoint(e.getPoint());
             if (fila > -1){                
                this.clientes.dni.setText( String.valueOf( this.clientes.listaclientes.getValueAt(fila, 0) ));
                this.clientes.nombre.setText( String.valueOf( this.clientes.listaclientes.getValueAt(fila, 1) ));

             }
        }
    }
    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}
    
    public void actionPerformed(ActionEvent e) {
        
          //Switch-case para controlar qué hace cada botón en la vista exactamente
        switch (Controlador_Clientes.AccionMVC.valueOf(e.getActionCommand())){
            case clientesATRAS:                
                this.clientes.dispose();
                new Controlador_Principal( new Principal() ).principal() ;
            break;
            
            //Botón Guardar que nos permitirá meter clientes en la base de datos
            case clientesGUARDAR:
                 //Comprobamos que todos los campos estén llenos
                if (this.clientes.dni.getText().equals("")||this.clientes.nombre.getText().equals(""))
                {
                    this.clientes.ok.setText("Complete todos los campos");
                }else{
                    //Cogemos los datos pasados por parámetros y los guardamos con un Insert en la base de datos
                    if (a.ClientExists(this.clientes.dni.getText())==false){
                                            a.ClientInsert(this.clientes.dni.getText(), this.clientes.nombre.getText());
                    this.clientes.ok.setText("Guardado");
                    //Actualizamos la tabla
                    this.clientes.listaclientes.setModel(a.getTabla());
                    }else{
                        this.clientes.ok.setText("Ya existe");
                    }
                }         
            break;
            
            //Botón Modificar que nos permitirá modificar los datos de un cliente
            case clientesMODIFICAR:
                if (a.ClientExists(this.clientes.dni.getText())==false)
                {
                    this.clientes.ok.setText("No existe ese cliente");
                }else{
                    //Usamos un update para actualizar la tabla cogiendo los datos metidos en los campos
                    a.ClientUpdate(this.clientes.dni.getText(), this.clientes.nombre.getText());
                    this.clientes.ok.setText("Actualizado");
                    //Actualizamos la tabla
                    this.clientes.listaclientes.setModel(a.getTabla());
                }
            break;
            
            //Botón Eliminar que nos permite eliminar un artículo de la base de datos
            case clientesELIMINAR:
                if (a.ClientExists(this.clientes.dni.getText())==false)
                {
                    this.clientes.ok.setText("No existe ese cliente");
                }else{
                    //Usamos un Delete para eliminar el cliente de la base de datos
                    a.ClientDelete(this.clientes.dni.getText());
                        this.clientes.ok.setText("Eliminado");
                        //Actualizamos la tabla
                    this.clientes.listaclientes.setModel(a.getTabla());
                }
            break;
            
            //Botón Buscar que nos permite buscar un Cliente en la base de datos
            case clientesBUSCAR:
                if (this.clientes.DNIBusqueda.getText().equals("")) {
                    this.clientes.dni.setText("");
                    this.clientes.nombre.setText("");
                }else{
                    //Usamos un método llamado ClientSearch para buscar el clienteo en la base de datos
                   Cliente client= a.ClientSearch(this.clientes.DNIBusqueda.getText());
                    this.clientes.dni.setText(client.getDni());
                    this.clientes.nombre.setText(client.getNombre());
                }
            break;
    }
    
}
}
