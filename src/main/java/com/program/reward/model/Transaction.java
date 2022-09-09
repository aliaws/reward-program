package com.program.reward.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "transactions")
public class Transaction {

    public float salesAmount;
    public LocalDate date;
    public float quantity;
    public String month;
    @ManyToOne()
    Customer customer;
    @Id
    private int id;

    public Transaction() {
    }

    public Transaction(float salesAmount, LocalDate date, float quantity, Customer customer, int id, String month) {
        this.salesAmount = salesAmount;
        this.date = date;
        this.quantity = quantity;
        this.customer = customer;
        this.id = id;
        this.month = month;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public float getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(float salesAmount) {
        this.salesAmount = salesAmount;
    }

    public int getYear() {
        return this.date.getYear();
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
