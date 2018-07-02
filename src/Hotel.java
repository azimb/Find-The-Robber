public class Hotel extends Places {
	public String name="Hotel";
	public String location; 
	public Player hintPlayer;
	public Hotel( String location, Player hintPlayer ){
		this.location = location;
		this.hintPlayer = hintPlayer;
	}
	// @Override
	public String getName(){
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
