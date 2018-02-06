/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package model;

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
public class VetFacade extends AbstractFacade<Vet> {
    
    @PersistenceContext(unitName = "DemoTest-ejbPU")
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public VetFacade() {
        super(Vet.class);
    }
    
    public boolean getLogin(String user, String pwd) {
        Vet m = null;
        Query q = em.createNamedQuery("Vet.findByEmail");
        //Query q = em.createQuery("SELECT e FROM Manager e WHERE e.email = :email");
        q.setParameter("email", user);
        try {
            m = (Vet) q.getSingleResult();
        } catch(NoResultException x) {
            return false;
        }
        if(m != null) {
            if(m.getPwd().equals(pwd)) {
                return true;
            }
        }
        return false;
    }
    
    public Vet getVet(String email) {
        Vet v = null;
        Query q = em.createNamedQuery("Vet.findByEmail");
        q.setParameter("email", email);
        try {
            v = (Vet) q.getSingleResult();
            return v;
        } catch(NoResultException ex) {
            return null;
        }
        
    }
}
