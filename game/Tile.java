package game;

import piece.Piece;

public class Tile {
	
	private Piece piece;
	private String display;
	private int x;
	private int y;
	
	public Tile(){
		piece = null;
		display = "";
	}
	
	public Tile(int i, int j){
		x = i;
		y = j;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public Tile(Piece p){
		piece = p;
	}
	
	public Piece getPiece(){
		return piece;
	}
	
	public String getPieceName(){
		if(piece == null){
			return "";
		}
		return piece.getName();
	}
	
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
	
