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
public class Registro implements Serializable {
    private String nick;
    private String mail;
    private String mail_rep;
    private String nombre;
    private String apellidos;
    private String nacimiento;
    private String pass;
    private String pass_rep;

    /**
     * @return the nick
     */
    public String getNick() {
        return nick;
    }

    /**
     * @param nick the nick to set
     */
    public void setNick(String nick) {
        this.nick = nick;
    }

    /**
     * @return the mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param mail the mail to set
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * @return the mail_rep
     */
    public String getMail_rep() {
        return mail_rep;
    }

    /**
     * @param mail_rep the mail_rep to set
     */
    public void setMail_rep(String mail_rep) {
        this.mail_rep = mail_rep;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the nacimiento
     */
    public String getNacimiento() {
        return nacimiento;
    }

    /**
     * @param nacimiento the nacimiento to set
     */
    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * @return the pass_rep
     */
    public String getPass_rep() {
        return pass_rep;
    }

    /**
     * @param pass_rep the pass_rep to set
     */
    public void setPass_rep(String pass_rep) {
        this.pass_rep = pass_rep;
    }

}
