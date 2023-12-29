package com.udd.cls.service;


import co.elastic.clients.elasticsearch._types.query_dsl.BoolQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;

import org.springframework.stereotype.Service;
import com.udd.cls.dto.SearchDTO;
import com.udd.cls.indexmodel.ContractIndex;

import org.elasticsearch.common.unit.Fuzziness;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.client.elc.NativeQueryBuilder;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHitSupport;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SearchService {

    
    private final ElasticsearchOperations elasticsearchTemplate;

  
    public void searchContracts(SearchDTO search) {
        
        String firstName = search.getFirstname();
        
        //var searchHits = elasticsearchTemplate.search(searchQuery, ContractIndex.class, IndexCoordinates.of("contractindex"));
    }
    
}
