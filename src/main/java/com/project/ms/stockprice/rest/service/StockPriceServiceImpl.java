package com.project.ms.stockprice.rest.service;

import java.util.List;


import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.hazelcast.withzookeeper.entities.StockPrice;
import com.project.ms.stockprice.rest.dao.StockPriceDAO;

@Service
public class StockPriceServiceImpl implements StockPriceService {

	@Autowired
	private StockPriceDAO stockPriceDAO;
	
	//@Cacheable(value="stocksCache",key="#stockName",unless="#result==null")
	@Transactional
	public float getLatestPrice(String stockName) {
		return stockPriceDAO.getLatestPrice(stockName);
		
	}

	@Transactional
	public List<StockPrice> getStocks(){
		return stockPriceDAO.getStocks();
	}

	@Transactional
	public StockPrice saveOrUpdateStock(StockPrice theStock) {
		return stockPriceDAO.saveOrUpdateStock(theStock);
	}

	@Transactional
	public StockPrice deleteStock(String stockName) {
		return stockPriceDAO.deleteStock(stockName);
	}

	@Transactional
	public StockPrice getStock(String stockName) {
		return stockPriceDAO.getStock(stockName);
	}
}
