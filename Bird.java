import java.util.Random;

public class Bird extends Critter {
	
	//Creates random object 
	Random r = new Random();

	/*
	 * getChar() determines when a critter should be a 'X' or 'B'based on count
	 * if count is 5, then it should remain an 'X'
	 * 
	 */
	
	public char getChar() {
		if (count == 5) {
			//currentDirection = Direction.NONE;
			return 'X';
		}
		else {
			return 'B';
		}
	}
	
	public Direction getMove(CritterInfo info) {
		Random r = new Random();
		
		//holder is a randomly generated number.
		//Each number 0-3 is a direction, and the bird will move
		//in that randomly generated direction whenever it equals the number
		
		int holder = r.nextInt(4);
	
		//Will return a 'X' indefinitely after count == 5
		if (getChar() == ('X')) {
			currentDirection = Direction.NONE;
			return currentDirection;
		}
		
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
	
		
		
		return currentDirection;
	}	
}
