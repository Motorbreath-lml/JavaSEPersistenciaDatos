package com.platzi.mensajes_app;

import java.sql.Connection;

/**
 * @author j3r4ck
 */
public class Inicio {

    public static void main(String[] args) {
        //El objeto que nos permite la conexion
        ConexionDB conexion = new ConexionDB();
        //Intetan hacer la conexion
        try(Connection cnx=conexion.getConnection()){
            //Este bloque esta vacio por que la llamade del metodo ya esta en los argumentos del try            
        } catch (Exception ex) {
            System.out.println("No se obtuvo una conexion a la base de datos\n"+ex);
        }
    }
}
