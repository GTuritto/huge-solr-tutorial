package com.hugeinc.solr.search;

import java.util.Collection;

import org.apache.solr.client.solrj.SolrServerException;

import com.hugeinc.solr.data.BarData;
import com.hugeinc.web.form.SearchForm;

public interface SinglesBarSearchService {

  public Collection<BarData> search() throws SolrServerException;

  public Collection<BarData> search(SearchForm searchForm) throws SolrServerException;

}
