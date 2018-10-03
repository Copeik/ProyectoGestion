/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Modelo_Clientes;
import Vistas.Detalle;
import static Vistas.Detalle.nomfac;
import Vistas.TablaCli;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author qiqer
 */
public class Controlador_TablaCli implements ActionListener, MouseListener{
    
    //Creamos los objetos para poder usar los métodos y el de la vista
    Modelo.Modelo_Clientes cli = new Modelo_Clientes();
    Detalle det;
    TablaCli tablacli;
    
    //Creamos el controlador
    public Controlador_TablaCli (TablaCli tablacli)
    {
        this.tablacli = tablacli;
    }
    
    //Necesitamos un Enum para la lista de posibles acciones en la vista
    public enum AccionMVC{
        
        //Acciones Vista 
        tablacliATRAS,       
        }
    
    //Aqui vendrán recogidos todas las posibles acciones de la vista y su estado
    void tablacli ()
    {        
        tablacli.setLocationRelativeTo(null);
        tablacli.setTitle("Tabla Clientes");
        tablacli.setVisible(true);
        
        //Aqui es donde mediante un método imprimimos la tabla con todos los datos de la base de datos
        this.tablacli.tablaclientes.addMouseListener(this);
        this.tablacli.tablaclientes.setModel(cli.getTabla());
        
        this.tablacli.atras.setActionCommand("tablacliATRAS");
        this.tablacli.atras.addActionListener(this);
    }
    
    //Con este mouseclicked controlamos que podamos clickar sobre una tabla para poder recoger esos datos y mostrarlos en otro campo
     public void mouseClicked(MouseEvent e) {
        if( e.getButton()== 1)//boton izquierdo
        {
             int fila = this.tablacli.tablaclientes.rowAtPoint(e.getPoint());
             if (fila > -1){                
                nomfac.setText(String.valueOf( this.tablacli.tablaclientes.getValueAt(fila, 0) ));
             }
                this.tablacli.dispose();
        }
    }
     
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        //Switch-case para controlar qué hace cada botón en la vista exactamente
        switch (AccionMVC.valueOf(e.getActionCommand())){
                
            //Botón Atrás que nos cierra la vista
            case tablacliATRAS:
                
                this.tablacli.dispose();
                break;
     }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
