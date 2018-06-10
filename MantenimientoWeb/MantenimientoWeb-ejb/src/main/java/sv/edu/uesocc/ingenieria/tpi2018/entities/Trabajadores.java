/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "trabajadores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trabajadores.findAll", query = "SELECT t FROM Trabajadores t")
    , @NamedQuery(name = "Trabajadores.findByIdTrabajador", query = "SELECT t FROM Trabajadores t WHERE t.idTrabajador = :idTrabajador")
    , @NamedQuery(name = "Trabajadores.findByApellidos", query = "SELECT t FROM Trabajadores t WHERE t.apellidos = :apellidos")
    , @NamedQuery(name = "Trabajadores.findByEmail", query = "SELECT t FROM Trabajadores t WHERE t.email = :email")
    , @NamedQuery(name = "Trabajadores.findByNombres", query = "SELECT t FROM Trabajadores t WHERE t.nombres = :nombres")})
public class Trabajadores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_trabajador")
    private Integer idTrabajador;
    @Size(max = 255)
    @Column(name = "apellidos")
    private String apellidos;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "email")
    private String email;
    @Size(max = 255)
    @Column(name = "nombres")
    private String nombres;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trabajadores")
    private Collection<OrdenTrabajoPorTrabajadores> ordenTrabajoPorTrabajadoresCollection;
    @OneToMany(mappedBy = "idTrabajadores")
    private Collection<Cargo> cargoCollection;

    public Trabajadores() {
    }

    public Trabajadores(Integer idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public Integer getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(Integer idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    @XmlTransient
    public Collection<OrdenTrabajoPorTrabajadores> getOrdenTrabajoPorTrabajadoresCollection() {
        return ordenTrabajoPorTrabajadoresCollection;
    }

    public void setOrdenTrabajoPorTrabajadoresCollection(Collection<OrdenTrabajoPorTrabajadores> ordenTrabajoPorTrabajadoresCollection) {
        this.ordenTrabajoPorTrabajadoresCollection = ordenTrabajoPorTrabajadoresCollection;
    }

    @XmlTransient
    public Collection<Cargo> getCargoCollection() {
        return cargoCollection;
    }

    public void setCargoCollection(Collection<Cargo> cargoCollection) {
        this.cargoCollection = cargoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTrabajador != null ? idTrabajador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Trabajadores)) {
            return false;
        }
        Trabajadores other = (Trabajadores) object;
        if ((this.idTrabajador == null && other.idTrabajador != null) || (this.idTrabajador != null && !this.idTrabajador.equals(other.idTrabajador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.uesocc.ingenieria.tpi2018.entities.Trabajadores[ idTrabajador=" + idTrabajador + " ]";
    }
    
}
