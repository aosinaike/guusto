package com.guusto.balance;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BalanceRepository extends JpaRepository<BalanceModel, Integer> {

    List<BalanceModel> findAll();

    List<BalanceModel> findAllByClientId(String clientId);
}
