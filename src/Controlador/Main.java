/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.Modelo_Clientes;
import Vistas.Principal;

/**
 *
 * @author danireySvQ
 */
public class Main {
    
    public static void main(String[] args) {
        //ejecuta el controlador y este la vista
        new Controlador_Principal( new Principal() ).principal() ;
        Modelo_Clientes b =new Modelo_Clientes();
        System.out.println(b.ClientExists("abcdefg2"));
        
    }
    
}
