package com.guusto;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GiftCardRepository extends JpaRepository<ClientGiftCardModel, Integer> {

    List<ClientGiftCardModel> findAll();

    ClientGiftCardModel findClientGiftCardModelByClientId(String clientId);

    @Query("update ClientGiftCardModel cg set cg.balance = :balance where cg.clientId = :clientId")
    ClientGiftCardModel updateBalance(String balance,String clientId);
}
