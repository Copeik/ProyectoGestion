/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static sun.security.jgss.GSSUtil.login;

/**
 *
 * @author Victor
 */
public class Gestion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        conexion.conectar();
}
}
