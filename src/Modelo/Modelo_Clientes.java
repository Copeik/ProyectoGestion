/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.pojos.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author elabu
 */
public class Modelo_Clientes extends database {
    int count;
    //getTabla() nos devuelve la tabla con los valores de base de datos.
        public DefaultTableModel getTabla()
    {
      DefaultTableModel tablemodel = new DefaultTableModel();
      int registros = 0;
      String[] columNames = {"Dni","Nombre"};
      //obtenemos la cantidad de registros existentes en la tabla y se almacena en la variable "registros"
      //para formar la matriz de datos
      try{
         PreparedStatement pstm = this.getConnection().prepareStatement( "SELECT count(*) as total FROM Cliente");
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
         PreparedStatement pstm = this.getConnection().prepareStatement("SELECT * FROM Cliente");
         ResultSet res = pstm.executeQuery();
         int i=0;
         while(res.next()){
                data[i][0] = res.getString( "dni" );
                data[i][1] = res.getString( "Nombre" );
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
     public boolean ClientExists (String dni)
    {
        count=0;
        boolean res = false;
        int idc=0;
        String q = "SELECT * FROM cliente  WHERE dni='" + dni+"' ";
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
     //En este metodo eliminamos una tupla en la BBDD buscando esa tupla por la clave primaria
          public boolean ClientDelete (String dni)
    {
        boolean res = false;
        int idc=0;
        String q = "DELETE FROM cliente WHERE dni='"+dni+"'";
        try {
            PreparedStatement pstm = this.getConnection().prepareStatement(q);
            pstm.execute();
            res=true; 
            pstm.close();
         }catch(SQLException e){
            System.err.println( e.getMessage() );
       
        
         }
         return res;
}
          //En este metodo Actualizamos una tupla en la BBDD , buscando esa tupla con la clave primaria
          public boolean ClientUpdate (String dni, String nombre)
    {
        boolean res = false;
        int idc=0;
        String q = "UPDATE cliente \n" +
        "SET dni='"+dni+"', nombre='"+nombre+"' \n" +
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
          //Aqui realizamos la busqueda y devolvemos la tupla buscada por la clave primaria y la devolvemos como un objeto para poder ser usado.
          public Cliente ClientSearch (String dni)
    {
        Cliente cli = null;
        count=0;
        boolean res = false;
        int idc=0;
        String q = "SELECT * FROM cliente  WHERE dni='" + dni+"' ";
        try {
            PreparedStatement pstm = this.getConnection().prepareStatement(q);
            ResultSet cr = pstm.executeQuery();
            while(cr.next())
            {  
                cli= new Cliente(cr.getString("dni"),cr.getString("nombre"));
                count++;
            }
            if (count>=1) {
                res=true;
            }
            
            pstm.close();
         }catch(SQLException e){
            System.err.println( e.getMessage() );
       
        
         }
        
         return cli;
}
          




}