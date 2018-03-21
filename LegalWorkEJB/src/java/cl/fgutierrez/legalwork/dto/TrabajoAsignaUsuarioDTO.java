/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fgutierrez.legalwork.dto;

import cl.fgutierrez.legalwork.entidades.Asignacion;
import cl.fgutierrez.legalwork.entidades.Trabajo;


public class TrabajoAsignaUsuarioDTO {

    private Trabajo trabajo;
    private Asignacion asigna;
    private UsuarioDTO usuario;

    public TrabajoAsignaUsuarioDTO() {
    }

    public TrabajoAsignaUsuarioDTO(Trabajo trabajo, Asignacion asigna, UsuarioDTO usuario) {
        this.trabajo = trabajo;
        this.asigna = asigna;
        this.usuario = usuario;
    }

    public Trabajo getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(Trabajo trabajo) {
        this.trabajo = trabajo;
    }

    public Asignacion getAsigna() {
        return asigna;
    }

    public void setAsigna(Asignacion asigna) {
        this.asigna = asigna;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }


    
    
}
