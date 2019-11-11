package com.project.ms.stockprice.rest.service;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ms.stockprice.rest.dao.StockPriceDAO;
import com.project.ms.stockprice.rest.entity.StockPrice;

@Service
public interface StockPriceService {

	public float getLatestPrice(String stockName);
	public List<StockPrice> getStocks();
	public StockPrice saveOrUpdateStock(StockPrice theStock);
}
