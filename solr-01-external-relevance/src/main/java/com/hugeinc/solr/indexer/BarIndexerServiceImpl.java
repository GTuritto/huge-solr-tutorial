package com.hugeinc.solr.indexer;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.hugeinc.db.BarDataRowMapper;
import com.hugeinc.solr.data.BarData;

@Component
public class BarIndexerServiceImpl extends AbstractIndexerService<BarData> implements BarIndexerService {

  @Autowired
  public BarIndexerServiceImpl(JdbcTemplate jdbcTemplate, @Value("${sql}") String sqlGrabAll, SolrServer server) {
    super(checkNotNull(jdbcTemplate), new BarDataRowMapper(), checkNotNull(sqlGrabAll), checkNotNull(server));
  }

  @Override
  public void indexRestuarants() {
    try {
      this.index();
    } catch (SolrServerException e) {
      throw new IndexerException("Solr issue while trying to run indexing", e);
    } catch (IOException e) {
      throw new IndexerException("IO issue while trying to run indexing", e);
    }
    
  }

}
