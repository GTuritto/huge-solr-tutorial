package com.hugeinc.solr.search;

import org.apache.solr.client.solrj.SolrServerException;

import com.hugeinc.solr.data.BarDataSearchResults;
import com.hugeinc.web.form.SearchForm;

public interface SinglesBarSearchService {

  public BarDataSearchResults search() throws SolrServerException;

  public BarDataSearchResults search(SearchForm searchForm) throws SolrServerException;

}
