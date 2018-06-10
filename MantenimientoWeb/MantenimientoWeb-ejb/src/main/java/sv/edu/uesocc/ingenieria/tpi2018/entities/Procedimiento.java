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
@Table(name = "procedimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Procedimiento.findAll", query = "SELECT p FROM Procedimiento p")
    , @NamedQuery(name = "Procedimiento.findByName", query = "SELECT m FROM Procedimiento m WHERE LOWER(m.procedimiento) LIKE CONCAT('%',LOWER(:name),'%')")        
    , @NamedQuery(name = "Procedimiento.findByIdProcedimiento", query = "SELECT p FROM Procedimiento p WHERE p.idProcedimiento = :idProcedimiento")
    , @NamedQuery(name = "Procedimiento.findByProcedimiento", query = "SELECT p FROM Procedimiento p WHERE p.procedimiento = :procedimiento")})
public class Procedimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_procedimiento")
    private Integer idProcedimiento;
    @Size(max = 255)
    @Column(name = "procedimiento")
    private String procedimiento;
    @JoinColumn(name = "id_pasos", referencedColumnName = "id_paso")
    @ManyToOne
    private Pasos idPasos;
    @OneToMany(mappedBy = "idProcedimiento")
    private Collection<Diagnostico> diagnosticoCollection;
    @OneToMany(mappedBy = "idProcedimiento")
    private Collection<EstadoDetalleMantenimiento> estadoDetalleMantenimientoCollection;

    public Procedimiento() {
    }

    public Procedimiento(Integer idProcedimiento) {
        this.idProcedimiento = idProcedimiento;
    }
    
    public Procedimiento(Integer idProcedimiento, String procedimiento) {
        this.idProcedimiento = idProcedimiento;
        this.procedimiento = procedimiento;
    }

    public Integer getIdProcedimiento() {
        return idProcedimiento;
    }

    public void setIdProcedimiento(Integer idProcedimiento) {
        this.idProcedimiento = idProcedimiento;
    }

    public String getProcedimiento() {
        return procedimiento;
    }

    public void setProcedimiento(String procedimiento) {
        this.procedimiento = procedimiento;
    }

    public Pasos getIdPasos() {
        return idPasos;
    }

    public void setIdPasos(Pasos idPasos) {
        this.idPasos = idPasos;
    }

    @XmlTransient
    public Collection<Diagnostico> getDiagnosticoCollection() {
        return diagnosticoCollection;
    }

    public void setDiagnosticoCollection(Collection<Diagnostico> diagnosticoCollection) {
        this.diagnosticoCollection = diagnosticoCollection;
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
        hash += (idProcedimiento != null ? idProcedimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Procedimiento)) {
            return false;
        }
        Procedimiento other = (Procedimiento) object;
        if ((this.idProcedimiento == null && other.idProcedimiento != null) || (this.idProcedimiento != null && !this.idProcedimiento.equals(other.idProcedimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.uesocc.ingenieria.tpi2018.entities.Procedimiento[ idProcedimiento=" + idProcedimiento + " ]";
    }
    
}
