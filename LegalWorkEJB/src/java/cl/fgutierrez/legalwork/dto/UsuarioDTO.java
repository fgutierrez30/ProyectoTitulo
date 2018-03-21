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
public class UsuarioDTO implements Serializable{
    private int id_usr;
    private String rut_usr;
    private String login_usr;
    private String pass_usr;
    private String nom_usr;
    private String apell_usr;
    private String email_usr;
    private String telef_usr;
    private int estado_usr;
    private int id_perfil;

    public UsuarioDTO() {
    }

    public UsuarioDTO(int id_usr, String rut_usr, String login_usr, String pass_usr, String nom_usr, String apell_usr, String email_usr, String telef_usr, int estado_usr, int id_perfil) {
        this.id_usr = id_usr;
        this.rut_usr = rut_usr;
        this.login_usr = login_usr;
        this.pass_usr = pass_usr;
        this.nom_usr = nom_usr;
        this.apell_usr = apell_usr;
        this.email_usr = email_usr;
        this.telef_usr = telef_usr;
        this.estado_usr = estado_usr;
        this.id_perfil = id_perfil;
    }

    public UsuarioDTO(String rut_usr, String login_usr, String pass_usr, String nom_usr, String apell_usr, String email_usr, String telef_usr, int estado_usr, int id_perfil) {
        this.rut_usr = rut_usr;
        this.login_usr = login_usr;
        this.pass_usr = pass_usr;
        this.nom_usr = nom_usr;
        this.apell_usr = apell_usr;
        this.email_usr = email_usr;
        this.telef_usr = telef_usr;
        this.estado_usr = estado_usr;
        this.id_perfil = id_perfil;
    }

    public int getId_usr() {
        return id_usr;
    }

    public void setId_usr(int id_usr) {
        this.id_usr = id_usr;
    }

    public String getRut_usr() {
        return rut_usr;
    }

    public void setRut_usr(String rut_usr) {
        this.rut_usr = rut_usr;
    }

    public String getLogin_usr() {
        return login_usr;
    }

    public void setLogin_usr(String login_usr) {
        this.login_usr = login_usr;
    }

    public String getPass_usr() {
        return pass_usr;
    }

    public void setPass_usr(String pass_usr) {
        this.pass_usr = pass_usr;
    }

    public String getNom_usr() {
        return nom_usr;
    }

    public void setNom_usr(String nom_usr) {
        this.nom_usr = nom_usr;
    }

    public String getApell_usr() {
        return apell_usr;
    }

    public void setApell_usr(String apell_usr) {
        this.apell_usr = apell_usr;
    }

    public String getEmail_usr() {
        return email_usr;
    }

    public void setEmail_usr(String email_usr) {
        this.email_usr = email_usr;
    }

    public String getTelef_usr() {
        return telef_usr;
    }

    public void setTelef_usr(String telef_usr) {
        this.telef_usr = telef_usr;
    }

    public int getEstado_usr() {
        return estado_usr;
    }

    public void setEstado_usr(int estado_usr) {
        this.estado_usr = estado_usr;
    }

    public int getId_perfil() {
        return id_perfil;
    }

    public void setId_perfil(int id_perfil) {
        this.id_perfil = id_perfil;
    }
    
    
}
