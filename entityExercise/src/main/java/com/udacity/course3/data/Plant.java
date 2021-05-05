package com.udacity.course3.data;

import com.fasterxml.jackson.annotation.JsonView;
import com.udacity.course3.dto.View;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Plant {

    @Id
    @GeneratedValue
    private long id;

    @JsonView(View.Public.class)
    @Nationalized
    private String name;

    @JsonView(View.Public.class)
    @Column(precision = 12,scale = 4)
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_ID")
    private Delivery delivery;


    public Plant() {
    }

    public Plant(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public Plant( String name, BigDecimal price, Delivery delivery) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.delivery = delivery;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }
}
