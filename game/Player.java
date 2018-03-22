/**
 *  Player.java constructs Player objects which are defined by
 *  color as an integer to distinguish between opponents' pieces
 *  @author George Durrant
 *  
 */

package game;

public class Player {
	
	// color defined by integer
	// 0 = white, 1 = black
	private int color;
	
	/** default player constructor sets player to white
	 * 
	 */
	public Player(){
		color = 0;
	}
	
	/** set player to color based on integer
	 * 
	 * @param i
	 */
	public Player(int i){
		color = i;
	}
	
	
	/** set color of player
	 * 
	 * @param i
	 */
	public void setColor(int i){
		color = i;
	}
	
	/** return color of player
	 * 
	 * @return
	 */
	public int getColor(){
		return color;
	}
	
}
