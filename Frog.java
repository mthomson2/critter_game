import java.util.Random;

public class Frog extends Critter {
	
	Random r = new Random();
	private int count = 0;
	
	// Used for getMove() method
	private int max = 3;
	
	private Direction sameDirection; 
	
	//Returns 'X' if count is 5, 'F' otherwise
	public char getChar() {
		if (count == 5) {
			return 'X';
		}
		else {
			return 'F';
		}
	}
	
	public Direction getMove(CritterInfo info) {
		if (getChar() == 'X') {
			currentDirection = Direction.NONE;
			return currentDirection;
		}
		
		//Random direction using r. Sets max == 3 to pick a new direction every three turns
		if (max == 3) {
			int holder = r.nextInt(4);
			if (holder == 0) {
				currentDirection = Direction.NORTH;
			}
			else if (holder == 1) {
				currentDirection = Direction.EAST;
			}
			else if (holder == 2) {
				currentDirection = Direction.SOUTH;
			}
			else {
				currentDirection = Direction.WEST;
			}
			
			if (info.getNeighbor(currentDirection) instanceof Stone) {
				//System.out.println("Stone here.");
				currentDirection = Direction.NONE;
				count++;
			}	
			else {
				count = 0;
			}
			
			
			sameDirection = currentDirection;
			//decrements to control flow. 
			max--;
		}
		//Keeps on going until max == 3. 
		else {
			
			//checks to see if the neighbor of the currentDirection is a stone object
			//If a stone is in the way, it will not move and increase the counter.
			//If there is no stone object, and the counter is not 5, it will move
			//in that direction and reset the counter. 
			
			if (info.getNeighbor(currentDirection) instanceof Stone) {
				//System.out.println("Stone here.");
				currentDirection = Direction.NONE;
				count++;
			}	
			else {
				count = 0;
			}
			
			sameDirection = currentDirection;
			max--;
			if (max == 0) {
				max = 3;
			}
		}
		return sameDirection;
	}
}
