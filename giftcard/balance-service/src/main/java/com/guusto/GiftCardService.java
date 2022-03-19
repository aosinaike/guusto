package com.guusto;

import org.springframework.stereotype.Service;

import java.util.List;


public interface GiftCardService {

    ClientGiftCardModel findBalanceByClientId(String clientId);
    ClientGiftCardModel updateBalance(String balance, String clientId);
}
