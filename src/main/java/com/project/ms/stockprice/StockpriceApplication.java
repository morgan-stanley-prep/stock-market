package com.project.ms.stockprice;

import java.util.concurrent.locks.Lock;

import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.withzookeeper.entities.StockPrice;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.project.ms.stockprice"})
@EntityScan(basePackages = {"com.hazelcast.withzookeeper.entities"})
public class StockpriceApplication {

	public static void main(String[] args) {
		//SpringApplication.run(StockpriceApplication.class, args);
		ConfigurableApplicationContext context = SpringApplication.run(StockpriceApplication.class, args);
		HazelcastInstance client = context.getBean(HazelcastInstance.class);
		//Lock lock = client.getLock(myLockedObject);

		IMap<String,StockPrice> map = client.getMap("stocksMap");
		//map.set("city", "Hyderabad");
        StockPrice city = map.get("Raymond");
        
        System.out.println("City is: " + city);
        
//        StockPriceSupplier supplier = new StockPriceSupplier();
//        supplier.checkSomething();
	}

}