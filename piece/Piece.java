/**
 *  Piece.java is the superclass of all piece classes, and 
 *  contains methods used to get and set information about 
 *  the piece's color, player, and name
 *  @author George Durrant
 *  @author Omar Morsy
 *  
 */

package piece;

import java.util.ArrayList;
import game.Tile;
import game.Player;

public abstract class Piece {

	private int color;
	private String name=null;
	private Player player;
	
	//ArrayList<Tile> newmoves = new ArrayList<Tile>();
	protected ArrayList<Tile> nextTiles = new ArrayList<Tile>();
	public abstract ArrayList<Tile> goTo(Tile tile[][], int x, int y);
	
	/** create piece object based on the player
	 * 
	 * @param p
	 */
	public Piece(Player p){
		player = p;
	}
	
	/** constructor for Piece with player and name
	 * 
	 * @param p
	 * @param s
	 */
	public Piece(Player p, String s){
		player = p;
		name = s;
	}
	
	/** set name of piece
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name=name;
	}

	/** set color of piece
	 * 
	 * @param color
	 */
	public void setColor(int color) {
		this.color=color;
	}
	
	/** return name of piece
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/** return color of piece
	 * 
	 * @return
	 */
	public int getColor() {
		return this.color;
	}
	
	/** return player who owns piece
	 * 
	 * @return
	 */
	public Player getPlayer(){
		return player;
	}
	
	/** return player color who owns piece
	 * 
	 * @return
	 */
	public int getPlayerColor(){
		return player.getColor();
	}



}