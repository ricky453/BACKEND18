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
@Table(name = "detalle_equipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleEquipo.findAll", query = "SELECT d FROM DetalleEquipo d")
    , @NamedQuery(name = "DetalleEquipo.findByIdDetalleEquipo", query = "SELECT d FROM DetalleEquipo d WHERE d.idDetalleEquipo = :idDetalleEquipo")
    , @NamedQuery(name = "DetalleEquipo.findByDescripcion", query = "SELECT d FROM DetalleEquipo d WHERE d.descripcion = :descripcion")
    , @NamedQuery(name = "DetalleEquipo.findByDispositivo", query = "SELECT d FROM DetalleEquipo d WHERE d.dispositivo = :dispositivo")})
public class DetalleEquipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_detalle_equipo")
    private Integer idDetalleEquipo;
    @Size(max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 255)
    @Column(name = "dispositivo")
    private String dispositivo;
    @JoinColumn(name = "id_equipo", referencedColumnName = "id_equipo")
    @ManyToOne
    private Equipo idEquipo;
    @JoinColumn(name = "id_marca", referencedColumnName = "id_marca")
    @ManyToOne
    private Marca idMarca;
    @JoinColumn(name = "id_modelo", referencedColumnName = "id_modelo")
    @ManyToOne
    private Modelo idModelo;

    public DetalleEquipo() {
    }

    public DetalleEquipo(Integer idDetalleEquipo) {
        this.idDetalleEquipo = idDetalleEquipo;
    }

    public Integer getIdDetalleEquipo() {
        return idDetalleEquipo;
    }

    public void setIdDetalleEquipo(Integer idDetalleEquipo) {
        this.idDetalleEquipo = idDetalleEquipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(String dispositivo) {
        this.dispositivo = dispositivo;
    }

    public Equipo getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Equipo idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Marca getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Marca idMarca) {
        this.idMarca = idMarca;
    }

    public Modelo getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Modelo idModelo) {
        this.idModelo = idModelo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleEquipo != null ? idDetalleEquipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleEquipo)) {
            return false;
        }
        DetalleEquipo other = (DetalleEquipo) object;
        if ((this.idDetalleEquipo == null && other.idDetalleEquipo != null) || (this.idDetalleEquipo != null && !this.idDetalleEquipo.equals(other.idDetalleEquipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.uesocc.ingenieria.tpi2018.entities.DetalleEquipo[ idDetalleEquipo=" + idDetalleEquipo + " ]";
    }
    
}
