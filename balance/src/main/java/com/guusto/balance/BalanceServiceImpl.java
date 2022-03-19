package com.guusto.balance;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BalanceServiceImpl implements  BalanceService{

    @Autowired
    GrpcServerService grpcServerService;

    @Override
    public List<BalanceModel> findAll() {
        return null;
    }

    @Override
    public List<BalanceModel> findAllByClientId(String clientId) {
        return null;
    }

    @Override
    public List<BalanceResponse> processGiftCardRequest(GiftCardRequest giftCardRequest) {
        return null;
    }
}
