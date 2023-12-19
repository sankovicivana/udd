package com.udd.project.esrepository;
import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.udd.project.esmodel.ContractES;

@Repository
public interface ContractRepositoryES extends ElasticsearchRepository <ContractES,Long> {

    List<ContractES> findByCity(String city);


}