package com.hugeinc.solr.indexer;

import static com.google.common.base.Preconditions.checkNotNull;

import org.apache.solr.client.solrj.SolrServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.hugeinc.db.RestuarantDataRowMapper;
import com.hugeinc.solr.data.SolrRestaurantData;

public class RestaurantIndexer extends AbstractIndexerService<SolrRestaurantData> {

  @Autowired
  public RestaurantIndexer(NamedParameterJdbcTemplate jdbcTemplate, RestuarantDataRowMapper rowMapper, @Value("${sql}") String sqlGrabAll, SolrServer server) {
    super(checkNotNull(jdbcTemplate), checkNotNull(rowMapper), checkNotNull(sqlGrabAll), checkNotNull(server));
  }

}
