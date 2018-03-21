/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fgutierrez.legalwork.entidades;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Felipe
 */
@Entity
@Table(name = "menu", catalog = "legalwork", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menu.getXPerfil",query = " SELECT NEW cl.fgutierrez.legalwork.dto.MenuPerfilDTO(m,m.idPerfil)"
    +"FROM Menu m WHERE m.idPerfil= :perfilCodigo"),
    @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m"),
    @NamedQuery(name = "Menu.findByIdMenu", query = "SELECT m FROM Menu m WHERE m.idMenu = :idMenu"),
    @NamedQuery(name = "Menu.findByNomMenu", query = "SELECT m FROM Menu m WHERE m.nomMenu = :nomMenu"),
    @NamedQuery(name = "Menu.findByPadreMenu", query = "SELECT m FROM Menu m WHERE m.padreMenu = :padreMenu"),
    @NamedQuery(name = "Menu.findByUrlMenu", query = "SELECT m FROM Menu m WHERE m.urlMenu = :urlMenu")})
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_menu", nullable = false)
    private Integer idMenu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nom_menu", nullable = false, length = 50)
    private String nomMenu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "padre_menu", nullable = false)
    private int padreMenu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "url_menu", nullable = false, length = 80)
    private String urlMenu;
    @JoinColumn(name = "id_perfil", referencedColumnName = "id_perfil", nullable = false)
    @ManyToOne(optional = false)
    private Perfil idPerfil;

    public Menu() {
    }

    public Menu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public Menu(Integer idMenu, String nomMenu, int padreMenu, String urlMenu) {
        this.idMenu = idMenu;
        this.nomMenu = nomMenu;
        this.padreMenu = padreMenu;
        this.urlMenu = urlMenu;
    }

    public Integer getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public String getNomMenu() {
        return nomMenu;
    }

    public void setNomMenu(String nomMenu) {
        this.nomMenu = nomMenu;
    }

    public int getPadreMenu() {
        return padreMenu;
    }

    public void setPadreMenu(int padreMenu) {
        this.padreMenu = padreMenu;
    }

    public String getUrlMenu() {
        return urlMenu;
    }

    public void setUrlMenu(String urlMenu) {
        this.urlMenu = urlMenu;
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
        hash += (idMenu != null ? idMenu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.idMenu == null && other.idMenu != null) || (this.idMenu != null && !this.idMenu.equals(other.idMenu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "c.fgutierrez.legalwork.entidades.Menu[ idMenu=" + idMenu + " ]";
    }
    
}
