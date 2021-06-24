package game.board;

import game.board.card.Card;

import java.util.HashSet;
import java.util.Set;

public class Hand {
	Set<Card> cardSet = new HashSet<>();

	public void addCard(Card newCard) {
		cardSet.add(newCard);
	}

	@Override
	public String toString() {
		return "game.board.Hand{" +
				"cardSet=" + cardSet +
				'}';
	}

	public Card getFirstCard() {
		var card = cardSet.stream().findFirst().orElseThrow();
		cardSet.remove(card);
		return card;
	}
}
