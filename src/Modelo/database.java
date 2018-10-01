/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//ENRIQUE GAY
package Modelo;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static sun.security.jgss.GSSUtil.login;

/**
 *
 * @author elabu
 */
public class database {
      /* DATOS PARA LA CONEXION */
  private String bd = "antonio";
  private String login = "root";
  private String password = "admin";
  private String url = "jdbc:mysql://localhost/"+bd;
  private Connection conn = null;
//________
     public database(){
      try{
         //obtenemos el driver de para mysql
         Class.forName("com.mysql.jdbc.Driver");
         //obtenemos la conexiÃ³n
         conn = (Connection) DriverManager.getConnection(url,login,password);
         if (conn!=null){
            System.out.println("OK base de datos "+bd+" listo");
         }
      }catch(SQLException e){
         System.out.println(e);
      }catch(ClassNotFoundException e){
         System.out.println(e);
      }
    }
     public Connection getConnection()
    {
        return this.conn;
    }
}
