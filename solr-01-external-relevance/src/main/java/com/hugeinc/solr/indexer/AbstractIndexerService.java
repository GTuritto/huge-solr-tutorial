package com.hugeinc.solr.indexer;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.CollectionUtils;

public abstract class AbstractIndexerService<T> implements Indexer {
  private static final Logger logger = LoggerFactory.getLogger(AbstractIndexerService.class);
  
  private final JdbcTemplate jdbcTemplate;
  private final String sqlGrabAll;
  private final RowMapper<T> rowMapper;
  private final SolrServer server;
  
  public AbstractIndexerService(JdbcTemplate jdbcTemplate, RowMapper<T> rowMapper, String sqlGrabAll, SolrServer server) {
    this.jdbcTemplate = checkNotNull(jdbcTemplate);
    this.sqlGrabAll = checkNotNull(sqlGrabAll);
    this.rowMapper = checkNotNull(rowMapper);
    this.server = checkNotNull(server);
  }
  
  public void index() throws SolrServerException, IOException {
    List<T> docsToAdd = jdbcTemplate.query(sqlGrabAll, rowMapper);
    if(CollectionUtils.isEmpty(docsToAdd)) {
      logger.info("No docs to add after query");
      return;
    }
    
    server.addBeans(docsToAdd);
    server.commit();
    
  }
}

