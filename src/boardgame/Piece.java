package boardgame;

public class Piece {

	protected Position position;
	private Board board;
	
	public Piece(Position position, Board board) {
		this.board = board;
		this.position = null;
	}
	
	protected Board getBoard() {
		return board;
	}
	
}
