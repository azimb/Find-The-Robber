import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class World {
	public static Country[][] CountryList=new Country[2][3];
    public static Player alex;
    public static Thief abd;
    public static Player boss;
	public static void newGame() throws InterruptedException{
		String playerName;
		Scanner input=new Scanner(System.in);
		System.out.println("PLAYER, enter your details ");
		System.out.println("Name :");
		playerName=input.nextLine();
		alex = new Human (playerName,"Canada", 50); //name , Country , Time 
		Things medal=new Things("Medal");
		abd = new Thief("Abd", "New Zeland", "White", 120, true);
		boss=new Computer("Boss","",medal);
		Things t1=new Things("Ticket");
		Things t2=new Things ("Ticket");
		Things t3=new Things("Ticket");
		Things t4=new Things ("Ticket");
		Things t5=new Things("Ticket");
		Things t6=new Things ("Ticket");
		Computer hotRecepCan = new Computer("Hotel Receptionist Canada", "HINT: The guy you're looking for said something about 3 Lions.",null);
		Computer resWaitCan = new Computer("Restaurant Waiter Canada", "HINT + THIEF CHARACTERISTIC(1): This guy wanted to know where he could exchange his money for pounds.  He had funny GLASSES on. ",null);
		Computer airOffCan = new Computer("Airport Officer Canada", "HINT: The gentleman seemed to have a fascination for a certain monarch.",t1); 
		Computer hotRecepEng = new Computer("Hotel Receptionist England", "Hint: Yes the gentleman was interested in staying in one of our franchise hotels near the Sphinx.",null);
		Computer resWaitEng = new Computer("Restaurant Waiter England", "Hint: Yeah the guy you want to interrogate wanted to visit the Pharaohs.",null);
		Computer airOffEng = new Computer("Airport Officer England", "Hint: I overheard the guy you're looking saying something about an excursion near the Nile.",t2);
		Computer hotRecepEgy = new Computer("Hotel Receptionist Egypt", "HINT + THIEF CHARACTERISTIC(2): This funny individual said he was a huge fan of the All Blacks Rugby team.  He had a TATTOO on his right arm.",null);
		Computer resWaitEgy = new Computer("Restaurant Waiter Egypt", "Hint: Yeah the guy you want to apprehend mentioned he wanted to be around kiwis and he didn't mean fruit. ",null);
		Computer airOffEgy = new Computer("Airport Officer Egypt", "HINT: The guy you're looking for wanted to learn more about Maori culture.",t3); 
		Computer hotRecepNzl = new Computer("Hotel Receptionist New Zeland", "nzl hint 1 - empty ",null);
		Computer resWaitNzl = new Computer("Restaurant Waiter New Zeland", "nzl hint 2 - empty",null);
		Computer airOffNzl = new Computer("Airport Officer New Zeland", "nzl hint 3 - empty",t4); 
		Computer airOffJap = new Computer("Airport Officer Japan", "Things have been very quiet here.  There's more action where you came from. Safe travels.",t5);
		Computer airOffBra = new Computer("Airport Officer Brazil", "Things have been very quiet here.  There's more action where you came from. Safe travels.",t6);
		Hotel hotelCan = new Hotel ( "Canada", hotRecepCan );
		Res resCan = new Res ( "Canada", resWaitCan );
		Air airCan = new Air ("Canada", airOffCan );
		Hotel hotelEng = new Hotel ( "England", hotRecepEng );
		Res resEng = new Res ( "England", resWaitEng );
		Air airEng = new Air ("England", airOffEng );
		Hotel hotelEgy = new Hotel ( "Egypt", hotRecepEgy );
		Res resEgy = new Res ( "Egypt", resWaitEgy );
		Air airEgy = new Air ("Egypt", airOffEgy );
		Hotel hotelNzl = new Hotel ( "New Zeland", hotRecepNzl );
		Res resNzl = new Res ( "New Zeland", resWaitNzl );
		Air airNzl = new Air ("New Zeland", airOffNzl );
		Air airJap = new Air ("Japan", airOffJap);
		Air airBra = new Air ("Brazil", airOffBra);
		//creating countries 
		Places[] placesCanada = {hotelCan, resCan, airCan}; 
		Country canada = new Country ("Canada", placesCanada);
		Places[] placesEngland = new Places[]{hotelEng, resEng, airEng};
		Country england = new Country ("England", placesEngland);
		Places[] placesEgypt = new Places[]{hotelEgy, resEgy, airEgy};
		Country egypt = new Country ("Egypt", placesEgypt);
		Places[] placesNzl = new Places[]{hotelNzl, resNzl, airNzl};
		Country newzeland = new Country ("New Zeland", placesNzl);
		Places[] placesJapan = new Places[]{airJap};
		Country japan = new Country ("Japan", placesJapan);
		Places[] placesBrazil = new Places[]{airBra};
		Country brazil = new Country ("Brazil", placesBrazil);
		CountryList[0][0] = canada;
		CountryList[0][1] = england;
		CountryList[0][2] = japan;
		CountryList[1][0] = brazil;
		CountryList[1][1] = egypt;
		CountryList[1][2] = newzeland;
		instructions();
		subMenu();
	}
    public static void instructions() throws InterruptedException{
		File welcome = new File("welcome.wav");
		Function.playSound(welcome);
		File daveName = new File("ekabaName.wav");
		Function.playSound(daveName);
		String instr = " Each country you investigate may provide you with a maximum of 3 clues.  You will need to interact with AI players in places like hotels, restaurants and airports.  An AI player at the airport will provide you  with a flight ticket to your next country of interest. ";
		char[] c = instr.toCharArray();
		for( int i = 0; i<c.length; i++ ){
			System.out.print(c[i]);
			File key = new File("keynn.wav");
			Function.playSound(key);
		}
    }
    public static void subMenu() throws InterruptedException{
		int counter = 0;      
		int locx = alex.locx;
		int locy = alex.locy;
		Function.displaySub();
		Scanner keyboard = new Scanner(System.in);
		String userInput = keyboard.next();
		if (userInput.equals( "D" ) )  {
			Function.displayMap();
			subMenu();
		}
		else if( userInput.equals( "T" ) ) {
			Function.displayTravel();
			Scanner askDir = new Scanner(System.in);
			String askDirStr = askDir.next().toUpperCase();
			String validDir = Function.askDirection(askDirStr);
			Function.makeMove(validDir);
			if ( (alex.locx == 1) && (alex.locy == 2) ){
				System.out.println("You are in " + alex.getPos() );
				System.out.println("You have found the thief, congrats!");
				System.out.println(abd.talk());
				System.out.println("You got a Medal(thing) from Boss");
				System.out.println("Do you want to restrat the game?");
				Scanner restart = new Scanner(System.in);
				String yesno = restart.next();
				if ( yesno.toUpperCase().equals("Y") ){
					World.newGame();
				}
				else{
					System.exit(0);
				}
			}
			else{
				alex.setPos(alex.locx, alex.locy);
				System.out.println("CURRENTLY: " + alex.getPos().toUpperCase() );
				subMenu();
			}
		}   
		else if ( userInput.equals( "I" )) {
			System.out.println("You are now collecting hints");
			//print places in that country
			Function.Investigation();
			System.out.println("You are currently in: " + alex.getPos() );
			subMenu();
        }
    }
	public static void save(){}
	public static void load(){}
	public static void main(String[] args)throws InterruptedException{
		newGame();
	}
	
}
