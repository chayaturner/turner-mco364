package turner.mco364.TicTacToe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
	public enum Piece {
		X, O, Empty;

		public Piece otherPlayer() {
			return this == Piece.X ? Piece.O : Piece.X;
		}
	}

	private Piece array[] = new Piece[9];
	private Piece active = Piece.X;

	public Board() {
		Arrays.fill(array, Piece.Empty);

	}

	public Board(Board other) {
		array = other.array.clone();
		active = other.active.otherPlayer();
	}

	public Piece getActive(){
		return active;
	}
	
	public boolean isWinner(int a, int b, int c) {
		return array[a] != Piece.Empty && array[a] == array[b]
				&& array[a] == array[c];
	}

	public Piece getWinner() {
		if (isWinner(0, 1, 2)) {
			return array[0];
		} else if (isWinner(3, 4, 5)) {
			return array[3];
		} else if (isWinner(6, 7, 8)) {
			return array[6];
		} else if (isWinner(0, 3, 6)) {
			return array[0];
		} else if (isWinner(1, 4, 7)) {
			return array[1];
		} else if (isWinner(2, 5, 8)) {
			return array[2];
		} else if (isWinner(0, 4, 8)) {
			return array[0];
		} else if (isWinner(2, 4, 6)) {
			return array[2];
		} else {
			return null;
		}
	}

	public void set(int index, Piece piece) {
		array[index] = piece;
		if (active == Piece.X) {
			active = Piece.O;
		} else {
			active = Piece.X;
		}
	}

	public Piece get(int index) {
		return array[index];
	}

	public List<Integer> getMoves() {
		List<Integer> emptyMoves = new ArrayList<Integer>();
		
		for(int i = 0; i < array.length; i++){
			if(array[i].equals(Piece.Empty)){
				emptyMoves.add(i);
			}
		}
		return emptyMoves;
	}

	public boolean isFull() {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == Piece.Empty) {
				return false;
			}
		}

		return true;
	}

	public String toString() {
		return array[0].name() + array[1].name() + array[2].name()
				+ array[3].name() + array[4].name() + array[5].name()
				+ array[6].name() + array[7].name() + array[8].name();
	}
}