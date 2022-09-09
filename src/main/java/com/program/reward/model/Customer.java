package com.program.reward.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {
    public String name;
    @OneToMany(mappedBy = "customer")
    List<Transaction> transactions;
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    public Customer() {
    }

    public Customer(String name, List<Transaction> transactions, int id) {
        this.name = name;
        this.transactions = transactions;
        this.id = id;
    }

    public Customer(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
