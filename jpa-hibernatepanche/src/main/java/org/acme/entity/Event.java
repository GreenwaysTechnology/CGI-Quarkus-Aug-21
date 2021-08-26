package org.acme.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "events")
public class Event extends PanacheEntity {
    @Column(name = "event_title")
    public String title;
    @Column(name = "event_date")
    public Date eventDate;



    //custom api
    public static Event findByTitle(String title) {
        return find("title", title).firstResult();
    }


}
