package com.program.reward.model;

import java.time.LocalDate;

public class Reward {
    public LocalDate date;
    public float salesAmount;
    public int customerId;
    public float rewardPoints;

    public Reward(LocalDate date, int customerId, float salesAmount, float rewardPoints) {
        this.date = date;
        this.salesAmount = salesAmount;
        this.customerId = customerId;
        this.rewardPoints = rewardPoints;
    }
}
