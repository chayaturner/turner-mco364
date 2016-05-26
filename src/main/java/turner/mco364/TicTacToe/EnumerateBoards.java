package turner.mco364.TicTacToe;

import java.util.List;
import java.util.Stack;

import turner.mco364.TicTacToe.Board.Piece;

public class EnumerateBoards {

	public static void main(String[] args) {
		Board emptyBoard = new Board();
		int boards = 0;
		int xWins = 0;
		int oWins = 0;
		int ties = 0;

		Stack<Board> stack = new Stack<Board>();
		stack.push(emptyBoard);

		while (!stack.isEmpty()) {
			Board board = stack.pop();
			boards++;

			Piece winner = board.getWinner();
			if (winner != null) {
				if (winner == Piece.X) {
					xWins++;
					continue;
				} else if (winner == Piece.O) {
					oWins++;
					continue;
				}
			}

			List<Integer> moves = board.getMoves();

			if (moves.size() == 0) {
				ties++;
				continue;
			}

			for (Integer i : moves) {
				Board newBoard = new Board(board);
				newBoard.set(i, board.getActive());
				stack.push(new Board(newBoard));
			}
		}

		// boards 549946, x: 131184, o: 77904, ties: 46080, leaves: 255168
		System.out.println(String.format("boards=%d, x wins=%d, o wins=%d, ties=%d, leaves=%d", boards, xWins, oWins,
				ties, (xWins + oWins + ties)));

	}
}