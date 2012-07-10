package com.hugeinc.solr.search;

import org.apache.solr.client.solrj.SolrQuery;

import com.hugeinc.web.form.SearchForm;

public interface BarCoreQueryFactory {

  public abstract SolrQuery createQuery(SearchForm searchForm);

}