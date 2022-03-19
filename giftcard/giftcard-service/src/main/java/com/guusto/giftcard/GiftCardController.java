package com.guusto.giftcard;

import com.guusto.BalanceResponse;
import com.guusto.GiftCardRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController("/guusto-service")
@Secured("ROLE_USER")
public class GiftCardController {

    @Autowired
    GiftCardService giftCardService;

    @GetMapping("/transactions")
    public ResponseEntity<List<CardTransactionModel>> fetchAllCardTransactionGifts(){
        try {
            List<CardTransactionModel> transactionList = giftCardService.findAll();
            if (transactionList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(transactionList, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/buy-gift")
    public ResponseEntity<CardTransactionModel> buyGifts(@RequestBody GiftCardRequest giftCardRequest){
        try {
            CardTransactionModel response = giftCardService.buyGift(giftCardRequest);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
