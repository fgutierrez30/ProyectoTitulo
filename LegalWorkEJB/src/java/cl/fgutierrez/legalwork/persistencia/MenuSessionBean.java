/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fgutierrez.legalwork.persistencia;

import cl.fgutierrez.legalwork.entidades.Perfil;
import cl.fgutierrez.legalwork.dto.MenuPerfilDTO;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Felipe
 */
@Stateless
public class MenuSessionBean {

   @PersistenceContext(unitName = "LegalWorkEJBPU")
   private EntityManager em;
   
   
   @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
   public List<MenuPerfilDTO>listadoMenuXPerfil(int codigoPerfil)
   {
      Perfil objPerfilCodigo=em.find(Perfil.class, codigoPerfil);
      return em.createNamedQuery("Menu.getXPerfil",MenuPerfilDTO.class).setParameter("perfilCodigo",objPerfilCodigo)
              .getResultList();
   }
}
