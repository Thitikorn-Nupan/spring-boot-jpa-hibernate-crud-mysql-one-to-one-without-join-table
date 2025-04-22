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
    private String identity;
    private String born;
    private String address;

    // the @JoinColumn annotation to configure the name of the column in the identity_cards table
    // that maps to the primary key in the customers table.
    // Note in the next entity that we won’t use the @JoinColumn annotation there.
    // Because we only need it on the owning side of the foreign key relationship.
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cid", referencedColumnName = "cid")
    private Customer customer;

    public IdentityCard(String identity, String born, String address, Customer customer) {
        this.identity = identity;
        this.born = born;
        this.address = address;
        this.customer = customer;
    }

    public IdentityCard() {
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getBorn() {
        return born;
    }

    public void setBorn(String bornDate) {
        this.born = bornDate;
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
                "identity='" + identity + '\'' +
                ", born='" + born + '\'' +
                ", address='" + address + '\'' +
                ", customer=" + customer +
                '}';
    }
}
