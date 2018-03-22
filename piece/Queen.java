package piece;

import java.util.ArrayList;

import game.Tile;
import game.Player;

public class Queen extends Piece{

	public Queen(Player p, String s){
		super(p, s);
	}
	
	public ArrayList<Tile> goTo(Tile tile[][],int x,int y) {
		
		nextTiles.clear();
		
		int currX = x-1;
		
		while(currX >= 0) {
			
			if(tile[currX][y].getPiece()==null) {
				nextTiles.add(tile[currX][y]);
			}
			else if(tile[currX][y].getPiece().getColor()==this.getColor()) {
				break;
			}
			else {
				nextTiles.add(tile[currX][y]);
				break;
			}
			currX--;
		}
		
		currX=x+1;
		
		while(currX < 8) {
			if(tile[currX][y].getPiece()==null) {
				nextTiles.add(tile[currX][y]);
			}
			else if(tile[currX][y].getPiece().getColor()==this.getColor()) {
				break;
			}
			else {
				nextTiles.add(tile[currX][y]);
				break;
			}
			currX++;
		}
		
		int currY=y-1;
		
		while(currY >= 0) {
			
			if(tile[x][currY].getPiece()==null) {
				nextTiles.add(tile[x][currY]);
			}
			else if(tile[x][currY].getPiece().getColor()==this.getColor()) {
				break;
			}
			else {
				nextTiles.add(tile[x][currY]);
				break;
			}
			currY--;
		}
		currY = y+1;
		while(currY < 8) {
			
			if(tile[x][currY].getPiece()==null) {
				nextTiles.add(tile[x][currY]);
			}
			
			else if(tile[x][currY].getPiece().getColor()==this.getColor()) {
				break;
			}
			
			else {
				nextTiles.add(tile[x][currY]);
				break;
			}
			currY++;
		}
		
		currX = x+1;
		currY = y-1;
		while(currX < 8 && currY >= 0) {
			if(tile[currX][currY].getPiece()==null) {
				nextTiles.add(tile[currX][currY]);
			}
			else if(tile[currX][currY].getPiece().getColor()==this.getColor()) {
				break;
			}
			else {
				nextTiles.add(tile[currX][currY]);
				break;
			}
			currX++;
			currY--;
		}
		currX = x-1;
		currY = y+1;
		while(currX >=0 && currY < 8) {
			if(tile[currX][currY].getPiece()==null) {
				nextTiles.add(tile[currX][currY]);
			}
			else if(tile[currX][currY].getPiece().getColor()==this.getColor()) {
				break;
			}
			else {
				nextTiles.add(tile[currX][currY]);
				break;
			}
			currX--;
			currY++;
		}
		currX = x-1;
		currY = y-1;
		while(currX >= 0 && currY >= 0) {
			if(tile[currX][currY].getPiece()==null) {
				nextTiles.add(tile[currX][currY]);
			}
			else if(tile[currX][currY].getPiece().getColor()==this.getColor()) {
				break;
			}
			else {
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
			else if(tile[currX][currY].getPiece().getColor()==this.getColor()) {
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
