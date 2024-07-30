package application;

import java.util.Scanner;

import chess.ChessPiece;
import chess.ChessMatch;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
//		Position pos = new Position(5, 8);
//		System.out.println(pos);

//		Board board = new Board(8, 8);
		
		ChessMatch chessMatch = new ChessMatch();
		
		while(true) {
			UI.printBoard(chessMatch.getPiece());
			System.out.println();
			System.out.print("Source: ");
			ChessPosition source = UI.readChessPosition(input);

			System.out.println();
			System.out.print("target: ");
			ChessPosition target = UI.readChessPosition(input);
			
			ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
		}
		
	}
}
