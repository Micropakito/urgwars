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
        Message msgDev = new Message();
        System.out.println("Va pasando va llegando");
        try {

            msgDev.setClase( Class.forName("com.micropakito.compartido.definiciones.RegistroDev" ));
            msgDev.setDesc("En Registro");
            msgDev.setID(10001);

            Registro reg = (Registro)obj;

            //validaciones
            //existe el usuario
            
            UsuariosJpaController usrjpa = new UsuariosJpaController();

            Usuarios usExi = (Usuarios) usrjpa.getEntityManager().createNamedQuery("Usuarios.findByNick").setParameter("nick", reg.getNick() );
            
            if ( usExi != null ) {
            
                msgDev.setObjeto( (Object) new com.micropakito.compartido.definiciones.RegistroDev("El Usuario Ya Exite", "El Usuario ya Existe", 2) );
                return msgDev;
            
            }

            //mail distinto
            if (! reg.getMail().equals( reg.getMail_rep() )){

                msgDev.setObjeto( (Object) new com.micropakito.compartido.definiciones.RegistroDev("Los Mails no coinciden", "Los Mails No coinciden", 3) );
                return msgDev;
            }
            //pass distinto
            if (! reg.getPass().equals( reg.getPass_rep() )){

                msgDev.setObjeto( (Object) new com.micropakito.compartido.definiciones.RegistroDev("Los Pass no coinciden", "Los Pass no coinciden", 4) );
                return msgDev;

            }

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

            msgDev.setID(10001);
            msgDev.setObjeto( (Object) new com.micropakito.compartido.definiciones.RegistroDev("Registro molon", "Porque mola mucho", 1)  );
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Registrar.class.getName()).log(Level.SEVERE, null, ex);
            msgDev.setObjeto( (Object) new com.micropakito.compartido.definiciones.RegistroDev("El Usuario Ya Exite", "El Usuario ya Existe", 2) );
        } catch (Exception exs) {

            System.out.println("Tacaaaaaaaa" + exs.getMessage() );

        }

        return msgDev;

     }

}
