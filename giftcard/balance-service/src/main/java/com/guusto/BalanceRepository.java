package com.guusto;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BalanceRepository extends JpaRepository<BalanceModel, Integer> {

    List<BalanceModel> findAll();

    BalanceModel findBalanceByClientId(String clientId);
}
