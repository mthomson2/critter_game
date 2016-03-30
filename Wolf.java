
public class Wolf extends Critter {
	
	//number used to see if a number is even or odd
	private int number = 1;
	
	//Will return 'X' if count is 5, 'W' otherwise
	public char getChar() {
		if (count == 5) {
			return 'X';
		}
		else {
			return 'W';
		}
	}
	
	/*
	 * Wolf will create a 'V' shape. Two V's make a 'W', so with two implementations of this method,
	 * the Wolf will move in the form of a 'W'. 
	 * 
	 */
	
	public Direction getMove(CritterInfo info) {
		if (getChar() == 'X') {
			currentDirection = Direction.NONE;
			return currentDirection;
		}
		
		//Makes the downward slash in V. Will zig zag South and East by even and odd numbers of variable number
		if (number < 40) {
			if (number % 2 == 0) {
				currentDirection = Direction.SOUTH;
			}
			else {
				currentDirection = Direction.EAST;
			}
		}
		//Makes forward slash in 'V'. 
		else if (number <80) {
			if (number % 2 == 0) {
				currentDirection = Direction.NORTH;
			}
			else {
				currentDirection = Direction.EAST;
			}
		}
		
		//restarts number count.
		if (number == 80) {
			number = 1;
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
		number++;
		return currentDirection;
	}
}
