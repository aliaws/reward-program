package com.program.reward.model;

import java.time.LocalDate;

import static com.program.reward.model.HelperClass.calculateRewardPoints;

public class Reward {
    public LocalDate date;
    public float salesAmount;
    public int customerId;
    public float rewardPoints;

    public Reward(LocalDate date, int customerId, float salesAmount) {
        this.date = date;
        this.salesAmount = salesAmount;
        this.customerId = customerId;
        this.rewardPoints = calculateRewardPoints(salesAmount);
    }
}
