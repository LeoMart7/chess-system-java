package chess.pieces;

import chess.ChessPiece;
import boardgame.Board;
import boardgame.Position;
import chess.Color;

public class Rook extends ChessPiece {

	public Rook(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public boolean[][] possibleMoves(){
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position pos = new Position(0,0);
		//Above
		pos.setValues(position.getRow() - 1, position.getColumn());
		while(getBoard().positionExist(pos) && !getBoard().thereIsAPiece(pos)) {
			mat[pos.getRow()][pos.getColumn()] = true;
			pos.setRow(pos.getRow() - 1);
		}
		if(getBoard().positionExist(pos) && isThereOponentPiece(pos)) {
			mat[pos.getRow()][pos.getColumn()] = true;
		} 
		
		// Left
		pos.setValues(position.getRow(), position.getColumn() - 1);
		while(getBoard().positionExist(pos) && !getBoard().thereIsAPiece(pos)) {
		 	mat[pos.getRow()][pos.getColumn()] = true;
			pos.setColumn(pos.getColumn() - 1);
		}
		if(getBoard().positionExist(pos) && isThereOponentPiece(pos)) {
			mat[pos.getRow()][pos.getColumn()] = true;
		}
		
		//Right
		pos.setValues(position.getRow(), position.getColumn() + 1);
		while(getBoard().positionExist(pos) && !getBoard().thereIsAPiece(pos)) {
		 	mat[pos.getRow()][pos.getColumn()] = true;
			pos.setColumn(pos.getColumn() + 1);
		}
		if(getBoard().positionExist(pos) && isThereOponentPiece(pos)) {
			mat[pos.getRow()][pos.getColumn()] = true;
		}
		
		//Below
		pos.setValues(position.getRow() + 1, position.getColumn());
		while(getBoard().positionExist(pos) && !getBoard().thereIsAPiece(pos)) {
		 	mat[pos.getRow()][pos.getColumn()] = true;
			pos.setRow(pos.getRow() + 1);
		}
		if(getBoard().positionExist(pos) && isThereOponentPiece(pos)) {
			mat[pos.getRow()][pos.getColumn()] = true;
		}
		
		return mat;
	}
	
	
	@Override
	public String toString() {
		return "R";
	}
	
}
