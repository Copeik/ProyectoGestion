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
public class Modelo_Detalles extends database {
        int count;
    public DefaultTableModel getTabla()
    {
      DefaultTableModel tablemodel = new DefaultTableModel();
      int registros = 0;
      String[] columNames = {"Codigo articulo","Codigo factura","Precio final"};
      //obtenemos la cantidad de registros existentes en la tabla y se almacena en la variable "registros"
      //para formar la matriz de datos
      try{
         PreparedStatement pstm = this.getConnection().prepareStatement( "SELECT count(*) as total1 FROM detalles");
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
         PreparedStatement pstm = this.getConnection().prepareStatement("SELECT * FROM detalles");
         ResultSet res = pstm.executeQuery();
         int i=0;
         while(res.next()){
                data[i][0] = res.getString( "codarticulo" );
                data[i][1] = res.getString( "codigofac2" );
                data[i][2] = res.getString("preciofinal" );
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

     public boolean DetInsert (int codarticulo, String codigofac2,double preciofinal)
    {
        boolean res = false;
        
        String q = "INSERT INTO detalles VALUES ("+codarticulo+",'"+codigofac2+"',"+preciofinal+")";
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
     
          public boolean DetDelete (int codigofac2)
    {
        boolean res = false;
        int idc=0;
        String q = "DELETE FROM detalles WHERE codigofac2="+codigofac2;
        try {
            PreparedStatement pstm = this.getConnection().prepareStatement(q);
            pstm.execute();
            System.out.println("Eliminado");
            res=true; 
            pstm.close();
         }catch(SQLException e){
            System.err.println( e.getMessage() );
         }
         return res;
}
          public boolean FacUpdate (int codarticulo, String codigofac2,double preciofinal)
    {
        boolean res = false;
        int idc=0;
        String q = "UPDATE facturas \n" +
        "SET codarticulo="+codarticulo+", codigofac2='"+codigofac2+"', preciofinal="+preciofinal+" \n" +
        "WHERE codigofac='"+codigofac2+"' AND codarticulo="+codarticulo ;
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


