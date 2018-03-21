/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fgutierrez.legalwork.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
 * @author Felipe
 */
@Entity
@Table(name = "entidad", catalog = "legalwork", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entidad.findAll", query = "SELECT e FROM Entidad e"),
    @NamedQuery(name = "Entidad.findByIdEntidad", query = "SELECT e FROM Entidad e WHERE e.idEntidad = :idEntidad"),
    @NamedQuery(name = "Entidad.findByNomEntidad", query = "SELECT e FROM Entidad e WHERE e.nomEntidad = :nomEntidad"),
    @NamedQuery(name = "Entidad.findByDireccEntidad", query = "SELECT e FROM Entidad e WHERE e.direccEntidad = :direccEntidad"),
    @NamedQuery(name = "Entidad.findByTelefEntidad", query = "SELECT e FROM Entidad e WHERE e.telefEntidad = :telefEntidad")})
public class Entidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_entidad", nullable = false)
    private Integer idEntidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nom_entidad", nullable = false, length = 100)
    private String nomEntidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "direcc_entidad", nullable = false, length = 100)
    private String direccEntidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "telef_entidad", nullable = false, length = 12)
    private String telefEntidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEntidad")
    private List<DetalleTrabajo> detalleTrabajoList;
    @JoinColumn(name = "id_comuna", referencedColumnName = "id_comuna", nullable = false)
    @ManyToOne(optional = false)
    private Comuna idComuna;

    public Entidad() {
    }

    public Entidad(Integer idEntidad) {
        this.idEntidad = idEntidad;
    }

    public Entidad(Integer idEntidad, String nomEntidad, String direccEntidad, String telefEntidad) {
        this.idEntidad = idEntidad;
        this.nomEntidad = nomEntidad;
        this.direccEntidad = direccEntidad;
        this.telefEntidad = telefEntidad;
    }

    public Integer getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(Integer idEntidad) {
        this.idEntidad = idEntidad;
    }

    public String getNomEntidad() {
        return nomEntidad;
    }

    public void setNomEntidad(String nomEntidad) {
        this.nomEntidad = nomEntidad;
    }

    public String getDireccEntidad() {
        return direccEntidad;
    }

    public void setDireccEntidad(String direccEntidad) {
        this.direccEntidad = direccEntidad;
    }

    public String getTelefEntidad() {
        return telefEntidad;
    }

    public void setTelefEntidad(String telefEntidad) {
        this.telefEntidad = telefEntidad;
    }

    @XmlTransient
    public List<DetalleTrabajo> getDetalleTrabajoList() {
        return detalleTrabajoList;
    }

    public void setDetalleTrabajoList(List<DetalleTrabajo> detalleTrabajoList) {
        this.detalleTrabajoList = detalleTrabajoList;
    }

    public Comuna getIdComuna() {
        return idComuna;
    }

    public void setIdComuna(Comuna idComuna) {
        this.idComuna = idComuna;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEntidad != null ? idEntidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entidad)) {
            return false;
        }
        Entidad other = (Entidad) object;
        if ((this.idEntidad == null && other.idEntidad != null) || (this.idEntidad != null && !this.idEntidad.equals(other.idEntidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "c.fgutierrez.legalwork.entidades.Entidad[ idEntidad=" + idEntidad + " ]";
    }
    
}
