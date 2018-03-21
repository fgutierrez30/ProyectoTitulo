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
@Table(name = "tipo_trabajo", catalog = "legalwork", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoTrabajo.findAll", query = "SELECT t FROM TipoTrabajo t"),
    @NamedQuery(name = "TipoTrabajo.findByIdTipoTrabajo", query = "SELECT t FROM TipoTrabajo t WHERE t.idTipoTrabajo = :idTipoTrabajo"),
    @NamedQuery(name = "TipoTrabajo.findByNomTipoTrabajo", query = "SELECT t FROM TipoTrabajo t WHERE t.nomTipoTrabajo = :nomTipoTrabajo")})
public class TipoTrabajo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_trabajo", nullable = false)
    private Integer idTipoTrabajo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "nom_tipo_trabajo", nullable = false, length = 80)
    private String nomTipoTrabajo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoTrabajo")
    private List<Trabajo> trabajoList;

    public TipoTrabajo() {
    }

    public TipoTrabajo(Integer idTipoTrabajo) {
        this.idTipoTrabajo = idTipoTrabajo;
    }

    public TipoTrabajo(Integer idTipoTrabajo, String nomTipoTrabajo) {
        this.idTipoTrabajo = idTipoTrabajo;
        this.nomTipoTrabajo = nomTipoTrabajo;
    }

    public Integer getIdTipoTrabajo() {
        return idTipoTrabajo;
    }

    public void setIdTipoTrabajo(Integer idTipoTrabajo) {
        this.idTipoTrabajo = idTipoTrabajo;
    }

    public String getNomTipoTrabajo() {
        return nomTipoTrabajo;
    }

    public void setNomTipoTrabajo(String nomTipoTrabajo) {
        this.nomTipoTrabajo = nomTipoTrabajo;
    }

    @XmlTransient
    public List<Trabajo> getTrabajoList() {
        return trabajoList;
    }

    public void setTrabajoList(List<Trabajo> trabajoList) {
        this.trabajoList = trabajoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoTrabajo != null ? idTipoTrabajo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoTrabajo)) {
            return false;
        }
        TipoTrabajo other = (TipoTrabajo) object;
        if ((this.idTipoTrabajo == null && other.idTipoTrabajo != null) || (this.idTipoTrabajo != null && !this.idTipoTrabajo.equals(other.idTipoTrabajo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "c.fgutierrez.legalwork.entidades.TipoTrabajo[ idTipoTrabajo=" + idTipoTrabajo + " ]";
    }
    
}
