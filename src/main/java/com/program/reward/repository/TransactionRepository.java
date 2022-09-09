package com.program.reward.repository;

import com.program.reward.model.MonthlyResponse;
import com.program.reward.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {


    @Query("select t from Transaction t where t.date >= ?1 and t.date <= ?2")
    List<Transaction> findTransactionsByDate(LocalDate startDate, LocalDate endDate);

    @Query("SELECT  new com.program.reward.model.MonthlyResponse(" +
            "t.customer.id, MONTHNAME(t.date) AS MonthName, YEAR(t.date) AS Year, " +
            "SUM(t.salesAmount) AS Sales ) FROM Transaction t GROUP BY customer, YEAR(t.date)," +
            " MONTHNAME(t.date),MONTH(date) order by Year(date) ")
    List<MonthlyResponse> getMonthlyReport();

    @Query("SELECT  new com.program.reward.model.MonthlyResponse(" +
            "t.customer.id, MONTHNAME(t.date) AS MonthName, YEAR(t.date) AS Year, " +
            "SUM(t.salesAmount) AS Sales ) FROM Transaction t where t.customer.id = ?1" +
            " GROUP BY customer, YEAR(t.date)," +
            " MONTHNAME(t.date),MONTH(date) order by Year(date) ")
    List<MonthlyResponse> getMonthlyReportByCustomerId(int id);

    @Query("SELECT  new com.program.reward.model.MonthlyResponse(" +
            "t.customer.id, MONTHNAME(t.date) AS MonthName, YEAR(t.date) AS Year, " +
            "SUM(t.salesAmount) AS Sales ) FROM Transaction t where t.date >= ?1 and t.date <= ?2" +
            " GROUP BY YEAR(t.date)," +
            " MONTHNAME(t.date),MONTH(date),customer order by Year(date) ")
    List<MonthlyResponse> getQuarterlyReport(LocalDate startDate, LocalDate endDate);
}
