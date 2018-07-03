import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Walk{
  
	public static void walkDisplay(String str) throws InterruptedException{
		String IInput = str;
		if(IInput.equals("H")){
			System.out.println("\t\t"+World.alex.humanName);
			System.out.print("\t  ");
			for(int i=0;i<10;i++){
				for(int j=10-i-1;j>0;j--){
					System.out.print(" ");
				}
				System.out.println("/");
				File footsteps = new File("pasn.wav");
				Function.playSound(footsteps);
				if(i!=9){
					System.out.print("\t  ");
				}
				else 
					System.out.print("\t");      
			}
		}
		else if(IInput.equals("R")){
			System.out.println("\t"+World.alex.humanName);
			System.out.print("\t");
			for(int i=0;i<10;i++){
				for(int j=1;j>0;j--){
					if(i!=9)
						System.out.print(" |");
				}
				File footsteps = new File("pasn.wav");
				Function.playSound(footsteps);
				if(i!=9)
					System.out.print("\n\t");
				else 
					System.out.println(" V");
			}
		}
		else{
			System.out.println("\t"+World.alex.humanName);
			for(int i=0;i<10;i++){
				System.out.print("\t"); 
				for(int j=0;j<i+1;j++){
					System.out.print(" ");
				}
				System.out.println("\\");
				File footsteps = new File("pasn.wav");
				Function.playSound(footsteps);
			}
		}
		System.out.println("Hotel  Restraunt  Airport");
	}
	
}
