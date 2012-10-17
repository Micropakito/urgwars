/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.micropakito.server.paquete;

import com.micropakito.compartido.Message;
import com.micropakito.server.ServerHilo;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

import com.micropakito.server.utilidades.LeeXML;

/**
 *
 * @author Administrador
 */
public class Paquete {

    private Class clase;
    private Object obj;
    private String idClase;
    private int id;
    private ServerHilo srv;

    private Message msg ;

    public Paquete(  int id, String idClase, Class clase, Object obj, ServerHilo srv  ) {

        Class[] clasesParamSetEmail;
        Object[] paramSetEmail;


        this.clase = clase;
        this.obj = obj;
        this.idClase = idClase;
        this.id = id;
        this.srv = srv;
        //ejectuto el método main de la clase
        //busco el id en el fichero properties
        Properties prop = new Properties();
        InputStream is = null;
        try {

         //leo la accion que será ejecutada
         LeeXML lxml = new LeeXML("build/classes/com/micropakito/server/config/parseo.xml");
         
         Class claseEjecuta = Class.forName( lxml.getClass(Integer.toString(id) ));

          //Ejecuto el metodo arranca que será el que haga cosas
          //preparo el método con los parametros que necesita
          clasesParamSetEmail = new Class[5];
          clasesParamSetEmail[0] = Class.forName("java.lang.Integer");
          clasesParamSetEmail[1] = Class.forName("java.lang.String");
          clasesParamSetEmail[2] = Class.forName("java.lang.Class");
          clasesParamSetEmail[3] = Class.forName("java.lang.Object");
          clasesParamSetEmail[4] = Class.forName("com.micropakito.server.ServerHilo");
          
          
          //le paso los parámetros en sí
          Method meth = claseEjecuta.getMethod("arranca",clasesParamSetEmail );
          paramSetEmail = new Object[5];
          paramSetEmail[0] = new Integer(id);
          paramSetEmail[1] = idClase;
          paramSetEmail[2] = clase;
          paramSetEmail[3] = obj ;
          paramSetEmail[4] = this.getSrv() ;
          
          Object ob = claseEjecuta.newInstance();
          Message m = (Message) meth.invoke(ob, paramSetEmail);
          this.setMsg(m);

          //TODO
          //cuando se invoke el método debe devolver un mensaje, que será
          //La respuesta al cliente.
          //Como el findfordward de las acciones de Java
          

          //http://www.javahispano.org/contenidos/es/introduccrion_al_api_reflection_reflexrion_de_ja/


        } catch(Exception e) {
            System.out.println("Error en Paquete: " + e.getMessage());
        }
        
    }
    public Paquete() {}
    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public String getIdClase() {
        return idClase;
    }

    public void setIdClase(String idClase) {
        this.idClase = idClase;
    }

    /**
     * @return the clase
     */
    public Class getClase() {
        return clase;
    }

    /**
     * @param clase the clase to set
     */
    public void setClase(Class clase) {
        this.clase = clase;
    }

    /**
     * @return the srv
     */
    public ServerHilo getSrv() {
        return srv;
    }

    /**
     * @param srv the srv to set
     */
    public void setSrv(ServerHilo srv) {
        this.srv = srv;
    }

    /**
     * @return the msg
     */
    public Message getMsg() {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(Message msg) {
        this.msg = msg;
    }
    
}
