package com.program.reward.controller;


import com.program.reward.model.HelperClass;
import com.program.reward.model.MonthlyResponse;
import com.program.reward.model.Reward;
import com.program.reward.model.Transaction;
import com.program.reward.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

@RestController
@RequestMapping("transactions")
public class TransactionController {

    @Autowired
    TransactionRepository transactionRepository;

    @GetMapping("/page={pageNumber}")
    public Page<Transaction> getAllTransactions(@PathVariable @Min(1) int pageNumber) {
        return transactionRepository.findAll(Pageable.ofSize(1000).withPage(pageNumber - 1));
    }

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

    @GetMapping("/monthly-total")
    public List<MonthlyResponse> getMonthlyReport() {
//        transactionRepository.findAll()
//                .parallelStream()
//                .map(transaction ->
//                        new MonthlyResponse(transaction.getCustomer().getId(), transaction.getMonth(), transaction.getYear(), transaction.salesAmount)
//                ).collect(
//                        Collectors.toMap(
//                                map -> map.getCustomerId(),
//                                Function.identity(),
//                                (customer1, customer2) -> new MonthlyResponse(customer1.getCustomerId(), customer1.getMonth(),
//                                        customer1.getYear(), customer1.getSalesAmount()
//                                ))
//                );
        return transactionRepository.getMonthlyReport();
    }

    @GetMapping("/monthly-total/user={id}")
    public List<MonthlyResponse> getMonthlyReportByCustomerId(@PathVariable @Min(1) int id) {
        return transactionRepository.getMonthlyReportByCustomerId(id);
    }

    @GetMapping("/quarter-month={monthNumber}")
    public List<MonthlyResponse> getQuarterlyReport(@PathVariable @Min(1) @Max(10) int monthNumber) {
        HashMap<String, LocalDate> dates = HelperClass.getDatesLimit(monthNumber, false);
        return transactionRepository.getQuarterlyReport(dates.get("startDate"), dates.get("endDate"));
    }
}
