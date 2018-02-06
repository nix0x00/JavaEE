/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.customer;

import java.util.List;
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
public class BoardingFacade extends AbstractFacade<Boarding> {

    @PersistenceContext(unitName = "DemoTest-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BoardingFacade() {
        super(Boarding.class);
    }
    
    public List<Boarding> getBoardingAppointment(long id) {
        List<Boarding> b = null;
        Query q = em.createNamedQuery("Boarding.findById");
        q.setParameter("id", id);
        try {
            b = q.getResultList();
            return b;
        } catch(NoResultException x) {
            return null;
        }
    }
    
    public Boarding getBoardingObject(long id) {
        Query q = em.createNamedQuery("Boarding.findById");
        q.setParameter("id", id);
        Boarding b = null;
        try {
            b = (Boarding) q.getSingleResult();
            return b;
        } catch(Exception x) {
            return null;
        }
    }
}
