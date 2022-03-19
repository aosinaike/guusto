package com.guusto.giftcard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardTransactionRepository extends JpaRepository<CardTransactionModel, Integer> {

    CardTransactionModel save(CardTransactionModel cardTransactionModel);
    List<CardTransactionModel> findAllById(Integer id);
}
