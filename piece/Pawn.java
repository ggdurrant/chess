/**
 *  Pawn.java contains the rules for pawns to move
 *  @author Omar Morsy
 *  
 */

package piece;

import java.util.ArrayList;

import game.Player;
import game.Tile;

public class Pawn extends Piece{

	// keep track of pawn's first move (capable of moving 2 spaces)
	//private boolean firstMove;
	
	public Pawn(Player p, String s){
		super(p, s);
	}
	
	//firstMove = true;
	
	public ArrayList<Tile> goTo(Tile tile[][], int x, int y){
		
		nextTiles.clear();
		if(getPlayerColor()==0) {
			if(x==0) {
				return nextTiles;
			}
			if(tile[x-1][y].getPiece()==null) {
				nextTiles.add(tile[x-1][y]);
				if(x==6) {
					if(tile[4][y].getPiece()==null) {
						nextTiles.add(tile[4][y]);
					}
				}
			}
			if( (y>0) && (tile[x-1][y-1].getPiece() != null) && (tile[x-1][y-1].getPiece().getPlayerColor() != this.getPlayerColor()) ) {
				nextTiles.add(tile[x-1][y-1]);
			}
			if( (y<7) && (tile[x-1][y+1].getPiece() != null) && (tile[x-1][y+1].getPiece().getPlayerColor() != this.getPlayerColor()) ) {
				nextTiles.add(tile[x-1][y+1]);
			}
		} else {
			
			if(x==8) {
				return nextTiles;
			}
			if(tile[x+1][y].getPiece()==null) {
				nextTiles.add(tile[x+1][y]);
				if(x==1) {
					if(tile[3][y].getPiece()==null) {
						nextTiles.add(tile[3][y]);
					}
				}
			}
			if( (y>0) && (tile[x+1][y-1].getPiece() != null) && (tile[x+1][y-1].getPiece().getPlayerColor() != this.getPlayerColor()) ) {
				nextTiles.add(tile[x+1][y-1]);
			}
			if( (y<7) && (tile[x+1][y+1].getPiece() != null) && (tile[x+1][y+1].getPiece().getPlayerColor() != this.getPlayerColor()) ) {
				nextTiles.add(tile[x+1][y+1]);
			}
		}
		return nextTiles;
	}
}


