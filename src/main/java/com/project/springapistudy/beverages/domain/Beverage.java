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
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private Long price;

    @Column(nullable = false)
    private Boolean deleted;

    public Beverage(String name, Long price) {
        this.name = name;
        this.price = price;
        this.deleted = false;
    }

    public Beverage() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getPrice() {
        return price;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void update(Beverage beverage) {
        this.name = beverage.getName();
        this.price = beverage.getPrice();
    }

    public void delete() {
        this.deleted = true;
    }
}
