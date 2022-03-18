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

    @GetMapping("/gifts")
    public ResponseEntity<List<GiftCardModel>> fetchAllCardGifts(){
        try {
            List<GiftCardModel> giftCardModelList = new ArrayList<>();
            giftCardService.findAll().forEach(giftCardModelList::add);
            if (giftCardModelList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(giftCardModelList, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/buy-gift")
    public ResponseEntity<BalanceResponse> buyGiftCardGifts(@RequestBody GiftCardRequest giftCardRequest){
        try {
            BalanceResponse balanceResponse = giftCardService.buyGiftCards(giftCardRequest);
            return new ResponseEntity<>(balanceResponse, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
