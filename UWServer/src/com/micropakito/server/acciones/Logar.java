/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.micropakito.server.acciones;

import com.micropakito.compartido.definiciones.UserLogin;
import com.micropakito.server.ServerHilo;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Micropakito
 */
public class Logar {


    public void arranca( Integer id,  String idClase, Class clase, Object obj, ServerHilo serverContext) {

        UserLogin ul = (UserLogin) obj;
        
        System.out.println("Arrancando el método que yo quiero") ;
        System.out.println("Con el siguiente id" + idClase) ;
        System.out.println("Login que hace" + ul.getLogin()) ;

        //System.out.println("Accedo hasta el principal..." + serverContext.getServidor().getPpal().getTxtInfo().getText() ) ;

        ArrayList al = (ArrayList)serverContext.getServidores();

        Iterator it = al.iterator();

        while (it.hasNext()) {
            ServerHilo srv = (ServerHilo)it.next();
            System.out.println("Usuarios en server: " + srv.getNombre() );

        }

    }

}
