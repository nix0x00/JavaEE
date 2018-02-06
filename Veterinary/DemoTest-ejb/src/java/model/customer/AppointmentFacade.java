/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package model.customer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Vet;

/**
 *
 * @author abspk
 */
@Stateless
public class AppointmentFacade extends AbstractFacade<Appointment> {
    
    @PersistenceContext(unitName = "DemoTest-ejbPU")
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public AppointmentFacade() {
        super(Appointment.class);
    }
    
    public List<Appointment> getAppointment(String name) {
        Query q = em.createNamedQuery("findByCustName");
        List<Appointment> appointment = null;
        q.setParameter("name", name);
        
        try {
            appointment = q.getResultList();
            
        } catch(NoResultException exception) {
            return null;
        }
        
        return appointment;
    }
    
    public List<Appointment> getAppointment(long id) {
        List<Appointment> ap = null;
        Query q = em.createNamedQuery("Appointment.findById");
        q.setParameter("id", id);
        try {
            ap = q.getResultList();
            return ap;
        } catch(NoResultException x) {
            return null;
        }
    }
    
    public boolean ifExists(Date date) {
        Query q = em.createNamedQuery("findByDate");
        q.setParameter("date", date);
        Appointment ap = null;
        
        try {
            ap = (Appointment) q.getSingleResult();
            if(ap != null) {
                return true;
            }
        } catch(NoResultException x) {
            return false;
        }
        return false;
    }
    
    public Appointment getSingleAppointment(Date date) {
        Appointment ap = null;
        Query q = em.createNamedQuery("findByDate");
        q.setParameter("date", date);
        try {
            ap = (Appointment) q.getSingleResult();
            return ap;
        } catch(NoResultException x) {
            return null;
        }
    }
    
    public Appointment getSingleAppointment(long id) {
        Appointment ap = null;
        Query q = em.createNamedQuery("Appointment.findById");
        q.setParameter("id", id);
        try {
            ap = (Appointment) q.getSingleResult();
            return ap;
        } catch(NoResultException x) {
            return null;
        }
    }
    
    public List<Appointment> getVet(String email) {
        List<Appointment> vet = null;
        Query q = em.createNamedQuery("Appointment.findByEmail");
        q.setParameter("email", email);
        
        try {
            vet = q.getResultList();
            return vet;
        } catch(NoResultException x) {
            return null;
        }
    }
    
    public List<Appointment> getPrice() {
        List<Appointment> appoint = null;
        Query q = em.createNamedQuery("Appointment.findByPrice");
        
        try {
            appoint = q.getResultList();
            return appoint;
        } catch(NoResultException x) {
            return null;
        }
    }
}
