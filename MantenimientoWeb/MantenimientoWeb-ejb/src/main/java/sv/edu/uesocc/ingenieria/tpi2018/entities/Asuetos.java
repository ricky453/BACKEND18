/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ricky
 */
@Entity
@Table(name = "asuetos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asuetos.findAll", query = "SELECT a FROM Asuetos a")
    , @NamedQuery(name = "Asuetos.findByIdAsueto", query = "SELECT a FROM Asuetos a WHERE a.idAsueto = :idAsueto")
    , @NamedQuery(name = "Asuetos.findByDescripcion", query = "SELECT a FROM Asuetos a WHERE a.descripcion = :descripcion")
    , @NamedQuery(name = "Asuetos.findByFecha", query = "SELECT a FROM Asuetos a WHERE a.fecha = :fecha")})
public class Asuetos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_asueto")
    private Integer idAsueto;
    @Size(max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @OneToMany(mappedBy = "idAsuetos")
    private Collection<Calendario> calendarioCollection;

    public Asuetos() {
    }

    public Asuetos(Integer idAsueto) {
        this.idAsueto = idAsueto;
    }

    public Integer getIdAsueto() {
        return idAsueto;
    }

    public void setIdAsueto(Integer idAsueto) {
        this.idAsueto = idAsueto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @XmlTransient
    public Collection<Calendario> getCalendarioCollection() {
        return calendarioCollection;
    }

    public void setCalendarioCollection(Collection<Calendario> calendarioCollection) {
        this.calendarioCollection = calendarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAsueto != null ? idAsueto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Asuetos)) {
            return false;
        }
        Asuetos other = (Asuetos) object;
        if ((this.idAsueto == null && other.idAsueto != null) || (this.idAsueto != null && !this.idAsueto.equals(other.idAsueto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.uesocc.ingenieria.tpi2018.entities.Asuetos[ idAsueto=" + idAsueto + " ]";
    }
    
}
