package com.project.ms.stockprice.rest.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.ms.stockprice.rest.entity.StockPrice;
import com.project.ms.stockprice.rest.exception.handling.StockNotFoundException;

@Repository
public class StockPriceDAOImpl implements StockPriceDAO{
	
	@Autowired
    private EntityManager entityManager;
	
	private Session getSession() {
		return entityManager.unwrap(Session.class);
	}
	
	@Override
	public float getLatestPrice(String stockName) {
		
		Session session = getSession();
		
		Query<StockPrice> query = session.createQuery("from StockPrice s where UPPER(s.stockName)=UPPER(:stockName)");
		query.setParameter("stockName", stockName);
		
		StockPrice stockPrice = query.getSingleResult();
		
		if(stockPrice==null) {
			throw new StockNotFoundException("Stock not found");
		}
		
		return stockPrice.getPrice();
	}
	
	public List<StockPrice> getStocks(){
		
		List<StockPrice> listStockPrice = null;
		
		//getCurrent session
		Session session = getSession();
		
		Query<StockPrice> query = session.createQuery("from StockPrice",StockPrice.class);
		
		listStockPrice = query.getResultList();
		
		return listStockPrice;
		
	}
	
	public StockPrice saveOrUpdateStock(StockPrice theStock) {
		
		//getCurrent session
		Session session = getSession();
		
		session.saveOrUpdate(theStock);
		
		return theStock;
	}
}
