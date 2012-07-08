package com.hugeinc.db;

public class StringPair implements Pair<String, String> {

  private final String first;
  private final String second;
  
  public StringPair(String first, String second) {
    this.first = first;
    this.second = second;
  }
  
  @Override
  public String getKey() {
    return first;
  }

  @Override
  public String getValue() {
    return second;
  }

}
