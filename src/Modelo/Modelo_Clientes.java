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
public class Modelo_Clientes extends database {
     public boolean ClientExists (String dni)
    {
        boolean res = false;
        int idc=0;
        String q = "SELECT * FROM cliente  WHERE dni='" + dni+"' ";
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
     public boolean ClientInsert (String dni, String nombre)
    {
        boolean res = false;
        int idc=0;
        String q = "INSERT INTO cliente VALUES ('"+dni+"','"+nombre+"')";
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
          public boolean ClientDelete (String dni)
    {
        boolean res = false;
        int idc=0;
        String q = "DELETE FROM cliente WHERE dni='"+dni+"'";
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
          public boolean ClientUpdate (String dni, String nombre)
    {
        boolean res = false;
        int idc=0;
        String q = "UPDATE cliente \n" +
        "SET dni='"+dni+"', column2='"+nombre+"' \n" +
        "WHERE dni='"+dni+"'";
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