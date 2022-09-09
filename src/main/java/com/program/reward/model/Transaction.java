package com.program.reward.model;

import javax.persistence.*;
import java.time.LocalDate;

import static com.program.reward.model.HelperClass.calculateRewardPoints;

@Entity
@Table(name = "transactions")
public class Transaction {



    public float salesAmount;
    public float rewardPoints;
    public LocalDate date;
    public float quantity;
    public String month;
    @Id
    public int id;
    @ManyToOne()
    @JoinColumn(name = "customer_id")
    Customer customer;

    public Transaction() {
    }

    //    public Transaction(float salesAmount, LocalDate date, float quantity, Customer customer, int id, String month) {
    public Transaction(int id, Customer customer, LocalDate date, String month, float quantity, float salesAmount) {
        this.id = id;
        this.salesAmount = salesAmount;
        this.date = date;
        this.quantity = quantity;
        this.customer = customer;
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

    public float getRewardPoints() {
        return rewardPoints;
    }

    public void setRewardPoints(float rewardPoints) {
        this.rewardPoints = rewardPoints;
    }
}
