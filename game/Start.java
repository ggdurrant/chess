/**
 * Start is the main class in our chess program, which runs the actual 
 * game in the main method. It imports all of the piece classes and
 * uses the board defined in Board.java, as well as Tile.java and Player.java.
 * 
 * There is a white player and a black player, white goes first. The user enters
 * the coordinates of the piece they want to move and the coordinates they want
 * to move it to. The piece will move and the board will update with a prompt 
 * for the next player's turn, or it will be an illegal move and the player will
 * have to make a move again.
 * 
 * The user can resign at any time by typing "resign" instead of their move, can
 * offer a draw by appending "draw?" to the end of their move, which ends the game
 * if the opponent responds with "draw", and can enter the type of piece they want
 * to promote a pawn to if it is capable.
 * 
 * @author George Durrant
 * @author Omar Morsy
 * 
 */

package game;

import game.Board;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import piece.Bishop;
import piece.Knight;
import piece.Pawn;
import piece.Piece;
import piece.Queen;
import piece.Rook;

public class Start {

	public static void main(String[] args) {
		
		/** create new board with starting positions
		 * 
		 */
		// make new board
		Board game = new Board();

		/** boolean varialbes to track changes
		 * 
		 */
		// quit boolean to end game
		boolean quit = false;
		// illegal move boolean
		boolean isLegal = false;
		// white check boolean
		boolean whiteCheck = false;
		// black check boolean
		boolean blackCheck = false;
		// white can castle boolean
		boolean whiteCastle = true;
		// black can castle boolean
		boolean blackCastle = true;
		Piece blackChecker = null;
		Piece whiteChecker = null;
		Tile blackCheckerTile = null;
		Tile whiteCheckerTile = null;
		
		/** buffered reader to accept user input
		 * 
		 */
		// make buffered reader for user input
		BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
	
		
		/** initialize variables
		 * 
		 */
		String extra, draw, line;
		int fromx, fromy, tox, toy;
		boolean enpassantWhite = false;
		boolean enpassantBlack = false;
	
		Tile wkingTile = game.getTile(7,4);
		Tile bkingTile = game.getTile(0,4);
		
		/** load game, break only for draw/resign/etc
		 * 
		 */
		while(!quit){
		
		/** print board, white player's input
		 * 
		 */
		game.printBoard();
		System.out.println("\n");
		
		if(whiteCheck){
			System.out.println("Check");
		}
		
		System.out.print("White's move: ");
		
		isLegal = false;
		whiteCheck = false;
		
		/** only end turn when legal move has been made
		 * 
		 */
		while(!isLegal){
		
			fromx=0;
			fromy=0;
			tox=0;
			toy=0;
			
			try { 
				/**
				 * read white input
				 */
				line = inp.readLine();
				
				/** end game with resignation
				 * 
				 */
				if(line.equals("resign")){
					System.out.println("Black wins");
					quit = true;
				}
				
				if(!quit){
					/**
					 * turn input into int coordinates
					 */
					fromy = (int) line.charAt(0) - 97;
					fromx = 8 - (line.charAt(1)-'0');
					toy = (int) line.charAt(3) - 97;
					tox = 8 - (line.charAt(4)-'0');
				
					/**
					 * if more than coordinates, make extra String
					 */
					if(line.length()>5){
						extra = line.substring(6, line.length());
		
						/**
						 * player asks for draw
						 */
						if(extra.equals("draw?")){
							draw = inp.readLine();
							
							/**
							 * if draw agreed, quit
							 */
							if(draw.equals("draw")){
								quit = true;
								break;
							}
						}
						
					}
				}
				
				/** 
				 * define current and next pieces and tiles
				 * based on user input coordinates
				 */
				Piece currPiece = game.getTile(fromx, fromy).getPiece();
				Tile currTile = game.getTile(fromx, fromy);
					
				Piece nextPiece = game.getTile(tox, toy).getPiece();
				Tile nextTile = game.getTile(tox, toy);
				
				//Tile bkingTile = game.getTile(0, 4);
				Tile brook1Tile = game.getTile(0, 0);
				Tile brook2Tile = game.getTile(0, 8);
				
				ArrayList<Tile> moves = currPiece.goTo(game.getBoard(), fromx, fromy);
						
				
				/** 
				 * castling procedure
				 */
				boolean castleW = false;
				
				if(game.getTile(fromx, fromy).getPiece().getName().equals("wK") && fromx==7 && fromy==4 && tox==7 && toy==6) {
					//castle = true;
					if(game.getTile(7,6).getPiece()==null && game.getTile(7,5).getPiece()==null && game.getTile(7,7).getPiece().getName().equals("wR")) {
						
						castleW = true;
						Piece kingPieceW = game.getTile(7, 4).getPiece();
						Tile kingNextTileW = game.getTile(7, 6);
						kingNextTileW.setPiece(kingPieceW);
						game.getTile(7, 4).setPiece(null);
						
						Piece rookPieceW = game.getTile(7, 7).getPiece();
						Tile rookNextTileW= game.getTile(7, 5);
						rookNextTileW.setPiece(rookPieceW);
						game.getTile(7, 7).setPiece(null);
						
						wkingTile = game.getTile(7, 6);
					}
				}
				
				else if(game.getTile(fromx, fromy).getPiece().getName().equals("wK") && fromx==7 && fromy==4 && tox==7 && toy==2) {
					//castle = true;
					if(game.getTile(7,3).getPiece()==null && game.getTile(7,2).getPiece()==null && game.getTile(7,1).getPiece()==null && game.getTile(7,0).getPiece().getName().equals("wR")) {
						castleW = true;
						Piece kingPieceW = game.getTile(7, 4).getPiece();
						Tile kingNextTileW = game.getTile(7, 2);
						kingNextTileW.setPiece(kingPieceW);
						game.getTile(7, 4).setPiece(null);
						
						Piece rookPieceW = game.getTile(7, 0).getPiece();
						Tile rookNextTileW= game.getTile(7, 3);
						rookNextTileW.setPiece(rookPieceW);
						game.getTile(7, 0).setPiece(null);
						
						wkingTile = game.getTile(7, 2);
					}
				}
				
				
				/** 
				 * enpassant procedure 
				 */
				enpassantWhite = false;
				
				if(fromx==6 && tox==4){
					enpassantWhite = true;
				}
				
				boolean enpassantDoneW = false;
				if(!castleW && currPiece.getName().equals("wp") && fromx==3 && nextTile.getPiece()==null && game.getTile(tox+1, toy).getPiece().getName().equals("bp") ){
					if(enpassantBlack == true) {
						Piece pawnPieceW = game.getTile(fromx, fromy).getPiece();
						Tile pawnNextTileW = game.getTile(tox, toy);
						pawnNextTileW.setPiece(pawnPieceW);
						game.getTile(fromx, fromy).setPiece(null);
						game.getTile(tox+1, toy).setPiece(null);
						enpassantDoneW = true;
					}
				}
				
				
				/** 
				 * checks for illegal moves
				 */
				if(currPiece.getPlayerColor()==0){
					if(enpassantDoneW == true) {
						break;
					}
					if(castleW == true) {
						break;
					}
					if(nextPiece!=null && nextPiece.getPlayerColor()==1){
						if(moves.contains(nextTile)){
							nextTile.setPiece(currPiece);
							currTile.setPiece(null);
							isLegal = true;
						}
						else{
							System.out.println("Illegal move, try again");
						}
					}
					else if(nextPiece==null){
						if(moves.contains(nextTile)){
							nextTile.setPiece(currPiece);
							currTile.setPiece(null);
							isLegal = true;
						}
						else{
							System.out.println("Illegal move, try again");
						}
					}
					else{
						System.out.println("Illegal move, try again");
					}
				}
				else{
					System.out.println("Illegal move, try again");
				}
				
				if(bkingTile.getPiece()==null){
					bkingTile = nextTile;
					if(brook1Tile.getPiece()==null && brook2Tile.getPiece()==null){
						blackCastle = false;
					}
				}
				
				/**
				 * find if king is in check
				 */
				ArrayList<Tile> checkMoves = currPiece.goTo(game.getBoard(), tox, toy);
				if (checkMoves.contains(bkingTile)){
					blackCheck = true;
					whiteChecker = currPiece;
					whiteCheckerTile = nextTile;
				}
					
				/** 
				 * find if king is in checkmate
				 */
				if(isCheckmate(game, wkingTile)){
					System.out.println("Black wins");
					quit = true;
				}	
				
			} catch (IOException e) {			
			}
		}
		
		
		/** 
		 * continue to black player's turn
		 */
		if(!quit){
			
			/**
			 * print board, black player's input
			 */
			System.out.println();
			game.printBoard();
			System.out.println("\n");
			
			if(blackCheck){
				System.out.println("Check");
			}
			
			System.out.print("Black's move: ");
			
			isLegal = false;
			blackCheck = false;

			while(!isLegal){
			
				if(isCheckmate(game, wkingTile)){
					System.out.println("Black wins");
					quit = true;
				}
				
			try { 
				
				line = "";
				extra = "";
				fromx=0;
				fromy=0;
				tox=0;
				toy=0;
				
				
				/**
				 * read black input
				 */
				line = inp.readLine();
				
				/**
				 * end if resign
				 */
				if(line.equals("resign")){
					System.out.println("White wins");
					quit = true;
				}
				
				if(!quit){
				/**
				 * turn input into int coordinates
				 */
				fromy = (int) line.charAt(0) - 97;
				fromx = 8 - (line.charAt(1)-'0');
				toy = (int) line.charAt(3) - 97;
				tox = 8 - (line.charAt(4)-'0');
			
				/**
				 * if more than coordinates, make extra String
				 */
				if(line.length()>5){
					extra = line.substring(6, line.length());

					/**
					 * player asks for draw
					 */
					if(extra.equals("draw?")){
						draw = inp.readLine();
						
						/**
						 * if draw agreed, quit
						 */
						if(draw.equals("draw")){
							quit = true;
							break;
						}
					}
								
					
				}
				}
				
				Piece currPiece = null;
				Tile currTile = null;
						
				Piece nextPiece = null;
				Tile nextTile = null;
				
				//Tile wkingTile = game.getTile(7, 4);
				Tile wrook1Tile = game.getTile(7, 0);
				Tile wrook2Tile = game.getTile(7, 8);
						
				ArrayList<Tile> moves = null;
				ArrayList<Tile> checkMoves = null;
				
				currPiece = game.getTile(fromx, fromy).getPiece();
				currTile = game.getTile(fromx, fromy);
				nextPiece = game.getTile(tox, toy).getPiece();
				nextTile = game.getTile(tox, toy);
				moves = currPiece.goTo(game.getBoard(), fromx, fromy);
				
				String pieceName = currPiece.getName();
			
				if(pieceName.equals("bp") && moves.contains(nextTile)){
					if(fromx==6 && tox==7){
						extra = line.substring(6,7);
						System.out.println(extra);
						System.out.println(fromx + " "+ tox);
						if(extra.equals("R")){
							currPiece = new Rook(currPiece.getPlayer(), "bR");
							nextTile.setPiece(currPiece);
						}
						else if(extra.equals("N")){
							currPiece = new Knight(currPiece.getPlayer(), "bN");
							nextTile.setPiece(currPiece);
						}
						else if(extra.equals("B")){
							currPiece = new Bishop(currPiece.getPlayer(), "bB");
							nextTile.setPiece(currPiece);
						}
						else{
							currPiece = new Queen(currPiece.getPlayer(), "bQ");
							nextTile.setPiece(currPiece);
						}
						currTile.setPiece(null);
						isLegal = true;
					}
				}
				
				enpassantBlack = false;
				if(fromx==1 && tox==3){
					enpassantBlack = true;
				}
				
				boolean enpassantDone = false;
				if(pieceName.equals("bp") && fromx==4 && nextTile.getPiece()==null && game.getTile(tox-1, toy).getPiece().getName().equals("wp") ){
					if(enpassantWhite == true) {
						Piece pawnPiece = game.getTile(fromx, fromy).getPiece();
						Tile pawnNextTile = game.getTile(tox, toy);
						pawnNextTile.setPiece(pawnPiece);
						game.getTile(fromx, fromy).setPiece(null);
						game.getTile(tox-1, toy).setPiece(null);
						enpassantDone = true;
						//enpassantWhite = false;
					}
				}
				
				boolean castle = false;
				
				if(!enpassantDone && game.getTile(fromx, fromy).getPiece().getName().equals("bK") && fromx==0 && fromy==4 && tox==0 && toy==6) {
					//castle = true;
					if(game.getTile(0,6).getPiece()==null && game.getTile(0,5).getPiece()==null && game.getTile(0,7).getPiece().getName().equals("bR")) {
						castle = true;
						Piece kingPiece = game.getTile(0, 4).getPiece();
						Tile kingNextTile = game.getTile(0, 6);
						kingNextTile.setPiece(kingPiece);
						game.getTile(0, 4).setPiece(null);
						
						Piece rookPiece = game.getTile(0, 7).getPiece();
						Tile rookNextTile = game.getTile(0, 5);
						rookNextTile.setPiece(rookPiece);
						game.getTile(0, 7).setPiece(null);
						
						bkingTile = game.getTile(0, 6);
					}
				}
				
				else if(!enpassantDone && game.getTile(fromx, fromy).getPiece().getName().equals("bK") && fromx==0 && fromy==4 && tox==0 && toy==2) {
					//castle = true;
					if(game.getTile(0,3).getPiece()==null && game.getTile(0,2).getPiece()==null && game.getTile(0,1).getPiece()==null && game.getTile(0,0).getPiece().getName().equals("bR")) {
						castle = true;
						Piece kingPiece = game.getTile(0, 4).getPiece();
						Tile kingNextTile = game.getTile(0, 2);
						kingNextTile.setPiece(kingPiece);
						game.getTile(0, 4).setPiece(null);
						
						Piece rookPiece = game.getTile(0, 0).getPiece();
						Tile rookNextTile= game.getTile(0, 3);
						rookNextTile.setPiece(rookPiece);
						game.getTile(0, 0).setPiece(null);
						
						bkingTile = game.getTile(0, 2);
					}
				}
				
					if(currPiece.getPlayerColor()==1){
						if(enpassantDone == true) {
							break;
						}
						if(castle == true) {
							break;
						}
						if(nextPiece!=null && nextPiece.getPlayerColor()==0){
							if(moves.contains(nextTile)){
								nextTile.setPiece(currPiece);
								currTile.setPiece(null);
								isLegal = true;
							}
							else{
								System.out.println("Illegal move, try again");
							}
						}
						else if(nextPiece==null){
							if(moves.contains(nextTile)){
								nextTile.setPiece(currPiece);
								currTile.setPiece(null);
								isLegal = true;
							}
							else{
								System.out.println("Illegal move, try again");
							}
						}
						else{
							System.out.println("Illegal move, try again");
						}
					}
					else{
						System.out.println("Illegal move, try again");
					}
				
					
				if(wkingTile.getPiece()==null){
					wkingTile = nextTile;
					if(wrook1Tile.getPiece()==null && wrook2Tile.getPiece()==null){
						whiteCastle = false;
					}
				}
				
				checkMoves = currPiece.goTo(game.getBoard(), tox, toy);
				if (checkMoves.contains(wkingTile)){
					whiteCheck = true;
					blackChecker = currPiece;
					blackCheckerTile = nextTile;
				}
				
			System.out.println();
				
			} catch (IOException e) {}
			}
			
		}
		}
		
	}
	
	/**
	 * method to determine if king is in danger from opponent pieces
	 * @param b
	 * @param k
	 * @return
	 */
	public static boolean isCheckmate(Board b, Tile k){
		ArrayList<Tile> temp = new ArrayList<Tile>();
		ArrayList<Tile> list = new ArrayList<Tile>();
		ArrayList<Tile> king = new ArrayList<Tile>();
		int kx = k.getX();
		int ky = k.getY();
		king = k.getPiece().goTo(b.getBoard(), kx, ky);
		for(int i=0; i<8; i++){
			for(int j=0; j<8; j++){
				Tile t = b.getTile(i, j);
				if(t.getPiece()!=null && t.getPiece().getPlayerColor()!=k.getPiece().getPlayerColor()){
					Piece p = t.getPiece();
					temp = p.goTo(b.getBoard(), i, j);
					list.addAll(temp);
				}
			}
		}
		king.removeAll(list);
		if(king.isEmpty()){	
			return true;
		}
		else{
			return false;
		}
	}

}
