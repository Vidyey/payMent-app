package com.EazyPay.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EazyPay.demo.entity.Wallet;

public interface WalletRepositoty extends JpaRepository<Wallet, String> {

}
