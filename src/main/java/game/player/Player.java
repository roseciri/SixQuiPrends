package game.player;

import game.board.Hand;
import game.board.Line;
import game.board.card.Card;
import game.rule.CollectCardPhase;
import game.rule.SelectionLinePhase;

import java.util.Collection;
import java.util.List;

public class Player {
	Hand hand;
	final String name;
	int points = 0;

	public Player(String name) {
		this.name = name;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

	@Override
	public String toString() {
		return name;
	}


	public void selectCard(CollectCardPhase collectCardPhase) {
		var c = selectCard();
		collectCardPhase.playerPlayCard(this, c);
	}


	private Card selectCard() {
		return hand.getFirstCard();
	}

	public void addPoint(Collection<Card> addCard) {
		points += addCard.stream().map(Card::getCowsSum).reduce(Integer::sum).orElse(0);
	}

	public void selectLine(SelectionLinePhase selectionLinePhase, List<Line> lines) {
		selectionLinePhase.select(lines.get(0));
	}
}
