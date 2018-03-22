/**
 *  Bishop.java contains the rules for bishops to move
 *  @author Omar Morsy
 *  
 */

package piece;

import java.util.ArrayList;

import game.Tile;
import game.Player;

public class Bishop extends Piece{

	public Bishop(Player p, String s){
		super(p, s);
	}
	
	public ArrayList<Tile> goTo(Tile tile[][], int x, int y){
		nextTiles.clear();
		int currX = x+1;
		int currY = y-1; // step curry #30
		
		while(currX < 8 && currY >= 0) {
			
			if(tile[currX][currY].getPiece()==null) {
				nextTiles.add(tile[currX][currY]);
			}
			else if(tile[currX][currY].getPiece().getPlayerColor()==this.getPlayerColor()) {
				break;
			} else {
				nextTiles.add(tile[currX][currY]);
				break;
			}
			currX++;
			currY--;
		}
		
		currX = x-1;
		currY = y+1;
		
		while(currX >= 0 && currY < 8) {
			
			if(tile[currX][currY].getPiece()==null) {
				nextTiles.add(tile[currX][currY]);
			} else if(tile[currX][currY].getPiece().getPlayerColor()==this.getPlayerColor()) {
				break;
			} else {
				nextTiles.add(tile[currX][currY]);
				break;
			}
			currX--;
			currY++;
		}
		
		currX=x-1;currY=y-1;
		
		while(currX >= 0 && currY >= 0) {
			
			if(tile[currX][currY].getPiece()==null) {
				nextTiles.add(tile[currX][currY]);
			} else if(tile[currX][currY].getPiece().getPlayerColor()==this.getPlayerColor()) {
				break;
			} else {
				nextTiles.add(tile[currX][currY]);
				break;
			}
			currX--;
			currY--;
		}
		currX=x+1;
		currY=y+1;
		
		while(currX < 8 && currY < 8) {
			
			if(tile[currX][currY].getPiece()==null) {
				nextTiles.add(tile[currX][currY]);
			}
			else if(tile[currX][currY].getPiece().getPlayerColor()==this.getPlayerColor()) {
				break;
			}
			else {
				nextTiles.add(tile[currX][currY]);
				break;
			}
			currX++;
			currY++;
		}
		return nextTiles;
	}
	
}
