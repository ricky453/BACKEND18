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
@Table(name = "pasos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pasos.findAll", query = "SELECT p FROM Pasos p")
    , @NamedQuery(name = "Pasos.findByName", query = "SELECT m FROM Pasos m WHERE LOWER(m.paso) LIKE CONCAT('%',LOWER(:name),'%')")        
    , @NamedQuery(name = "Pasos.findByIdPaso", query = "SELECT p FROM Pasos p WHERE p.idPaso = :idPaso")
    , @NamedQuery(name = "Pasos.findByPaso", query = "SELECT p FROM Pasos p WHERE p.paso = :paso")})
public class Pasos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_paso")
    private Integer idPaso;
    @Size(max = 255)
    @Column(name = "paso")
    private String paso;
    @OneToMany(mappedBy = "idPasos")
    private Collection<Procedimiento> procedimientoCollection;

    public Pasos() {
    }

    public Pasos(Integer idPaso) {
        this.idPaso = idPaso;
    }
    
    public Pasos(Integer idPaso, String paso) {
        this.idPaso = idPaso;
        this.paso = paso;
    }    

    public Integer getIdPaso() {
        return idPaso;
    }

    public void setIdPaso(Integer idPaso) {
        this.idPaso = idPaso;
    }

    public String getPaso() {
        return paso;
    }

    public void setPaso(String paso) {
        this.paso = paso;
    }

    @XmlTransient
    public Collection<Procedimiento> getProcedimientoCollection() {
        return procedimientoCollection;
    }

    public void setProcedimientoCollection(Collection<Procedimiento> procedimientoCollection) {
        this.procedimientoCollection = procedimientoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPaso != null ? idPaso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pasos)) {
            return false;
        }
        Pasos other = (Pasos) object;
        if ((this.idPaso == null && other.idPaso != null) || (this.idPaso != null && !this.idPaso.equals(other.idPaso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.uesocc.ingenieria.tpi2018.entities.Pasos[ idPaso=" + idPaso + " ]";
    }
    
}
