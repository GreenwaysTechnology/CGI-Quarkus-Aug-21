package org.acme.enity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @SequenceGenerator(name = "eventseq", sequenceName = "event_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "eventseq")
    private int eventId;
    @Column(name = "event_title")
    private String title;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "event_date")
    private Date eventDate;

    public Event() {
    }

    public Event(String title, Date eventDate) {
        this.title = title;
        this.eventDate = eventDate;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }
}
