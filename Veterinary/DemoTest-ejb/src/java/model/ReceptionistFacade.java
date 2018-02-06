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
public class ReceptionistFacade extends AbstractFacade<Receptionist> {

    @PersistenceContext(unitName = "DemoTest-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReceptionistFacade() {
        super(Receptionist.class);
    }
    
    public boolean getLogin(String email, String pwd) {
        Receptionist m = null;
        Query q = em.createNamedQuery("Receptionist.findByEmail");
        //Query q = em.createQuery("SELECT e FROM Manager e WHERE e.email = :email");
        q.setParameter("email", email);
        try {
            m = (Receptionist) q.getSingleResult();
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
}
