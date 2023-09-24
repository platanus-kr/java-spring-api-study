package com.project.springapistudy.beverages.domain;

import com.project.springapistudy.commons.domain.BaseTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Beverage extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private long price;

    @Column(nullable = false)
    private boolean deleted;

    public Beverage(String name, Long price) {
        this.name = name;
        this.price = price;
        this.deleted = false;
    }

    public Beverage() {

    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getPrice() {
        return price;
    }

    public void update(Beverage beverage) {
        this.name = beverage.getName();
        this.price = beverage.getPrice();
    }

    public void delete() {
        this.deleted = true;
    }
}
