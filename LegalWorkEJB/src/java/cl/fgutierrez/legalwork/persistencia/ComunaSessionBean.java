
package cl.fgutierrez.legalwork.persistencia;

import cl.fgutierrez.legalwork.dto.ComunaDTO;
import cl.fgutierrez.legalwork.entidades.Ciudad;
import cl.fgutierrez.legalwork.entidades.Comuna;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ComunaSessionBean {

   @PersistenceContext(unitName = "LegalWorkEJBPU")
    private EntityManager em;
   
   public void addComuna(ComunaDTO infoComunaDTO)
   {
       Comuna objComuna=new Comuna();
       objComuna.setNomComuna(infoComunaDTO.getNom_comuna());
       Ciudad objCiudad=em.find(Ciudad.class, infoComunaDTO.getId_ciudad());
       objComuna.setIdCiudad(objCiudad);
       em.persist(objComuna);
   }
   
     @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Comuna>getAllComuna()
    {
        return em.createNamedQuery("Comuna.findAll", Comuna.class)
                 .getResultList();
    }
   
}
