/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.micropakito.persist.entity.roles;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author PascuaS
 */
@Entity
@Table(name = "roles")
@NamedQueries({
    @NamedQuery(name = "Roles.findAll", query = "SELECT r FROM Roles r"),
    @NamedQuery(name = "Roles.findByIdRoles", query = "SELECT r FROM Roles r WHERE r.idRoles = :idRoles"),
    @NamedQuery(name = "Roles.findByTexto", query = "SELECT r FROM Roles r WHERE r.texto = :texto"),
    @NamedQuery(name = "Roles.findByTextoLargo", query = "SELECT r FROM Roles r WHERE r.textoLargo = :textoLargo")})
public class Roles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idRoles")
    private Integer idRoles;
    @Column(name = "texto")
    private String texto;
    @Column(name = "texto_largo")
    private String textoLargo;

    public Roles() {
    }

    public Roles(Integer idRoles) {
        this.idRoles = idRoles;
    }

    public Integer getIdRoles() {
        return idRoles;
    }

    public void setIdRoles(Integer idRoles) {
        this.idRoles = idRoles;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getTextoLargo() {
        return textoLargo;
    }

    public void setTextoLargo(String textoLargo) {
        this.textoLargo = textoLargo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRoles != null ? idRoles.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roles)) {
            return false;
        }
        Roles other = (Roles) object;
        if ((this.idRoles == null && other.idRoles != null) || (this.idRoles != null && !this.idRoles.equals(other.idRoles))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.micropakito.persist.entity.roles.Roles[idRoles=" + idRoles + "]";
    }

}
