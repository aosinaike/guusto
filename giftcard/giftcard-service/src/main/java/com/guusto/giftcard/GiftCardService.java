package com.guusto.giftcard;

import com.guusto.BalanceResponse;
import org.springframework.stereotype.Service;

import java.util.List;


public interface GiftCardService {

    List<CardTransactionModel> findAll();

    CardTransactionModel buyGift(com.guusto.GiftCardRequest giftCardRequest);
}
