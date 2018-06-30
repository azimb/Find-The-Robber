public class Computer extends Player{

  String workPlace;
  private String hint;

  public Computer(String workPlace, String hint,Things T){ //new
    this.workPlace = workPlace;
    this.hint = hint;
    this.thing=T; //new
  }
  
  @Override
  public void setPos ( int row, int col ) {  
    this.locx = row;
    this.locy = col;
  }
  
  @Override
  public String getPos() {
    try {
    return World.CountryList[locx][locy].getName();
    }catch(Exception e){ 
      return "Invalid move, try again!";    
    }
  }
  
  @Override 
  public String talk(){  
    return this.hint;
  }

}
