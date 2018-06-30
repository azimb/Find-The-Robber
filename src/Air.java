public class Air extends Places{
  String location; 
  Player hintPlayer; 
  public String name="Airport";
  
  public Air( String location, Player hintPlayer ){
    this.location = location;
    this.hintPlayer = hintPlayer;
  }
 
  public String getName()
  {
   return this.name; 
  }
  
  @Override
  public int timeLost(){
    return 3;
  } 
  
  @Override
  public String getHint(){
    return this.hintPlayer.talk();
  }
  
  @Override
  public String getThing(){ 
   return "You have got a "+this.hintPlayer.thing.type+" (thing) "; 
  }
}
