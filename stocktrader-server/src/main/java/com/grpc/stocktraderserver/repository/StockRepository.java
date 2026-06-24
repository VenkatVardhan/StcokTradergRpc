package com.grpc.stocktraderserver.repository;

import com.grpc.stocktraderserver.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StockRepository extends JpaRepository<Stock,Long> {
    Stock getByStockSymbol(String stockSymbol);
}
