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
public class Controlador_Principal implements ActionListener, MouseListener{
    
    //Vista Principal
    Principal principal;
    
    // Declaro en ENUMs los eventos de la interfaz
    public enum AccionMVC{        
        principalADMCLIENTES,
        principalADMARTICULOS,
        principalADMFACTURAS,
    }

    public Controlador_Principal(Principal principal){
        this.principal = principal;
    }
    
    //Ventana inicio
    public void principal(){
        principal.setLocationRelativeTo(null);
        principal.setTitle("Principal");
        principal.setVisible(true);

        //Declaramos una acción utilizando los Enum para asignarle un evento
        this.principal.admclientes.setActionCommand("principalADMCLIENTES");
        this.principal.admclientes.addActionListener(this);
        
        this.principal.admarticulos.setActionCommand("principalADMARTICULOS");
        this.principal.admarticulos.addActionListener(this);
        
        this.principal.admfacturas.setActionCommand("principalADMFACTURAS");
        this.principal.admfacturas.addActionListener(this);
        
    }
    
            public void mouseClicked(MouseEvent e) {}

            public void mousePressed(MouseEvent e) {}

            public void mouseReleased(MouseEvent e) {}

            public void mouseEntered(MouseEvent e) {}

            public void mouseExited(MouseEvent e) {}

            public void actionPerformed(ActionEvent e) {
        
        switch (AccionMVC.valueOf(e.getActionCommand())){
            case principalADMCLIENTES:
                this.principal.dispose();
                new Controlador_Clientes(new Clientes()).clientes();
                break;
    }
    
}
}
