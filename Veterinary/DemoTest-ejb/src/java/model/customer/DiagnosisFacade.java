/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package model.customer;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author abspk
 */
@Stateless
public class DiagnosisFacade extends AbstractFacade<Diagnosis> {
    
    @PersistenceContext(unitName = "DemoTest-ejbPU")
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public DiagnosisFacade() {
        super(Diagnosis.class);
    }
    
    public Diagnosis getDiagnosis(long id) {
        Query q = em.createNamedQuery("Diagnosis.findById");
        q.setParameter("id", id);
        Diagnosis d = null;
        
        try {
            d = (Diagnosis) q.getSingleResult();
            return d;
        } catch(Exception x) {
            return null;
        }
    }
    
    public List<Diagnosis> getListDiagnosis(long id) {
        Query q = em.createNamedQuery("Diagnosis.findById");
        q.setParameter("id", id);
        List<Diagnosis> d = null;
        
        try {
            d = q.getResultList();
            return d;
        } catch(Exception x) {
            return null;
        }
    }
    
    public boolean validateDiagnosis(String email) {
        Query q = em.createNamedQuery("Diagnosis.findByEmail");
        q.setParameter("customer", email);
        Diagnosis d = null;
        
        try {
            d = (Diagnosis) q.getSingleResult();
            if(d != null) {
                return true;
            }
        } catch(Exception x) {
            return false;
        }
        return false;
    }
}
