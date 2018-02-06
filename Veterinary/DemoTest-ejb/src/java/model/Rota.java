/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author abspk
 */
@Entity
public class Rota implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date rotaDate;

    private String firstVet;
    private String secondVet;
    private String thirdVet;
    private String rotaDay;

    public String getFirstVet() {
        return firstVet;
    }

    public void setFirstVet(String firstVet) {
        this.firstVet = firstVet;
    }

    public String getSecondVet() {
        return secondVet;
    }

    public void setSecondVet(String secondVet) {
        this.secondVet = secondVet;
    }

    public String getThirdVet() {
        return thirdVet;
    }

    public void setThirdVet(String thirdVet) {
        this.thirdVet = thirdVet;
    }

    
    public Date getRotaDate() {
        return rotaDate;
    }

    public void setRotaDate(Date rotaDate) {
        this.rotaDate = rotaDate;
    }

    public String getRotaDay() {
        return rotaDay;
    }

    public void setRotaDay(String rotaDay) {
        this.rotaDay = rotaDay;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rotaDate != null ? rotaDate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the rotaDate fields are not set
        if (!(object instanceof Rota)) {
            return false;
        }
        Rota other = (Rota) object;
        if ((this.rotaDate == null && other.rotaDate != null) || (this.rotaDate != null && !this.rotaDate.equals(other.rotaDate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Rota[ id=" + rotaDate + " ]";
    }
    
}
