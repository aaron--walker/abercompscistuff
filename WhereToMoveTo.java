import java.util.Random;

/**
 * Where to move to - an object that helps users decide where they should move to, and if it is possible to do so. 
 * It requires a direction enum with the 8 main compass points in (N,E,S,W,NE,NW,SE,SW) and a position class
 * The position class should contain x and y ints, as well as getters and setters.
 * This class was used for my CS12320 java module
 * note that in this example the range is from 1 to max rather than 0 to max.
 * @author Aaron Walker - aaw13@aber.ac.uk
 *
 */
public class WhereToMoveTo {
	private int xmin;
	private int ymin;
	private int xmax;
	private int ymax;
	/**	
	 * @param xmax the maximum value of x
	 * @param ymax the maximum value of y
	 */
	public WhereToMoveTo(int xmax,int ymax){
		xmin = 1;
		ymin = 1;
		this.xmax = xmax;
		this.ymax = ymax;
	}
	
	
	/**
	 * Generates a random direction in the form of direction
	 * @return A random direction
	 */
	public direction getRandomDirection(){
		Random rn = new Random();
		int randomNumber = rn.nextInt(8) + 1;
		return direction.values()[randomNumber];
	}
	
	
	/**
	 * Tries to return the new location in a grid.
	 * It will check if it is on the boundary, and if it tries to move outside, will return start pos.
	 * If it can be moved, then it will move, and return the new location
	 * @param start the starting possession
	 * @param direction the direction of travel
	 * @return the end destination - it will be the same as start if it can not move
	 */
	public Position getMovePosition(Position start, direction direction){
		if (checkCanMove(start, direction) == false){
			System.out.println("Cannont move to this location!");
		}
		else{
			switch (direction){
			case N: minY(start);
			case E: addX(start);
			case S: addY(start);
			case W: minX(start);
			case NE: minY(start); addX(start);
			case NW: minY(start); minX(start);
			case SE: addY(start); addX(start);
			case SW: addY(start); minX(start);
			}
		}
		return start;
	}
	
	
	/**
	 * Check if a move can be made
	 * @param start the start location
	 * @param direction the direction of travel
	 * @return true if it can move, otherwise false
	 */
	public boolean checkCanMove(Position start, direction direction){
		switch (direction){
		case N: return canMoveNorth(start);
		case E: return canMoveEast(start);
		case S: return canMoveSouth(start);
		case W: return canMoveWest(start);
		case NE: return canMoveNorthEast(start);
		case NW: return canMoveNorthWest(start);
		case SE: return canMoveSouthEast(start);
		case SW: return canMoveSouthWest(start);
		default: return false;
		}
	}
	
	
	
	/**
	 * Increments the x value of a position by one
	 * @param the position to alter
	 */
	private void addX(Position start){
		start.setX(start.getX() +1); 
	}
	/**
	 * Decreases the x value of a position by one
	 * @param the position to alter
	 */
	private void minX(Position start){
		start.setX(start.getX() -1); 
	}
	/**
	 * Increments the y value of a position by one
	 * @param the position to alter
	 */
	private void addY(Position start){
		start.setY(start.getY() +1); 
	}
	/**
	 * Decreases the y value of a position by one
	 * @param the position to alter
	 */
	private void minY(Position start){
		start.setY(start.getY() -1); 
	}
	
	
	
	
	/**
	 * Checks if the location can be moved in the direction
	 * @param start the position
	 * @return true if possible, otherwise false
	 */
	private boolean canMoveNorth(Position start){
		if (start.getY() < ymin){
			return false;
		}
		return true;
	}
	/**
	 * Checks if the location can be moved in the direction
	 * @param start the position
	 * @return true if possible, otherwise false
	 */
	private boolean canMoveSouth(Position start){
		if (start.getY() > ymax){
			return false;
		}
		return true;
	}
	/**
	 * Checks if the location can be moved in the direction
	 * @param start the position
	 * @return true if possible, otherwise false
	 */
	private boolean canMoveEast(Position start){
		if (start.getX() > xmax){
			return false;
		}
		return true;
	}
	/**
	 * Checks if the location can be moved in the direction
	 * @param start the position
	 * @return true if possible, otherwise false
	 */
	private boolean canMoveWest(Position start){
		if (start.getX() < xmin){
			return false;
		}
		return true;
	}
	/**
	 * Checks if the location can be moved in the direction
	 * @param start the position
	 * @return true if possible, otherwise false
	 */
	private boolean canMoveNorthWest(Position start){
		if (canMoveNorth(start) && canMoveWest(start)){
			return true;
		}
		return false;
	}
	/**
	 * Checks if the location can be moved in the direction
	 * @param start the position
	 * @return true if possible, otherwise false
	 */
	private boolean canMoveNorthEast(Position start){
		if (canMoveNorth(start) && canMoveEast(start)){
			return true;
		}
		return false;
	}
	/**
	 * Checks if the location can be moved in the direction
	 * @param start the position
	 * @return true if possible, otherwise false
	 */
	private boolean canMoveSouthWest(Position start){
		if (canMoveSouth(start) && canMoveWest(start)){
			return true;
		}
		return false;
	}
	/**
	 * Checks if the location can be moved in the direction
	 * @param start the position
	 * @return true if possible, otherwise false
	 */
	private boolean canMoveSouthEast(Position start){
		if (canMoveSouth(start) && canMoveEast(start)){
			return true;
		}
		return false;
	}
}
