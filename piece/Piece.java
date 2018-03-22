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
	
	public Piece(Player p){
		player = p;
	}
	
	public Piece(Player p, String s){
		player = p;
		name = s;
	}
	
	public void setName(String name) {
		this.name=name;
	}

	public void setColor(int color) {
		this.color=color;
	}
	
	public String getName() {
		return name;
	}
	
	public int getColor() {
		return this.color;
	}
	
//	public void setType(String type){
//		this.type = type;
//	}
//	
//	public void setWhite(boolean isWhite){
//		this.white = isWhite;
//	}
}
