package application;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import chess.ChessPiece;
import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		ChessMatch chessMatch = new ChessMatch();
		List<ChessPiece> captured = new ArrayList<>();

		while (true) {
			try {
				UI.clearScreen();
				UI.printMatch(chessMatch, captured);
				System.out.println();
				System.out.print("Source: ");
				ChessPosition source = UI.readChessPosition(input);
				
				boolean[][] possibleMoves = chessMatch.possibleMoves(source);
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces(), possibleMoves);
				System.out.println();
				System.out.print("target: ");
				ChessPosition target = UI.readChessPosition(input);

				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
				if(capturedPiece != null) {
					captured.add(capturedPiece);
				}
				
			} catch (ChessException e) {
				System.out.print(e.getMessage());
				input.nextLine();
				
			} catch(InputMismatchException e) {
				System.out.print(e.getMessage());
				input.nextLine();
			}
		}
		
	}
}
