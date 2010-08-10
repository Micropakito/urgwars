/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.micropakito.server.acciones;

import com.micropakito.compartido.Message;
import com.micropakito.compartido.definiciones.Registro;
import com.micropakito.persist.entity.usuarios.Usuarios;
import com.micropakito.persist.entity.usuarios.UsuariosJpaController;
import com.micropakito.server.ServerHilo;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PascuaS
 */
public class Registrar {


     public Message arranca( Integer id,  String idClase, Class clase, Object obj, ServerHilo serverContext) {

        //recibe compartida.Registrar

        Registro reg = (Registro)obj;

        //validaciones

        //existe el usuario

        //mail distinto

        //pass distinto

        // alta en bdd

        Usuarios us = new Usuarios();
        us.setNick(reg.getNick());
        us.setNombre(reg.getNombre());
        us.setPass(reg.getPass());
        us.setApellidos(reg.getApellidos());
        us.setMail(reg.getMail());
        us.setRol(0);

        UsuariosJpaController usjpa = new UsuariosJpaController();

        usjpa.create(us);


        Message msg = new Message();
        try {
            msg.setClase(Class.forName("com.micropakito.compartido.definiciones.RegistroDev"));
            msg.setDesc("Registrado OK");
            msg.setID(10001);
            msg.setObjeto( (Object) new com.micropakito.compartido.definiciones.RegistroDev("Registro molon", "Porque mola mucho", 1)  );
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Registrar.class.getName()).log(Level.SEVERE, null, ex);
        }

        return msg;

     }

}
