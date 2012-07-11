package com.hugeinc.solr.data;

import java.io.Serializable;
import java.util.Collection;

import org.apache.solr.client.solrj.response.QueryResponse;

import com.hugeinc.web.form.SearchForm;

public class BarDataSearchResults implements Serializable {
  
  private static final long serialVersionUID = 357782745302629410L;
  private final Collection<BarData> results;
  private final long numberOfResults;
  private final int numberOfPages;
  private final int pageNumber;
  private final SearchForm originalRequest;
  
  public BarDataSearchResults(QueryResponse response, SearchForm originalRequest) {
    this.results = response.getBeans(BarData.class);
    this.numberOfResults = response.getResults().getNumFound();
    this.pageNumber = ((int)response.getResults().getStart())/10;
    this.numberOfPages = ((int)this.numberOfResults)/10 + 1;
    this.originalRequest = originalRequest;
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

  public int getNumberOfPages() {
    return numberOfPages;
  }

  public SearchForm getOriginalRequest() {
    return originalRequest;
  }

  @Override
  public String toString() {
    return "BarDataSearchResults [results=" + results + ", numberOfResults=" + numberOfResults + ", numberOfPages=" + numberOfPages + ", pageNumber="
        + pageNumber + ", originalRequest=" + originalRequest + "]";
  }

  
}
