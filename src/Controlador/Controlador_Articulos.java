/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Modelo_Articulos;
import Modelo.pojos.Articulo;
import Modelo.pojos.Cliente;
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
    
    //Creamos los objetos para poder usar los métodos y el de la vista
        Modelo_Articulos a= new Modelo_Articulos();
        Articulos articulos;

        //Creamos el controlador
    Controlador_Articulos(Articulos articulos) {
        this.articulos = articulos;
    }
        
        //Necesitamos un Enum para la lista de posibles acciones en la vista
        public enum AccionMVC{
        articulosATRAS,
        articulosGUARDAR,
        articulosMODIFICAR,
        articulosELIMINAR,
        articulosBUSCAR,
        }
        
        //Aqui vendrán recogidos todas las posibles acciones de la vista y su estado
        public void articulos()
        {
            articulos.setVisible(true);
            articulos.setLocationRelativeTo(null);
            articulos.setResizable(false);
            
            this.articulos.atras.setActionCommand("articulosATRAS");
            this.articulos.atras.addActionListener(this);
            
            this.articulos.guardar.setActionCommand("articulosGUARDAR");
            this.articulos.guardar.addActionListener(this);
            
            this.articulos.modificar.setActionCommand("articulosMODIFICAR");
            this.articulos.modificar.addActionListener(this);
            
            this.articulos.eliminar.setActionCommand("articulosELIMINAR");
            this.articulos.eliminar.addActionListener(this);
            
            this.articulos.buscar.setActionCommand("articulosBUSCAR");
            this.articulos.buscar.addActionListener(this);
            
            //Aqui es donde mediante un método imprimimos la tabla con todos los datos de la base de datos
            this.articulos.listaarticulos.addMouseListener(this);
            this.articulos.listaarticulos.setModel(a.getTabla());
        }
        
        //Con este mouseclicked controlamos que podamos clickar sobre una tabla para poder recoger esos datos y mostrarlos en otro campo
    public void mouseClicked(MouseEvent e) {
        if( e.getButton()== 1)//boton izquierdo
        {
             int fila = this.articulos.listaarticulos.rowAtPoint(e.getPoint());
             if (fila > -1){                
                this.articulos.codarticulo.setText( String.valueOf( this.articulos.listaarticulos.getValueAt(fila, 0) ));
                this.articulos.nombre.setText( String.valueOf( this.articulos.listaarticulos.getValueAt(fila, 1) ));
                this.articulos.precio.setText( String.valueOf( this.articulos.listaarticulos.getValueAt(fila, 2) ));
             }
        }
    }
    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}
    
    public void actionPerformed(ActionEvent e) {
        
        //Switch-case para controlar qué hace cada botón en la vista exactamente
        switch (Controlador_Articulos.AccionMVC.valueOf(e.getActionCommand())){
            //Botón de Atrás que nos cierra la vista actual y nos abre otra vez la de opciones
            case articulosATRAS:                
                this.articulos.dispose();
                new Controlador_Principal( new Principal() ).principal() ;
            break;
            
            //Botón Guardar que nos permitirá meter artículos en la base de datos
            case articulosGUARDAR:
                //Comprobamos que todos los campos estén llenos
                if (this.articulos.codarticulo.getText().equals("")||this.articulos.nombre.getText().equals("")||this.articulos.codarticulo.getText().equals(""))
                {
                    this.articulos.ok.setText("Complete todos los campos");
                }else{
                    //Cogemos los datos pasados por parámetros y los guardamos con un Insert en la base de datos
                     if (a.ArtExists(Integer.parseInt(this.articulos.codarticulo.getText()))==false) {
                        a.ArtInsert(Integer.parseInt(this.articulos.codarticulo.getText()), this.articulos.nombre.getText(),Double.parseDouble(this.articulos.precio.getText()));
                         this.articulos.ok.setText("Guardado");
                    }else{
                        this.articulos.ok.setText("No guardado");
                    }
                   //Actualizamos la tabla
                    this.articulos.listaarticulos.setModel(a.getTabla());
                }
            break;
            
            //Botón Modificar que nos permitirá modificar los datos de un artículo
            case articulosMODIFICAR:
                if (this.articulos.codarticulo.getText()!=null)
                {
                    //Usamos un update para actualizar la tabla cogiendo los datos metidos en los campos
                    a.ArtUpdate(Integer.parseInt(this.articulos.codarticulo.getText()), this.articulos.nombre.getText(),Double.parseDouble(this.articulos.precio.getText()));
                    this.articulos.ok.setText("Actualizado");
                    //Actualizamos la tabla
                    this.articulos.listaarticulos.setModel(a.getTabla());
                }
            break;
            
            //Botón Eliminar que nos permite eliminar un artículo de la base de datos
            case articulosELIMINAR:
                if (this.articulos.codarticulo.getText()!=null)
                {
                    //Usamos un Delete para eliminar el artículo de la base de datos
                    a.ArtDelete(Integer.parseInt(this.articulos.codarticulo.getText()));
                    this.articulos.ok.setText("Eliminado");
                    //Actualizamos la tabla
                    this.articulos.listaarticulos.setModel(a.getTabla());
                }
            break;
            
            //Botón Buscar que nos permite buscar un artículo en la base de datos
            case articulosBUSCAR:
                if (this.articulos.articulobuscar.getText().equals("")) {
                    this.articulos.codarticulo.setText("");
                    this.articulos.nombre.setText("");
                    this.articulos.precio.setText("");
                }else{
                    //Usamos un método llamado ArtSearch para buscar el artículo en la base de datos
                   Articulo art= a.ArtSearch(Integer.parseInt(this.articulos.articulobuscar.getText()));
                    this.articulos.codarticulo.setText(""+art.getCodart());
                    this.articulos.nombre.setText(art.getNombreart());
                    this.articulos.precio.setText(""+art.getPrecioini());
                }
            break;
    }
    
}
}
