package com.hugeinc.solr.indexer;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.util.CollectionUtils;

import com.google.common.base.Preconditions;

public abstract class AbstractIndexerService<T> implements Indexer {
  private static final Logger logger = LoggerFactory.getLogger(AbstractIndexerService.class);
  
  private final NamedParameterJdbcTemplate jdbcTemplate;
  private final String sqlGrabAll;
  private final RowMapper<T> rowMapper;
  private final SolrServer server;
  
  public AbstractIndexerService(NamedParameterJdbcTemplate jdbcTemplate, RowMapper<T> rowMapper, String sqlGrabAll, SolrServer server) {
    this.jdbcTemplate = Preconditions.checkNotNull(jdbcTemplate);
    this.sqlGrabAll = sqlGrabAll;
    this.rowMapper = rowMapper;
    this.server = server;
  }
  
  public void index() throws SolrServerException, IOException {
    Map<String, ?> paramMap = Collections.emptyMap();
    List<T> docsToAdd = jdbcTemplate.query(sqlGrabAll, paramMap, rowMapper);
    if(CollectionUtils.isEmpty(docsToAdd)) {
      logger.info("No docs to add after query");
      return;
    }
    
    server.addBeans(docsToAdd);
    
  }
}

