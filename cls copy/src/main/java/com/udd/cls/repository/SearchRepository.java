
package com.udd.cls.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import com.udd.cls.indexmodel.SearchIndex;

@Repository
public interface SearchRepository extends ElasticsearchRepository<SearchIndex, String> {

}