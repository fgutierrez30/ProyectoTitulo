
package cl.fgutierrez.legalwork.persistencia;

import cl.fgutierrez.legalwork.entidades.Region;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class RegionSessionBean {

     @PersistenceContext(unitName = "LegalWorkEJBPU")
     private EntityManager em;
     
     
     @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Region>getAllRegion()
    {
        return em.createNamedQuery("Region.findAll", Region.class)
                 .getResultList();
    }
}
