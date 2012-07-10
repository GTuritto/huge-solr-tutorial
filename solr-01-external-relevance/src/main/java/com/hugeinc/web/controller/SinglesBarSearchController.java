package com.hugeinc.web.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hugeinc.solr.data.BarData;
import com.hugeinc.solr.search.BarSearchException;
import com.hugeinc.solr.search.SinglesBarSearchService;
import com.hugeinc.web.form.SearchForm;

@Controller
@RequestMapping("search")
public class SinglesBarSearchController {
  
  private final SinglesBarSearchService searchService;
  
  @Autowired
  public SinglesBarSearchController(final SinglesBarSearchService searchService) {
    this.searchService = searchService;
  }

  @ModelAttribute("searchForm")
  public SearchForm getSearchFormObject() {
    return new SearchForm();
  }

  @RequestMapping(value = "", method = RequestMethod.GET)
  public ModelAndView searchHome() {
    return search(new SearchForm());
  }
  
  @RequestMapping(value = "", method = RequestMethod.POST)
  public ModelAndView search(@Valid SearchForm searchForm, BindingResult result) {
    if (result.hasErrors()) {
      ModelAndView bad = new ModelAndView("SearchFormError");
      bad.addObject("errors", result.getAllErrors());
      return bad;
    }
    
    return search(searchForm);
  }

  private ModelAndView search(SearchForm searchForm) {
    Collection<BarData> results;
    try {
      results = searchService.search(searchForm);
    } catch (SolrServerException e) {
      throw new BarSearchException("solr failed during search " + searchForm, e);
    }
    ModelAndView searchResultPage = new ModelAndView("SearchResultPage");
    searchResultPage.addObject("results", results);
    searchResultPage.addObject("pageNumber", searchForm.getPageNumber());
    return searchResultPage;
  }
}
