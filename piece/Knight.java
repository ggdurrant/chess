package piece;

import java.util.ArrayList;
import game.Tile;
import game.Player;

public class Knight extends Piece{

	public Knight(Player p, String s){
		super(p, s);
	}
	
	public ArrayList<Tile> goTo(Tile tile[][], int x, int y){
		
		nextTiles.clear(); //remove all elements from nextTiles
		int desX[] = {x+1, x+1, x+2, x+2, x-1, x-1, x-2, x-2};// the destination x locations where Knight can go
		int desY[] = {y-2, y+2, y-1, y+1, y-2, y+2, y-1, y+1};
		for (int k=0; k<8; k++) {
			if((desX[k] >= 0 && desX[k] < 8 && desY[k] >= 0 && desY[k] < 8)) {
				if((tile[desX[k]][desY[k]].getPiece() == null || tile[desX[k]][desY[k]].getPiece().getColor() != this.getColor() )) {
					nextTiles.add(tile[desX[k]][desY[k]]);
				}
			}
		}
		
		return nextTiles; // this will be utilized in the Start/ main class
	}
}
