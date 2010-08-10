/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.micropakito.persist.entity.noticias;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author PascuaS
 */
@Entity
@Table(name = "noticias")
@NamedQueries({
    @NamedQuery(name = "Noticias.findAll", query = "SELECT n FROM Noticias n"),
    @NamedQuery(name = "Noticias.findByIdNoticias", query = "SELECT n FROM Noticias n WHERE n.idNoticias = :idNoticias"),
    @NamedQuery(name = "Noticias.findByAutor", query = "SELECT n FROM Noticias n WHERE n.autor = :autor"),
    @NamedQuery(name = "Noticias.findByTexto", query = "SELECT n FROM Noticias n WHERE n.texto = :texto"),
    @NamedQuery(name = "Noticias.findByFecha", query = "SELECT n FROM Noticias n WHERE n.fecha = :fecha")})
public class Noticias implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idNoticias")
    private Integer idNoticias;
    @Column(name = "autor")
    private Integer autor;
    @Column(name = "texto")
    private String texto;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    public Noticias() {
    }

    public Noticias(Integer idNoticias) {
        this.idNoticias = idNoticias;
    }

    public Integer getIdNoticias() {
        return idNoticias;
    }

    public void setIdNoticias(Integer idNoticias) {
        this.idNoticias = idNoticias;
    }

    public Integer getAutor() {
        return autor;
    }

    public void setAutor(Integer autor) {
        this.autor = autor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNoticias != null ? idNoticias.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Noticias)) {
            return false;
        }
        Noticias other = (Noticias) object;
        if ((this.idNoticias == null && other.idNoticias != null) || (this.idNoticias != null && !this.idNoticias.equals(other.idNoticias))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.micropakito.persist.entity.noticias.Noticias[idNoticias=" + idNoticias + "]";
    }

}
