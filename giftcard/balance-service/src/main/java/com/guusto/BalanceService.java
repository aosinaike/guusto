package com.guusto;

import org.springframework.stereotype.Service;

import java.util.List;


public interface BalanceService {

    BalanceModel findBalanceByClientId(String clientId);
}
