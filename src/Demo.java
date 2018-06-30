
public class demo{

	public static void main(String[] arggs) throws InterruptedException{   
		String IInput="H";
		if(IInput.equals("H")){ 
			System.out.println("\t\tALEX");
			System.out.print("\t  ");
			for(int i=0;i<10;i++){
				for(int j=10-i-1;j>0;j--){
					System.out.print(" ");
				}
				System.out.println("/");
				if(i!=9){
					System.out.print("\t  ");
				}
				else 
					System.out.print("\t");
				Thread.sleep(500);
			}
		}
		
		else if(IInput.equals("R")){
			System.out.println("\tALEX");
			System.out.print("\t");
			for(int i=0;i<10;i++){
				for(int j=1;j>0;j--){
					if(i!=9)
						System.out.print("|");
				}
			if(i!=9)
				System.out.print("\n\t");
			else 
				System.out.println("V");
			Thread.sleep(500);
			}
		}
		
		else{
			System.out.println("\tALEX");
			for(int i=0;i<10;i++){
				System.out.print("\t"); 
				for(int j=0;j<i+1;j++){
					System.out.print(" ");      
				}
				System.out.println("\\");
				Thread.sleep(500);
			}
		}
		System.out.println("Hotel  Restraunt  Airport");
	}
	
}
