package edu.pjatk.s19701.model;

import jakarta.persistence.*;

import java.util.UUID;

//marks class as ann entity
@Entity
//specifies the table name where data of this entity is persisted
//if not specified Hibernate will use Class name as default
@Table(name = "Clinic")
public class Clinic {

    //marks the identifier (primary key) for this entity
    @Id
    //GenerationType.UUID specifies that a UUID should be
    //  generated automatically by the persistence provider (here Hibernate)
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    //UUID is globally unique
    private UUID id;

    //specifies the details of the column or field
    //if not specified, the property name will be specified as the column name by default
    @Column(name = "address", nullable = false)
    private String address;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
