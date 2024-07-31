package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessPiece;
import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		ChessMatch chessMatch = new ChessMatch();

		while (true) {
			try {
				UI.clearScreen();
				UI.printBoard(chessMatch.getPiece());
				System.out.println();
				System.out.print("Source: ");
				ChessPosition source = UI.readChessPosition(input);

				System.out.println();
				System.out.print("target: ");
				ChessPosition target = UI.readChessPosition(input);

				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
				
			} catch (ChessException e) {
				System.out.println(e.getMessage());
				input.nextLine();
				
			} catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				input.nextLine();
			}
		}
		
	}
}
