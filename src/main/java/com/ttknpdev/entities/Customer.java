package com.ttknpdev.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    private String cid;
    private String firstname;
    private String lastname;

    // @OneToOne(mappedBy = "customer") // *** it mapped to private Customer <customer>; clear!!
    // @JsonIgnore // you have to choose some One entity. which entity you will use @OneToOne ?
    // private IdentityCard identityCard;

    public Customer(String cid, String firstname, String lastname) {
        this.cid = cid;
        this.firstname = firstname;
        this.lastname = lastname;
        // this.identityCard = identityCard;
    }

    public Customer() {
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    // public IdentityCard getIdentityCard() {return identityCard;}

    // public void setIdentityCard(IdentityCard identityCard) {this.identityCard = identityCard;}

    @Override
    public String toString() {
        return "Customer{" +
                "cid='" + cid + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
