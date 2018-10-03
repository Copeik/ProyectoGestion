/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.pojos.Articulo;
import Modelo.pojos.Cliente;
import Vistas.Articulos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author elabu
 */
public class Modelo_Articulos extends database {
    int count;
    //getTabla() nos devuelve la tabla con los valores de base de datos.
    public DefaultTableModel getTabla()
    {
      DefaultTableModel tablemodel = new DefaultTableModel();
      int registros = 0;
      String[] columNames = {"Codigo","Nombre","Precio"};
      //obtenemos la cantidad de registros existentes en la tabla y se almacena en la variable "registros"
      //para formar la matriz de datos
      try{
         PreparedStatement pstm = this.getConnection().prepareStatement( "SELECT count(*) as total FROM Articulos");
         ResultSet res = pstm.executeQuery();
         res.next();
         registros = res.getInt("total");
         res.close();
      }catch(SQLException e){
         System.err.println( e.getMessage() );
      }
    //se crea una matriz con tantas filas y columnas que necesite
    Object[][] data = new String[registros][5];
      try{
          //realizamos la consulta sql y llenamos los datos en la matriz "Object[][] data"
         PreparedStatement pstm = this.getConnection().prepareStatement("SELECT * FROM Articulos");
         ResultSet res = pstm.executeQuery();
         int i=0;
         while(res.next()){
                data[i][0] = res.getString( "codarticulo" );
                data[i][1] = res.getString( "nombreart" );
                data[i][2] = res.getString( "precioini" );
            i++;
         }
         res.close();
         //se añade la matriz de datos en el DefaultTableModel
         tablemodel.setDataVector(data, columNames );
         }catch(SQLException e){
            System.err.println( e.getMessage() );
        }
        return tablemodel;
    } 
    //En este metodo metemos la claveprimaria y comprobamos que existe si no existe devolvera false.
     public boolean ArtExists (int codarticulo)
    {
        count=0;
        boolean res = false;
        int idc=0;
        //preparamos la consulta
        String q = "SELECT * FROM articulos WHERE codarticulo =" + codarticulo;
        try {
            PreparedStatement pstm = this.getConnection().prepareStatement(q);
            ResultSet cr = pstm.executeQuery();
            while(cr.next())
            {  
                count++;
            }
            if (count>=1) {
                res=true;
            }
            pstm.close();
         }catch(SQLException e){
            System.err.println( e.getMessage() );
       
        
         }
         return res;
}
     //En este metodo Insertamos una nueva tupla en la BBDD 
     public boolean ArtInsert (int codarticulo, String nombreart,double precioini)
    {
        boolean res = false;
        int idc=0;
        String q = "INSERT INTO articulos VALUES ("+codarticulo+",'"+nombreart+"',"+precioini+")";
        try {
            PreparedStatement pstm = this.getConnection().prepareStatement(q);
            pstm.execute();
            System.out.println("Insertado con exito");
            res=true; 
            pstm.close();
         }catch(SQLException e){
            System.err.println( e.getMessage() );
       
        
         }
         return res;
}
    //En este metodo eliminamos una tupla en la BBDD buscando esa tupla por la clave primaria
          public boolean ArtDelete (int codarticulo)
    {
        boolean res = false;
        int idc=0;
        String q = "DELETE FROM articulos WHERE codarticulo="+codarticulo;
        try {
            PreparedStatement pstm = this.getConnection().prepareStatement(q);
            pstm.execute();
            System.out.println("Insertado con exito");
            res=true; 
            pstm.close();
         }catch(SQLException e){
            System.err.println( e.getMessage() );
         }
         return res;
}
     //En este metodo Actualizamos una tupla en la BBDD , buscando esa tupla con la clave primaria
          public boolean ArtUpdate (int codarticulo, String nombreart,double precioini)
    {
        boolean res = false;
        int idc=0;
        String q = "UPDATE articulos \n" +
        "SET codarticulo="+codarticulo+", nombreart='"+nombreart+"', precioini="+precioini+" \n" +
        "WHERE codarticulo="+codarticulo ;
        try {
            PreparedStatement pstm = this.getConnection().prepareStatement(q);
            pstm.execute();
            System.out.println("Actualizado con exito");
            res=true; 
            pstm.close();
         }catch(SQLException e){
            System.err.println( e.getMessage() );
       
        
         }
         return res;
}
     //Aqui realizamos la busqueda y devolvemos la tupla buscada por la clave primaria y la devolvemos como un objeto para poder ser usado.
          public Articulo ArtSearch (int codarticulo)
    {
        Articulo art = null;
        count=0;
        boolean res = false;
        int idc=0;
        String q = "SELECT * FROM articulos  WHERE codarticulo=" + codarticulo;
        try {
            PreparedStatement pstm = this.getConnection().prepareStatement(q);
            ResultSet cr = pstm.executeQuery();
            while(cr.next())
            {  
                art= new Articulo(Integer.parseInt(cr.getString("codarticulo")),cr.getString("nombreart"),Double.parseDouble(cr.getString("precioini")));
                count++;
            }
            if (count>=1) {
                res=true;
            }
            
            pstm.close();
         }catch(SQLException e){
            System.err.println( e.getMessage() );
       
        
         }
        
         return art;
}



}
