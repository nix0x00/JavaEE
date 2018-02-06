/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author abspk
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Vet.findByEmail", query = "SELECT e FROM Vet e WHERE e.email = :email"),
})
public class Vet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String email;

    private String firstName;
    private String lastName;
    private String pwd;
    private String speciality;
    private String secondSpeciality;
    private final String type = "vet";

    public String getType() {
        return type;
    }


    public String getSecondSpeciality() {
        return secondSpeciality;
    }

    /*public void setType(String type) {
    this.type = type;
    }*/
    
    public void setSecondSpeciality(String secondSpeciality) {
        this.secondSpeciality = secondSpeciality;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String latName) {
        this.lastName = latName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (email != null ? email.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vet)) {
            return false;
        }
        Vet other = (Vet) object;
        if ((this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Vet[ id=" + email + " ]";
    }
    
}
