
package cl.fgutierrez.legalwork.dto;

import java.io.Serializable;


public class ComunaDTO implements Serializable{
    
    private int id_comuna;
    private String nom_comuna;
    private int id_ciudad;

    public ComunaDTO() {
    }

    public ComunaDTO(int id_comuna, String nom_comuna, int id_ciudad) {
        this.id_comuna = id_comuna;
        this.nom_comuna = nom_comuna;
        this.id_ciudad = id_ciudad;
    }

    public ComunaDTO(String nom_comuna, int id_ciudad) {
        this.nom_comuna = nom_comuna;
        this.id_ciudad = id_ciudad;
    }

    public int getId_comuna() {
        return id_comuna;
    }

    public void setId_comuna(int id_comuna) {
        this.id_comuna = id_comuna;
    }

    public String getNom_comuna() {
        return nom_comuna;
    }

    public void setNom_comuna(String nom_comuna) {
        this.nom_comuna = nom_comuna;
    }

    public int getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(int id_ciudad) {
        this.id_ciudad = id_ciudad;
    }
    
    
}
