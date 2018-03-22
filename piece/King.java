package piece;

import java.util.ArrayList;

import game.Tile;

public class King extends Piece {

	// position variables
	private int x;
	private int y;
	
	// constructor with position and color
	public King(String n, int x, int y, int c) {
		setX(x);
		setY(y);
		setName(n);
		setColor(c);
	}
	
	public void setX(int x) {
		this.x=x;
	}
	
	public void setY(int y) {
		this.y=y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	

}
