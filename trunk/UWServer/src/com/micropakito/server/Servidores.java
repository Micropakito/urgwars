/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.micropakito.server;

import java.util.ArrayList;

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
