package com.tgj.eventaid.models;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private long id;

    @NotBlank(message = "Must have First Name")
    @Column(nullable = false)
    private String firstname;

    @NotBlank(message = "Must have Last Name")
    @Column(nullable = false)
    private String lastname;

    @NotBlank(message = "Must have an address")
    @Column(nullable = false)
    private String address;

    @NotBlank(message = "Must have Email")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "Must have Password")
    @Column(nullable = false)
    private String password;

    @NotBlank(message = "Must have Phone number")
    @Column(nullable = false)
    private String telephone;

    @Column
    private LocalDateTime created_on;

    @Column() // switched this to nullable
    private boolean owner;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user_id")
    private List<Ticket> eventTickets;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Event> userEvents;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private List<Event> events;

    public User() {
    }

    public User(String firstname, String lastname, String address, String email, String password, String telephone, LocalDateTime created_on, boolean owner, List<Ticket> eventTickets, List<Event> events, List<Event> userEvents) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.email = email;
        this.password = password;
        this.telephone = telephone;
        this.created_on = created_on;
        this.owner = owner;
        this.eventTickets = eventTickets;
        this.events = events;
        this.userEvents = userEvents;
    }

    // Security Config
    public User(User copy) {
        id = copy.id;
        firstname = copy.firstname;
        lastname = copy.lastname;
        address = copy.address;
        email = copy.email;
        password = copy.password;
        telephone = copy.telephone;
        created_on = copy.created_on;
        owner = copy.owner;
        eventTickets = copy.eventTickets;
        events = copy.events;
        userEvents = copy.userEvents;
    }

    public List<Event> getUserEvents() {
        return userEvents;
    }

    public void setUserEvents(List<Event> userEvents) {
        this.userEvents = userEvents;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public boolean isOwner() {
        return owner;
    }

    public void setOwner(boolean owner) {
        this.owner = owner;
    }

    public LocalDateTime getCreated_on() {
        return created_on;
    }

    public void setCreated_on(LocalDateTime created_on) {
        this.created_on = created_on;
    }

    public List<Ticket> getEventTickets() {
        return eventTickets;
    }

    public void setEventTickets(List<Ticket> eventTickets) {
        this.eventTickets = eventTickets;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
