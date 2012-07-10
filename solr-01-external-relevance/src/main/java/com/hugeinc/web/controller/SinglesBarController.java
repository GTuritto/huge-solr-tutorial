package com.hugeinc.web.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hugeinc.db.BarDataInsertService;
import com.hugeinc.solr.indexer.BarIndexerService;

@Controller
public class SinglesBarController {
  
  private final BarIndexerService barIndexer;
  private final BarDataInsertService barDataInsertService;
  
  @Autowired
  public SinglesBarController(final BarIndexerService barIndexer, BarDataInsertService barDataInsertService) {
    this.barIndexer = barIndexer;
    this.barDataInsertService = barDataInsertService;
  }
  
  @RequestMapping("")
  public ModelAndView home() {
    ModelAndView singlesBarHome = new ModelAndView("SinglesBarHome");
    singlesBarHome.addObject("msg", "<a href=\"reindex_bars\">click here to reindex</a>");
    return singlesBarHome;
  }
  
  @RequestMapping("create")
  public ModelAndView create() throws SQLException {
    barDataInsertService.createDatabase();
    barIndexer.indexRestuarants();
    ModelAndView singlesBarHome = new ModelAndView("SinglesBarHome");
    
    singlesBarHome.addObject("msg", "Success!  Everything has been created. <br>" +
    		"<a href=\"reindex_bars\">click here to reindex</a><br>" +
    		"<a href=\"search\">click here to search</a>");
        
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
