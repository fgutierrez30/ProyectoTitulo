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
@Table(name = "sub_trabajo", catalog = "legalwork", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubTrabajo.findAll", query = "SELECT s FROM SubTrabajo s"),
    @NamedQuery(name = "SubTrabajo.findByIdSubTrabajo", query = "SELECT s FROM SubTrabajo s WHERE s.idSubTrabajo = :idSubTrabajo"),
    @NamedQuery(name = "SubTrabajo.findByNomSubTrabajo", query = "SELECT s FROM SubTrabajo s WHERE s.nomSubTrabajo = :nomSubTrabajo")})
public class SubTrabajo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sub_trabajo", nullable = false)
    private Integer idSubTrabajo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nom_sub_trabajo", nullable = false, length = 200)
    private String nomSubTrabajo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSubTrabajo")
    private List<DetalleTrabajo> detalleTrabajoList;

    public SubTrabajo() {
    }

    public SubTrabajo(Integer idSubTrabajo) {
        this.idSubTrabajo = idSubTrabajo;
    }

    public SubTrabajo(Integer idSubTrabajo, String nomSubTrabajo) {
        this.idSubTrabajo = idSubTrabajo;
        this.nomSubTrabajo = nomSubTrabajo;
    }

    public Integer getIdSubTrabajo() {
        return idSubTrabajo;
    }

    public void setIdSubTrabajo(Integer idSubTrabajo) {
        this.idSubTrabajo = idSubTrabajo;
    }

    public String getNomSubTrabajo() {
        return nomSubTrabajo;
    }

    public void setNomSubTrabajo(String nomSubTrabajo) {
        this.nomSubTrabajo = nomSubTrabajo;
    }

    @XmlTransient
    public List<DetalleTrabajo> getDetalleTrabajoList() {
        return detalleTrabajoList;
    }

    public void setDetalleTrabajoList(List<DetalleTrabajo> detalleTrabajoList) {
        this.detalleTrabajoList = detalleTrabajoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSubTrabajo != null ? idSubTrabajo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubTrabajo)) {
            return false;
        }
        SubTrabajo other = (SubTrabajo) object;
        if ((this.idSubTrabajo == null && other.idSubTrabajo != null) || (this.idSubTrabajo != null && !this.idSubTrabajo.equals(other.idSubTrabajo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "c.fgutierrez.legalwork.entidades.SubTrabajo[ idSubTrabajo=" + idSubTrabajo + " ]";
    }
    
}
