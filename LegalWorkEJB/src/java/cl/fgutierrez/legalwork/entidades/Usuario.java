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
@Table(name = "usuario", catalog = "legalwork", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name="Usuario.valida",query = "SELECT NEW cl.fgutierrez.legalwork.dto.UsuarioPerfilDTO(u,u.idPerfil)"
    +" FROM Usuario u WHERE u.loginUsr = :loginUsr and u.passUsr= :passUsr"),
    @NamedQuery(name="Usuario.listado",query = "SELECT NEW cl.fgutierrez.legalwork.dto.UsuarioPerfilDTO(u,u.idPerfil)"
    +" FROM Usuario u"),
    @NamedQuery(name="Usuario.modifica",query = "SELECT NEW cl.fgutierrez.legalwork.dto.UsuarioPerfilDTO(u,u.idPerfil)"
    +" FROM Usuario u WHERE u.idUsr = :idUsr"),
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdUsr", query = "SELECT u FROM Usuario u WHERE u.idUsr = :idUsr"),
    @NamedQuery(name = "Usuario.findByRutUsr", query = "SELECT u FROM Usuario u WHERE u.rutUsr = :rutUsr"),
    @NamedQuery(name = "Usuario.findByLoginUsr", query = "SELECT u FROM Usuario u WHERE u.loginUsr = :loginUsr"),
    @NamedQuery(name = "Usuario.findByPassUsr", query = "SELECT u FROM Usuario u WHERE u.passUsr = :passUsr"),
    @NamedQuery(name = "Usuario.findByNomUsr", query = "SELECT u FROM Usuario u WHERE u.nomUsr = :nomUsr"),
    @NamedQuery(name = "Usuario.findByApellUsr", query = "SELECT u FROM Usuario u WHERE u.apellUsr = :apellUsr"),
    @NamedQuery(name = "Usuario.findByEmailUsr", query = "SELECT u FROM Usuario u WHERE u.emailUsr = :emailUsr"),
    @NamedQuery(name = "Usuario.findByTelefUsr", query = "SELECT u FROM Usuario u WHERE u.telefUsr = :telefUsr"),
    @NamedQuery(name = "Usuario.findByEstadoUsr", query = "SELECT u FROM Usuario u WHERE u.estadoUsr = :estadoUsr")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usr", nullable = false)
    private Integer idUsr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "rut_usr", nullable = false, length = 10)
    private String rutUsr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "login_usr", nullable = false, length = 30)
    private String loginUsr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "pass_usr", nullable = false, length = 15)
    private String passUsr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nom_usr", nullable = false, length = 50)
    private String nomUsr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "apell_usr", nullable = false, length = 50)
    private String apellUsr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "email_usr", nullable = false, length = 100)
    private String emailUsr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "telef_usr", nullable = false, length = 15)
    private String telefUsr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_usr", nullable = false)
    private int estadoUsr;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsr")
    private List<Asignacion> asignacionList;
    @JoinColumn(name = "id_perfil", referencedColumnName = "id_perfil", nullable = false)
    @ManyToOne(optional = false)
    private Perfil idPerfil;

    public Usuario() {
    }

    public Usuario(Integer idUsr) {
        this.idUsr = idUsr;
    }

    public Usuario(Integer idUsr, String rutUsr, String loginUsr, String passUsr, String nomUsr, String apellUsr, String emailUsr, String telefUsr, int estadoUsr) {
        this.idUsr = idUsr;
        this.rutUsr = rutUsr;
        this.loginUsr = loginUsr;
        this.passUsr = passUsr;
        this.nomUsr = nomUsr;
        this.apellUsr = apellUsr;
        this.emailUsr = emailUsr;
        this.telefUsr = telefUsr;
        this.estadoUsr = estadoUsr;
    }

    public Integer getIdUsr() {
        return idUsr;
    }

    public void setIdUsr(Integer idUsr) {
        this.idUsr = idUsr;
    }

    public String getRutUsr() {
        return rutUsr;
    }

    public void setRutUsr(String rutUsr) {
        this.rutUsr = rutUsr;
    }

    public String getLoginUsr() {
        return loginUsr;
    }

    public void setLoginUsr(String loginUsr) {
        this.loginUsr = loginUsr;
    }

    public String getPassUsr() {
        return passUsr;
    }

    public void setPassUsr(String passUsr) {
        this.passUsr = passUsr;
    }

    public String getNomUsr() {
        return nomUsr;
    }

    public void setNomUsr(String nomUsr) {
        this.nomUsr = nomUsr;
    }

    public String getApellUsr() {
        return apellUsr;
    }

    public void setApellUsr(String apellUsr) {
        this.apellUsr = apellUsr;
    }

    public String getEmailUsr() {
        return emailUsr;
    }

    public void setEmailUsr(String emailUsr) {
        this.emailUsr = emailUsr;
    }

    public String getTelefUsr() {
        return telefUsr;
    }

    public void setTelefUsr(String telefUsr) {
        this.telefUsr = telefUsr;
    }

    public int getEstadoUsr() {
        return estadoUsr;
    }

    public void setEstadoUsr(int estadoUsr) {
        this.estadoUsr = estadoUsr;
    }

    @XmlTransient
    public List<Asignacion> getAsignacionList() {
        return asignacionList;
    }

    public void setAsignacionList(List<Asignacion> asignacionList) {
        this.asignacionList = asignacionList;
    }

    public Perfil getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Perfil idPerfil) {
        this.idPerfil = idPerfil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsr != null ? idUsr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsr == null && other.idUsr != null) || (this.idUsr != null && !this.idUsr.equals(other.idUsr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "c.fgutierrez.legalwork.entidades.Usuario[ idUsr=" + idUsr + " ]";
    }
    
}
