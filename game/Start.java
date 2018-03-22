package game;

import game.Board;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.*;

public class Start {

	public static void main(String[] args) {
		
		// make new board
		Board game = new Board();
		// input scanner
		Scanner sc = new Scanner(System.in);
		
		BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
		
		String s = inp.readLine();
		
		
		
		// initialize variables
		String extra, from, to, draw;
		char first, second;
		int fromx, fromy, tox, toy;
	
		// load game, break only for draw/resign/etc
		while(true){
		
		// print board, white player's input
		game.printBoard();
		System.out.println("\n");
		System.out.print("White's move: ");
		
		// make extra string empty
		extra = "";
		
		// scan from coordinate
		from = sc.nextLine();
		
		// if resigning
		if(from.equals("resign")){
			System.out.println(from);
			System.out.println("Black wins");
			break;
		}
		
		// int coordinates in fromx, fromy
		first = from.charAt(0);
		fromx = (int) first - 97;
		fromy = 8 - (from.charAt(1)-'0');
		
	
		// scan to coordinate
		to = sc.next();
		// int coordinates in tox, toy
		second = to.charAt(0);
		tox = (int) second - 97;
		toy = 8 - (to.charAt(1)-'0');
		
		
		// if extra input, scan
		if(extra.equals("")){System.out.println("empty");}
		else{
		//	extra = sc.next();
		}

		
		// NEED TO BREAK HERE FOR DRAW, WIN, ETC
		if(extra.equals("draw?")){
			draw = sc.next();
			if(draw.equals("draw")){
				break;
			}
		}
		
		
		// NEED TO USE COORDINATES TO MOVE
		
		
		// print board, black player's input
		game.printBoard();
		System.out.println("\n");
		System.out.print("Blacks's move: ");
		
		// make extra string empty
				extra = "";
				
				// scan from coordinate
				from = sc.next();
				
				
				// if resigning
				if(from.equals("resign")){
					System.out.println(from);
					System.out.println("White wins");
					break;
				}
				
				
				// int coordinates in fromx, fromy
				first = from.charAt(0);
				fromx = (int) first - 97;
				fromy = 8 - (from.charAt(1)-'0');
				
			
				// scan to coordinate
				to = sc.next();
				// int coordinates in tox, toy
				second = to.charAt(0);
				tox = (int) second - 97;
				toy = 8 - (to.charAt(1)-'0');
				
				// if extra input, scan
				if(sc.hasNext()==true){
					extra = sc.next();
				}
				
				if(!sc.nextLine().equals("")){
					extra = sc.next();
				}
				
				
				
				// NEED TO BREAK HERE FOR DRAW, WIN, ETC
				if(extra.equals("draw?")){
					draw = sc.next();
					if(draw.equals("draw")){
						break;
					}
				}
				
				
				// NEED TO USE COORDINATES TO MOVE
				
		}
		
	}

}
