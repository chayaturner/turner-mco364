package turner.mco364.puzzles;

import java.util.Random;

//group class puzzle 

public class Doors {
	static final Random RAND = new Random();
	
	public static void main(String[] args){
		//switching for loop
		double switchCounter = 0;
		for(int i = 0; i < 1000; i++){
			int door = RAND.nextInt(3) + 1;
			int chosen = RAND.nextInt(3) + 1;
			
			int open = openDoor(door, chosen);
			int finalChoice = 1;
			
			while(finalChoice == open || finalChoice == chosen){
				finalChoice = RAND.nextInt(3) + 1;
			}
			
			if(finalChoice == door){
				switchCounter++;
			}
		}
		System.out.println("Percent switched and correct: " + (switchCounter / 1000));
		
		double counter = 0;
		for(int i = 0; i < 1000; i++){
			int door = RAND.nextInt(3) + 1;
			int chosen = RAND.nextInt(3) + 1;
			
			//int open = openDoor(door, chosen);
			
			if(chosen == door){
				counter++;
			}
		}
		
		System.out.println("Percent not switched and correct: " + (counter/1000));
		
	}
	
	public static int openDoor(int door, int chosen){
		int open;
		if(chosen == door){
			//opens door - not yours
			open = door;
			while(open == door){
				open = RAND.nextInt(3) + 1;
			}
		} else{
			open = door;
			while(open == door || open == chosen){
				open = RAND.nextInt(3) + 1;
			}
		}
		return open;
	}
}