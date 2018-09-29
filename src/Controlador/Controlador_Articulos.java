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
        
        //Creación del objeto para usar los métodos de clientes
        //Modelo_Articulos ma = new Metodos_Articulos();

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
            
            //Aqui técnicamente te imprimiría la tabla de clientes
            //this.articulos.listaarticulos.setModel(this.ma.mostrarA());
            
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
                //Aqui va cómo se guarda el articulo
                /*if(this.ma.crearA(Integer.parseInt(this.articulos.codarticulo.getText()),
                        Float.parseFloat(this.articulos.precio.getText()), this.articulos.nombre.getText())){                    
                    this.articulos.ok.setText("Creado");
                    //Aqui va que se actualice la tabla sola
                }else{
                    this.articulos.ok.setText("No creado");
                }*/
            break;
            case articulosMODIFICAR:
                /*if (this.ma.ArtExist(Integer.parseInt(this.articulos.codarticulo.getText())))
                 {
                     if (this.ma.ArtUpdate(Integer.parseInt(this.articulos.codarticulo.getText())))
                     {
                     this.articulos.ok.setText("Modificado");
                     //Aqui va que se actualice la tabla sola
                     }
                     else
                     {
                         this.articulos.ok.setText("No modificado");
                     }
                 }
                 else
                 {
                     this.articulos.ok.setText("No modificado");
                 }*/
            break;
            case articulosELIMINAR:
                /*if (this.ma.ArtDelete(Integer.parseInt(this.articulos.codarticulo.getText())))
                {
                    this.articulos.ok.setText("Eliminado");
                    //Aqui va que se actualice la tabla sola
                }
                else
                {
                    this.articulos.ok.setText("No eliminado");
                }*/
            break;
            case articulosBUSCAR:
                //Buscamos el código del usuario y si está 
                /*if (this.ma.ArtExist(Integer.parseInt(this.articulos.codarticulo.getText())))
                {
                    this.articulos.ok.setText("Encontrado");
                    //Aqui va que se actualice la tabla sola
                }
                else
                {
                    this.articulos.ok.setText("No encontrado");
                }*/
            break;
    }
    
}
}
