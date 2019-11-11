package com.project.ms.stockprice.rest.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stock_price_table")
public class StockPrice {
	
	@Id
	@Column(name="stock_name")
	private String stockName;
	
	@Column(name="timestamp")
	private Timestamp timestamp;
	
	@Column(name="price")
	private float price;
	
	public StockPrice() {
		
	}

	public StockPrice(String stockName, float price) {
		this.stockName = stockName;
		this.price = price;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "StockPrice [stockName=" + stockName + ", timestamp=" + timestamp + ", price=" + price + "]";
	}
	
}
