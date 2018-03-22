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
	
	
	

//	public int x;
//	public int y;
//	private boolean occupied;
//	private Piece piece;
//	private boolean whiteTile;
//	private String display;
//	
//	public Tile(int x, int y){
//		this.x = x;
//		this.y = y;
//	}
//	
//	public Piece getPiece(){
//		return this.piece;		
//	}
//	
//	public void setPiece(Piece piece){
//		this.piece = piece;
//	}
//	
//	public void clearTile(){
//		this.piece = null;
//	}
//	
	
}
	
	
	
	
	
//	public Tile(int x, int y, Piece piece){
//		this.x = x;
//		this.y = y;
//		
//		// set alternating white and black tiles
//		if((x+y)%2==0){
//			whiteTile = true;
//		}
//		else{
//			whiteTile = false;
//		}
//		
//		this.piece = piece;
//	}
	
	// get Piece on Tile

