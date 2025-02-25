package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

	public King(Board board, Color color) {
		super(board, color);
	}
	
	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		return p == null ||  p.getColor() != getColor();
	}
	
	@Override
	public boolean[][] possibleMoves(){
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0,0);
		
		//Above
		p.setValues(position.getRow() - 1, position.getColumn());
		if(getBoard().positionExist(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		//Below
		p.setValues(position.getRow() + 1, position.getColumn());
		if(getBoard().positionExist(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//Left
		p.setValues(position.getRow(), position.getColumn() - 1);
		if(getBoard().positionExist(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//Right
		p.setValues(position.getRow()  , position.getColumn() + 1);
		if(getBoard().positionExist(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//Noroeste - diagonal superior esquerda
		p.setValues(position.getRow() - 1, position.getColumn() - 1);
		if(getBoard().positionExist(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		//Nordeste - diagonal superior direita
		p.setValues(position.getRow() - 1, position.getColumn() + 1);
		if(getBoard().positionExist(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//Suldoeste - diagonal inferior esquerda
		p.setValues(position.getRow() + 1, position.getColumn() - 1);
		if(getBoard().positionExist(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		//Suldeste  - diagonal inferior direita
		p.setValues(position.getRow() + 1, position.getColumn() + 1);
		if(getBoard().positionExist(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		return mat;
	}
	
	@Override
	public String toString() {
		return "K";
	}
}
