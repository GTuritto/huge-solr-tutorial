package com.hugeinc.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hugeinc.solr.indexer.BarIndexerService;

@Controller
public class SinglesBarController {
  
  private final BarIndexerService barIndexer;
  
  @Autowired
  public SinglesBarController(final BarIndexerService barIndexer) {
    this.barIndexer = barIndexer;
  }
  
  @RequestMapping("")
  public ModelAndView home() {
    ModelAndView singlesBarHome = new ModelAndView("SinglesBarHome");
    singlesBarHome.addObject("msg", "<a href=\"reindex_bars\">click here to reindex</a>");
    return singlesBarHome;
  }
  
  @RequestMapping("reindex_bars")
  public ModelAndView reindexBars() {
    barIndexer.indexRestuarants();
    ModelAndView singlesBarHome = new ModelAndView("SinglesBarHome");
    singlesBarHome.addObject("msg", "reindex success");
    return singlesBarHome;
  }
  

}
