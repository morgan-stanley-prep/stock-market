package com.project.ms.stockprice.rest.controller;
//
//import java.net.InetAddress;
//import java.net.ServerSocket;
//import java.net.UnknownHostException;
//import java.sql.Timestamp;
//import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.withzookeeper.entities.StockPrice;
import com.project.ms.stockprice.rest.service.StockPriceService;

@RestController
@RequestMapping("/api")
public class StockPriceController {
	
	@Autowired
	private StockPriceService stockPriceService;
	
	@Autowired
	private HazelcastInstance client;
	
	@GetMapping("/stocks")
	public List<StockPrice> getStocks(){
		return stockPriceService.getStocks();
	}

	// load all
//	IMap<String, StockPrice> map = server.getMap("stocksMap");
//	// load
//	StockPrice p = map.get("RAYMOND");
//	StockPrice p1 = map.get("igl");
//	// load all keys
//	Set<String> stock_names = map.keySet();
	
	@GetMapping("/getstocknames")
	public Set<String> getStockNames() throws InterruptedException{
		IMap<String, StockPrice> map = client.getMap("stocksMap");
		
		Set<String> stock_names = map.keySet();
		map.lock("Raymond");
		try {
			
			StockPrice stocknames = map.get("Raymond");
			Thread.sleep(20);
			stocknames.setPrice(20);
			map.put("Raymond", stocknames);
		}
		finally {
			map.unlock("Raymond");
		}
		return stock_names;
	}
	
	@GetMapping("/port")
	public int getPortNo(HttpServletRequest req){
		return req.getLocalPort();
	}
	 
	@GetMapping("/stocks/{stockName}")
	public StockPrice getStock(@PathVariable("stockName") String stockName) {
		//return stockPriceService.getStock(stockName);
		IMap<String,StockPrice> map = client.getMap("stocksMap");
		//map.set("city", "Hyderabad");
        StockPrice stock = map.get(stockName);
        
        System.out.println("City is: " + stock);
        return stock;
	}
	
	@GetMapping("stocks/price/{stockName}")
	public float getStockLatestPrice(@PathVariable("stockName") String stockName) {
//		Lock lock = client.getLock("stocksMap");
//		lock.lock();
//		try {
			IMap<String,StockPrice> map = client.getMap("stocksMap");
			StockPrice stock = map.get(stockName);
			
			return stock.getPrice();
//		} finally {
//		    lock.unlock();
//		} 
		 
		//return stockPriceService.getLatestPrice(stockName);
	}
	
	@DeleteMapping("/stocks/{stockName}")
	public StockPrice deleteStock(@PathVariable("stockName") String stockName) {
		//return stockPriceService.deleteStock(stockName);
		return null;
	}
	
	@PostMapping("/stocks")
	public StockPrice addOrUpdate(@RequestBody StockPrice theStock) {
//		theStock.setTimestamp(getCurrentTimeStamp());
//		long time = System.currentTimeMillis();
//		Timestamp timestamp = new Timestamp(time);
//		System.out.println(getCurrentTimeStamp());
//		theStock.setTimestamp(timestamp);
		//return stockPriceService.saveOrUpdateStock(theStock);
		return null;
	}
	
	private static java.sql.Timestamp getCurrentTimeStamp() {

		java.util.Date today = new java.util.Date();
		return new java.sql.Timestamp(today.getTime());

	}

}
