/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author elabu
 */
public class Modelo_Articulos extends database {
     public boolean ArtExists (int codarticulo)
    {
        boolean res = false;
        int idc=0;
        String q = "SELECT * FROM articulos WHERE codarticulo =" + codarticulo;
        try {
            PreparedStatement pstm = this.getConnection().prepareStatement(q);
            ResultSet cr = pstm.executeQuery();
            if(cr.next())
            {   
               res=true; 
            }
            pstm.close();
         }catch(SQLException e){
            System.err.println( e.getMessage() );
       
        
         }
         return res;
}
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




}
