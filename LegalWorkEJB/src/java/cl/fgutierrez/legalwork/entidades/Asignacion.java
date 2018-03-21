/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fgutierrez.legalwork.entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Felipe
 */
@Entity
@Table(name = "asignacion", catalog = "legalwork", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asignacion.findAll", query = "SELECT a FROM Asignacion a"),
    @NamedQuery(name = "Asignacion.findByIdAsignacion", query = "SELECT a FROM Asignacion a WHERE a.idAsignacion = :idAsignacion"),
    @NamedQuery(name = "Asignacion.findByFechaAsignacion", query = "SELECT a FROM Asignacion a WHERE a.fechaAsignacion = :fechaAsignacion"),
    @NamedQuery(name = "Asignacion.findByEstadoAsignacion", query = "SELECT a FROM Asignacion a WHERE a.estadoAsignacion = :estadoAsignacion")})
public class Asignacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_asignacion", nullable = false)
    private Integer idAsignacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_asignacion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaAsignacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_asignacion", nullable = false)
    private int estadoAsignacion;
    @JoinColumn(name = "id_trabajo", referencedColumnName = "id_trabajo", nullable = false)
    @ManyToOne(optional = false)
    private Trabajo idTrabajo;
    @JoinColumn(name = "id_usr", referencedColumnName = "id_usr", nullable = false)
    @ManyToOne(optional = false)
    private Usuario idUsr;

    public Asignacion() {
    }

    public Asignacion(Integer idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public Asignacion(Integer idAsignacion, Date fechaAsignacion, int estadoAsignacion) {
        this.idAsignacion = idAsignacion;
        this.fechaAsignacion = fechaAsignacion;
        this.estadoAsignacion = estadoAsignacion;
    }

    public Integer getIdAsignacion() {
        return idAsignacion;
    }

    public void setIdAsignacion(Integer idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public Date getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(Date fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public int getEstadoAsignacion() {
        return estadoAsignacion;
    }

    public void setEstadoAsignacion(int estadoAsignacion) {
        this.estadoAsignacion = estadoAsignacion;
    }

    public Trabajo getIdTrabajo() {
        return idTrabajo;
    }

    public void setIdTrabajo(Trabajo idTrabajo) {
        this.idTrabajo = idTrabajo;
    }

    public Usuario getIdUsr() {
        return idUsr;
    }

    public void setIdUsr(Usuario idUsr) {
        this.idUsr = idUsr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAsignacion != null ? idAsignacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asignacion)) {
            return false;
        }
        Asignacion other = (Asignacion) object;
        if ((this.idAsignacion == null && other.idAsignacion != null) || (this.idAsignacion != null && !this.idAsignacion.equals(other.idAsignacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "c.fgutierrez.legalwork.entidades.Asignacion[ idAsignacion=" + idAsignacion + " ]";
    }
    
}
