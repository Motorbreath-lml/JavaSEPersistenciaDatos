package com.platzi.mensajes_app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author j3r4ck
 */
public class ConexionDB {
    
    public Connection getConnection(){
        Connection conection=null;
        try{
            //El conector para la BD:el manejador//la direccion hacia la BD:el puerto/el nombre de la BD,Usuario,contraseña
            //Es mala practica dejar a root para manejar la BD lo mejor es crear otro usuario para esta BD y sobre todo hay que colocar contraseñas fuertes
            conection=DriverManager.getConnection("jdbc:mysql://localhost:3306/mensajes_app","root","");
            if(conection!=null){
                System.out.println("Conexion exitosa");
            }
        }
        catch(SQLException e){
            System.out.println("Error en la conexion a la BD:\n"+e);
                 
        }
        return conection;
    }        
}
