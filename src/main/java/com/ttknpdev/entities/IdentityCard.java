package com.ttknpdev.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "identity_cards")
public class IdentityCard {
    /*
    cid_number VARCHAR(13) ,
    born_date date,
    address VARCHAR(60),
    cid VARCHAR(4),
    */
    @Id
    private String cidNumber;
    private String bornDate;
    private String address;
    @OneToOne(cascade = CascadeType.ALL)
    // the @JoinColumn annotation to configure the name of the column in the identity_cards table
    // that maps to the primary key in the customers table.
    // Note in the next entity that we won’t use the @JoinColumn annotation there.
    // Because we only need it on the owning side of the foreign key relationship.
    @JoinColumn(name = "cid", referencedColumnName = "cid")
    private Customer customer;

    public IdentityCard(String cidNumber, String bornDate, String address, Customer customer) {
        this.cidNumber = cidNumber;
        this.bornDate = bornDate;
        this.address = address;
        this.customer = customer;
    }

    public IdentityCard() {
    }

    public String getCidNumber() {
        return cidNumber;
    }

    public void setCidNumber(String cidNumber) {
        this.cidNumber = cidNumber;
    }

    public String getBornDate() {
        return bornDate;
    }

    public void setBornDate(String bornDate) {
        this.bornDate = bornDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "IdentityCard{" +
                "cidNumber='" + cidNumber + '\'' +
                ", bornDate='" + bornDate + '\'' +
                ", address='" + address + '\'' +
                ", customer=" + customer +
                '}';
    }
}
