/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.micropakito.compartido.definiciones;

import java.io.Serializable;

/**
 *
 * @author PascuaS
 */
public class RegistroDev implements Serializable {
    private String mensaje;
    private String descripcion;
    private int resultado;

    public RegistroDev(String descripcion, String mensaje, int resultado) {

        this.descripcion = descripcion;
        this.mensaje = mensaje;
        this.resultado = resultado;

    }

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the resultado
     */
    public int getResultado() {
        return resultado;
    }

    /**
     * @param resultado the resultado to set
     */
    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

    

}
