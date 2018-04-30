package com.tgj.eventaid.models;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "artists")
public class Artist {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "INT(12) UNSIGNED")
    private long id;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)
    private BigDecimal costs;

    @Column(nullable = false)
    private boolean contract;

    @Column(nullable = false)
    private String contract_location;

    @Column
    private String notes;

    public Artist() {}

    public Artist(long id, String firstname, String lastname, BigDecimal costs, boolean contract, String contract_location, String notes) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.costs = costs;
        this.contract = contract;
        this.contract_location = contract_location;
        this.notes = notes;
    }

    public Artist(String firstname, String lastname, BigDecimal costs, boolean contract, String contract_location, String notes) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.costs = costs;
        this.contract = contract;
        this.contract_location = contract_location;
        this.notes = notes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public BigDecimal getCosts() {
        return costs;
    }

    public void setCosts(BigDecimal costs) {
        this.costs = costs;
    }

    public boolean isContract() {
        return contract;
    }

    public void setContract(boolean contract) {
        this.contract = contract;
    }

    public String getContract_location() {
        return contract_location;
    }

    public void setContract_location(String contract_location) {
        this.contract_location = contract_location;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
