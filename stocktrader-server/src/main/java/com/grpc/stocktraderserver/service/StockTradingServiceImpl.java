package com.grpc.stocktraderserver.service;

import com.javatechie.grpc.StockTradingServiceGrpc;
import com.javatechie.grpc.stockRequest;
import com.javatechie.grpc.stockResponse;
import io.grpc.stub.StreamObserver;
import org.springframework.grpc.server.service.GrpcService;

@GrpcService
public class StockTradingServiceImpl extends StockTradingServiceGrpc.StockTradingServiceImplBase {
    @Override
    public void getStockPrice(stockRequest request, StreamObserver<stockResponse> responseObserver) {
        super.getStockPrice(request, responseObserver);
    }
}
