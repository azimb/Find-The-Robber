import java.util.Scanner;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Function {
		
	public static void displaySub() {
		System.out.println( " Type: ");
		System.out.println( " D- for 'Display map' ");
		System.out.println( " T- for travel ");
		System.out.println( " I- for investigation ");
		System.out.println( " U - thief updates ");
	}
  
    public static void displayMap() {
		String ANSI_RED = "\u001B[31m";
		String ANSI_RESET = "\u001B[0m";
		int locx=World.alex.locx;
		int locy=World.alex.locy;
		System.out.println();
		System.out.println("|-----------------------------------------|");  
		for (int r = 0; r < World.CountryList.length; r++){
			for (int c = 0; c < World.CountryList[r].length; c++){
			if(r==locx && c==locy)
				System.out.print("| [" + (World.CountryList[r][c].getName() + "*" +   World.alex.humanName.toUpperCase()+ "*")+ "] |");
        	else
				System.out.print("| [" +World.CountryList[r][c].getName()+ "] |") ;
		}
		System.out.println("\n|-----------------------------------------|");  
		}
	} 
    
	public static void displayTravel() {
		System.out.println("Where do you want to travel next?");
        System.out.println("Type: ");
        System.out.println(" N- for north (up) ");
        System.out.println(" S- for south (down) ");
        System.out.println(" E- for east (right) ");
        System.out.println(" W- for west (left) ");
	}
  
	public static String askDirection(String str) {
		String TInput = str;
		while( ( !TInput.equals("N") ) && ( !TInput.equals("S") ) && ( !TInput.equals("E") ) && ( !TInput.equals("W") ) ){
			System.out.println("Where do you want to travel next?");
			System.out.println("Type: "); 
			System.out.println(" N- for north (up) ");
			System.out.println(" S- for south (down) ");
			System.out.println(" E- for east (right) ");
			System.out.println(" W- for west (left) ");
			Scanner askAgain = new Scanner(System.in);
			TInput = askAgain.next();
		}
		return TInput;
	}

	public static void makeMove (String str) throws InterruptedException{ 
        if( World.alex.hasTicket()==false ){
			System.out.println("You don't have a ticket to fly my friend, you need to INVESTIGATE at the airport and piclup your ticket");
			File beep = new File("beep.wav");
            Function.playSound(beep);
		}  
        else {
			int locx = World.alex.locx;
			int locy = World.alex.locy;
			String TInput = str;
			while(true){
				if ( TInput.equals("N") ){
					locx -= 1;
					World.alex.setPos(locx, locy);
					if ( World.alex.getPos().equals("Invalid move, try again!") == true ){
						locx += 1;
						System.out.println("Out of the world exception");
						System.out.println("Please enter: ");
						System.out.println("Enter (N) to go north  / up");
						System.out.println("Enter (S) to go north  / down");
						System.out.println("Enter (E) to go north  / right");
						System.out.println("Enter (W) to go north  / left");
						Scanner keyboard4 = new Scanner(System.in);
						TInput = keyboard4.next();
					}
					else{
						World.alex.time -= 5;
						System.out.println("Travel complete.");
						if(World.alex.time <= 0){
							System.out.println("******************");
							System.out.println("You are out of time");
							System.exit(0);
						}
						File airplane = new File("airland.wav");
						Function.playSound(airplane);
						if ( World.alex.getPos().equals("England") ) {
							File englandName = new File("toEngland.wav");
							File welcome = new File("welcome.wav");
							Function.playSound(welcome);
							Function.playSound(englandName);
						}
						else if ( World.alex.getPos().equals("Japan") ){
							File JapanName = new File("toJapan.wav");
							File welcome = new File("welcome.wav");
							Function.playSound(welcome);
							Function.playSound(JapanName);
						}
						else if ( World.alex.getPos().equals("Brazil") ) {
							File BrazilName = new File("toBrazil.wav");
							File welcome = new File("welcome.wav");
							Function.playSound(welcome);
							Function.playSound(BrazilName);
						}
						else if ( World.alex.getPos().equals("Egypt") ) {
							File EgyptName = new File("toEgypt.wav");
							File welcome = new File("welcome.wav");
							Function.playSound(welcome);
							Function.playSound(EgyptName);
						}
						else if ( World.alex.getPos().equals("New Zeland") ) {
							File NewZelandName = new File("toNewZeland.wav");
							File welcome = new File("welcome.wav");
							Function.playSound(welcome);
							Function.playSound(NewZelandName);         
						}
						System.out.println("Welcome to " + World.alex.getPos() );
						System.out.println("You have " + World.alex.time + " hours left to accomplish this mission");
					}
					break;
				}
				else if ( TInput.equals("S") ){      
					locx =+ 1;
					World.alex.setPos(locx, locy);
					if ( World.alex.getPos().equals("Invalid move, try again!") == true ){
						locx -= 1;
						System.out.println("Out of the world exception");
						System.out.println("Please enter: ");
						System.out.println("Enter (N) to go north  / up");
						System.out.println("Enter (S) to go north  / down");
						System.out.println("Enter (E) to go north  / right");
						System.out.println("Enter (W) to go north  / left");
						Scanner keyboard4 = new Scanner(System.in);
						TInput = keyboard4.next();
					}
					else{
						World.alex.time -= 5;
						System.out.println("Travel complete.");           
						if(World.alex.time <= 0){
							System.out.println("******************");
							System.out.println("You are out of time");
							System.exit(0);
						}
						File airplane = new File("airland.wav");
						Function.playSound(airplane);
						if ( World.alex.getPos().equals("England") ) {
							File englandName = new File("toEngland.wav");
							File welcome = new File("welcome.wav");Function.playSound(welcome);
							Function.playSound(englandName);
						}	
						else if ( World.alex.getPos().equals("Japan") ) {
							File JapanName = new File("toJapan.wav");
							File welcome = new File("welcome.wav");Function.playSound(welcome);
							Function.playSound(JapanName);
						}
						else if ( World.alex.getPos().equals("Brazil") ) {
							File BrazilName = new File("toBrazil.wav");
							File welcome = new File("welcome.wav");
							Function.playSound(welcome);
							Function.playSound(BrazilName);
						}
						else if ( World.alex.getPos().equals("Egypt") ) {
							File EgyptName = new File("toEgypt.wav");
							File welcome = new File("welcome.wav");
							Function.playSound(welcome);
							Function.playSound(EgyptName);
						}
						else if ( World.alex.getPos().equals("New Zeland") ) {File NewZelandName = new File("toNewZeland.wav");
							File welcome = new File("welcome.wav");Function.playSound(welcome);
							Function.playSound(NewZelandName);
						}
						System.out.println("Welcome to " + World.alex.getPos() );
						System.out.println("You have " + World.alex.time + " hours left to accomplish this mission");
						break;
					}
				}
				else if ( TInput.equals("E") ){
					locy += 1;
					World.alex.setPos(locx, locy);
					if ( World.alex.getPos().equals("Invalid move, try again!") == true ){
						locy -= 1;
						System.out.println("Out of the world exception");
						System.out.println("Please enter: ");
						System.out.println("Enter (N) to go north  / up");
						System.out.println("Enter (S) to go north  / down");
						System.out.println("Enter (E) to go north  / right");
						System.out.println("Enter (W) to go north  / left");
						Scanner keyboard4 = new Scanner(System.in);
						TInput = keyboard4.next();
					}
					else{
						World.alex.time -= 5;
						System.out.println("Travel complete.");
						if(World.alex.time <= 0){
							System.out.println("******************");
							System.out.println("You are out of time");
							System.exit(0);
						}
						File airplane = new File("airland.wav");
						Function.playSound(airplane);
					
						if ( World.alex.getPos().equals("England") ) {
							File englandName = new File("toEngland.wav");
							File welcome = new File("welcome.wav");
							Function.playSound(welcome);
							Function.playSound(englandName);
						}
						else if ( World.alex.getPos().equals("Japan") ) {
							File JapanName = new File("toJapan.wav");
							File welcome = new File("welcome.wav");
							Function.playSound(welcome);
							Function.playSound(JapanName);
						}
						else if ( World.alex.getPos().equals("Brazil") ) {
							File BrazilName = new File("toBrazil.wav");
							File welcome = new File("welcome.wav");
							Function.playSound(welcome);
							Function.playSound(BrazilName);
						} 
						else if ( World.alex.getPos().equals("Egypt") ) {
							File EgyptName = new File("toEgypt.wav");
							File welcome = new File("welcome.wav");
							Function.playSound(welcome);
							Function.playSound(EgyptName);              
						}
						else if ( World.alex.getPos().equals("New Zeland") ) {
							File NewZelandName = new File("toNewZeland.wav");
							File welcome = new File("welcome.wav");
							Function.playSound(welcome);
							Function.playSound(NewZelandName);
						} 
						System.out.println("Welcome to " + World.alex.getPos() );
						System.out.println("You have " + World.alex.time + " hours left to accomplish this mission");
						break;
					}  
				}
				else if ( TInput.equals("W") ){
					locy -= 1;
					World.alex.setPos(locx, locy);
			   
					if ( World.alex.getPos().equals("Invalid move, try again!") == true ){
						locy += 1;
						System.out.println("Out of the world exception");
						System.out.println("Please enter: ");
						System.out.println("Enter (N) to go north  / up");
						System.out.println("Enter (S) to go north  / down");
						System.out.println("Enter (E) to go north  / right");
						System.out.println("Enter (W) to go north  / left");
						Scanner keyboard4 = new Scanner(System.in);
						TInput = keyboard4.next();	 
					}
					else{
						World.alex.time -= 5;
						System.out.println("Travel complete.");
						if( World.alex.time <=0 ) {
							System.out.println("You are out of time young man. Mission failed! Do you want to restart the game (y/n)?");
							Scanner restart = new Scanner(System.in);
							String yesno = restart.next();
							if ( yesno.toUpperCase().equals("Y") ){
								World.newGame();
							}
							else{
								System.exit(0);
							}
						}
						File airplane = new File("airland.wav");
						Function.playSound(airplane);
						if ( World.alex.getPos().equals("England") ) {
							File englandName = new File("toEngland.wav");
							File welcome = new File("welcome.wav");
							Function.playSound(welcome);
							Function.playSound(englandName);
						}
						System.out.println("Welcome to " + World.alex.getPos() );
						System.out.println("You have " + World.alex.time + " hours left to accomplish this mission");
						break;
					}
				}
			}
			World.alex.locx=locx;
			World.alex.locy=locy;
      
         
     
		}
    }
	
    public static void Investigation() throws InterruptedException{
		int locx = World.alex.locx;
		int locy = World.alex.locy;
		int flag = 0;
		int counter = 0;
        if(World.CountryList[locx][locy].PlacesList.length==3) {
			System.out.println("Possible Options -> "+World.CountryList[locx][locy].PlacesList[0].getName()+"\t"+World.CountryList[locx][locy].PlacesList[1].getName()+"\t"+World.CountryList[locx][locy].PlacesList[2].getName());
			System.out.println("H for Hotel\nR for Restraunt\nA for Airport");
			flag=0;
        }
        else {
			System.out.println("Possible Options -> "+World.CountryList[locx][locy].PlacesList[0].getName()); 
			System.out.println("A for Airport");
			flag=1;
        }
        System.out.println("Where do you want to investigate? ");
        Scanner keyboard3 = new Scanner(System.in);
        String IInput = keyboard3.next().toUpperCase();
        while(true) { 
			if(flag==0) {
				if( !IInput.equals("H") && !IInput.equals("A") && !IInput.equals("R") ) {              
					System.out.println("INVALID INPUT !!!");				  
					System.out.println("Possible Options -> "+World.CountryList[locx][locy].PlacesList[0].getName()+"\t"+World.CountryList[locx][locy].PlacesList[1].getName()+"\t"+World.CountryList[locx][locy].PlacesList[2].getName());
					System.out.println("H for Hotel\nR for Restraunt\nA for Airport");				  
					System.out.println("Where do you want to investigate? ");
					IInput = keyboard3.next().toUpperCase();            
				}
				else {
					break;
				}	
			}
			else { 
				if(!IInput.equals("A") ) {
				System.out.println("INVALID INPUT !!!");
				System.out.println("Possible Options -> "+World.CountryList[locx][locy].PlacesList[0].getName()); 
				System.out.println("A for Airport");
				System.out.println("Where do you want to investigate? ");
				IInput = keyboard3.next().toUpperCase();
			}
            else {
              break;
            }
			}
        }
        while (true){
			if( IInput.equals("H") ){
				World.alex.time -= 2;
				Walk.walkDisplay(IInput);
				System.out.println("Investigation complete. You spent 2 hours to do so.");
				System.out.println("Here is your hint(thing): ");
				System.out.println ( World.CountryList[locx][locy].PlacesList[0].getHint() );
				System.out.println("You have " + World.alex.time + " hours to finish this task" );
				if( World.alex.time <=0 ) {
					System.out.println("You are out of time young man. Mission failed! Do you want to restart the game (y/n)?");
					Scanner restart = new Scanner(System.in);
					String yesno = restart.next();
					if ( yesno.toUpperCase().equals("Y") ){
						World.newGame();
					}
					else{
						System.exit(0);
					}
				}
				counter +=1;
				break;
			}
			else if( IInput.equals("R") ){
				World.alex.time -= 2;
				Walk.walkDisplay(IInput);
				System.out.println("Investigation complete. You spent 2 hours to do so.");
				System.out.println("Here is your hint(thing): ");
				System.out.println ( World.CountryList[locx][locy].PlacesList[1].getHint() );
				System.out.println("You now have " + World.alex.time + " hours to finish this mission" );
				if( World.alex.time <=0 ) {
					System.out.println("You are out of time young man. Mission failed! Do you want to restart the game (y/n)?");
					Scanner restart = new Scanner(System.in);
					String yesno = restart.next();
					if ( yesno.toUpperCase().equals("Y") ){
						World.newGame();
					}
					else{
						System.exit(0);
					}
				}
				counter +=1;
				break;
			}
			else if( IInput.equals("A") ){
				World.alex.time -= 2;
				Walk.walkDisplay(IInput);
				System.out.println("Investigation complete. You spent 2 hours to do so.");
				System.out.println("Here is your hint(thing): ");
				if(flag==0){
					System.out.println (World.CountryList[locx][locy].PlacesList[2].getHint());
					System.out.println(World.CountryList[locx][locy].PlacesList[2].getThing());
				}
				else{
					System.out.println(World.CountryList[locx][locy].PlacesList[0].getHint());
					System.out.println(World.CountryList[locx][locy].PlacesList[0].getThing());
				}
				System.out.println("You now have " + World.alex.time + " hours to finish this mission" );
				if( World.alex.time <=0 ) {
					System.out.println("You are out of time young man. Mission failed! Do you want to restart the game (y/n)?");
					Scanner restart = new Scanner(System.in);
					String yesno = restart.next();
					if ( yesno.toUpperCase().equals("Y") ){
						World.newGame();
					}
					else{
						System.exit(0);
					}
				}
				if(flag ==0){
					counter +=1;
				}
				else{
					counter +=3;
				}
			}
			World.alex.setTicket();
			break;
		}
	}
     
    public static void playSound(File Sound){
		//inspired from https://www.youtube.com/watch?v=QVrxiJyLTqU
        try{			
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(Sound));
			clip.start();
			Thread.sleep(clip.getMicrosecondLength()/1000);
        }catch(Exception e){
        } 
    }
}
