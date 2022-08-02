/*
 * DAO
 * es la que se encarga de obtener datos desde la base de datos
   y llenar la clase Value Object y enviarla al cliente, 
   o a su vez recibir la clase desde el cliente
   y enviar los datos al servidor, por lo general 
   tiene todos los métodos CRUD (create, read, update y delete).
 */
package com.platzi.mensajes_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author j3r4ck
 */
public class MensajeDAO {
    public static void crearMensajeBD(Mensaje mensaje){
        //El objeto que nos permite la conexion
        ConexionDB conexion = new ConexionDB();
        //Intetan hacer la conexion, en los argumentos del try
        try ( Connection cnx = conexion.getConnection()) {    
            //Creacion de prepared statement que sirvira para hacer la inserccion a la BD
            PreparedStatement  ps=null;
            try{
                //Sentencia de inserccion ala base de datos, el ID y el TimeStamp lo agrega automaticamente MySQL
                String query="INSERT INTO mensajes ( mensaje, autor_mensaje) VALUES (?,?)";
                
                ps=cnx.prepareStatement(query);
                //Valores  presentes en la sentencia, el primer argumento indica el numero del argumento de la sentencia, el segundo argumento indica el valor
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutorMensaje());
                //Ejecucion de la sentencia
                ps.executeUpdate();
                System.out.println("mensaje creado");
            }catch(Exception e){
                System.out.println("No se puedo insertar el mensaje: "+e);
            }
        } catch (Exception ex) {
            System.out.println("No se obtuvo una conexion a la base de datos\n" + ex);
        }        
    }
    
    public static void leerMensajesBD(){
        ConexionDB db_connect = new ConexionDB();
        
        PreparedStatement ps=null;
        //El resultSet es el resultado de la seleccion nos proporsiona una forma de extraer los elementos del mismo
        ResultSet rs=null;
        
        try(Connection conexion = db_connect.getConnection())  {       
            //creacion del select y obtencion del resultset
            String query="SELECT * FROM mensajes";
            ps=conexion.prepareStatement(query);
            rs=ps.executeQuery();
            
            //Recorrer el ResultSet mientras tenga datos
            while(rs.next()){
                //Del ResultSet se obtienen lo datos de la colimnas y tipo de dato
                //En la tabla un ID se declaro como int, entonces por eso se obtine un int, cuyo nombre de columna es "id_mensaje"
                System.out.println("ID: "+rs.getInt("id_mensaje"));
                System.out.println("Mensaje: "+rs.getString("mensaje"));
                System.out.println("Autor: "+rs.getString("autor_mensaje"));
                System.out.println("Fecha: "+rs.getString("fecha_mensaje"));
                System.out.println("");
            }
        }catch(Exception e){
            System.out.println("No se pudieron recuperar los mensajes:\n"+e);
        }       
        
    }
    
    public static void borrarMensajeBD(){
        
    }
    
    public static void actualizarMensajeBD(Mensaje mensaje){
        
    }
    
}
