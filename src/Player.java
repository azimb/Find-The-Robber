public abstract class Player implements Character {
	
	public int locx =0;
	public int locy =0;
	public static String humanName;
	public static int time;
	public Things thing;
	private boolean ticket;
	public void setTicket(){
		this.ticket = true;
	}
	public boolean hasTicket(){
		return this.ticket;
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
	public abstract String talk();
	
}
