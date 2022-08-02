/*
 * Esta clase sirve para obtener los datos necesarios para crear el crud
posterior mente mandarlos a la capa DAO quien termina de hacer el crud 
y hacer la conexion a la BD
 */
package com.platzi.mensajes_app;

import java.util.Scanner;

/**
 * @author j3r4ck
 */
public class MensajeServicio {
    public static void crearMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu mensaje");
        String mensaje = sc.nextLine();
        
        System.out.println("Escribe tu nombre");
        String nombre = sc.nextLine();
        
        Mensaje registro = new Mensaje();
        registro.setMensaje(mensaje);
        registro.setAutorMensaje(nombre);
        MensajeDAO.crearMensajeBD(registro);        
        
    }
    
    public static void listarMensaje(){
        MensajeDAO.leerMensajesBD();        
    }
    
    public static void borrarMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el id del mensaje");
        String id = sc.nextLine();
        
        MensajeDAO.borrarMensajeBD(Integer.parseInt(id));  
    }
    
    public static void editarMensaje(){
        
    }
        
}
