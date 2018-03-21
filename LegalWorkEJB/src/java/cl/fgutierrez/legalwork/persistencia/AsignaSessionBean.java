
package cl.fgutierrez.legalwork.persistencia;

import cl.fgutierrez.legalwork.dto.TrabajoAsignaUsuarioDTO;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Felipe
 */
@Stateless
public class AsignaSessionBean {

      @PersistenceContext(unitName = "LegalWorkEJBPU")
   
       private EntityManager em;
      
      public void addAsignacion (TrabajoAsignaUsuarioDTO asigna) throws ControladorExceptions
      {
          
      }
}
