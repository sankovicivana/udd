package com.udd.cls.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import com.udd.cls.indexmodel.ContractIndex;

public interface ContractRepository extends ElasticsearchRepository<ContractIndex, String> {

    // List<ContractIndex> findById(String id);

}