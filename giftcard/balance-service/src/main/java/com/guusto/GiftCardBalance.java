package com.guusto;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
class GiftCardBalance extends GiftCardBalanceGrpc.GiftCardBalanceImplBase{

    @Autowired
    BalanceService balanceService;

    @Override
    public void processGiftCardRequest(GiftCardRequest request, StreamObserver<BalanceResponse> responseObserver) {
        BalanceModel balanceModel = balanceService.findBalanceByClientId(request.getClientId());

        if (balanceModel != null){
            if (Double.parseDouble(request.getTotalAmount()) > Double.parseDouble(balanceModel.getBalance())){
                responseObserver.onNext(BalanceResponse.newBuilder()
                        .setMessage("Insufficient fund").setStatus(false).build());
                responseObserver.onError(new Throwable("An unxpected error occured"));
                responseObserver.onCompleted();
            }else{
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
