package com.hugeinc.web;

import java.net.MalformedURLException;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.h2.Driver;
import org.h2.tools.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.google.common.base.Preconditions;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.hugeinc")
public class SolrSpringConfiguration {
  private static final Logger logger = LoggerFactory.getLogger(SolrSpringConfiguration.class);

  @Bean
  public InternalResourceViewResolver configureInternalResourceViewResolver() {
    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
    resolver.setPrefix("/WEB-INF/views/");
    resolver.setSuffix(".jsp");
    return resolver;
  }

  @Bean(name = "dataSource")
  public DataSource configureDatasource(@Value("${db.url}") String dbUrl, @Value("${db.username}") String dbUsername, @Value("${db.password}") String dbPassword) {
    SimpleDriverDataSource ds = new SimpleDriverDataSource(new Driver(), dbUrl, dbUsername, dbPassword);
    return ds;
  }

  @Bean(name = "org.h2.tools.Server-WebServer")
  public Server createPgServer(DataSource dataSource) {
    Preconditions.checkNotNull(dataSource);
    try {
      return Server.createPgServer("-pgAllowOthers").start();
    } catch (SQLException e) {
      throw new IllegalStateException("The h2 database web console didn't start up.", e);
    }
  }
  
  @Bean(name="jdbcTemplate")
  public JdbcTemplate configureJdbcTemplate(DataSource dataSource) {
    return new JdbcTemplate(dataSource);
  }
  
  @Bean(name="propertyPlaceholderConfigurer")
  public static PropertyPlaceholderConfigurer configurePlaceholder() {
    PropertyPlaceholderConfigurer configure = new PropertyPlaceholderConfigurer();
    configure.setLocation(new ClassPathResource("huge-solr.properties"));
    
    return configure;
  }

  @Bean(name="solrServer") 
  public SolrServer configureSolrServer(@Value(value="${httpAddressOfSolr}") String httpAddressOfSolr) throws MalformedURLException {
    logger.debug("setting up solr server");
    return new HttpSolrServer(httpAddressOfSolr);
  }
}
