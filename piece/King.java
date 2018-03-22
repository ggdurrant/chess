/**
 *  King.java contains the rules for kings to move
 *  @author Omar Morsy
 *  
 */

package piece;

import java.util.ArrayList;

import game.Player;
import game.Tile;

public class King extends Piece {

	public King(Player p, String s){
		super(p, s);
	}
	
	public ArrayList<Tile> goTo(Tile tile[][],int x,int y) {
		
		nextTiles.clear();
		int desX[]={x,x,x+1,x+1,x+1,x-1,x-1,x-1};
		int desY[]={y-1,y+1,y-1,y,y+1,y-1,y,y+1};
		for(int k=0;k<8;k++) {
			if((desX[k]>=0 && desX[k] < 8 && desY[k] >= 0 && desY[k] < 8)) {
				if((tile[desX[k]][desY[k]].getPiece() == null||tile[desX[k]][desY[k]].getPiece().getPlayerColor() != this.getPlayerColor())) {
					nextTiles.add(tile[desX[k]][desY[k]]);
				}
			}
		}
		return nextTiles;
	}
	

}

