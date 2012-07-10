package com.hugeinc.web.form;

import javax.validation.constraints.NotNull;

/**
 * Singles bar search form
 * @author krickert
 *
 */
public class SearchForm {
  //1) search term (optional) 2) desired gender 3) neighborhood (optional) 4) rating and 5) price 6) page num
  private String queryText;
  @NotNull
  private String gender;
  private String[] neighborhoods;
  private Float rating;
  private Float price;
  private DesiredGenderType desiredGender = DesiredGenderType.FEMALE;
  private String sortType = "popularity";
  private BarSortType barSortType = BarSortType.POPULARITY;
  private Integer pageNumber = 0;
  
  public String getQueryText() {
    return queryText;
  }
  public void setQueryText(String queryText) {
    this.queryText = queryText;
  }
  public String getGender() {
    return gender;
  }
  public void setGender(String gender) {
    this.gender = gender;
  }
  public String[] getNeighborhoods() {
    return neighborhoods;
  }
  public void setNeighborhoods(String[] neighborhoods) {
    this.neighborhoods = neighborhoods;
  }
  public Float getRating() {
    return rating;
  }
  public void setRating(Float rating) {
    this.rating = rating;
  }
  public Float getPrice() {
    return price;
  }
  public void setPrice(Float price) {
    this.price = price;
  }
  public DesiredGenderType getDesiredGender() {
    return desiredGender;
  }
  public void setDesiredGender(DesiredGenderType desiredGender) {
    this.desiredGender = desiredGender;
  }
  public BarSortType getBarSortType() {
    return barSortType;
  }
  public void setBarSortType(BarSortType barSortType) {
    this.barSortType = barSortType;
  }
  public Integer getPageNumber() {
    return pageNumber;
  }
  public void setPageNumber(Integer pageNumber) {
    this.pageNumber = pageNumber;
  }
  public String getSortType() {
    return sortType;
  }
  public void setSortType(String sortType) {
    this.sortType = sortType;
  }
   
}
