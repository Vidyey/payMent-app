package com.EazyPay.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EazyPay.demo.entity.Transaction_Details;

public interface TransactionRepositoty extends JpaRepository<Transaction_Details, String> {

}
