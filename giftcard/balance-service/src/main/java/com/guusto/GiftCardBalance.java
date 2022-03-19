package com.guusto;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
class GiftCardBalance extends GiftCardBalanceGrpc.GiftCardBalanceImplBase{

    @Autowired
    GiftCardService giftCardService;

    @Override
    public void processGiftCardRequest(GiftCardRequest request, StreamObserver<BalanceResponse> responseObserver) {
        ClientGiftCardModel balanceModel = giftCardService.findBalanceByClientId(request.getClientId());
        if (balanceModel != null){
            if (Integer.parseInt(request.getTotalAmount()) > Integer.parseInt(balanceModel.getBalance())){
                responseObserver.onNext(BalanceResponse.newBuilder()
                        .setMessage("Insufficient fund").setStatus(false).build());
                responseObserver.onError(new Throwable("An unxpected error occured"));
                responseObserver.onCompleted();
            }else{
                int balance = Integer.parseInt(balanceModel.getBalance()) - Integer.parseInt(request.getTotalAmount())* request.getQuantity();
                giftCardService.updateBalance(Integer.toString(balance), balanceModel.getClientId());
                responseObserver.onNext(BalanceResponse.newBuilder()
                        .setMessage("Gift purchase was successful").setStatus(true).build());
                responseObserver.onError(new Throwable("An unxpected error occured"));
                responseObserver.onCompleted();
            }
        }else{
            responseObserver.onNext(BalanceResponse.newBuilder()
                    .setMessage("User Account not found").setStatus(false).build());
            responseObserver.onError(new Throwable("An unxpected error occured"));
            responseObserver.onCompleted();
        }
    }
}
