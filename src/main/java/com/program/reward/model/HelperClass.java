package com.program.reward.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HelperClass {

    public static HashMap<String, LocalDate> getDatesLimit(int monthNumber, boolean monthlyFormat) {
        String dateFormat = "2016-" + monthNumber + "-01";
        LocalDate startDate = LocalDate.parse(dateFormat, DateTimeFormatter.ofPattern("yyyy-M-dd"));

        monthNumber = monthlyFormat ? monthNumber : monthNumber + 2;
        dateFormat = "2016-" + monthNumber + "-01";

        LocalDate endDate = LocalDate.parse(dateFormat, DateTimeFormatter.ofPattern("yyyy-M-dd"));
        endDate = endDate.withDayOfMonth(endDate.getMonth().length(endDate.isLeapYear()));

        HashMap<String, LocalDate> dates = new HashMap<>();
        dates.put("startDate", startDate);
        dates.put("endDate", endDate);
        return dates;
    }

    public static List<Reward> getTransactions(List<Transaction> transactions) {
        List<Reward> salesReward = new ArrayList<>();
        for (Transaction transaction : transactions) {
            LocalDate date = transaction.getDate();
            int customerId = transaction.getCustomer().getId();
            float salesAmount = transaction.getSalesAmount();
//            float rewardPoints = calculateRewardPoints(salesAmount);
            salesReward.add(new Reward(date, customerId, salesAmount));
        }
        return salesReward;
    }

    public static float calculateRewardPoints(float salesAmount) {
        float rewardPoints = salesAmount > 50 ? salesAmount - 50 : 0;
        rewardPoints += salesAmount > 100 ? salesAmount - 100 : 0;
        return (float) (Math.round(rewardPoints * 10)) / 10;
    }

    public static float calculateRewardPoints(double salesAmount) {
        double rewardPoints = salesAmount > 50 ? salesAmount - 50 : 0;
        rewardPoints += salesAmount > 100 ? salesAmount - 100 : 0;
        return (float) (Math.round(rewardPoints * 10)) / 10;
    }
}
