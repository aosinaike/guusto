package com.guusto.giftcard;

import com.guusto.BalanceResponse;
import com.guusto.GiftCardBalanceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GiftCardServiceImpl implements GiftCardService{
    @GrpcClient("guusto-balance")
    GiftCardBalanceGrpc.GiftCardBalanceBlockingStub GiftCardBalanceClient;

    private CardTransactionRepository repository ;

    @Autowired
    public GiftCardServiceImpl(CardTransactionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CardTransactionModel> findAll() {
        return repository.findAll();
    }

    @Override
    public CardTransactionModel buyGift(com.guusto.GiftCardRequest giftCardRequest) {
        BalanceResponse response =  GiftCardBalanceClient.processGiftCardRequest(giftCardRequest);
        if (response.getStatus()){
            CardTransactionModel transaction = new CardTransactionModel();
            transaction.setAmount(giftCardRequest.getTotalAmount());
            int balance = giftCardRequest.getQuantity()*Integer.getInteger(giftCardRequest.getTotalAmount())-Integer.getInteger(response.getBalance());
            transaction.setBalance(Integer.toString(balance));
            transaction.setGift(giftCardRequest.getGiftCard());
            transaction.setQuantity(giftCardRequest.getQuantity());
            return repository.save(transaction);
        }
        return null;
    }
}
