package com.hugeinc.solr.indexer;

public class IndexerException extends RuntimeException {

  private static final long serialVersionUID = 5173556669493048201L;

  public IndexerException(String message, Throwable clause) {
    super(message, clause);
  }
}
