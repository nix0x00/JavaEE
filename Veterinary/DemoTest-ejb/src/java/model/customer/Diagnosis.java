/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package model.customer;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import model.Staff;
import model.Vet;

/**
 *
 * @author abspk
 */
@NamedQueries({
    @NamedQuery(name = "Diagnosis.findById", query = "SELECT e FROM Diagnosis e WHERE e.id = :id"),
    @NamedQuery(name = "Diagnosis.findByEmail", query = "SELECT e FROM Diagnosis e WHERE e.customer = :customer"),
})
@Entity
public class Diagnosis implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    private String lastFed;
    
    @OneToOne(cascade = {CascadeType.REMOVE})
    private Pet pet;
    @OneToOne(cascade = {CascadeType.REMOVE})
    private Customer customer;
    @OneToOne(cascade = {CascadeType.REMOVE})
    private Appointment appointment;
    @OneToOne(cascade = {CascadeType.REMOVE})
    private Vet vet;
    @OneToOne(cascade = {CascadeType.REMOVE})
    private Staff staff;

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }
    
    public Vet getVet() {
        return vet;
    }
    
    public void setVet(Vet vet) {
        this.vet = vet;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getLastFed() {
        return lastFed;
    }
    
    public void setLastFed(String lastFed) {
        this.lastFed = lastFed;
    }
    
    public Pet getPet() {
        return pet;
    }
    
    public void setPet(Pet pet) {
        this.pet = pet;
    }
    
    public Customer getCustomer() {
        return customer;
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public Appointment getAppointment() {
        return appointment;
    }
    
    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }
    
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diagnosis)) {
            return false;
        }
        Diagnosis other = (Diagnosis) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "model.customer.Diagnosis[ id=" + id + " ]";
    }
}
