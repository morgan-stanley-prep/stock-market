package com.project.ms.stockprice.rest.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ms.stockprice.rest.dao.StockPriceDAO;
import com.project.ms.stockprice.rest.entity.StockPrice;

@Service
public class StockPriceServiceImpl implements StockPriceService {

	@Autowired
	private StockPriceDAO stockPriceDAO;
	
	public float getLatestPrice(String stockName) {
		return stockPriceDAO.getLatestPrice(stockName);
		
	}
	@Transactional
	public List<StockPrice> getStocks(){
		return stockPriceDAO.getStocks();
	}
}
