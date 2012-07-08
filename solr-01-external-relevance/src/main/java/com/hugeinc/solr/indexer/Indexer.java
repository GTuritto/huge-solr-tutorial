package com.hugeinc.solr.indexer;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrServerException;

public interface Indexer {

  public void index() throws SolrServerException, IOException;

}
