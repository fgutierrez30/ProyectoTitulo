/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fgutierrez.legalwork.dto;

import cl.fgutierrez.legalwork.entidades.Menu;
import cl.fgutierrez.legalwork.entidades.Perfil;
import java.io.Serializable;

/**
 *
 * @author Felipe
 */
public class MenuPerfilDTO implements Serializable{
    
    public Menu objMenu;
    public Perfil objPerfil;

    public MenuPerfilDTO() {
    }

    public MenuPerfilDTO(Menu objMenu, Perfil objPerfil) {
        this.objMenu = objMenu;
        this.objPerfil = objPerfil;
    }

    public Menu getObjMenu() {
        return objMenu;
    }

    public void setObjMenu(Menu objMenu) {
        this.objMenu = objMenu;
    }

    public Perfil getObjPerfil() {
        return objPerfil;
    }

    public void setObjPerfil(Perfil objPerfil) {
        this.objPerfil = objPerfil;
    }
    
    
}
