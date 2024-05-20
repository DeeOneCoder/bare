package com.davidson.ActiveEdgeStocks;

import com.davidson.ActiveEdgeStocks.model.Stock;
import com.davidson.ActiveEdgeStocks.repository.StockRepository;
import com.davidson.ActiveEdgeStocks.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ActiveEdgeStocksApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ActiveEdgeStocksApplication.class, args);
	}

	@Autowired
	private StockService stockService;

	@Override
	public void run(String... args) throws Exception {


		stockService.createStocks();
	}
}
