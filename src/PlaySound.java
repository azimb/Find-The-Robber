import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class PlaySound{
  
	public static void main(String[] args){
		File airplane = new File("airland.wav");
		File footsteps = new File("pas.wav");
		PlaySound(footsteps);
		PlaySound(footsteps);
	}
	static void PlaySound(File Sound){
		try{

			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(Sound));
			clip.start();
	   
			Thread.sleep(clip.getMicrosecondLength()/1000);
   
		}catch(Exception e){
   
		} 
	} 
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/* FOR AIRPLANE SOUND
File airplane = new File("airland.wav");
static void playAir(File Sound){
 
  static void PlaySound(File Sound){
  
  try{

   Clip clip = AudioSystem.getClip();
   clip.open(AudioSystem.getAudioInputStream(Sound));
   clip.start();
   
   Thread.sleep(clip.getMicrosecondLength()/1000);
   
  }catch(Exception e){
   
  } 
 }
} */


/* FOR FOOTSTEPS SOUND
File airplane = new File("pas.wav");
static void playAir(File Sound){
 
  static void PlaySound(File Sound){
  
  try{

   Clip clip = AudioSystem.getClip();
   clip.open(AudioSystem.getAudioInputStream(Sound));
   clip.start();
   
   Thread.sleep(clip.getMicrosecondLength()/1000);
   
  }catch(Exception e){
   
  } 
 }
} */
