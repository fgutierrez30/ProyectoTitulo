/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fgutierrez.legalwork.dto;

import java.io.Serializable;

/**
 *
 * @author Felipe
 */
public class MenuDTO implements Serializable{
    
    private int id_menu;
    private String nom_menu;
    private int padre_menu;
    private String url_menu;
    private int id_perfil_menu;

    public MenuDTO() {
    }

    public MenuDTO(int id_menu, String nom_menu, int padre_menu, String url_menu, int id_perfil_menu) {
        this.id_menu = id_menu;
        this.nom_menu = nom_menu;
        this.padre_menu = padre_menu;
        this.url_menu = url_menu;
        this.id_perfil_menu = id_perfil_menu;
    }

    public MenuDTO(String nom_menu, int padre_menu, String url_menu, int id_perfil_menu) {
        this.nom_menu = nom_menu;
        this.padre_menu = padre_menu;
        this.url_menu = url_menu;
        this.id_perfil_menu = id_perfil_menu;
    }

    public int getId_menu() {
        return id_menu;
    }

    public void setId_menu(int id_menu) {
        this.id_menu = id_menu;
    }

    public String getNom_menu() {
        return nom_menu;
    }

    public void setNom_menu(String nom_menu) {
        this.nom_menu = nom_menu;
    }

    public int getPadre_menu() {
        return padre_menu;
    }

    public void setPadre_menu(int padre_menu) {
        this.padre_menu = padre_menu;
    }

    public String getUrl_menu() {
        return url_menu;
    }

    public void setUrl_menu(String url_menu) {
        this.url_menu = url_menu;
    }

    public int getId_perfil_menu() {
        return id_perfil_menu;
    }

    public void setId_perfil_menu(int id_perfil_menu) {
        this.id_perfil_menu = id_perfil_menu;
    }
    
    
    
}
