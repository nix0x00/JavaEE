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
public class ManagerFacade extends AbstractFacade<Manager> {
    
    @PersistenceContext(unitName = "DemoTest-ejbPU")
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public ManagerFacade() {
        super(Manager.class);
    }
    
    public boolean getLogin(String email, String password) {
        Query q = em.createNamedQuery("Manager.findByEmail");
        Manager m = null;
        //Query q = em.createQuery("SELECT e FROM Manager e WHERE e.email = :email");
        q.setParameter("email", email);
        try {
            m = (Manager) q.getSingleResult();
        } catch(NoResultException x) {
            return false;
        }
        
        if(m != null) {
            if(m.getPwd().equals(password)) {
                return true;
            }
        }
        return false;
    }
    
}
