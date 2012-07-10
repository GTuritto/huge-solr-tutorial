package com.hugeinc.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import com.hugeinc.solr.data.BarData;


public class BarDataRowMapper implements ParameterizedRowMapper<BarData> {

  @Override
  public BarData mapRow(ResultSet rs, int rowNum) throws SQLException {
    BarData entry = new BarData();
    entry.setId(rs.getString("id"));
    entry.setName(rs.getString("name"));
    entry.setAddress(rs.getString("address"));
    entry.setAddressExtended(rs.getString("address_extended"));
    entry.setCity(rs.getString("city"));
    entry.setState(rs.getString("state"));
    entry.setZip(rs.getString("zip"));
    entry.setTelephone(rs.getString("tel"));
    entry.setLatitude(rs.getFloat("latitude"));
    entry.setLongitude(rs.getFloat("longitude"));
    entry.setWebsite(rs.getString("website"));
    entry.setCategory(rs.getString("category"));
    entry.setCuisine(rs.getString("cuisine"));
    entry.setPrice(rs.getInt("price"));
    entry.setRating(rs.getFloat("rating"));
    entry.setWifi(rs.getBoolean("wifi"));
    entry.setNeighborhood(rs.getString("neighborhood"));
    entry.setPopulation(rs.getInt("population"));
    entry.setDensity(rs.getFloat("density"));
    entry.setIncome(rs.getFloat("income"));
    entry.setMale(rs.getFloat("male"));
    entry.setFemale(rs.getFloat("female"));
    entry.setUnmarried(rs.getFloat("unmarried"));
    entry.setSeparated(rs.getFloat("separated"));
    entry.setWidowed(rs.getFloat("widowed"));
    entry.setDivorced(rs.getFloat("divorced"));
    
    
    return entry;
  }


}
