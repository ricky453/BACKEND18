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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "orden_trabajo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenTrabajo.findAll", query = "SELECT o FROM OrdenTrabajo o")
    , @NamedQuery(name = "OrdenTrabajo.findByIdOrdenTrabajo", query = "SELECT o FROM OrdenTrabajo o WHERE o.idOrdenTrabajo = :idOrdenTrabajo")
    , @NamedQuery(name = "OrdenTrabajo.findByFechaInicio", query = "SELECT o FROM OrdenTrabajo o WHERE o.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "OrdenTrabajo.findByPrioridad", query = "SELECT o FROM OrdenTrabajo o WHERE o.prioridad = :prioridad")})
public class OrdenTrabajo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_orden_trabajo")
    private Integer idOrdenTrabajo;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Size(max = 255)
    @Column(name = "prioridad")
    private String prioridad;
    @JoinColumn(name = "id_calendario", referencedColumnName = "id_calendario")
    @ManyToOne
    private Calendario idCalendario;
    @JoinColumn(name = "id_solicitud", referencedColumnName = "id_solicitud")
    @ManyToOne
    private Solicitud idSolicitud;
    @OneToMany(mappedBy = "idOrdenTrabajo")
    private Collection<DetalleMantenimiento> detalleMantenimientoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordenTrabajo")
    private Collection<OrdenTrabajoPorTrabajadores> ordenTrabajoPorTrabajadoresCollection;

    public OrdenTrabajo() {
    }

    public OrdenTrabajo(Integer idOrdenTrabajo) {
        this.idOrdenTrabajo = idOrdenTrabajo;
    }

    public Integer getIdOrdenTrabajo() {
        return idOrdenTrabajo;
    }

    public void setIdOrdenTrabajo(Integer idOrdenTrabajo) {
        this.idOrdenTrabajo = idOrdenTrabajo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public Calendario getIdCalendario() {
        return idCalendario;
    }

    public void setIdCalendario(Calendario idCalendario) {
        this.idCalendario = idCalendario;
    }

    public Solicitud getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(Solicitud idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    @XmlTransient
    public Collection<DetalleMantenimiento> getDetalleMantenimientoCollection() {
        return detalleMantenimientoCollection;
    }

    public void setDetalleMantenimientoCollection(Collection<DetalleMantenimiento> detalleMantenimientoCollection) {
        this.detalleMantenimientoCollection = detalleMantenimientoCollection;
    }

    @XmlTransient
    public Collection<OrdenTrabajoPorTrabajadores> getOrdenTrabajoPorTrabajadoresCollection() {
        return ordenTrabajoPorTrabajadoresCollection;
    }

    public void setOrdenTrabajoPorTrabajadoresCollection(Collection<OrdenTrabajoPorTrabajadores> ordenTrabajoPorTrabajadoresCollection) {
        this.ordenTrabajoPorTrabajadoresCollection = ordenTrabajoPorTrabajadoresCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrdenTrabajo != null ? idOrdenTrabajo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenTrabajo)) {
            return false;
        }
        OrdenTrabajo other = (OrdenTrabajo) object;
        if ((this.idOrdenTrabajo == null && other.idOrdenTrabajo != null) || (this.idOrdenTrabajo != null && !this.idOrdenTrabajo.equals(other.idOrdenTrabajo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.uesocc.ingenieria.tpi2018.entities.OrdenTrabajo[ idOrdenTrabajo=" + idOrdenTrabajo + " ]";
    }
    
}
