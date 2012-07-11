package com.hugeinc.solr.data;

import java.util.Collection;

import org.apache.solr.client.solrj.response.QueryResponse;

public class BarDataSearchResults {
  
  private final Collection<BarData> results;
  private final long numberOfResults;
  private final int pageNumber;
  
  public BarDataSearchResults(QueryResponse response) {
    this.results = response.getBeans(BarData.class);
    this.numberOfResults = response.getResults().getNumFound();
    this.pageNumber = ((int)response.getResults().getStart())/10;
  }

  public Collection<BarData> getResults() {
    return results;
  }

  public long getNumberOfResults() {
    return numberOfResults;
  }

  public int getPageNumber() {
    return pageNumber;
  }

  
}
