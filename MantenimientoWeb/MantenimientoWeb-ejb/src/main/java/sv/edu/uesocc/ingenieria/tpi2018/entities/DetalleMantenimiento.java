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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "detalle_mantenimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleMantenimiento.findAll", query = "SELECT d FROM DetalleMantenimiento d")
    , @NamedQuery(name = "DetalleMantenimiento.findByIdDetalleMantenimiento", query = "SELECT d FROM DetalleMantenimiento d WHERE d.idDetalleMantenimiento = :idDetalleMantenimiento")
    , @NamedQuery(name = "DetalleMantenimiento.findByDetalleHarware", query = "SELECT d FROM DetalleMantenimiento d WHERE d.detalleHarware = :detalleHarware")
    , @NamedQuery(name = "DetalleMantenimiento.findByDetalleSoftware", query = "SELECT d FROM DetalleMantenimiento d WHERE d.detalleSoftware = :detalleSoftware")
    , @NamedQuery(name = "DetalleMantenimiento.findBySoftware", query = "SELECT d FROM DetalleMantenimiento d WHERE d.software = :software")})
public class DetalleMantenimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_detalle_mantenimiento")
    private Integer idDetalleMantenimiento;
    @Size(max = 255)
    @Column(name = "detalle_harware")
    private String detalleHarware;
    @Size(max = 255)
    @Column(name = "detalle_software")
    private String detalleSoftware;
    @Size(max = 255)
    @Column(name = "software")
    private String software;
    @JoinColumn(name = "id_orden_trabajo", referencedColumnName = "id_orden_trabajo")
    @ManyToOne
    private OrdenTrabajo idOrdenTrabajo;
    @OneToMany(mappedBy = "idDetalleMantenimiento")
    private Collection<EstadoDetalleMantenimiento> estadoDetalleMantenimientoCollection;

    public DetalleMantenimiento() {
    }

    public DetalleMantenimiento(Integer idDetalleMantenimiento) {
        this.idDetalleMantenimiento = idDetalleMantenimiento;
    }

    public Integer getIdDetalleMantenimiento() {
        return idDetalleMantenimiento;
    }

    public void setIdDetalleMantenimiento(Integer idDetalleMantenimiento) {
        this.idDetalleMantenimiento = idDetalleMantenimiento;
    }

    public String getDetalleHarware() {
        return detalleHarware;
    }

    public void setDetalleHarware(String detalleHarware) {
        this.detalleHarware = detalleHarware;
    }

    public String getDetalleSoftware() {
        return detalleSoftware;
    }

    public void setDetalleSoftware(String detalleSoftware) {
        this.detalleSoftware = detalleSoftware;
    }

    public String getSoftware() {
        return software;
    }

    public void setSoftware(String software) {
        this.software = software;
    }

    public OrdenTrabajo getIdOrdenTrabajo() {
        return idOrdenTrabajo;
    }

    public void setIdOrdenTrabajo(OrdenTrabajo idOrdenTrabajo) {
        this.idOrdenTrabajo = idOrdenTrabajo;
    }

    @XmlTransient
    public Collection<EstadoDetalleMantenimiento> getEstadoDetalleMantenimientoCollection() {
        return estadoDetalleMantenimientoCollection;
    }

    public void setEstadoDetalleMantenimientoCollection(Collection<EstadoDetalleMantenimiento> estadoDetalleMantenimientoCollection) {
        this.estadoDetalleMantenimientoCollection = estadoDetalleMantenimientoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleMantenimiento != null ? idDetalleMantenimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof DetalleMantenimiento)) {
            return false;
        }
        DetalleMantenimiento other = (DetalleMantenimiento) object;
        if ((this.idDetalleMantenimiento == null && other.idDetalleMantenimiento != null) || (this.idDetalleMantenimiento != null && !this.idDetalleMantenimiento.equals(other.idDetalleMantenimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.uesocc.ingenieria.tpi2018.entities.DetalleMantenimiento[ idDetalleMantenimiento=" + idDetalleMantenimiento + " ]";
    }
    
}
