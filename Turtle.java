
public class Turtle extends Critter {
	
	//steps used for movement in increments of 5
	
	private int steps = 0;
	
	// will equal 'X' if count is 5, 'T' otherwise
	public char getChar() {
		if (count == 5) {
			return 'X';
		}
		else {
			return 'T';
		}
	}
	
	public Direction getMove(CritterInfo info) {
		//Will keep the 'X' constant after count = 5
		if (getChar() == 'X') {
			currentDirection = Direction.NONE;
			return currentDirection;
		}
		//restarts the steps
		if (steps == 20) {
			steps = 0;
		}
		//direction is based on the steps variable.
		//Critter will move in the direction according to the number step is on
		if (steps < 5) {
			currentDirection = Direction.SOUTH;
			steps++;
		}
		else if (steps < 10) {
			currentDirection = Direction.WEST;
			steps++;
		}
		else if (steps < 15) {
			currentDirection = Direction.NORTH;
			steps++;
		}
		else {
			currentDirection = Direction.EAST;
			steps++;
		}
		
		//checks to see if the neighbor of the currentDirection is a stone object
		//If a stone is in the way, it will not move and increase the counter.
		//If there is no stone object, and the counter is not 5, it will move
		//in that direction and reset the counter. 
		if (info.getNeighbor(currentDirection) instanceof Stone) {
			//System.out.println("Stone here.");
			currentDirection = Direction.NONE;
			steps++;
			count++;
		}
		else {
			count = 0;
		}
		//currentDirection = sameDirection;
		return currentDirection;
	}
}
