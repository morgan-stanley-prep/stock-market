package com.project.ms.stockprice.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.ms.stockprice.rest.entity.StockPrice;
import com.project.ms.stockprice.rest.service.StockPriceService;

@RestController
@RequestMapping("/api")
public class StockPriceController {
	
	@Autowired
	private StockPriceService stockPriceService;
	
	@GetMapping("/stocks")
	public List<StockPrice> getStocks(){
		return stockPriceService.getStocks();
	}
	
	@GetMapping("/price/{stockName}")
	public float getStockLatestPrice(@PathVariable("stockName") String stockName) {
		return stockPriceService.getLatestPrice(stockName);
	}

}
