/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.micropakito.persist.entity.usuariossesion;

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
@Table(name = "usuariosesion")
@NamedQueries({
    @NamedQuery(name = "Usuariosesion.findAll", query = "SELECT u FROM Usuariosesion u"),
    @NamedQuery(name = "Usuariosesion.findByIdUsuarioSesion", query = "SELECT u FROM Usuariosesion u WHERE u.idUsuarioSesion = :idUsuarioSesion"),
    @NamedQuery(name = "Usuariosesion.findByIdUsuario", query = "SELECT u FROM Usuariosesion u WHERE u.idUsuario = :idUsuario"),
    @NamedQuery(name = "Usuariosesion.findByHash", query = "SELECT u FROM Usuariosesion u WHERE u.hash = :hash")})
public class Usuariosesion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idUsuarioSesion")
    private Integer idUsuarioSesion;
    @Column(name = "idUsuario")
    private Integer idUsuario;
    @Column(name = "hash")
    private String hash;

    public Usuariosesion() {
    }

    public Usuariosesion(Integer idUsuarioSesion) {
        this.idUsuarioSesion = idUsuarioSesion;
    }

    public Integer getIdUsuarioSesion() {
        return idUsuarioSesion;
    }

    public void setIdUsuarioSesion(Integer idUsuarioSesion) {
        this.idUsuarioSesion = idUsuarioSesion;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuarioSesion != null ? idUsuarioSesion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuariosesion)) {
            return false;
        }
        Usuariosesion other = (Usuariosesion) object;
        if ((this.idUsuarioSesion == null && other.idUsuarioSesion != null) || (this.idUsuarioSesion != null && !this.idUsuarioSesion.equals(other.idUsuarioSesion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.micropakito.persist.entity.usuariossesion.Usuariosesion[idUsuarioSesion=" + idUsuarioSesion + "]";
    }

}
