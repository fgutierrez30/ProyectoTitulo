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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Felipe
 */
@Entity
@Table(name = "detalle_trabajo", catalog = "legalwork", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleTrabajo.findAll", query = "SELECT d FROM DetalleTrabajo d"),
    @NamedQuery(name = "DetalleTrabajo.findByIdDetalleTrabajo", query = "SELECT d FROM DetalleTrabajo d WHERE d.idDetalleTrabajo = :idDetalleTrabajo"),
    @NamedQuery(name = "DetalleTrabajo.findByFechaInicioDetTrabajo", query = "SELECT d FROM DetalleTrabajo d WHERE d.fechaInicioDetTrabajo = :fechaInicioDetTrabajo"),
    @NamedQuery(name = "DetalleTrabajo.findByFechaFinDetTrabajo", query = "SELECT d FROM DetalleTrabajo d WHERE d.fechaFinDetTrabajo = :fechaFinDetTrabajo"),
    @NamedQuery(name = "DetalleTrabajo.findByEstadoDetTrabajo", query = "SELECT d FROM DetalleTrabajo d WHERE d.estadoDetTrabajo = :estadoDetTrabajo"),
    @NamedQuery(name = "DetalleTrabajo.findBySessionUsr", query = "SELECT d FROM DetalleTrabajo d WHERE d.sessionUsr = :sessionUsr"),
    @NamedQuery(name = "DetalleTrabajo.findByValorDetTrabajo", query = "SELECT d FROM DetalleTrabajo d WHERE d.valorDetTrabajo = :valorDetTrabajo")})
public class DetalleTrabajo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detalle_trabajo", nullable = false)
    private Integer idDetalleTrabajo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio_det_trabajo", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaInicioDetTrabajo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_fin_det_trabajo", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaFinDetTrabajo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_det_trabajo", nullable = false)
    private int estadoDetTrabajo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "session_usr", nullable = false, length = 80)
    private String sessionUsr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_det_trabajo", nullable = false)
    private int valorDetTrabajo;
    @JoinColumn(name = "id_entidad", referencedColumnName = "id_entidad", nullable = false)
    @ManyToOne(optional = false)
    private Entidad idEntidad;
    @JoinColumn(name = "id_sub_trabajo", referencedColumnName = "id_sub_trabajo", nullable = false)
    @ManyToOne(optional = false)
    private SubTrabajo idSubTrabajo;
    @JoinColumn(name = "id_trabajo", referencedColumnName = "id_trabajo", nullable = false)
    @ManyToOne(optional = false)
    private Trabajo idTrabajo;

    public DetalleTrabajo() {
    }

    public DetalleTrabajo(Integer idDetalleTrabajo) {
        this.idDetalleTrabajo = idDetalleTrabajo;
    }

    public DetalleTrabajo(Integer idDetalleTrabajo, Date fechaInicioDetTrabajo, Date fechaFinDetTrabajo, int estadoDetTrabajo, String sessionUsr, int valorDetTrabajo) {
        this.idDetalleTrabajo = idDetalleTrabajo;
        this.fechaInicioDetTrabajo = fechaInicioDetTrabajo;
        this.fechaFinDetTrabajo = fechaFinDetTrabajo;
        this.estadoDetTrabajo = estadoDetTrabajo;
        this.sessionUsr = sessionUsr;
        this.valorDetTrabajo = valorDetTrabajo;
    }

    public Integer getIdDetalleTrabajo() {
        return idDetalleTrabajo;
    }

    public void setIdDetalleTrabajo(Integer idDetalleTrabajo) {
        this.idDetalleTrabajo = idDetalleTrabajo;
    }

    public Date getFechaInicioDetTrabajo() {
        return fechaInicioDetTrabajo;
    }

    public void setFechaInicioDetTrabajo(Date fechaInicioDetTrabajo) {
        this.fechaInicioDetTrabajo = fechaInicioDetTrabajo;
    }

    public Date getFechaFinDetTrabajo() {
        return fechaFinDetTrabajo;
    }

    public void setFechaFinDetTrabajo(Date fechaFinDetTrabajo) {
        this.fechaFinDetTrabajo = fechaFinDetTrabajo;
    }

    public int getEstadoDetTrabajo() {
        return estadoDetTrabajo;
    }

    public void setEstadoDetTrabajo(int estadoDetTrabajo) {
        this.estadoDetTrabajo = estadoDetTrabajo;
    }

    public String getSessionUsr() {
        return sessionUsr;
    }

    public void setSessionUsr(String sessionUsr) {
        this.sessionUsr = sessionUsr;
    }

    public int getValorDetTrabajo() {
        return valorDetTrabajo;
    }

    public void setValorDetTrabajo(int valorDetTrabajo) {
        this.valorDetTrabajo = valorDetTrabajo;
    }

    public Entidad getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(Entidad idEntidad) {
        this.idEntidad = idEntidad;
    }

    public SubTrabajo getIdSubTrabajo() {
        return idSubTrabajo;
    }

    public void setIdSubTrabajo(SubTrabajo idSubTrabajo) {
        this.idSubTrabajo = idSubTrabajo;
    }

    public Trabajo getIdTrabajo() {
        return idTrabajo;
    }

    public void setIdTrabajo(Trabajo idTrabajo) {
        this.idTrabajo = idTrabajo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleTrabajo != null ? idDetalleTrabajo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleTrabajo)) {
            return false;
        }
        DetalleTrabajo other = (DetalleTrabajo) object;
        if ((this.idDetalleTrabajo == null && other.idDetalleTrabajo != null) || (this.idDetalleTrabajo != null && !this.idDetalleTrabajo.equals(other.idDetalleTrabajo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "c.fgutierrez.legalwork.entidades.DetalleTrabajo[ idDetalleTrabajo=" + idDetalleTrabajo + " ]";
    }
    
}
