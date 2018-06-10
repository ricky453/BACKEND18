/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.entities;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ricky
 */
@Entity
@Table(name = "tipo_mantenimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoMantenimiento.findAll", query = "SELECT t FROM TipoMantenimiento t")
    , @NamedQuery(name = "TipoMantenimiento.findByName", query = "SELECT m FROM TipoMantenimiento m WHERE LOWER(m.tipoMantenimiento) LIKE CONCAT('%',LOWER(:name),'%')")        
    , @NamedQuery(name = "TipoMantenimiento.findByIdTipoMantenimiento", query = "SELECT t FROM TipoMantenimiento t WHERE t.idTipoMantenimiento = :idTipoMantenimiento")
    , @NamedQuery(name = "TipoMantenimiento.findByObservaciones", query = "SELECT t FROM TipoMantenimiento t WHERE t.observaciones = :observaciones")
    , @NamedQuery(name = "TipoMantenimiento.findByTipoMantenimiento", query = "SELECT t FROM TipoMantenimiento t WHERE t.tipoMantenimiento = :tipoMantenimiento")})
public class TipoMantenimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_mantenimiento")
    private Integer idTipoMantenimiento;
    @Size(max = 255)
    @Column(name = "observaciones")
    private String observaciones;
    @Size(max = 255)
    @Column(name = "tipo_mantenimiento")
    private String tipoMantenimiento;
    @OneToMany(mappedBy = "idTipoMantenimiento")
    private Collection<Solicitud> solicitudCollection;

    public TipoMantenimiento() {
    }

    public TipoMantenimiento(Integer idTipoMantenimiento) {
        this.idTipoMantenimiento = idTipoMantenimiento;
    }
    
    public TipoMantenimiento(Integer idTipoMantenimiento, String tipoMantenimiento) {
        this.idTipoMantenimiento = idTipoMantenimiento;
        this.tipoMantenimiento = tipoMantenimiento;
    }

    public Integer getIdTipoMantenimiento() {
        return idTipoMantenimiento;
    }

    public void setIdTipoMantenimiento(Integer idTipoMantenimiento) {
        this.idTipoMantenimiento = idTipoMantenimiento;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getTipoMantenimiento() {
        return tipoMantenimiento;
    }

    public void setTipoMantenimiento(String tipoMantenimiento) {
        this.tipoMantenimiento = tipoMantenimiento;
    }

    @XmlTransient
    public Collection<Solicitud> getSolicitudCollection() {
        return solicitudCollection;
    }

    public void setSolicitudCollection(Collection<Solicitud> solicitudCollection) {
        this.solicitudCollection = solicitudCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoMantenimiento != null ? idTipoMantenimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof TipoMantenimiento)) {
            return false;
        }
        TipoMantenimiento other = (TipoMantenimiento) object;
        if ((this.idTipoMantenimiento == null && other.idTipoMantenimiento != null) || (this.idTipoMantenimiento != null && !this.idTipoMantenimiento.equals(other.idTipoMantenimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.uesocc.ingenieria.tpi2018.entities.TipoMantenimiento[ idTipoMantenimiento=" + idTipoMantenimiento + " ]";
    }
    
}
