public class Human extends Player{
	String location;
	public Human(String humanName, String location, int time){
		this.humanName = humanName;
		this.location = location;
		this.time = time;
	}
	@Override
	public String talk(){
		return "";
	}
}
