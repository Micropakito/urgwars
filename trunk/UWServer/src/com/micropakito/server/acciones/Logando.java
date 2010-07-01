/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.micropakito.server.acciones;

import com.micropakito.compartido.definiciones.UserLogin;
import com.micropakito.server.paquete.IPaquete;

/**
 *
 * @author Administrador
 */
public class Logando implements com.micropakito.server.paquete.IPaquete  {
    
    UserLogin usl;
    Object obj;
    String id;
    public Logando ( Object objeto, String idClase ) {
        super();
        this.obj = objeto;
        this.id = idClase;
        this.usl = (UserLogin) objeto;
    }
    public Logando() {
        super();
    }
    public void arranca(){
        

    }

}
