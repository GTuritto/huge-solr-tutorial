package com.hugeinc.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class SolrSpringWebApplicationInitializer implements WebApplicationInitializer {

  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    AnnotationConfigWebApplicationContext mvcContext = new AnnotationConfigWebApplicationContext();
    mvcContext.register(SolrSpringConfiguration.class);

    ServletRegistration.Dynamic dispatcher = servletContext.addServlet(
      "dispatcher", new DispatcherServlet(mvcContext));
    dispatcher.setLoadOnStartup(1);
    dispatcher.addMapping("/app/*");
    
  }

}
