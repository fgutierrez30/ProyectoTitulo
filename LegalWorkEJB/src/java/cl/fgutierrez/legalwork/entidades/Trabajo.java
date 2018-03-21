/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fgutierrez.legalwork.entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Felipe
 */
@Entity
@Table(name = "trabajo", catalog = "legalwork", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trabajo.sinAsignar", query = "SELECT NEW cl.fgutierrez.legalwork.dto.TrabajoTpTrabajoClienteDTO(t,t.idTipoTrabajo,t.rutCliente)"+
            "FROM Trabajo t WHERE t.estadoTrabajo = :estadoTrabajo"),
    @NamedQuery(name = "Trabajo.findAll", query = "SELECT t FROM Trabajo t"),
    @NamedQuery(name = "Trabajo.findByIdTrabajo", query = "SELECT t FROM Trabajo t WHERE t.idTrabajo = :idTrabajo"),
    @NamedQuery(name = "Trabajo.findByFechaInicioTrabajo", query = "SELECT t FROM Trabajo t WHERE t.fechaInicioTrabajo = :fechaInicioTrabajo"),
    @NamedQuery(name = "Trabajo.findByFechaFinTrabajo", query = "SELECT t FROM Trabajo t WHERE t.fechaFinTrabajo = :fechaFinTrabajo"),
    @NamedQuery(name = "Trabajo.findByEstadoTrabajo", query = "SELECT t FROM Trabajo t WHERE t.estadoTrabajo = :estadoTrabajo"),
    @NamedQuery(name = "Trabajo.findByFechaFinRealTrabajo", query = "SELECT t FROM Trabajo t WHERE t.fechaFinRealTrabajo = :fechaFinRealTrabajo"),
    @NamedQuery(name = "Trabajo.findByDetTrabajo", query = "SELECT t FROM Trabajo t WHERE t.detTrabajo = :detTrabajo")})
public class Trabajo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_trabajo", nullable = false)
    private Integer idTrabajo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio_trabajo", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaInicioTrabajo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_fin_trabajo", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaFinTrabajo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "estado_trabajo", nullable = false, length = 80)
    private String estadoTrabajo;
    @Column(name = "fecha_fin_real_trabajo")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaFinRealTrabajo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "det_trabajo", nullable = false, length = 200)
    private String detTrabajo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTrabajo")
    private List<Asignacion> asignacionList;
    @JoinColumn(name = "rut_cliente", referencedColumnName = "rut_cliente", nullable = false)
    @ManyToOne(optional = false)
    private Cliente rutCliente;
    @JoinColumn(name = "id_tipo_trabajo", referencedColumnName = "id_tipo_trabajo", nullable = false)
    @ManyToOne(optional = false)
    private TipoTrabajo idTipoTrabajo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTrabajo")
    private List<DetalleTrabajo> detalleTrabajoList;

    public Trabajo() {
    }

    public Trabajo(Integer idTrabajo) {
        this.idTrabajo = idTrabajo;
    }

    public Trabajo(Integer idTrabajo, Date fechaInicioTrabajo, Date fechaFinTrabajo, String estadoTrabajo, String detTrabajo) {
        this.idTrabajo = idTrabajo;
        this.fechaInicioTrabajo = fechaInicioTrabajo;
        this.fechaFinTrabajo = fechaFinTrabajo;
        this.estadoTrabajo = estadoTrabajo;
        this.detTrabajo = detTrabajo;
    }

    public Integer getIdTrabajo() {
        return idTrabajo;
    }

    public void setIdTrabajo(Integer idTrabajo) {
        this.idTrabajo = idTrabajo;
    }

    public Date getFechaInicioTrabajo() {
        return fechaInicioTrabajo;
    }

    public void setFechaInicioTrabajo(Date fechaInicioTrabajo) {
        this.fechaInicioTrabajo = fechaInicioTrabajo;
    }

    public Date getFechaFinTrabajo() {
        return fechaFinTrabajo;
    }

    public void setFechaFinTrabajo(Date fechaFinTrabajo) {
        this.fechaFinTrabajo = fechaFinTrabajo;
    }

    public String getEstadoTrabajo() {
        return estadoTrabajo;
    }

    public void setEstadoTrabajo(String estadoTrabajo) {
        this.estadoTrabajo = estadoTrabajo;
    }

    public Date getFechaFinRealTrabajo() {
        return fechaFinRealTrabajo;
    }

    public void setFechaFinRealTrabajo(Date fechaFinRealTrabajo) {
        this.fechaFinRealTrabajo = fechaFinRealTrabajo;
    }

    public String getDetTrabajo() {
        return detTrabajo;
    }

    public void setDetTrabajo(String detTrabajo) {
        this.detTrabajo = detTrabajo;
    }

    @XmlTransient
    public List<Asignacion> getAsignacionList() {
        return asignacionList;
    }

    public void setAsignacionList(List<Asignacion> asignacionList) {
        this.asignacionList = asignacionList;
    }

    public Cliente getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(Cliente rutCliente) {
        this.rutCliente = rutCliente;
    }

    public TipoTrabajo getIdTipoTrabajo() {
        return idTipoTrabajo;
    }

    public void setIdTipoTrabajo(TipoTrabajo idTipoTrabajo) {
        this.idTipoTrabajo = idTipoTrabajo;
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
        hash += (idTrabajo != null ? idTrabajo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trabajo)) {
            return false;
        }
        Trabajo other = (Trabajo) object;
        if ((this.idTrabajo == null && other.idTrabajo != null) || (this.idTrabajo != null && !this.idTrabajo.equals(other.idTrabajo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "c.fgutierrez.legalwork.entidades.Trabajo[ idTrabajo=" + idTrabajo + " ]";
    }
    
}
