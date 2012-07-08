package com.hugeinc.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import com.hugeinc.solr.data.SolrRestaurantData;


public class RestuarantDataRowMapper implements ParameterizedRowMapper<SolrRestaurantData> {

  @Override
  public SolrRestaurantData mapRow(ResultSet rs, int rowNum) throws SQLException {
    SolrRestaurantData entry = new SolrRestaurantData();
    entry.setId(rs.getString("id"));
    entry.setTitle(rs.getString("title"));
    return entry;
  }


}
