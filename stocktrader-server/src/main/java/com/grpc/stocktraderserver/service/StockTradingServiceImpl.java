package com.grpc.stocktraderserver.service;

import com.grpc.stocktraderserver.entity.Stock;
import com.grpc.stocktraderserver.repository.StockRepository;
import com.javatechie.grpc.*;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.grpc.server.service.GrpcService;

@GrpcService
public class StockTradingServiceImpl extends StockTradingServiceGrpc.StockTradingServiceImplBase {
    private final StockRepository stockRepository;
    public StockTradingServiceImpl(StockRepository stockRepository){
        this.stockRepository=stockRepository;
    }


    @Override
    public void getStockPrice(StockRequest request, StreamObserver<StockResponse> responseObserver) {


        String stockSymbol  = request.getStockSymbol();
        Stock stockEntity = stockRepository.getByStockSymbol(stockSymbol);
        StockResponse response = StockResponse.newBuilder().setPrice(stockEntity.getPrice()).setStockSymbol(stockEntity.getStockSymbol())
                .setTimestamp(stockEntity.getLastUpdated().toString()).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}

