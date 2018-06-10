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
@Table(name = "diagnostico_parte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DiagnosticoParte.findAll", query = "SELECT d FROM DiagnosticoParte d")
    , @NamedQuery(name = "DiagnosticoParte.findByIdDiagnosticoParte", query = "SELECT d FROM DiagnosticoParte d WHERE d.idDiagnosticoParte = :idDiagnosticoParte")
    , @NamedQuery(name = "DiagnosticoParte.findByObservaciones", query = "SELECT d FROM DiagnosticoParte d WHERE d.observaciones = :observaciones")
    , @NamedQuery(name = "DiagnosticoParte.findByParte", query = "SELECT d FROM DiagnosticoParte d WHERE d.parte = :parte")})
public class DiagnosticoParte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_diagnostico_parte")
    private Integer idDiagnosticoParte;
    @Size(max = 255)
    @Column(name = "observaciones")
    private String observaciones;
    @Size(max = 255)
    @Column(name = "parte")
    private String parte;
    @OneToMany(mappedBy = "idDiagnosticoParte")
    private Collection<Diagnostico> diagnosticoCollection;

    public DiagnosticoParte() {
    }

    public DiagnosticoParte(Integer idDiagnosticoParte) {
        this.idDiagnosticoParte = idDiagnosticoParte;
    }

    public Integer getIdDiagnosticoParte() {
        return idDiagnosticoParte;
    }

    public void setIdDiagnosticoParte(Integer idDiagnosticoParte) {
        this.idDiagnosticoParte = idDiagnosticoParte;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getParte() {
        return parte;
    }

    public void setParte(String parte) {
        this.parte = parte;
    }

    @XmlTransient
    public Collection<Diagnostico> getDiagnosticoCollection() {
        return diagnosticoCollection;
    }

    public void setDiagnosticoCollection(Collection<Diagnostico> diagnosticoCollection) {
        this.diagnosticoCollection = diagnosticoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDiagnosticoParte != null ? idDiagnosticoParte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof DiagnosticoParte)) {
            return false;
        }
        DiagnosticoParte other = (DiagnosticoParte) object;
        if ((this.idDiagnosticoParte == null && other.idDiagnosticoParte != null) || (this.idDiagnosticoParte != null && !this.idDiagnosticoParte.equals(other.idDiagnosticoParte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.uesocc.ingenieria.tpi2018.entities.DiagnosticoParte[ idDiagnosticoParte=" + idDiagnosticoParte + " ]";
    }
    
}
