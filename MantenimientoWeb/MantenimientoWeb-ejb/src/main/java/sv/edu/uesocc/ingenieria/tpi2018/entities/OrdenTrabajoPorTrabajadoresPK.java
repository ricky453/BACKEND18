/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ricky
 */
@Embeddable
public class OrdenTrabajoPorTrabajadoresPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_orden_trabajo")
    private int idOrdenTrabajo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_trabajadores")
    private int idTrabajadores;

    public OrdenTrabajoPorTrabajadoresPK() {
    }

    public OrdenTrabajoPorTrabajadoresPK(int idOrdenTrabajo, int idTrabajadores) {
        this.idOrdenTrabajo = idOrdenTrabajo;
        this.idTrabajadores = idTrabajadores;
    }

    public int getIdOrdenTrabajo() {
        return idOrdenTrabajo;
    }

    public void setIdOrdenTrabajo(int idOrdenTrabajo) {
        this.idOrdenTrabajo = idOrdenTrabajo;
    }

    public int getIdTrabajadores() {
        return idTrabajadores;
    }

    public void setIdTrabajadores(int idTrabajadores) {
        this.idTrabajadores = idTrabajadores;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idOrdenTrabajo;
        hash += (int) idTrabajadores;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenTrabajoPorTrabajadoresPK)) {
            return false;
        }
        OrdenTrabajoPorTrabajadoresPK other = (OrdenTrabajoPorTrabajadoresPK) object;
        if (this.idOrdenTrabajo != other.idOrdenTrabajo) {
            return false;
        }
        if (this.idTrabajadores != other.idTrabajadores) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.uesocc.ingenieria.tpi2018.entities.OrdenTrabajoPorTrabajadoresPK[ idOrdenTrabajo=" + idOrdenTrabajo + ", idTrabajadores=" + idTrabajadores + " ]";
    }
    
}
