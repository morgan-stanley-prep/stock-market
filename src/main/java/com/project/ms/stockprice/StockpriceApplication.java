package com.project.ms.stockprice;

import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.withzookeeper.entities.StockPrice;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.hazelcast.withzookeeper.caching"})
public class StockpriceApplication {

	public static void main(String[] args) {
		//SpringApplication.run(StockpriceApplication.class, args);
		ConfigurableApplicationContext context = SpringApplication.run(StockpriceApplication.class, args);
		HazelcastInstance client = context.getBean(HazelcastInstance.class);
		
		IMap<String,StockPrice> map = client.getMap("stocksMap");
		//map.set("city", "Hyderabad");
        StockPrice city = map.get("Raymond");
        
        System.out.println("City is: " + city);
        
//        StockPriceSupplier supplier = new StockPriceSupplier();
//        supplier.checkSomething();
	}

}