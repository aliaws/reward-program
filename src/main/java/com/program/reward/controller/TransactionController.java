package com.program.reward.controller;


import com.program.reward.model.HelperClass;
import com.program.reward.model.MonthlyResponse;
import com.program.reward.model.Reward;
import com.program.reward.model.Transaction;
import com.program.reward.repository.TransactionRepository;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.object.SqlQuery;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
@RequestMapping("transactions")
public class TransactionController {

    @Autowired
    TransactionRepository transactionRepository;

    @GetMapping("/page={pageNumber}")
    public Page<Transaction> getAllTransactions(@PathVariable @Min(1) int pageNumber) {
        return transactionRepository.findAll(Pageable.ofSize(1000).withPage(pageNumber - 1));
//        return transactionRepository.findAll();
    }

//    @GetMapping("/page={pageNumber}")
//    public Page<Transaction> getAllTransactions(@PathVariable @Min(1) int pageNumber) {
//        return transactionRepository.findAll(Pageable.ofSize(1000).withPage(pageNumber - 1));
//    }

    @GetMapping("/id={id}")
    public Optional<Transaction> getTransactionById(@PathVariable @Min(1) int id) {
        return transactionRepository.findById(id);

    }


    @GetMapping("/of-month={monthNumber}")
    public List<Reward> getMonthlyTransactions(@PathVariable @Min(1) @Max(12) int monthNumber) {
        HashMap<String, LocalDate> dates = HelperClass.getDatesLimit(monthNumber, true);
        List<Transaction> transactions = transactionRepository.findTransactionsByDate(dates.get("startDate"), dates.get("endDate"));
        return HelperClass.getTransactions(transactions);
//        return transactionRepository.findAll(Pageable.ofSize(1000).withPage(pageNumber - 1));
    }

    @GetMapping("/from-month={monthNumber}")
    public List<Reward> getQuarterlyTransactions(@PathVariable @Min(1) @Max(12) int monthNumber) {
        HashMap<String, LocalDate> dates = HelperClass.getDatesLimit(monthNumber, false);
        List<Transaction> transactions = transactionRepository.findTransactionsByDate(dates.get("startDate"), dates.get("endDate"));
        return HelperClass.getTransactions(transactions);
    }

    /**
     * this is a GET request and returns monthly-total for each customer
     * @return List
     */
    @GetMapping("/monthly-total")
    public List<Object[]> getMonthlyReport(){
        return transactionRepository.getMonthlyReport();
//    public List<Object[]> getMonthlyReport() {
////        @Query(nativeQuery = true, value = "SELECT c.id, c.name, MONTHNAME(t.date) AS MonthName, YEAR(t.date) AS year1, " +
////            " SUM(t.sales_amount) AS Sales, " +
////            " sum(points), " +
////            " sum(if(sales_amount > 100, (sales_amount - 100)+(sales_amount-50), if(sales_amount>50, (sales_amount-50), 0))) " +
////            "FROM transaction t inner join customer c on t.customer_id = c.id GROUP BY YEAR(t.date), MONTHNAME(t.date), MONTH(t.date), c.id, c.name")
////    NativeQuery<Object[]> objects = session
//Session session =  sessionFactory.getCurrentSession();
//        SqlQuery<Object[]> query = (SqlQuery<Object[]>) session.createSQLQuery("SELECT MONTHNAME(t.date) AS MonthName, YEAR(t.date) AS Year, " +
//                "            SUM(t.sales_amount) AS Sales, " +
//                "            sum(points), " +
//                "            sum(if(sales_amount > 100, (sales_amount - 100)+(sales_amount-50), if(sales_amount>50, (sales_amount-50), 0)  )) " +
//                "FROM transaction t GROUP BY YEAR(t.date), MONTHNAME(t.date), MONTH(t.date), c.id, c.name");
//        return query.execute().stream().toList();
//        return transactionRepository.getMonthlyReport();
//        return transactions;
    }


    /**
     * this method takes a query string parameter as input and return monthly total for a customer in the year
     * @param  customerId
     * @return List<MonthlyResponse>
     */
//    @GetMapping("/monthly-total/customer={customerId}")
//    public List<MonthlyResponse> getMonthlyReportByCustomerId(@PathVariable @Min(1) int customerId) {
//        return transactionRepository.getMonthlyReportByCustomerId(customerId);
//    }
//
//    @GetMapping("/quarter-month={monthNumber}")
//    public List<MonthlyResponse> getQuarterlyReport(@PathVariable @Min(1) @Max(10) int monthNumber) {
//        HashMap<String, LocalDate> dates = HelperClass.getDatesLimit(monthNumber, false);
//        return transactionRepository.getQuarterlyReport(dates.get("startDate"), dates.get("endDate"));
//    }
}
