
package cl.fgutierrez.legalwork.dto;

import cl.fgutierrez.legalwork.entidades.Ciudad;
import cl.fgutierrez.legalwork.entidades.Region;
import java.io.Serializable;


public class RegionCiudadDTO implements Serializable{
    
    private Region region;
    private Ciudad ciudad;

    public RegionCiudadDTO() {
    }

    public RegionCiudadDTO(Region region, Ciudad ciudad) {
        this.region = region;
        this.ciudad = ciudad;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
    
    
    
}
