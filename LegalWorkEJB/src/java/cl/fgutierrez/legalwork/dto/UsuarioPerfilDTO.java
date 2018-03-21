
package cl.fgutierrez.legalwork.dto;

import cl.fgutierrez.legalwork.entidades.Perfil;
import cl.fgutierrez.legalwork.entidades.Usuario;


public class UsuarioPerfilDTO {
    
    private Usuario usuario;
    private Perfil perfil;

    public UsuarioPerfilDTO() {
    }

    public UsuarioPerfilDTO(Usuario usuario, Perfil perfil) {
        this.usuario = usuario;
        this.perfil = perfil;
    }

    public Usuario getUsr() {
        return usuario;
    }

    public void setUsr(Usuario usr) {
        this.usuario = usr;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
    
    
    
}
