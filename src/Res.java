public class Res extends Places {
  
	String location; 
	public Player hintPlayer; 
	String name="Restraunt";
	public Res( String location, Player hintPlayer ){
		this.location = location;
		this.hintPlayer = hintPlayer;
	}
	//@Override
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
		return ""; 
	}
	
}
