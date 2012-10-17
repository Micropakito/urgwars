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


        //Trato de acceder al cliente (por si ya está logado)

        try {

            Cliente  c = (Cliente)((ArrayList)serverContext.getClientes()).get(0) ;
            System.out.println("Y el nick esssssss:" + c.getNick() );
            
        } catch (Exception e) {

            System.out.println("No existe el cliente en esa posición");
        }

        //System.out.println("Accedo hasta el principal..." + serverContext.getServidor().getPpal().getTxtInfo().getText() ) ;

        ArrayList al = (ArrayList)serverContext.getServidores().getServidores();

        Iterator it = al.iterator();
        Cliente c = new Cliente();
        c.setId(10);
        c.setNick("micropakito");

        while (it.hasNext()) {
            ServerHilo srv = (ServerHilo)it.next();
            System.out.println("Usuarios en server: " + srv.getNombre() );
            srv.getClientes().add(0, c);
        }
        try {

            UserLogin uld = new UserLogin();
            uld.setLogin("aaabbb");
            uld.setPass("cccddd");


            Message m = new Message(100, "De vuelta logando", Class.forName("com.micropakito.compartido.definiciones.UserLogin"), (Object)uld);
            
            return m;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Logar.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

        
        

    }

}
