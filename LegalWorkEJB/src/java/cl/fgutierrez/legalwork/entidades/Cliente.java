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
@Table(name = "cliente", catalog = "legalwork", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByRutCliente", query = "SELECT c FROM Cliente c WHERE c.rutCliente = :rutCliente"),
    @NamedQuery(name = "Cliente.findByRazonSocial", query = "SELECT c FROM Cliente c WHERE c.razonSocial = :razonSocial"),
    @NamedQuery(name = "Cliente.findByEstadoCliente", query = "SELECT c FROM Cliente c WHERE c.estadoCliente = :estadoCliente"),
    @NamedQuery(name = "Cliente.findByCorreoCliente", query = "SELECT c FROM Cliente c WHERE c.correoCliente = :correoCliente"),
    @NamedQuery(name = "Cliente.findByTelefCliente", query = "SELECT c FROM Cliente c WHERE c.telefCliente = :telefCliente")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "rut_cliente", nullable = false, length = 10)
    private String rutCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "razon_social", nullable = false, length = 200)
    private String razonSocial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_cliente", nullable = false)
    private int estadoCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "correo_cliente", nullable = false, length = 100)
    private String correoCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "telef_cliente", nullable = false, length = 15)
    private String telefCliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rutCliente")
    private List<Trabajo> trabajoList;

    public Cliente() {
    }

    public Cliente(String rutCliente) {
        this.rutCliente = rutCliente;
    }

    public Cliente(String rutCliente, String razonSocial, int estadoCliente, String correoCliente, String telefCliente) {
        this.rutCliente = rutCliente;
        this.razonSocial = razonSocial;
        this.estadoCliente = estadoCliente;
        this.correoCliente = correoCliente;
        this.telefCliente = telefCliente;
    }

    public String getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(String rutCliente) {
        this.rutCliente = rutCliente;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public int getEstadoCliente() {
        return estadoCliente;
    }

    public void setEstadoCliente(int estadoCliente) {
        this.estadoCliente = estadoCliente;
    }

    public String getCorreoCliente() {
        return correoCliente;
    }

    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }

    public String getTelefCliente() {
        return telefCliente;
    }

    public void setTelefCliente(String telefCliente) {
        this.telefCliente = telefCliente;
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
        hash += (rutCliente != null ? rutCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.rutCliente == null && other.rutCliente != null) || (this.rutCliente != null && !this.rutCliente.equals(other.rutCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "c.fgutierrez.legalwork.entidades.Cliente[ rutCliente=" + rutCliente + " ]";
    }
    
}
