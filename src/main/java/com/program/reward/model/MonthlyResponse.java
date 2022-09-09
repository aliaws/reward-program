package com.program.reward.model;

import static com.program.reward.model.HelperClass.calculateRewardPoints;

public class MonthlyResponse {
    public int customerId;
    public double salesAmount;
    public double rewardPoints;
    public String month;
    int year;

    public MonthlyResponse(int customerId, String month, int year, double salesAmount) {
        this.customerId = customerId;
        this.month = month;
        this.salesAmount = salesAmount;
        this.year = year;
        this.rewardPoints = calculateRewardPoints(salesAmount);
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
