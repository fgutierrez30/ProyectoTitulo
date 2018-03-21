
package cl.fgutierrez.legalwork.dto;

import java.io.Serializable;


public class CiudadDTO implements Serializable{
    
    private int id_comuna;
    private String nom_ciudad;
    private int id_region;

    public CiudadDTO() {
    }

    public CiudadDTO(int id_comuna, String nom_ciudad, int id_region) {
        this.id_comuna = id_comuna;
        this.nom_ciudad = nom_ciudad;
        this.id_region = id_region;
    }

    public CiudadDTO(String nom_ciudad, int id_region) {
        this.nom_ciudad = nom_ciudad;
        this.id_region = id_region;
    }
    
    

    public int getId_comuna() {
        return id_comuna;
    }

    public void setId_comuna(int id_comuna) {
        this.id_comuna = id_comuna;
    }

    public String getNom_ciudad() {
        return nom_ciudad;
    }

    public void setNom_ciudad(String nom_ciudad) {
        this.nom_ciudad = nom_ciudad;
    }

    public int getId_region() {
        return id_region;
    }

    public void setId_region(int id_region) {
        this.id_region = id_region;
    }
    
    
    
}
