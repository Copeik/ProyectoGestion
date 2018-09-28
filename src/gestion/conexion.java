/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Victor
 */
public class conexion {

     public static void conectar(){
     
    try {
             Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/antonio","root","admin");
            System.out.println("Intentando acceder...");
            Class.forName("com.mysql.jdbc.Driver");
            
         //obtenemos la conexiÃ³n
        
         

         if (conn!=null){
            System.out.println("OK base de datos  listo");
                     
                     PreparedStatement modificar = conn.prepareStatement("INSERT INTO cliente (dni,Nombre) VALUES ('12345678a','Manolo')");
                     modificar.executeUpdate();
                     Statement estado = conn.createStatement();
         ResultSet resultado = estado.executeQuery("select * from cliente");
         
             while (resultado.next()) {
                 System.out.println("ejemplo :"+resultado.getString("dni"));
                 
             }
           
         }
      }catch(SQLException e){
         System.out.println(e);
      }catch(ClassNotFoundException e){
         System.out.println(e);
      }
      catch (Exception e) {
        }
    }
}
