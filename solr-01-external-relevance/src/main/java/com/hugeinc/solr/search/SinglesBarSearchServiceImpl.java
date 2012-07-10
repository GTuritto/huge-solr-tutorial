package com.hugeinc.solr.search;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hugeinc.solr.data.BarData;
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
  public Collection<BarData> search() throws SolrServerException {
    SolrQuery query = queryFactory.createQuery(null);
    QueryResponse response = solrServer.query(query);
    List<BarData> responseList = response.getBeans(BarData.class);
    return responseList;
  }

  @Override
  public Collection<BarData> search(SearchForm searchForm) throws SolrServerException {
    SolrQuery query = queryFactory.createQuery(searchForm);
    QueryResponse response = solrServer.query(query);
    List<BarData> responseList = response.getBeans(BarData.class);
    return responseList;
  }

  
}
