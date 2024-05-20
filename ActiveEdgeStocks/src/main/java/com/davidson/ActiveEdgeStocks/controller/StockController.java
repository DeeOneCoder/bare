package com.davidson.ActiveEdgeStocks.controller;

import com.davidson.ActiveEdgeStocks.model.Stock;
import com.davidson.ActiveEdgeStocks.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class StockController {

    private final StockService stockService;

    @GetMapping("/stocks")
    public ModelAndView getAllStock(){
        ModelAndView allStock = new ModelAndView("all-stock");
        List<Stock> stocks = stockService.getAllStock();
        allStock.addObject("stocks", stocks);
        return allStock;
    }

    @GetMapping("/stocks-f")
    public ModelAndView getStock(){
        ModelAndView newStock = new ModelAndView("new-stock");
        Stock stock = new Stock();
        newStock.addObject("stock", stock);
        return newStock;
    }

    @GetMapping("/stocks/{id}")
    public ModelAndView getAllStock(@PathVariable int id){
        ModelAndView singleStock = new ModelAndView("stock-d");
        Stock stock = stockService.getSingleStock(id);
        singleStock.addObject("stock", stock);
        return singleStock;
    }



    @PutMapping("/stocks/{id}")
    public ModelAndView updateStock(@PathVariable int id ){
        ModelAndView newStock = new ModelAndView("new-stock");
        Stock stock = new Stock();
        newStock.addObject("stock", stock);
        return newStock;
    }

    @PostMapping("/stocks")
    public ModelAndView createStock(@ModelAttribute Stock freshStock){
        ModelAndView newStock = new ModelAndView("new-stock");
        Stock stock = stockService.createStock(freshStock);
        newStock.addObject("freshStock", freshStock);
        return getAllStock();
    }
}
