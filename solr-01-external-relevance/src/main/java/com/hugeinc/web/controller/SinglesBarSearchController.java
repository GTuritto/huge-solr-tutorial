package com.hugeinc.web.controller;

import static org.apache.commons.lang.StringUtils.isEmpty;

import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Lists;
import com.hugeinc.solr.data.BarData;
import com.hugeinc.solr.search.BarSearchException;
import com.hugeinc.solr.search.SinglesBarSearchService;
import com.hugeinc.web.form.BarSortType;
import com.hugeinc.web.form.DesiredGenderType;
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

  public static String getDiv(BarData barData, DesiredGenderType desiredGender) {
    String output = "<div><h2>" + barData.getName() + "</h2>";
    output += "<p id=\"links_" + barData.getId() + "\" class=\"links\"></p>";
    output += "<p>" + getSnippet(barData, desiredGender) + "</p></div>";
    return output;
  };
  
  private static String getSnippet(BarData barData, DesiredGenderType desiredGender) {
      String output = "";
      output += barData.getAddress();
      if (!isEmpty(barData.getAddressExtended())) {
        output += ", " + barData.getAddressExtended();
      }
      output += "<br/>";
      output += barData.getCity() + ", " + barData.getState() + " " + barData.getZip() + "<br/>";
      
      if (!isEmpty(barData.getNeighborhood())) {
        output += "(" + barData.getNeighborhood() + ") ";
      }
      if (barData.getRating() != null && barData.getRating() > 0) {
        output += barData.getRating() + "/5 ";
      }
      if (barData.getPrice() != null && barData.getPrice() > 0) {
        output += "$" + barData.getPrice() ;
      }
      if (barData.getWifi()) {
        output += " wifi";
      }
      output += "<br/>";
      if (!isEmpty(barData.getCuisine())) {
        output += barData.getCuisine() + "<br/>";
      }
      if (desiredGender == DesiredGenderType.FEMALE) {
        output += "<i>" + "F/M: " + (barData.getFemale()/barData.getMale()) + " | Singles: " + (barData.getUnmarried()*100) + "% | Income: $" + (barData.getIncome()/1000) +"k</i>";           
      } else {
        output += "<i>" + "M/F: " + (barData.getMale()/barData.getFemale()) + " | Singles: " + (barData.getUnmarried()*100) + "% | Income: $" + (barData.getIncome()/1000) +"k</i>";           
      }
      return output;
    };

  private ModelAndView search(SearchForm searchForm) {
    //parse gender, sort type
    if ("male".equals(searchForm.getGender())) {
      searchForm.setDesiredGender(DesiredGenderType.MALE);
    } else {
      searchForm.setDesiredGender(DesiredGenderType.FEMALE);
    }
    
    if("popularity".equals(searchForm.getSortType())) {
      searchForm.setBarSortType(BarSortType.RATING);
    } else if ("gold_digger".equals(searchForm.getSortType())) {
      searchForm.setBarSortType(BarSortType.GOLD_DIGGER_SCORE);
    } else {
      searchForm.setBarSortType(BarSortType.COURTSHIP_SCORE);
    }
    Collection<BarData> results;
    List<String> resultsDivs = Lists.newArrayList();
    try {
      results = searchService.search(searchForm);
      for (BarData result : results) {
        resultsDivs.add(getDiv(result, searchForm.getDesiredGender()));
      }
    } catch (SolrServerException e) {
      throw new BarSearchException("solr failed during search " + searchForm, e);
    }
    ModelAndView searchResultPage = new ModelAndView("SearchResultPage");
    searchResultPage.addObject("results", resultsDivs);
    searchResultPage.addObject("pageNumber", searchForm.getPageNumber());
    return searchResultPage;
  }
}
