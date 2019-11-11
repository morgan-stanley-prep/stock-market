package com.project.ms.stockprice.rest.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.ms.stockprice.rest.entity.StockPrice;

@Repository
public class StockPriceDAOImpl implements StockPriceDAO{
	
	@Autowired
    private EntityManager entityManager;
	
	private Session getSession() {
		return entityManager.unwrap(Session.class);
	}
	
	@Override
	public float getLatestPrice(String stockName) {
		return 0;
	}
	
	public List<StockPrice> getStocks(){
		
		List<StockPrice> listStockPrice = null;
		
		//getCurrent session
		Session session = getSession();
		
		Query<StockPrice> query = session.createQuery("from StockPrice",StockPrice.class);
		
		listStockPrice = query.getResultList();
		
		return listStockPrice;
		
	}
}
