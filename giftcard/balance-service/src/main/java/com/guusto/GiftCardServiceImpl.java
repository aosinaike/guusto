package com.guusto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GiftCardServiceImpl implements GiftCardService{

    private GiftCardRepository repository;

    public GiftCardServiceImpl(GiftCardRepository repository) {
        this.repository = repository;
    }

    @Override
    public ClientGiftCardModel findBalanceByClientId(String clientId) {
        return repository.findClientGiftCardModelByClientId(clientId);
    }

    @Override
    public ClientGiftCardModel updateBalance(String balance, String clientId) {
        return repository.updateBalance(balance, clientId);
    }
}
