public class Country{
	
  private String CountryName;
  Places[] PlacesList = new Places[3] ;

  public Country (String CountryName, Places[] PlacesList){    
    this.CountryName = CountryName;
    this.PlacesList = PlacesList;
  }
  
  public String getName() {    
    return this.CountryName;
  }
  
}
