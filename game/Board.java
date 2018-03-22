package game;

import piece.Piece;
import piece.Pawn;
import piece.King;
import piece.Queen;
import piece.Knight;
import piece.Bishop;
import piece.Rook;

public class Board {

	private Tile[][] board;
	
	public Board(){
		
		// create white and black player
		Player white = new Player(0);
		Player black = new Player(1);
		
		// initialize new 9x9 board of Tile objects
		board = new Tile[9][9];
		// set black/white tiles 
		for(int i=0; i<9; i++){
			for(int j=0; j<9; j++){
				board[i][j] = new Tile();
				
			}
		}
		
		
		board[0][0] = new Tile(new Rook(black, "bR"));
		board[0][1] = new Tile(new Knight(black, "bN"));
		board[0][2] = new Tile(new Bishop(black, "bB"));
		board[0][3] = new Tile(new Queen(black, "bQ"));
		board[0][4] = new Tile(new King(black, "bK"));
		board[0][5] = new Tile(new Bishop(black, "bB"));
		board[0][6] = new Tile(new Knight(black, "bN"));
		board[0][7] = new Tile(new Rook(black, "bR"));
		
		for(int i=0; i<8; i++){
			board[1][i] = new Tile(new Pawn(black, "bp"));
		}
		
		board[7][0] = new Tile(new Rook(white, "wR"));
		board[7][1] = new Tile(new Knight(white, "wN"));
		board[7][2] = new Tile(new Bishop(white, "wB"));
		board[7][3] = new Tile(new Queen(white, "wQ"));
		board[7][4] = new Tile(new King(white, "wK"));
		board[7][5] = new Tile(new Bishop(white, "wB"));
		board[7][6] = new Tile(new Knight(white, "wN"));
		board[7][7] = new Tile(new Rook(white, "wR"));
		
		for(int i=0; i<8; i++){
			board[6][i] = new Tile(new Pawn(white, "wp"));
		}
		

	}
	
	public Tile getTile(int x, int y){
		return board[x][y];
	}
	
	public Tile[][] getBoard(){
		return board;
	}
	
	public void printBoard(){
		String s = "";
		for(int i=0; i<8; i++){
			s = "";
			for(int j=0; j<9; j++){
				if(j==8){
					if(i==0) s=s+"8";
					else if(i==1) s=s+"7";
					else if(i==2) s=s+"6";
					else if(i==3) s=s+"5";
					else if(i==4) s=s+"4";
					else if(i==5) s=s+"3";
					else if(i==6) s=s+"2";
					else if(i==7) s=s+"1";
					else s=s+" ";
				}
				else if(board[i][j].getPiece()==null){
					if((i+j)%2==0){
						s = s+"   ";
					}
					else{
						s = s+"##"+" ";
					}
					
				}
				else{
					s = s+board[i][j].getPieceName() + " ";
				}
			}
			System.out.println(s);
		}
		String sLast = " a  b  c  d  e  f  g  h";
		System.out.print(sLast);
		
	}
		

}
	
