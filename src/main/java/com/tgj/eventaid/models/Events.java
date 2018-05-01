package com.tgj.eventaid.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "events")
public class Events {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Date start_date;

    @Column(nullable = false)
    private Date end_date;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String url;

    @OneToOne  // relationship to events.id
    @JoinColumn (name = "venue_id")
    private Venues venue_id;

    // id must be in relationship to the users_events pivot table, and event_id on event_tickets
    @ManyToMany
    @JoinTable(
            name = "users_events",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<Users> users;


    public Events(long id, String name, Date start_date, Date end_date, String location, String url, Venues venue_id) {

        this.id = id;
        this.name = name;
        this.start_date = start_date;
        this.end_date = end_date;
        this.location = location;
        this.url = url;
        this.venue_id = venue_id;
    }

    public Events(String name, Date start_date, Date end_date, String location, String url, Venues venue_id) {
        this.name = name;
        this.start_date = start_date;
        this.end_date = end_date;
        this.location = location;
        this.url = url;
        this.venue_id = venue_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Venues getVenue_id() {
        return venue_id;
    }

    public void setVenue_id(Venues venue_id) {
        this.venue_id = venue_id;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }
}