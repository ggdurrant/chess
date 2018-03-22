package game;

public class Player {
	
	// color defined by integer
	// 0 = white, 1 = black
	private int color;
	
	// default player is white
	public Player(){
		color = 0;
	}
	
	public Player(int i){
		color = i;
	}
	
	// set color of player
	public void setColor(int i){
		color = i;
	}
	
	public int getColor(){
		return color;
	}
	
}
