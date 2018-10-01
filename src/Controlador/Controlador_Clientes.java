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
            Modelo_Clientes a= new Modelo_Clientes();
    
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
            
            this.clientes.listaclientes.addMouseListener(this);
            this.clientes.listaclientes.setModel(a.getTabla());
        }
        
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
        
        switch (Controlador_Clientes.AccionMVC.valueOf(e.getActionCommand())){
            case clientesGUARDAR:
                if (this.clientes.dni.getText().equals("")||this.clientes.nombre.getText().equals(""))
                {
                    this.clientes.ok.setText("Complete todos los campos");
                }else{
                    if (a.ClientExists(this.clientes.dni.getText())==false){
                                            a.ClientInsert(this.clientes.dni.getText(), this.clientes.nombre.getText());
                    this.clientes.ok.setText("Guardado");
                    this.clientes.listaclientes.setModel(a.getTabla());
                    }else{
                        this.clientes.ok.setText("Ya existe");
                    }
                }         
            break;
            case clientesMODIFICAR:
                if (a.ClientExists(this.clientes.dni.getText())==false)
                {
                    this.clientes.ok.setText("No existe ese cliente");
                }else{
                    a.ClientUpdate(this.clientes.dni.getText(), this.clientes.nombre.getText());
                    this.clientes.ok.setText("Actualizado");
                    this.clientes.listaclientes.setModel(a.getTabla());
                }
            break;
            case clientesELIMINAR:
                if (a.ClientExists(this.clientes.dni.getText())==false)
                {
                    this.clientes.ok.setText("No existe ese cliente");
                }else{
                    a.ClientDelete(this.clientes.dni.getText());
                        this.clientes.ok.setText("Eliminado");
                    this.clientes.listaclientes.setModel(a.getTabla());
                }
            break;
            case clientesBUSCAR:
                if (this.clientes.DNIBusqueda.getText().equals("")) {
                    this.clientes.dni.setText("");
                    this.clientes.nombre.setText("");
                }else{
                   Cliente client= a.ClientSearch(this.clientes.DNIBusqueda.getText());
                    this.clientes.dni.setText(client.getDni());
                    this.clientes.nombre.setText(client.getNombre());
                }
            break;
    }
    
}
}
