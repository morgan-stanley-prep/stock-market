package com.project.ms.stockprice.rest.controller;
//
//import java.net.InetAddress;
//import java.net.ServerSocket;
//import java.net.UnknownHostException;
//import java.sql.Timestamp;
//import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/port")
	public int getPortNo(HttpServletRequest req){
		return req.getLocalPort();
	}
	
	@GetMapping("/stocks/{stockName}")
	public StockPrice getStock(@PathVariable("stockName") String stockName) {
		return stockPriceService.getStock(stockName);
	}
	
	@GetMapping("stocks/price/{stockName}")
	public float getStockLatestPrice(@PathVariable("stockName") String stockName) {
		return stockPriceService.getLatestPrice(stockName);
	}
	
	@DeleteMapping("/stocks/{stockName}")
	public StockPrice deleteStock(@PathVariable("stockName") String stockName) {
		return stockPriceService.deleteStock(stockName);
	}
	
	@PostMapping("/stocks")
	public StockPrice addOrUpdate(@RequestBody StockPrice theStock) {
//		theStock.setTimestamp(getCurrentTimeStamp());
//		long time = System.currentTimeMillis();
//		Timestamp timestamp = new Timestamp(time);
//		System.out.println(getCurrentTimeStamp());
//		theStock.setTimestamp(timestamp);
		return stockPriceService.saveOrUpdateStock(theStock);
	}
	
	private static java.sql.Timestamp getCurrentTimeStamp() {

		java.util.Date today = new java.util.Date();
		return new java.sql.Timestamp(today.getTime());

	}

}
