package com.hugeinc.solr.search;

import static com.google.common.base.Preconditions.checkNotNull;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hugeinc.solr.data.BarDataSearchResults;
import com.hugeinc.web.form.SearchForm;

@Component
public class SinglesBarSearchServiceImpl implements SinglesBarSearchService {
  
  private final SolrServer solrServer;
  private final BarCoreQueryFactory queryFactory;
  
  @Autowired
  public SinglesBarSearchServiceImpl(final SolrServer solrServer, final BarCoreQueryFactory queryFactory) {
    this.solrServer = checkNotNull(solrServer);
    this.queryFactory = checkNotNull(queryFactory);
  }

  @Override
  public BarDataSearchResults search() throws SolrServerException {
    return search(new SearchForm());
  }

  @Override
  public BarDataSearchResults search(SearchForm searchForm) throws SolrServerException {
    SolrQuery query = queryFactory.createQuery(searchForm);
    QueryResponse response = solrServer.query(query);
    return new BarDataSearchResults(response, searchForm);
  }

  
}
