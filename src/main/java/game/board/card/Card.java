package game.board.card;

import java.util.Objects;

public class Card {

	final private int value;
	final private int cowsSum;

	public Card(int value, int cowsSum) {
		this.value = value;
		this.cowsSum = cowsSum;
	}

	@Override
	public String toString() {
		return ""+value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Card card = (Card) o;
		return value == card.value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	public int getValue() {
		return value;
	}

	public int getCowsSum() {
		return cowsSum;
	}
}
