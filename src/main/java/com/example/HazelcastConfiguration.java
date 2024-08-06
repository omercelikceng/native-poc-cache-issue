package com.example;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.config.ClientNetworkConfig;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration("hazelcastConfiguration")
public class HazelcastConfiguration {

    @Value("${hazelcast.addresses}")
    private String addresses;

    @Bean("hazelcastClientConfig")
    public ClientConfig hazelcastClientConfig() {
        return configureClientConfig();
    }

    private ClientConfig configureClientConfig() {
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.setClusterName("dev");
        ClientNetworkConfig clientNetworkConfig = clientConfig.getNetworkConfig();

        List<String> addressList = new ArrayList<String>(Arrays.asList(addresses.split(",")));
        clientNetworkConfig.setAddresses(addressList);
        clientNetworkConfig.setSmartRouting(true);
        clientNetworkConfig.setRedoOperation(true);
        clientNetworkConfig.setConnectionTimeout(Integer.MAX_VALUE);

        return clientConfig;
    }

    @Bean("hazelcastClient")
    HazelcastInstance hazelcastClient(@Autowired ClientConfig hazelcastClientConfig) {
        return HazelcastClient.newHazelcastClient(hazelcastClientConfig);
    }
}
