package com.hugeinc.solr.search;

import org.apache.commons.lang.StringUtils;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.springframework.stereotype.Component;

import com.hugeinc.web.form.SearchForm;

@Component
public class BarCoreQueryFactoryImpl implements SolrQueryFactory<SearchForm>, BarCoreQueryFactory {

  public BarCoreQueryFactoryImpl() {
    super();
  }
  
  /* (non-Javadoc)
   * @see com.hugeinc.solr.search.BarCoreQueryFactory#createQuery(com.hugeinc.web.form.SearchForm)
   */
  @Override
  public SolrQuery createQuery(SearchForm searchForm) {
    SolrQuery query = new SolrQuery();
    query.addField("*");
    query.addField("score");
    query.addSortField("product(female,unmarried)", ORDER.desc);
    if (searchForm == null || StringUtils.isEmpty(searchForm.getQueryText())) {
      query.setQuery("*.*");      
    } else {
      query.setQuery(searchForm.getQueryText());
    }
    return query;
  }

}
