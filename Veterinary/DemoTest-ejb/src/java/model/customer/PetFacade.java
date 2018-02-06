/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package model.customer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author abspk
 */
@Stateless
public class PetFacade extends AbstractFacade<Pet> {
    
    @PersistenceContext(unitName = "DemoTest-ejbPU")
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public PetFacade() {
        super(Pet.class);
    }
    
    public Pet getPet(long id) {
        Pet pet = null;
        Query q = em.createNamedQuery("findById");
        q.setParameter("id", id);
        try {
            pet = (Pet) q.getSingleResult();
            return pet;
        } catch(NoResultException x) {
            return null;
        }
    }
}
