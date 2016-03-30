
public class Mouse extends Critter {

	private Boolean isNorth = false;
	
	Direction saveDirection;
	
	public char getChar() {
		if (count == 5) {
			return 'X';
		}
		else {
			return 'M';
		}
	}
	
	public Direction getMove(CritterInfo info) {
		if (getChar() == 'X') {
			currentDirection = Direction.NONE;
			return currentDirection;
		}
		
		if (isNorth == false) {
			currentDirection = Direction.WEST;
			isNorth = true;
		}
		else {
			currentDirection = Direction.NORTH;
			isNorth = false;
		}
		
//		super.getXDirection(currentDirection, info);
//		System.out.println(count);
//		//System.out.println(super.count);
//		System.out.println(currentDirection);
////		public static Direction getXDirection(Direction currentDirection, CritterInfo info) {
////			if (info.getNeighbor(currentDirection) instanceof Stone) {
////				System.out.println("Stone here.");
////				currentDirection = Direction.NONE;
////				Critter.count++;
////				
////			}
////			else {
////				Critter.count = 0;
////				
////			}
////		}
		
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
