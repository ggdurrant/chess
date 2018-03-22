/** 
 *  Rook.java contains the rules for rooks to move
 *  @author Omar Morsy
 *  
 */


package piece;

import java.util.ArrayList;
import game.Player;
import game.Tile;

public class Rook extends Piece{

	public Rook(Player p, String s){
		super(p, s);
	}
	public ArrayList<Tile> goTo(Tile tile[][],int x,int y) {

		nextTiles.clear(); //empty out nextTiles
		
		int currX=x-1;
		
		while(currX>=0) {
			if(tile[currX][y].getPiece() == null) {
				nextTiles.add(tile[currX][y]);
			}
			else if(tile[currX][y].getPiece().getPlayerColor() == this.getPlayerColor()) {
				break;
			} else {
				nextTiles.add(tile[currX][y]);
				break;
			}
			currX--;
		}
		currX = x+1;
		
		while(currX < 8) {
			if(tile[currX][y].getPiece() == null) {
				nextTiles.add(tile[currX][y]);
			}
			else if(tile[currX][y].getPiece().getPlayerColor()==this.getPlayerColor()) {
				break;
			} else {
				nextTiles.add(tile[currX][y]);
				break;
			}
			currX++;
		}
		int currY = y-1;
		while(currY >= 0) {
			if(tile[x][currY].getPiece() == null) {
				nextTiles.add(tile[x][currY]);
			} else if(tile[x][currY].getPiece().getPlayerColor() == this.getPlayerColor()) {
				break;
			} else {
				nextTiles.add(tile[x][currY]);
				break;
			}
			currY--;
		}
		currY=y+1;
		while(currY < 8) {
			if(tile[x][currY].getPiece() == null) {
				nextTiles.add(tile[x][currY]);
			} else if(tile[x][currY].getPiece().getPlayerColor() == this.getPlayerColor()) {
				break;
			} else {
				nextTiles.add(tile[x][currY]);
				break;
			}
			currY++;
		}
		return nextTiles;
	}
}


