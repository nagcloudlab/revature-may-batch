package com.example.entity;

// JPA

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue
    private int id;
    private String name;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "emp_addresses")
    private List<Address> addresses;

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    // custom type
//    @Embedded
//    private Address homeAddress;
//
//    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(name = "street", column = @Column(name = "offi_street")),
//            @AttributeOverride(name = "city", column = @Column(name = "offi_city")),
//            @AttributeOverride(name = "country", column = @Column(name = "offi_country"))
//    })
//    private Address officeAddress;


//    public Address getOfficeAddress() {
//        return officeAddress;
//    }
//
//    public void setOfficeAddress(Address officeAddress) {
//        this.officeAddress = officeAddress;
//    }
//
//    public Address getHomeAddress() {
//        return homeAddress;
//    }
//
//    public void setHomeAddress(Address homeAddress) {
//        this.homeAddress = homeAddress;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addresses=" + addresses +
                '}';
    }
}
