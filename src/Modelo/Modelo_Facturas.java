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
public class Modelo_Facturas extends database {
     public boolean FacExists (int codigofac)
    {
        boolean res = false;
        
        String q = "SELECT * FROM facturas WHERE codigofac =" + codigofac;
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
     public boolean FacInsert (int codigofac, String nombrecli,double total)
    {
        boolean res = false;
        
        String q = "INSERT INTO facturas VALUES ("+codigofac+",'"+nombrecli+"',"+total+")";
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
     
          public boolean FacDelete (int codigofac)
    {
        boolean res = false;
        int idc=0;
        String q = "DELETE FROM facturas WHERE codigofac="+codigofac;
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
          public boolean FacUpdate (int codigofac, String nombrecli,double total)
    {
        boolean res = false;
        int idc=0;
        String q = "UPDATE facturas \n" +
        "SET codigofac="+codigofac+", nombreart='"+nombrecli+"', precioini="+total+" \n" +
        "WHERE codigofac="+codigofac ;
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
