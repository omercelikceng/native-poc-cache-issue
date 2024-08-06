package com.example;

import com.hazelcast.core.HazelcastInstance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Service;

@Service("cacheServiceImpl")
public class CacheServiceImpl implements SmartLifecycle {

	@Autowired
	@Qualifier("hazelcastClient")
	private HazelcastInstance hazelcastClient;

	private static final String CACHE_MAP_KEY = "CACHE_MAP_KEY";
	private static final String OBJECT_KEY = "OBJECT_KEY";

	@Override
	public void start() {
		hazelcastClient.getMap(CACHE_MAP_KEY).put(OBJECT_KEY, "Omer");
		String value = (String) hazelcastClient.getMap(CACHE_MAP_KEY).get(OBJECT_KEY);
		System.out.println(value);
	}

	@Override
	public void stop() {

	}

	@Override
	public boolean isRunning() {
		return false;
	}
}
