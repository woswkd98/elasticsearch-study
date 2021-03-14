package com.example.demo.Config;

import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;


@EnableElasticsearchRepositories(
    basePackages = "com.example.demo.repository.elasticsearch"
)
public class ElasticsearchConfig 
    extends AbstractElasticsearchConfiguration   {
    
    @Override
    @Bean
    public RestHighLevelClient elasticsearchClient() {

        final ClientConfiguration clientConfiguration = ClientConfiguration.builder()  
            .connectedTo("localhost:9200", "locallhost:9201", "localhost:9202") // 여기부분은 내가 노드로 쓸 포트연걸을 다 해놓는 부분
            .build();

        return RestClients.create(clientConfiguration).rest();                         
    }
}
