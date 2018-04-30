/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.entities;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ricky
 */
@Entity
@Table(name = "estado_detalle_mantenimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoDetalleMantenimiento.findAll", query = "SELECT e FROM EstadoDetalleMantenimiento e")
    , @NamedQuery(name = "EstadoDetalleMantenimiento.findByIdEstadoDetalleMantenimiento", query = "SELECT e FROM EstadoDetalleMantenimiento e WHERE e.idEstadoDetalleMantenimiento = :idEstadoDetalleMantenimiento")
    , @NamedQuery(name = "EstadoDetalleMantenimiento.findByEstado", query = "SELECT e FROM EstadoDetalleMantenimiento e WHERE e.estado = :estado")
    , @NamedQuery(name = "EstadoDetalleMantenimiento.findByObservaciones", query = "SELECT e FROM EstadoDetalleMantenimiento e WHERE e.observaciones = :observaciones")})
public class EstadoDetalleMantenimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_estado_detalle_mantenimiento")
    private Integer idEstadoDetalleMantenimiento;
    @Size(max = 255)
    @Column(name = "estado")
    private String estado;
    @Size(max = 255)
    @Column(name = "observaciones")
    private String observaciones;
    @JoinColumn(name = "id_detalle_mantenimiento", referencedColumnName = "id_detalle_mantenimiento")
    @ManyToOne
    private DetalleMantenimiento idDetalleMantenimiento;
    @JoinColumn(name = "id_procedimiento", referencedColumnName = "id_procedimiento")
    @ManyToOne
    private Procedimiento idProcedimiento;

    public EstadoDetalleMantenimiento() {
    }

    public EstadoDetalleMantenimiento(Integer idEstadoDetalleMantenimiento) {
        this.idEstadoDetalleMantenimiento = idEstadoDetalleMantenimiento;
    }

    public Integer getIdEstadoDetalleMantenimiento() {
        return idEstadoDetalleMantenimiento;
    }

    public void setIdEstadoDetalleMantenimiento(Integer idEstadoDetalleMantenimiento) {
        this.idEstadoDetalleMantenimiento = idEstadoDetalleMantenimiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public DetalleMantenimiento getIdDetalleMantenimiento() {
        return idDetalleMantenimiento;
    }

    public void setIdDetalleMantenimiento(DetalleMantenimiento idDetalleMantenimiento) {
        this.idDetalleMantenimiento = idDetalleMantenimiento;
    }

    public Procedimiento getIdProcedimiento() {
        return idProcedimiento;
    }

    public void setIdProcedimiento(Procedimiento idProcedimiento) {
        this.idProcedimiento = idProcedimiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoDetalleMantenimiento != null ? idEstadoDetalleMantenimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoDetalleMantenimiento)) {
            return false;
        }
        EstadoDetalleMantenimiento other = (EstadoDetalleMantenimiento) object;
        if ((this.idEstadoDetalleMantenimiento == null && other.idEstadoDetalleMantenimiento != null) || (this.idEstadoDetalleMantenimiento != null && !this.idEstadoDetalleMantenimiento.equals(other.idEstadoDetalleMantenimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.uesocc.ingenieria.tpi2018.entities.EstadoDetalleMantenimiento[ idEstadoDetalleMantenimiento=" + idEstadoDetalleMantenimiento + " ]";
    }
    
}
