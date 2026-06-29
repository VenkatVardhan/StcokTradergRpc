package com.vardhan.stocktraderclient.service;

import com.javatechie.grpc.StockRequest;
import com.javatechie.grpc.StockResponse;
import com.javatechie.grpc.StockTradingServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class StockClientService {
    @GrpcClient("stockService") //any name
    private StockTradingServiceGrpc.StockTradingServiceBlockingStub serviceBlockingStub;
    //blocking stub is unary communication similar to native rest
    // grpc server has StockResponse method(StockRequest) so call that in the code using blocking stub
    //jj
    public StockResponse getStockPrice(String stockSymbol){
        StockRequest request = StockRequest.newBuilder().setStockSymbol(stockSymbol).build();
        StockResponse response = serviceBlockingStub.getStockPrice(request);
        System.out.println("response",response);
        return response;
    }


}
