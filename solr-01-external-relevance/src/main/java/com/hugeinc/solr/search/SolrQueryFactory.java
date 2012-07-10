package com.hugeinc.solr.search;

import org.apache.solr.client.solrj.SolrQuery;

public interface SolrQueryFactory<T> {
  
  public SolrQuery createQuery(T queryFormData);

}
