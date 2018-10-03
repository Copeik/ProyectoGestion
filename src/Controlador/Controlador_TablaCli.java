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
    
    Modelo.Modelo_Clientes cli = new Modelo_Clientes();
    Detalle det;
    TablaCli tablacli;
    
    public Controlador_TablaCli (TablaCli tablacli)
    {
        this.tablacli = tablacli;
    }
    
    public enum AccionMVC{
        
        //Acciones Vista 
        tablacliATRAS,       
        }
    
    void tablacli ()
    {        
        tablacli.setLocationRelativeTo(null);
        tablacli.setTitle("Tabla Clientes");
        tablacli.setVisible(true);
        
        this.tablacli.tablaclientes.addMouseListener(this);
        this.tablacli.tablaclientes.setModel(cli.getTabla());
        
        this.tablacli.atras.setActionCommand("tablacliATRAS");
        this.tablacli.atras.addActionListener(this);
    }
    
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
        switch (AccionMVC.valueOf(e.getActionCommand())){
                
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
