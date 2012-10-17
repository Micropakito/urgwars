/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.micropakito.compartido.definiciones;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author e-spascual
 */
public class ServerList implements Serializable {
    private String[] servidores ;

    /**
     * @return the servidores
     */
    public ServerList(){}
    
    public String[] getServidores() {
        return servidores;
    }

    /**
     * @param servidores the servidores to set
     */
    public void setServidores(String[] servidores) {
        this.servidores = servidores;
    }
}
