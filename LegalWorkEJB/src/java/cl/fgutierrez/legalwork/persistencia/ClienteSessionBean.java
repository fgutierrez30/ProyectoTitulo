
package cl.fgutierrez.legalwork.persistencia;

import cl.fgutierrez.legalwork.entidades.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;


@Stateless
public class ClienteSessionBean {

 @PersistenceContext(name = "LegalWorkEJBPU")
 
 private EntityManager em;
 
 @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
 public List<Cliente>getAllCliente()
 {
     return em.createNamedQuery("Cliente.findAll", Cliente.class)
              .getResultList();
 }
 
 public void addCliente(Cliente infoCliente)throws ControladorExceptions
 {
     em.persist(infoCliente);
 }
 
 
   public Cliente buscarClienteXRut(String rut)
    {
        Cliente infoCliente=null;
        try{
            infoCliente=em.createNamedQuery("Cliente.findByRutCliente",Cliente.class)
                         .setParameter("rutCliente", rut)
                         .getSingleResult();
            
        }catch(NoResultException ex){
            return null;
        }catch(NonUniqueResultException ex){
            throw ex;
        }
        return infoCliente;
    }
 
 public void updateCliente(Cliente infoPerfil) throws ControladorExceptions
    {
        em.merge(infoPerfil);
    }
 
}
