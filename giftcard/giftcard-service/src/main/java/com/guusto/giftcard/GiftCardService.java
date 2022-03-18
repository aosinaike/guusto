package com.guusto.giftcard;

import com.guusto.BalanceResponse;
import org.springframework.stereotype.Service;

import java.util.List;


public interface GiftCardService {

    List<GiftCardModel> findAll();

    BalanceResponse buyGiftCards(com.guusto.GiftCardRequest giftCardRequest);
}
