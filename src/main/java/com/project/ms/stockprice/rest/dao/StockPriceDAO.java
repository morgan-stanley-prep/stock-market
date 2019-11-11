package com.project.ms.stockprice.rest.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.project.ms.stockprice.rest.entity.StockPrice;

@Repository
public interface StockPriceDAO {
	
	public float getLatestPrice(String stockName);
	public List<StockPrice> getStocks();
	public StockPrice saveOrUpdateStock(StockPrice theStock);
}
