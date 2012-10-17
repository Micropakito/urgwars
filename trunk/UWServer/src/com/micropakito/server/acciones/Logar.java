/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.micropakito.server.acciones;

import com.micropakito.compartido.Message;
import com.micropakito.compartido.definiciones.UserLogin;
import com.micropakito.server.ServerHilo;
import com.micropakito.server.clientes.Cliente;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Micropakito
 */
public class Logar {


    public Message arranca( Integer id,  String idClase, Class clase, Object obj, ServerHilo serverContext) {

        UserLogin ul = (UserLogin) obj;
        
        System.out.println("Arrancando el método que yo quiero") ;
        System.out.println("Con el siguiente id" + idClase) ;
        System.out.println("Login que hace" + ul.getLogin()) ;

        //Añadir al usuario por nombre de servidor.
        
        //public ServerHilo getServerByName(String name){
        ServerHilo sh = (ServerHilo)serverContext.getServidores().getServerByName(ul.getServer());
        System.out.println("El serverHilo es:" + sh.getNombre() ) ;

//        try {
//            
//            sh.getClientes().get( ul.getLogin() );
//            
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage()) ;
            //si no está logado en ese servidor, meto cliente nuevo.
            Cliente  c = new Cliente();
            System.out.println("1") ;
            c.setNick( ul.getLogin() );
            System.out.println("2") ;
            sh.getClientes().put(c.getNick(), c );
            System.out.println("3") ;
//        }   
        
        Message m = new Message( 100, "Ha logado bien" );
        System.out.println("4") ;
        return m;
////////        UserLogin uld = new UserLogin();
////////        uld.setLogin("aaabbb");
////////        uld.setPass("cccddd");
////////        try {
////////            Message m2 = new Message(100, "De vuelta logando", Class.forName("com.micropakito.compartido.definiciones.UserLogin"), (Object)uld);
////////            return m2;
////////        }catch (Exception ex){  return null;    }
        
        
        //Trato de acceder al cliente (por si ya está logado)

//        try {
//
//            Cliente  c = (Cliente)((HashMap)serverContext.getClientes()).get(0) ;
//            System.out.println("Y el nick esssssss:" + c.getNick() );
//            
//        } catch (Exception e) {
//
//            System.out.println("No existe el cliente en esa posición");
//        }
//
//        //System.out.println("Accedo hasta el principal..." + serverContext.getServidor().getPpal().getTxtInfo().getText() ) ;
//
//        ArrayList al = (ArrayList)serverContext.getServidores().getServidores();
//
//        Iterator it = al.iterator();
//        Cliente c = new Cliente();
//        c.setId(10);
//        c.setNick("micropakito");
//
//        while (it.hasNext()) {
//            ServerHilo srv = (ServerHilo)it.next();
//            System.out.println("Usuarios en server: " + srv.getNombre() );
//            srv.getClientes().put(c.getNick(), c);
//        }
//        try {
//
//            UserLogin uld = new UserLogin();
//            uld.setLogin("aaabbb");
//            uld.setPass("cccddd");
//
//
//            Message m = new Message(100, "De vuelta logando", Class.forName("com.micropakito.compartido.definiciones.UserLogin"), (Object)uld);
//            
//            return m;
//            
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Logar.class.getName()).log(Level.SEVERE, null, ex);
//            return null;
//        }

    }

}
