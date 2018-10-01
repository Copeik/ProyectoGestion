/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Modelo_Articulos;
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
        Modelo_Articulos a= new Modelo_Articulos();
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
            
            this.articulos.listaarticulos.addMouseListener(this);
            this.articulos.listaarticulos.setModel(a.getTabla());
        }
        
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
        
        switch (Controlador_Articulos.AccionMVC.valueOf(e.getActionCommand())){
            case articulosGUARDAR:
                if (this.articulos.codarticulo.getText().equals("")||this.articulos.nombre.getText().equals("")||this.articulos.codarticulo.getText().equals(""))
                {
                    this.articulos.ok.setText("Complete todos los campos");
                }else{
                     if (a.ArtExists(Integer.parseInt(this.articulos.codarticulo.getText()))==false) {
                        a.ArtInsert(Integer.parseInt(this.articulos.codarticulo.getText()), this.articulos.nombre.getText(),Double.parseDouble(this.articulos.precio.getText()));
                         this.articulos.ok.setText("Guardado");
                    }else{
                        this.articulos.ok.setText("No guardado");
                    }
                   
                    this.articulos.listaarticulos.setModel(a.getTabla());
                }
            break;
            case articulosMODIFICAR:
                if (this.articulos.codarticulo.getText()!=null)
                {
                    a.ArtUpdate(Integer.parseInt(this.articulos.codarticulo.getText()), this.articulos.nombre.getText(),Double.parseDouble(this.articulos.precio.getText()));
                    this.articulos.ok.setText("Actualizado");
                    this.articulos.listaarticulos.setModel(a.getTabla());
                }
            break;
            case articulosELIMINAR:
                if (this.articulos.codarticulo.getText()!=null)
                {
                    a.ArtDelete(Integer.parseInt(this.articulos.codarticulo.getText()));
                    this.articulos.ok.setText("Eliminado");
                    this.articulos.listaarticulos.setModel(a.getTabla());
                }
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
