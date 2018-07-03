public class Thief extends Player{
	
	String thiefName;
	String location;
	boolean wearsGlasses;
	boolean tattoos;
	public Thief(String thiefName, String location, String hairColor, int height, boolean wearsGlasses){
		this.thiefName = thiefName;
		this.location = location;
		this.wearsGlasses = wearsGlasses;
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
		return "THIEF: I woundn't have imagined to have been caught so quickly. You won't hear the last of me!!!";
	}
	
}
