package com.project.ms.stockprice;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

@SpringBootApplication
public class StockpriceApplication {

	public static void main(String[] args) {
		//SpringApplication.run(StockpriceApplication.class, args);
		ConfigurableApplicationContext context = SpringApplication.run(StockpriceApplication.class, args);
		HazelcastInstance client = context.getBean(HazelcastInstance.class);
		
		IMap<String, String> map = client.getMap("map");
		//map.set("city", "Hyderabad");
        String city = map.get("city");
        
        System.out.println("City is: " + city);
        
//        StockPriceSupplier supplier = new StockPriceSupplier();
//        supplier.checkSomething();
	}

}
