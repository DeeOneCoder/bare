package com.davidson.ActiveEdgeStocks.service;

import com.davidson.ActiveEdgeStocks.model.Stock;
import com.davidson.ActiveEdgeStocks.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StockService {

    private final StockRepository stockRepository;

    public List<Stock> getAllStock(){
        return stockRepository.findAll();
    }

    public Stock getSingleStock(int number){
        return stockRepository.findById(number).get();
    }

    public Stock updateStock(int id, Stock updateValue ){
        Stock fromDB = getSingleStock(id);
        fromDB.setCurrentPrice(updateValue.getCurrentPrice());
        fromDB.setLastUpdate(new Date(System.currentTimeMillis()));
        return stockRepository.save(fromDB);
    }

    public Stock createStock(Stock stock){
        stock.setCreateDate(new Date(System.currentTimeMillis()));
        stock.setLastUpdate(new Date(System.currentTimeMillis()));
        return stockRepository.save(stock);
    }

    public void createStocks(){
        List<Stock> stockList = new ArrayList<>();
        Stock stock = new Stock(1, "Computer", 98.50, new Date(System.currentTimeMillis()),  new Date(System.currentTimeMillis()));
        Stock stock1 = new Stock(2, "Tablet", 28.50, new Date(System.currentTimeMillis()),  new Date(System.currentTimeMillis()));
        stockList.add(stock);
        stockList.add(stock1);
        stockList.forEach(this::createStock);
    }

}
