package com.project.ms.stockprice;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.config.DiscoveryStrategyConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.spi.properties.GroupProperty;
import com.hazelcast.zookeeper.ZookeeperDiscoveryProperties;
import com.hazelcast.zookeeper.ZookeeperDiscoveryStrategyFactory;

@Configuration
public class HazelcastConfiguration {
	@Bean
	public HazelcastInstance getHazelcastInstance(ClientConfig configuration) {
		return HazelcastClient.newHazelcastClient(configuration);
	}
	
	@Bean
	public ClientConfig getClientConfig(DiscoveryStrategyConfig discoveryStrategyConfig) {
		ClientConfig config = new ClientConfig();
		config.getNetworkConfig().getAwsConfig().setEnabled(false);
		config.setProperty(GroupProperty.DISCOVERY_SPI_ENABLED.getName(), "true");
		
		config.getNetworkConfig().getDiscoveryConfig().addDiscoveryStrategyConfig(discoveryStrategyConfig);
		
		return config;
	}
	
	@Bean
	public DiscoveryStrategyConfig getDiscoveryConfig(
			@Value("${zookeeper_ip_address}") String zookeeperUrl, 
			@Value("${zookeeper_port}") String zookeeperPort, 
			@Value("${zookeeper_path}") String zookeeperPath,
			@Value("${hazelcast_group}") String hazelcastGroup) {
		
		DiscoveryStrategyConfig discoverStrategyConfig = new DiscoveryStrategyConfig(new ZookeeperDiscoveryStrategyFactory());
		discoverStrategyConfig.addProperty(ZookeeperDiscoveryProperties.ZOOKEEPER_URL.key(), zookeeperUrl + ":" + zookeeperPort);
		discoverStrategyConfig.addProperty(ZookeeperDiscoveryProperties.ZOOKEEPER_PATH.key(), zookeeperPath);
		discoverStrategyConfig.addProperty(ZookeeperDiscoveryProperties.GROUP.key(), hazelcastGroup);
		
		return discoverStrategyConfig;
	}
}
