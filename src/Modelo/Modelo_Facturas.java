/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.pojos.Factura;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author elabu
 */
public class Modelo_Facturas extends database {
    int count;
    //getTabla() nos devuelve la tabla con los valores de base de datos.
    public DefaultTableModel getTabla()
    {
      DefaultTableModel tablemodel = new DefaultTableModel();
      int registros = 0;
      String[] columNames = {"Codigo","DNI Cliente","Total"};
      //obtenemos la cantidad de registros existentes en la tabla y se almacena en la variable "registros"
      //para formar la matriz de datos
      try{
         PreparedStatement pstm = this.getConnection().prepareStatement( "SELECT count(*) as total1 FROM facturas");
         ResultSet res = pstm.executeQuery();
         res.next();
         registros = res.getInt("total1");
         res.close();
      }catch(SQLException e){
         System.err.println( e.getMessage() );
      }
    //se crea una matriz con tantas filas y columnas que necesite
    Object[][] data = new String[registros][5];
      try{
          //realizamos la consulta sql y llenamos los datos en la matriz "Object[][] data"
         PreparedStatement pstm = this.getConnection().prepareStatement("SELECT * FROM facturas");
         ResultSet res = pstm.executeQuery();
         int i=0;
         while(res.next()){
                data[i][0] = res.getString( "codigofac" );
                data[i][1] = res.getString( "nombrecli" );
                data[i][2] = res.getString("total" );
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
     public boolean FacExists (String codigofac)
    {
        boolean res = false;
        int count=0;
        
        String q = "SELECT * FROM facturas WHERE codigofac ='" + codigofac+"'";
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
     public boolean FacInsert (String codigofac, String nombrecli,double total)
    {
        boolean res = false;
        
        String q = "INSERT INTO facturas VALUES ('"+codigofac+"','"+nombrecli+"',"+total+")";
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
          public boolean FacDelete (String codigofac)
    {
        boolean res = false;
        int idc=0;
        String q = "DELETE FROM facturas WHERE codigofac='"+codigofac+"'";
        try {
            PreparedStatement pstm = this.getConnection().prepareStatement(q);
            pstm.execute();
            System.out.println("Delete con exito");
            res=true; 
            pstm.close();
         }catch(SQLException e){
            System.err.println( e.getMessage() );
         }
         return res;
}   
          //En este metodo Actualizamos una tupla en la BBDD , buscando esa tupla con la clave primaria
          public boolean FacUpdate (String codigofac, String nombrecli,double total)
    {
        boolean res = false;
        int idc=0;
        String q = "UPDATE facturas SET codigofac='"+codigofac+"', nombrecli='"+nombrecli+"', total="+total+" WHERE codigofac='"+codigofac+"'" ;
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
          public Factura FacSearch (String codfac)
    {
        Factura fac = null;
        boolean res = false;
        int idc=0;
        String q = "SELECT * FROM facturas  WHERE codfac='" + codfac+"' ";
        try {
            PreparedStatement pstm = this.getConnection().prepareStatement(q);
            ResultSet cr = pstm.executeQuery();
            while(cr.next())
            {  
                fac= new Factura(cr.getString("nombrecli"),cr.getString("codigofac"),Float.parseFloat(cr.getString("total")));
                count++;
            }
            if (count>=1) {
                res=true;
            }
            
            pstm.close();
         }catch(SQLException e){
            System.err.println( e.getMessage() );
       
        
         }
        
         return fac;
}




}
