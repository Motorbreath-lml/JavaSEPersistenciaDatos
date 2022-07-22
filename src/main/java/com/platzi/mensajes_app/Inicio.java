package com.platzi.mensajes_app;

import java.sql.Connection;
import java.util.Scanner;

/**
 * @author j3r4ck
 */
public class Inicio {

    public static void main(String[] args) {
        //Menu principal para los objetos
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("-----------------");
            System.out.println(" Aplicacion de mensajes");
            System.out.println(" 1. crear mensaje");
            System.out.println(" 2. listar mensajes");
            System.out.println(" 3. editar mensaje");
            System.out.println(" 4. eliminar mensaje");
            System.out.println(" 5. salir");
            //leemos la opcion del usuario
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    MensajeServicio.crearMensaje();
                    break;
                case 2:
                    MensajeServicio.listarMensaje();
                    break;
                case 3:
                    MensajeServicio.borrarMensaje();
                    break;
                case 4:
                    MensajeServicio.editarMensaje();
                    break;
                default:
                    break;
            }

        } while (opcion != 5);
        
        
        /*La conexion a la BD ya no va en esta clase*/
        //El objeto que nos permite la conexion
        ConexionDB conexion = new ConexionDB();
        //Intetan hacer la conexion
        try ( Connection cnx = conexion.getConnection()) {
            //Este bloque esta vacio por que la llamade del metodo ya esta en los argumentos del try            
        } catch (Exception ex) {
            System.out.println("No se obtuvo una conexion a la base de datos\n" + ex);
        }
    }
}
