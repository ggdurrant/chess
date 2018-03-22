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
		

		
//		for(int i=1; i<8; i++){
//			for(int j=1; j<8; j++){
//				if((i+j)%2==0){
//					board[i][j].setDisplay("  ");
//				}
//				else{
//					board[i][j].setDisplay("##");
//				}
//			}
//		}
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
		
		
//		for(int i=0; i<8; i++){
//			for(int j=0; j<8; j++){
//				System.out.print(board[i][j].getDisplay());
//			}
//		}
	

	
	
	
}
	
	
	
	
	
////	private static Pawn wP1, wP2, wP3, wP4, wP5, wP6, wP7, wP8;
////	private static Pawn bP1, bP2, bP3, bP4, bP5, bP6, bP7, bP8;
////	private static King wK, bK;
////	private static Queen wQ, bQ;
////	private static Knight wKn1, wKn2, bKn1, bKn2;
////	private static Bishop wB1, wB2, bB1, bB2;
////	private static Rook wR1, wR2, bR1, bR2;
//	
//	private static Pawn wp[], bp[];
//	private static King wK, bK;
//	private static Queen wQ, bQ;
//	private static Knight wN[], bN[];
//	private static Bishop wB[], bB[];
//	private static Rook wR[], bR[];
//	
//		public Board(){
//			
////			wP1 = new Pawn("wp", true);
////			wP2 = new Pawn("wp", true);
////			wP3 = new Pawn("wp", true);
////			wP4 = new Pawn("wp", true);
////			wP5 = new Pawn("wp", true);
////			wP6 = new Pawn("wp", true);
////			wP7 = new Pawn("wp", true);
////			wP8 = new Pawn("wp", true);
////			bP1 = new Pawn("bp", false);
////			bP2 = new Pawn("bp", false);
////			bP3 = new Pawn("bp", false);
////			bP4 = new Pawn("bp", false);
////			bP5 = new Pawn("bp", false);
////			bP6 = new Pawn("bp", false);
////			bP7 = new Pawn("bp", false);
////			bP8 = new Pawn("bp", false);
////			wK = new King("wK", true);
////			bK = new King("bK", false);
////			wQ = new Queen("wQ", true);
////			bQ = new Queen("bQ", false);
////			wKn1 = new Knight("wN", true);
////			wKn2 = new Knight("wN", true);
//			
//			
//			// initialize pawn objects
//			wp = new Pawn[8];
//			bp = new Pawn[8];
//			for(int i=0; i<8; i++){
//				wp[i] = new Pawn();
//				wp[i].setWhite(true);
//				wp[i].setName("wp");
//				bp[i] = new Pawn();
//				bp[i].setWhite(false);
//				bp[i].setName("bp");
//			}
//			
//			// initialize knight objects
//			wN = new Knight[2];
//			bN = new Knight[2];
//			for(int i=0; i<2; i++){
//				wN[i] = new Knight();
//				wN[i].setWhite(true);
//				wN[i].setName("wN");
//				bN[i] = new Knight();
//				bN[i].setWhite(false);
//				bN[i].setName("bN");
//			}
//			
//			// initialize bishop objects
//			wB = new Bishop[2];
//			bB = new Bishop[2];
//			for(int i=0; i<2; i++){
//				wB[i] = new Bishop();
//				wB[i].setWhite(true);
//				wB[i].setName("wB");
//				bB[i] = new Bishop();
//				bB[i].setWhite(false);
//				bB[i].setName("bB");
//			}
//			
//			// initialize rook objects
//			wR = new Rook[2];
//			bR = new Rook[2];
//			for(int i=0; i<2; i++){
//				wR[i] = new Rook();
//				wR[i].setWhite(true);
//				wR[i].setName("wR");
//				bR[i] = new Rook();
//				bR[i].setWhite(false);
//				bR[i].setName("bR");
//			}
//			
//			// initialize Queen objects
//			wQ = new Queen();
//			wQ.setName("wQ");
//			wQ.setWhite(true);
//			bQ = new Queen();
//			bQ.setName("bQ");
//			bQ.setWhite(false);
//			
//			// intialize King objects
//			wK = new King();
//			wK.setName("wK");
//			wK.setWhite(true);
//			bK = new King();
//			bK.setName("bK");
//			bK.setWhite(false);
//			
//			
//		
//			// set the initial board
//			board = new Tile[9][9];
//			for(int i=1; i<9; i++){
//				for(int j=1; j<9; j++){
//					board[i][j].x = i;
//					board[i][j].y = j;
//				}
//			}
//			
//		}
//		
//		public String toString(){
//			String s = "";
//			
//			for(int i=0; i<9; i++){
//				for(int j=0; j<9; j++){
//					s = s+board[i][j].x + " ";
//					s = s+board[i][j].y + " ";
//					
//				}
//			}
//			
//			return s;
//		}
//		
//		public static void main(String[] args){
//			Board begin = new Board();
//			System.out.println(begin);
//			
//		}
//}
