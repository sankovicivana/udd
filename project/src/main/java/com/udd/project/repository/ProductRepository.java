package com.udd.project.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.udd.project.indexmodel.Product;

public interface ProductRepository extends ElasticsearchRepository<Product, Integer> {
    
}
