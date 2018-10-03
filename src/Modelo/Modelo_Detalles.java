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
        public static double Completo=0;
            
        //Método que nos permite coger todos los datos de la tabla detalle
    public DefaultTableModel getTabla(String factura)
    {
      DefaultTableModel tablemodel = new DefaultTableModel();
      int registros = 0;
      String[] columNames = {"Codigo articulo","Codigo factura","Precio final"};
      //obtenemos la cantidad de registros existentes en la tabla y se almacena en la variable "registros"
      //para formar la matriz de datos
      try{
         PreparedStatement pstm = this.getConnection().prepareStatement( "SELECT count(*) as total1 FROM detalles WHERE codigofac2='"+factura+"'");
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
         PreparedStatement pstm = this.getConnection().prepareStatement("SELECT * FROM detalles WHERE codigofac2='"+factura+"'");
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

    //Método que nos permite insertar en la tabla Detalles los datos que nos vengan como parámetro a través de la vista
     public boolean DetInsert (int codarticulo, String codigofac2,double preciofinal)
    {
        boolean res = false;
        
        //Usamos un insert para poder guardar el Detalle
        String q = "INSERT INTO detalles VALUES ("+codarticulo+",'"+codigofac2+"',"+preciofinal+")";
        try {
            PreparedStatement pstm = this.getConnection().prepareStatement(q);
            pstm.execute();
            System.out.println("Insertado con exito");
            //Usamos esta variable para ir sumando los precios de los artículos para tener el precio final de la factura
            Completo = Completo + preciofinal;
            res=true; 
            pstm.close();
         }catch(SQLException e){
            System.err.println( e.getMessage() );
       
        
         }
         return res;
}
        //Método que nos permite eliminar los datos de la tabla Detalle
          public boolean DetDelete (String codigofac2,int codigoart)
    {
        boolean res = false;
        int idc=0;
        double preciodelete=0;
        try{
            //Para esto usamos antes un select para poder sacar el precio de lo que cuesta el artículo e irlo restando según quitemos de nuestra tabla para la factura
         PreparedStatement pstm2 = this.getConnection().prepareStatement( "SELECT preciofinal FROM detalles WHERE codigofac2='"+codigofac2+"' AND codarticulo="+codigoart);
         ResultSet res2 = pstm2.executeQuery();
         res2.next();
         preciodelete = res2.getDouble("preciofinal");
         res2.close();
      }catch(SQLException e){
         System.err.println( e.getMessage() );
      }
        
        //Usamos el Delete para eliminar el artículo de la vista Detalle y de nuestra tabla de selección de factura
        String q = "DELETE FROM detalles WHERE codigofac2='"+codigofac2+"' AND codarticulo="+codigoart;
        try {
            PreparedStatement pstm = this.getConnection().prepareStatement(q);
            pstm.execute();
            System.out.println("Eliminado");
            Completo = Completo - preciodelete;
            res=true; 
            pstm.close();
         }catch(SQLException e){
            System.err.println( e.getMessage() );
         }
         return res;
}
          //Método que nos permite borrar todos los datos de una factura
          public boolean DetDelete2 (String codigofac2)
    {
        boolean res = false;
        int idc=0;
        String q = "DELETE FROM detalles WHERE codigofac2='"+codigofac2+"'";
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
          //Método para actualizar la tabla facturas
          public boolean DetUpdate (int codarticulo, String codigofac2,double preciofinal)
    {
        boolean res = false;
        int idc=0;
        //Usamos un Update para poder actualizarlo mediante los datos dados
        String q = "UPDATE facturas \n" +
        "SET codarticulo="+codarticulo+", codigofac2='"+codigofac2+"', preciofinal="+preciofinal+" \n" +
        "WHERE codigofac2='"+codigofac2+"' AND codarticulo="+codarticulo ;
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
          //Método que nos permite sacar el precio total de la factura cuando vayamos a terminarla
          public double getTotal (String codfactura)
          {
              double totalisimo=0;
              try{
                    PreparedStatement pstm = this.getConnection().prepareStatement( "SELECT preciofinal FROM detalles WHERE codigofac2='"+codfactura+"'");
                    ResultSet res = pstm.executeQuery();
                    while (res.next())
                    {
                        totalisimo = totalisimo + res.getDouble("preciofinal");
                    }                    
                    res.close();
      }     catch(SQLException e){
         System.err.println( e.getMessage() );
      }
            return totalisimo;
          }

}


