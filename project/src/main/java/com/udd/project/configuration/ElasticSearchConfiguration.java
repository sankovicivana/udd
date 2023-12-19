package com.udd.project.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;

@Configuration
public class ElasticSearchConfiguration  extends org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration {
    @Value("${elasticsearch.host}")
    private String host;

    @Value("${elasticsearch.port}")
    private int port;

    @Value("${elasticsearch.username}")
    private String userName;

    @Value("${elasticsearch.password}")
    private String password;
    
    @Override
    public ClientConfiguration clientConfiguration() {
        // TODO Auto-generated method stub
        return ClientConfiguration.builder().connectedTo(host + ":" + port)
        .withBasicAuth(userName, password).build();
    }
    
}
