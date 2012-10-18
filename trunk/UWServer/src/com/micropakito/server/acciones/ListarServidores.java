/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.micropakito.server.acciones;

import com.micropakito.compartido.Message;
import com.micropakito.compartido.definiciones.ServerList;
import com.micropakito.compartido.definiciones.UserLogin;
import com.micropakito.server.ServerHilo;
import com.micropakito.server.clientes.Cliente;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author e-spascual
 */
public class ListarServidores {
    
    public Message arranca( Integer id,  String idClase, Class clase, Object obj, ServerHilo serverContext) {
        try {
            System.out.println("llegando que es gerundio");
            ServerList sl = new ServerList();

            ArrayList servidores = (ArrayList)serverContext.getServidoresArrayList();

            Iterator it = servidores.iterator();
            String servidoresStr[] = new String [servidores.size()];
            int cont = 0;
            while (it.hasNext()){
                ServerHilo sl2 = (ServerHilo) it.next();
                servidoresStr[cont] = sl2.getNombre();
                cont++;
            }
            sl.setServidores(servidoresStr);

            Message m = new Message(1000, "De vuelta logando", Class.forName("com.micropakito.compartido.definiciones.ServerList"), (Object)sl);
            return m;
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
