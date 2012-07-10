package com.hugeinc.solr.search;

import static com.google.common.base.Preconditions.checkNotNull;

import org.apache.solr.client.solrj.SolrServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SinglesBarSearchServiceImpl implements SinglesBarSearchService {
  
  private final SolrServer solrServer;
  
  @Autowired
  public SinglesBarSearchServiceImpl(SolrServer solrServer) {
    this.solrServer = checkNotNull(solrServer);
  }

  
}
