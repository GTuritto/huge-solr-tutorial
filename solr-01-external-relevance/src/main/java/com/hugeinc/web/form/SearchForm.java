package com.hugeinc.web.form;


/**
 * Singles bar search form
 * @author krickert
 *
 */
public class SearchForm {
  //1) search term (optional) 2) desired gender 3) neighborhood (optional) 4) rating and 5) price 6) page num
  private String queryText;
  private String gender;
  private Float rating;
  private DesiredGenderType desiredGender = DesiredGenderType.FEMALE;
  private String sortType = "rating";
  private BarSortType barSortType = BarSortType.RATING;
  private Integer pageNumber = 1;
  
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
  public Float getRating() {
    return rating;
  }
  public void setRating(Float rating) {
    this.rating = rating;
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
  @Override
  public String toString() {
    return "SearchForm [queryText=" + queryText + ", gender=" + gender + ", rating=" + rating + ", desiredGender=" + desiredGender + ", sortType=" + sortType
        + ", barSortType=" + barSortType + ", pageNumber=" + pageNumber + "]";
  }
}
