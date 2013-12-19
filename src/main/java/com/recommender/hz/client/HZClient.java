package com.recommender.hz.client;

import java.util.List;
import java.util.Map;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;

public class HZClient {

	

	public static Map<Integer, List<Integer>> loadUserProductMap(){
		return getHZClientInstance().getMap("userProductMap");
	}
	
	private static HazelcastInstance getHZClientInstance(){
		ClientConfig clientConfig = new ClientConfig();
		clientConfig.getGroupConfig().setName("dev").setPassword("dev-pass");
		clientConfig.addAddress("10.100.8.55", "10.100.8.56:5701");
		
		HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);
		return client;
	}
	
	public static Map<Integer, String> loadIDProductMap(){
		return getHZClientInstance().getMap("idProductMap");
	}
	
	public static Map<String, Integer> loadIDUserMap(){
		return getHZClientInstance().getMap("idUserMap");
	}
	
}
