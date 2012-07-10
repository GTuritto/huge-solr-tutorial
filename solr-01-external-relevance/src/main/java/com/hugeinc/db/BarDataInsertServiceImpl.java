package com.hugeinc.db;

import static com.google.common.base.Preconditions.checkNotNull;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Component;

@Component
public class BarDataInsertServiceImpl implements BarDataInsertService {

  private final DataSource ds;
  private final Resource schemaSqlFile;
  private final Resource dataSqlFile;
  
  @Autowired
  public BarDataInsertServiceImpl(final DataSource ds, @Value("${sql.schema}") String schemaSqlFileName, @Value("${sql.data}") String dataSqlFileName) throws SQLException {
    this.schemaSqlFile = checkNotNull(new ClassPathResource(checkNotNull(schemaSqlFileName)));
    this.dataSqlFile = checkNotNull(new ClassPathResource(checkNotNull(dataSqlFileName)));
    this.ds = checkNotNull(ds);
    this.createDatabase();
  }
  
  @Override
  public void createDatabase() throws SQLException {
    final ResourceDatabasePopulator rdp = new ResourceDatabasePopulator();
    rdp.addScript(schemaSqlFile);
    rdp.addScript(dataSqlFile);
    rdp.populate(ds.getConnection());
  }
  
}
