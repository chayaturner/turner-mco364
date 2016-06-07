package turner.mco364.TicTacToe;

import java.util.List;
import java.util.Random;

public class BestMoveFinder {

	private static final Random RAND = new Random();
	
	//modify this to go more levels down in the tree
	public int getBestMove(Board parent){
		Board.Piece activePlayer = parent.getActive();
		List<Integer> moves = parent.getMoves();
		
		for(int move : moves){
			Board child = new Board(parent);
			child.set(move, activePlayer);
			if(child.getWinner() == activePlayer){
				return move;
			}
		}
		
		return moves.get(RAND.nextInt(moves.size()));
	}
	
}
