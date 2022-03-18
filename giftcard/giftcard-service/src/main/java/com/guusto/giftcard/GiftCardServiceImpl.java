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

    private GiftCardRepository giftCardRepository ;

    @Autowired
    public GiftCardServiceImpl(GiftCardRepository giftCardRepository) {
        this.giftCardRepository = giftCardRepository;
    }

    @Override
    public List<GiftCardModel> findAll() {
        return giftCardRepository.findAll();
    }

    @Override
    public BalanceResponse buyGiftCards(com.guusto.GiftCardRequest giftCardRequest) {
        return GiftCardBalanceClient.processGiftCardRequest(giftCardRequest);
    }
}
