package org.acme.entity;

import io.quarkus.agroal.DataSource;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;

@Entity
@DataSource("author")
public class Author extends PanacheEntity {
    public String name;
    public String city;
}
