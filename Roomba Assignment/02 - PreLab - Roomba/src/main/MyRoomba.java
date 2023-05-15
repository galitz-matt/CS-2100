package main;

import world.Move;
import world.Roomba;

public class MyRoomba extends Roomba{
	
	private boolean turning = false;
	private Direction newDir = Direction.NORTH;

	public MyRoomba(int x, int y, int radius) {
		super(x, y, radius);
	}

	@Override
	public Move makeMove() {
		
		if(this.turning && this.getDirection() == newDir) {
			this.turning = false;
		}
		
//		if(this.frontBumper && !this.turning) {
//			turning = true;
//			switch(newDir) {
//			case NORTH :
//				if (this.wallSensor)
//					newDir = Direction.SOUTHWEST;
//				else
//					newDir = Direction.SOUTHEAST;
//				break;
//			case EAST :
//				newDir = Direction.values()[(int)(Math.random()*Direction.values().length)];
//				break;
//			case SOUTH :
//				if (this.wallSensor)
//					newDir = Direction.NORTHEAST;
//				else
//					newDir = Direction.NORTHWEST;
//				break;
//			case WEST:
//				newDir = Direction.values()[(int)(Math.random()*Direction.values().length)];
//				break;
//			case SOUTHEAST, NORTHEAST :
//				newDir = Direction.EAST;
//				break;
//			case SOUTHWEST, NORTHWEST :
//				newDir = Direction.WEST;
//				break;
//			}
			if(this.frontBumper && !this.turning) {
				turning = true;
				switch(newDir) {
				case NORTH :
						newDir = Direction.values()[(int)(Math.random()*Direction.values().length)];
					break;
				case EAST :
					if (this.wallSensor)
						newDir = Direction.NORTHWEST;
					else
						newDir = Direction.SOUTHWEST;
					break;
				case SOUTH :
						newDir = Direction.values()[(int)(Math.random()*Direction.values().length)];
					break;
				case WEST:
					if (this.wallSensor)
						newDir = Direction.SOUTHEAST;
					else
						newDir = Direction.NORTHEAST;
					break;
				case NORTHWEST, NORTHEAST :
					newDir = Direction.SOUTH;
					break;
				case SOUTHWEST, SOUTHEAST :
					newDir = Direction.NORTH;
					break;
				}
			return Move.TURNCLOCKWISE;
		}

		if(this.turning) { return Move.TURNCLOCKWISE; }
		return Move.FORWARD;
	}
	
}
