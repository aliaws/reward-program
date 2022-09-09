package com.program.reward.repository;

import com.program.reward.model.MonthlyResponse;
import com.program.reward.model.Transaction;
import org.hibernate.query.NativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;


public interface TransactionRepository extends JpaRepository<Transaction, Integer> {


    @Query("select t from Transaction t where t.date >= ?1 and t.date <= ?2")
    List<Transaction> findTransactionsByDate(LocalDate startDate, LocalDate endDate);

    @Query(nativeQuery = true, value = "SELECT c.id, c.name, MONTHNAME(t.date) AS MonthName, YEAR(t.date) AS year1, " +
            " SUM(t.sales_amount) AS Sales, " +
            " sum(points), " +
            " sum( IF (sales_amount > 100, (sales_amount - 100)+(sales_amount-50), IF(sales_amount>50, (sales_amount-50), 0))) as point2 " +
            "FROM transaction t inner join customer c on t.customer_id = c.id GROUP BY YEAR(t.date), MONTHNAME(t.date), MONTH(t.date), c.id, c.name;")
//    NativeQuery<Object[]> objects = session
    List<Object[]> getMonthlyReport();
//    @Query("SELECT  new com.program.reward.model.MonthlyResponse(" +
//            " t.customer.id, t.customer.name, MONTHNAME(t.date) AS MonthName, YEAR(t.date) AS Year," +
//            " SUM(t.salesAmount) AS Sales, sum(if(t.salesAmount > 100, (t.salesAmount - 100)+(t.salesAmount-50), if(t.salesAmount>50, (t.salesAmount-50), 0))) as rewardPoints )" +
//            " FROM Transaction t GROUP BY YEAR(t.date)," +
//            " MONTHNAME(t.date), MONTH(t.date), t.customer.id, t.customer.name ")
//    List<MonthlyResponse> getMonthlyReport();

//    @Query("SELECT  new com.program.reward.model.MonthlyResponse(" +
//            " t.customer.id,t.customer.name, MONTHNAME(t.date) AS MonthName, YEAR(t.date) AS Year, " +
//            " SUM(t.salesAmount) AS Sales, sum(if(sales_amount > 100, (sales_amount - 100)+(sales_amount-50), if(sales_amount>50, (sales_amount-50), 0)  )) ) FROM Transaction t where t.customer.id = ?1" +
//            " GROUP BY YEAR(t.date)," +
//            " MONTHNAME(t.date),MONTH(date),t.customer.id,t.customer.name order by Year(date) ")
//    List<MonthlyResponse> getMonthlyReportByCustomerId(int id);
//
//    @Query("SELECT  new com.program.reward.model.MonthlyResponse(" +
//            " t.customer.id,t.customer.name, MONTHNAME(t.date) AS MonthName, YEAR(t.date) AS Year, " +
//            " SUM(t.salesAmount) AS Sales, sum(if(sales_amount > 100, (sales_amount - 100)+(sales_amount-50), if(sales_amount>50, (sales_amount-50), 0)  )) ) FROM Transaction t where t.date >= ?1 and t.date <= ?2" +
//            " GROUP BY YEAR(t.date)," +
//            " MONTHNAME(t.date), MONTH(date),customer.id,customer.name order by Year(date) ")
//    List<MonthlyResponse> getQuarterlyReport(LocalDate startDate, LocalDate endDate);
}
