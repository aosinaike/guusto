package com.guusto.balance;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BalanceService {

    List<BalanceModel> findAll();

    List<BalanceModel> findAllByClientId(String clientId);

    List<BalanceResponse> processGiftCardRequest(GiftCardRequest giftCardRequest);
}
