
package cl.fgutierrez.legalwork.persistencia;

import cl.fgutierrez.legalwork.dto.CiudadDTO;
import cl.fgutierrez.legalwork.entidades.Ciudad;
import cl.fgutierrez.legalwork.entidades.Region;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class CiudadSessionBean {

    @PersistenceContext(unitName = "LegalWorkEJBPU")
    private EntityManager em;
    
    public void addCiudad(CiudadDTO infoCiudadDTO) throws ControladorExceptions
    {
        Ciudad objCiudad=new Ciudad();
        
        objCiudad.setNomCiudad(infoCiudadDTO.getNom_ciudad());
        Region objRegion=em.find(Region.class, infoCiudadDTO.getId_region());
        objCiudad.setIdRegion(objRegion);
        
        em.persist(objCiudad);
        
        
    }
    
     @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Ciudad>getAllCiudad()
    {
        return em.createNamedQuery("Ciudad.findAll", Ciudad.class)
                 .getResultList();
    }
    
}
