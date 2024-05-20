package com.davidson.ActiveEdgeStocks.repository;

import com.davidson.ActiveEdgeStocks.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {
}
