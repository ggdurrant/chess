/** 
 *  Tile.java contains information about a tile's location on the 
 *  chessboard as well as the piece currently associated with the 
 *  tile and the display shown on the chessboard
 *  @author George Durrant
 *  
 */

package game;

import piece.Piece;

public class Tile {
	
	private Piece piece;
	private String display;
	private int x;
	private int y;
	
	/** 
	 * default constructor giving null piece and blank name
	 */
	public Tile(){
		piece = null;
		display = "";
	}
	
	/** constructor specifiying coordinates of tile
	 * 
	 * @param i
	 * @param j
	 */
	public Tile(int i, int j){
		x = i;
		y = j;
	}
	
	/** get x coordinate 
	 * 
	 * @return
	 */
	public int getX(){
		return x;
	}
	
	/** get y coordinate
	 * 
	 * @return
	 */
	public int getY(){
		return y;
	}
	
	/** constructor for tile with piece to be associated with
	 * 
	 * @param p
	 */
	public Tile(Piece p){
		piece = p;
	}
	
	/** return piece on tile
	 * 
	 * @return
	 */
	public Piece getPiece(){
		return piece;
	}
	
	/** return name of piece on tile
	 * 
	 * @return
	 */
	public String getPieceName(){
		if(piece == null){
			return "";
		}
		return piece.getName();
	}
	
	/** set piece on tile
	 * 
	 * @param p
	 */
	public void setPiece(Piece p){
		piece = p;
	}

	public void setDisplay(String s){
		display = s;
	}
	
	public String getDisplay(){
		return display;
	}
	
	public String toString(){
		return display;
	}
	

}
	
