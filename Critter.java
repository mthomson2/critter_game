import java.util.Random;

/**
 *  Modified from version by Stuart Reges (12/03/04)
 */
public class Critter {
	/**
	 * These variables have been declared globally to be used in all child classes
	 *  currentDirection - The current direction the critter is moving.
	 *  count - the counter that determines when a critter should become an 'X'
	 */
	
	protected Direction currentDirection = Direction.NONE;
	public int count;
	
	/**
	 *  Gets the character representation of the critter
	 *  (for the simulation).
	 *  
	 *  @return character representation of the critter
	 */
    public char getChar() {
		return '\0';
	}
	
	/**
	 *  Gets the critter's next move.
	 *  
	 *  @param info a represenation of the information relevant to the critter
	 *  @return the direction of the critter's next move
	 */
    public Direction getMove(CritterInfo info) {
		return currentDirection;
	}
	
	/**
	 *  Returns the critter's current direction (the last
	 *  direction given by getMove())
	 *  
	 *  @return the direction of the critter's previous move
	 */
	public Direction getCurrentDirection() {
		return currentDirection;
	}
	
//	public static void getXDirection(Direction currentDirection, CritterInfo info) {
//		if (info.getNeighbor(currentDirection) instanceof Stone) {
//			System.out.println("Stone here.");
//			currentDirection = Direction.NONE;
//			count++;
//			System.out.println(currentDirection);
//			//return currentDirection;
//		}
//		else {
//			count = 0;
//			//return currentDirection;
//		}
//	}
}
