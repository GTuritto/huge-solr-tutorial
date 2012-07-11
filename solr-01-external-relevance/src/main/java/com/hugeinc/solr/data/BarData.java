package com.hugeinc.solr.data;

import java.io.Serializable;

import org.apache.solr.client.solrj.beans.Field;

public class BarData implements Serializable {
  
  private static final long serialVersionUID = 194853959391393386L;
  @Field("id")
  private String id;
  @Field("name")
  private String name;
  @Field("address")
  private String address;
  @Field("address_extended")
  private String addressExtended; 
  @Field("city")
  private String city;
  @Field("state")
  private String state;
  @Field("zip")
  private String zip;
  @Field("tel")
  private String telephone;
  @Field("latitude")
  private Float latitude;
  @Field("longitude")
  private Float longitude;
  @Field("website")
  private String website;
  @Field("category")
  private String category;
  @Field("cuisine")
  private String cuisine;
  @Field("price")
  private Integer price;
  @Field("rating")
  private Float rating;
  @Field("wifi")
  private Boolean wifi;
  @Field("neighborhood")
  private String neighborhood;
  @Field("population")
  private Integer population;
  @Field("density")
  private Float density;
  @Field("income")
  private Float income;
  @Field("male")
  private Float male;
  @Field("female")
  private Float female;
  @Field("unmarried")
  private Float unmarried;
  @Field("separated")
  private Float separated;
  @Field("widowed")
  private Float widowed;
  @Field("divorced")
  private Float divorced;
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getAddress() {
    return address;
  }
  public void setAddress(String address) {
    this.address = address;
  }
  public String getAddressExtended() {
    return addressExtended;
  }
  public void setAddressExtended(String addressExtended) {
    this.addressExtended = addressExtended;
  }
  public String getCity() {
    return city;
  }
  public void setCity(String city) {
    this.city = city;
  }
  public String getState() {
    return state;
  }
  public void setState(String state) {
    this.state = state;
  }
  public String getZip() {
    return zip;
  }
  public void setZip(String zip) {
    this.zip = zip;
  }
  public String getTelephone() {
    return telephone;
  }
  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }
  public Float getLatitude() {
    return latitude;
  }
  public void setLatitude(Float latitude) {
    this.latitude = latitude;
  }
  public Float getLongitude() {
    return longitude;
  }
  public void setLongitude(Float longitude) {
    this.longitude = longitude;
  }
  public String getWebsite() {
    return website;
  }
  public void setWebsite(String website) {
    this.website = website;
  }
  public String getCategory() {
    return category;
  }
  public void setCategory(String category) {
    this.category = category;
  }
  public String getCuisine() {
    return cuisine;
  }
  public void setCuisine(String cuisine) {
    this.cuisine = cuisine;
  }
  public Integer getPrice() {
    return price;
  }
  public void setPrice(Integer price) {
    this.price = price;
  }
  public Float getRating() {
    return rating;
  }
  public void setRating(Float rating) {
    this.rating = rating;
  }
  public Boolean getWifi() {
    return wifi;
  }
  public void setWifi(Boolean wifi) {
    this.wifi = wifi;
  }
  public String getNeighborhood() {
    return neighborhood;
  }
  public void setNeighborhood(String neighborhood) {
    this.neighborhood = neighborhood;
  }
  public Integer getPopulation() {
    return population;
  }
  public void setPopulation(Integer population) {
    this.population = population;
  }
  public Float getDensity() {
    return density;
  }
  public void setDensity(Float density) {
    this.density = density;
  }
  public Float getIncome() {
    return income;
  }
  public void setIncome(Float income) {
    this.income = income;
  }
  public Float getMale() {
    return male;
  }
  public void setMale(Float male) {
    this.male = male;
  }
  public Float getFemale() {
    return female;
  }
  public void setFemale(Float female) {
    this.female = female;
  }
  public Float getUnmarried() {
    return unmarried;
  }
  public void setUnmarried(Float unmarried) {
    this.unmarried = unmarried;
  }
  public Float getSeparated() {
    return separated;
  }
  public void setSeparated(Float separated) {
    this.separated = separated;
  }
  public Float getWidowed() {
    return widowed;
  }
  public void setWidowed(Float widowed) {
    this.widowed = widowed;
  }
  public Float getDivorced() {
    return divorced;
  }
  public void setDivorced(Float divorced) {
    this.divorced = divorced;
  }
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((address == null) ? 0 : address.hashCode());
    result = prime * result + ((addressExtended == null) ? 0 : addressExtended.hashCode());
    result = prime * result + ((category == null) ? 0 : category.hashCode());
    result = prime * result + ((city == null) ? 0 : city.hashCode());
    result = prime * result + ((cuisine == null) ? 0 : cuisine.hashCode());
    result = prime * result + ((density == null) ? 0 : density.hashCode());
    result = prime * result + ((divorced == null) ? 0 : divorced.hashCode());
    result = prime * result + ((female == null) ? 0 : female.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((income == null) ? 0 : income.hashCode());
    result = prime * result + ((latitude == null) ? 0 : latitude.hashCode());
    result = prime * result + ((longitude == null) ? 0 : longitude.hashCode());
    result = prime * result + ((male == null) ? 0 : male.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((neighborhood == null) ? 0 : neighborhood.hashCode());
    result = prime * result + ((population == null) ? 0 : population.hashCode());
    result = prime * result + ((price == null) ? 0 : price.hashCode());
    result = prime * result + ((rating == null) ? 0 : rating.hashCode());
    result = prime * result + ((separated == null) ? 0 : separated.hashCode());
    result = prime * result + ((state == null) ? 0 : state.hashCode());
    result = prime * result + ((telephone == null) ? 0 : telephone.hashCode());
    result = prime * result + ((unmarried == null) ? 0 : unmarried.hashCode());
    result = prime * result + ((website == null) ? 0 : website.hashCode());
    result = prime * result + ((widowed == null) ? 0 : widowed.hashCode());
    result = prime * result + ((wifi == null) ? 0 : wifi.hashCode());
    result = prime * result + ((zip == null) ? 0 : zip.hashCode());
    return result;
  }
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    BarData other = (BarData) obj;
    if (address == null) {
      if (other.address != null)
        return false;
    } else if (!address.equals(other.address))
      return false;
    if (addressExtended == null) {
      if (other.addressExtended != null)
        return false;
    } else if (!addressExtended.equals(other.addressExtended))
      return false;
    if (category == null) {
      if (other.category != null)
        return false;
    } else if (!category.equals(other.category))
      return false;
    if (city == null) {
      if (other.city != null)
        return false;
    } else if (!city.equals(other.city))
      return false;
    if (cuisine == null) {
      if (other.cuisine != null)
        return false;
    } else if (!cuisine.equals(other.cuisine))
      return false;
    if (density == null) {
      if (other.density != null)
        return false;
    } else if (!density.equals(other.density))
      return false;
    if (divorced == null) {
      if (other.divorced != null)
        return false;
    } else if (!divorced.equals(other.divorced))
      return false;
    if (female == null) {
      if (other.female != null)
        return false;
    } else if (!female.equals(other.female))
      return false;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (income == null) {
      if (other.income != null)
        return false;
    } else if (!income.equals(other.income))
      return false;
    if (latitude == null) {
      if (other.latitude != null)
        return false;
    } else if (!latitude.equals(other.latitude))
      return false;
    if (longitude == null) {
      if (other.longitude != null)
        return false;
    } else if (!longitude.equals(other.longitude))
      return false;
    if (male == null) {
      if (other.male != null)
        return false;
    } else if (!male.equals(other.male))
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (neighborhood == null) {
      if (other.neighborhood != null)
        return false;
    } else if (!neighborhood.equals(other.neighborhood))
      return false;
    if (population == null) {
      if (other.population != null)
        return false;
    } else if (!population.equals(other.population))
      return false;
    if (price == null) {
      if (other.price != null)
        return false;
    } else if (!price.equals(other.price))
      return false;
    if (rating == null) {
      if (other.rating != null)
        return false;
    } else if (!rating.equals(other.rating))
      return false;
    if (separated == null) {
      if (other.separated != null)
        return false;
    } else if (!separated.equals(other.separated))
      return false;
    if (state == null) {
      if (other.state != null)
        return false;
    } else if (!state.equals(other.state))
      return false;
    if (telephone == null) {
      if (other.telephone != null)
        return false;
    } else if (!telephone.equals(other.telephone))
      return false;
    if (unmarried == null) {
      if (other.unmarried != null)
        return false;
    } else if (!unmarried.equals(other.unmarried))
      return false;
    if (website == null) {
      if (other.website != null)
        return false;
    } else if (!website.equals(other.website))
      return false;
    if (widowed == null) {
      if (other.widowed != null)
        return false;
    } else if (!widowed.equals(other.widowed))
      return false;
    if (wifi == null) {
      if (other.wifi != null)
        return false;
    } else if (!wifi.equals(other.wifi))
      return false;
    if (zip == null) {
      if (other.zip != null)
        return false;
    } else if (!zip.equals(other.zip))
      return false;
    return true;
  }
  @Override
  public String toString() {
    return "SolrRestaurantData [id=" + id + ", name=" + name + ", address=" + address + ", addressExtended=" + addressExtended + ", city=" + city + ", state="
        + state + ", zip=" + zip + ", telephone=" + telephone + ", latitude=" + latitude + ", longitude=" + longitude + ", website=" + website + ", category="
        + category + ", cuisine=" + cuisine + ", price=" + price + ", rating=" + rating + ", wifi=" + wifi + ", neighborhood=" + neighborhood + ", population="
        + population + ", density=" + density + ", income=" + income + ", male=" + male + ", female=" + female + ", unmarried=" + unmarried + ", separated="
        + separated + ", widowed=" + widowed + ", divorced=" + divorced + "]";
  }
  
  

  
  
}
