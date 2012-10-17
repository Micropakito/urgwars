/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.micropakito.server;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Micropakito
 */
public class Servidores {

    private ArrayList servidores ;
    
    public Servidores(){
        this.servidores = new ArrayList();
    }

    /**
     * @return the servidores
     */
    public ArrayList getServidores() {
        return servidores;
    }
    public ServerHilo getServerByName(String name){
     
        Iterator it = this.servidores.iterator();
        
        while (it.hasNext()){
            ServerHilo sh = (ServerHilo)it.next();
            
            if ( sh.getNombre().equalsIgnoreCase(name) ){
                return sh;
            }
        }
       return null; 
    
    }
    /**
     * @param servidores the servidores to set
     */
    public void setServidores(ArrayList servidores) {
        this.servidores = servidores;
    }
    public void addServer(int id, ServerHilo server){

        this.getServidores().add(id, server);

    }



}
