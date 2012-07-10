package com.hugeinc.db;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;

@Component
public class H2Config {
  
  private static final String DB_URL = "db.url";
  private static final String DB_USER = "db.username";
  private static final String DB_PASS = "db.password";
  
  private final StringPair dbUrl;
  private final StringPair dbUser;
  private final StringPair dbPassword;
  private final List<StringPair> servletInitParams;
  
  @Autowired
  public H2Config(
      @Value(value = "${" + DB_URL + "}") String dbUrl, 
      @Value(value = "${" + DB_USER + "}") String dbUser, 
      @Value(value = "${" + DB_PASS + "}") String dbPassword) {
    this.servletInitParams = Lists.newArrayListWithExpectedSize(4);
    this.dbUrl = new StringPair(DB_URL, dbUrl);
    this.dbUser = new StringPair(DB_USER, dbUser);
    this.dbPassword = new StringPair(DB_PASS, dbPassword);
    servletInitParams.add(getDbUrl());
    servletInitParams.add(getDbUser());
    servletInitParams.add(getDbPassword());
    servletInitParams.add(new StringPair("db.tcpServer", "-tcpAllowOthers"));
  }
  
  public Collection<StringPair> getServletInitParams() {
    return servletInitParams;
  }

  public StringPair getDbUrl() {
    return dbUrl;
  }

  public StringPair getDbUser() {
    return dbUser;
  }

  public StringPair getDbPassword() {
    return dbPassword;
  }
  
  
}
