/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ricky
 */
@Entity
@Table(name = "orden_trabajo_por_trabajadores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenTrabajoPorTrabajadores.findAll", query = "SELECT o FROM OrdenTrabajoPorTrabajadores o")
    , @NamedQuery(name = "OrdenTrabajoPorTrabajadores.findByDetalle", query = "SELECT o FROM OrdenTrabajoPorTrabajadores o WHERE o.detalle = :detalle")
    , @NamedQuery(name = "OrdenTrabajoPorTrabajadores.findByIdOrdenTrabajo", query = "SELECT o FROM OrdenTrabajoPorTrabajadores o WHERE o.ordenTrabajoPorTrabajadoresPK.idOrdenTrabajo = :idOrdenTrabajo")
    , @NamedQuery(name = "OrdenTrabajoPorTrabajadores.findByIdTrabajadores", query = "SELECT o FROM OrdenTrabajoPorTrabajadores o WHERE o.ordenTrabajoPorTrabajadoresPK.idTrabajadores = :idTrabajadores")})
public class OrdenTrabajoPorTrabajadores implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrdenTrabajoPorTrabajadoresPK ordenTrabajoPorTrabajadoresPK;
    @Size(max = 255)
    @Column(name = "detalle")
    private String detalle;
    @JoinColumn(name = "id_orden_trabajo", referencedColumnName = "id_orden_trabajo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private OrdenTrabajo ordenTrabajo;
    @JoinColumn(name = "id_trabajadores", referencedColumnName = "id_trabajador", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Trabajadores trabajadores;

    public OrdenTrabajoPorTrabajadores() {
    }

    public OrdenTrabajoPorTrabajadores(OrdenTrabajoPorTrabajadoresPK ordenTrabajoPorTrabajadoresPK) {
        this.ordenTrabajoPorTrabajadoresPK = ordenTrabajoPorTrabajadoresPK;
    }

    public OrdenTrabajoPorTrabajadores(int idOrdenTrabajo, int idTrabajadores) {
        this.ordenTrabajoPorTrabajadoresPK = new OrdenTrabajoPorTrabajadoresPK(idOrdenTrabajo, idTrabajadores);
    }

    public OrdenTrabajoPorTrabajadoresPK getOrdenTrabajoPorTrabajadoresPK() {
        return ordenTrabajoPorTrabajadoresPK;
    }

    public void setOrdenTrabajoPorTrabajadoresPK(OrdenTrabajoPorTrabajadoresPK ordenTrabajoPorTrabajadoresPK) {
        this.ordenTrabajoPorTrabajadoresPK = ordenTrabajoPorTrabajadoresPK;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public OrdenTrabajo getOrdenTrabajo() {
        return ordenTrabajo;
    }

    public void setOrdenTrabajo(OrdenTrabajo ordenTrabajo) {
        this.ordenTrabajo = ordenTrabajo;
    }

    public Trabajadores getTrabajadores() {
        return trabajadores;
    }

    public void setTrabajadores(Trabajadores trabajadores) {
        this.trabajadores = trabajadores;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ordenTrabajoPorTrabajadoresPK != null ? ordenTrabajoPorTrabajadoresPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof OrdenTrabajoPorTrabajadores)) {
            return false;
        }
        OrdenTrabajoPorTrabajadores other = (OrdenTrabajoPorTrabajadores) object;
        if ((this.ordenTrabajoPorTrabajadoresPK == null && other.ordenTrabajoPorTrabajadoresPK != null) || (this.ordenTrabajoPorTrabajadoresPK != null && !this.ordenTrabajoPorTrabajadoresPK.equals(other.ordenTrabajoPorTrabajadoresPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.uesocc.ingenieria.tpi2018.entities.OrdenTrabajoPorTrabajadores[ ordenTrabajoPorTrabajadoresPK=" + ordenTrabajoPorTrabajadoresPK + " ]";
    }
    
}
