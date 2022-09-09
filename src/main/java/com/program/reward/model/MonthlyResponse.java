package com.program.reward.model;

import static com.program.reward.model.HelperClass.calculateRewardPoints;

public class MonthlyResponse {
    public int customerId;
    public String customerName;
    public double salesAmount;
    public double rewardPoints;
    public String month;
    int year;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public MonthlyResponse(int customerId, String customerName, String month, int year, double salesAmount, double rewardPoints) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.month = month;
        this.salesAmount = salesAmount;
        this.year = year;
        this.rewardPoints = rewardPoints;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public double getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(double salesAmount) {
        this.salesAmount = salesAmount;
    }

    public double getRewardPoints() {
        return rewardPoints;
    }

    public void setRewardPoints(double rewardPoints) {
        this.rewardPoints = rewardPoints;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
