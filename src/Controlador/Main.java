/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.Modelo_Articulos;
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
        Modelo_Articulos art= new Modelo_Articulos();
        System.out.println(b.ClientExists("abcdefg2"));
        System.out.println(b.ClientInsert("dasdass2","manue"));
        System.out.println(b.ClientDelete("dasdass2"));
        System.out.println(art.ArtInsert(123, "lavadora", 12.0));

                System.out.println(art.ArtUpdate(123, "Lavativa", 13.0));
                System.out.println(art.ArtDelete(123));
                System.out.println(art.ArtExists(123));

        
    }
    
}
