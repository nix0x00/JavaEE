/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.customer;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import model.Vet;

/**
 *
 * @author abspk
 */
@NamedQueries({
    @NamedQuery(name = "findByCustName", query = "SELECT e FROM Appointment e WHERE e.custName = :name"),
    @NamedQuery(name = "findByDate", query = "SELECT e FROM Appointment e WHERE e.appointmentDate = :date"),
    @NamedQuery(name = "Appointment.findById", query = "SELECT e FROM Appointment e WHERE e.id = :id"),
    @NamedQuery(name = "Appointment.deleteById", query = "DELETE FROM Appointment e WHERE e.id = :id"),
    @NamedQuery(name = "Appointment.findByEmail", query = "SELECT e FROM Appointment e WHERE e.vetEmail = :email"),
    @NamedQuery(name = "Appointment.findByPrice", query = "SELECT e FROM Appointment e"),
})
@Entity
public class Appointment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date appointmentDate;
    
    private double price;
    private String custName;
    private String custEmail;
    private String tel;
    private String petName;
    private String type;
    private String service;
    private String vetEmail;
    @OneToOne(cascade = {CascadeType.REMOVE})
    private Customer customer;
    @OneToOne(cascade = {CascadeType.REMOVE})
    private Pet pet;
    @OneToOne(cascade = {CascadeType.REMOVE})
    private Vet vet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustEmail() {
        return custEmail;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getVetEmail() {
        return vetEmail;
    }

    public void setVetEmail(String vetEmail) {
        this.vetEmail = vetEmail;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Vet getVet() {
        return vet;
    }

    public void setVet(Vet vet) {
        this.vet = vet;
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
        if (!(object instanceof Appointment)) {
            return false;
        }
        Appointment other = (Appointment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.customer.Appointment[ id=" + id + " ]";
    }
}