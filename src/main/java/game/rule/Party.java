package game.rule;

import game.board.Hand;
import game.board.Table;
import game.board.card.Card;
import game.board.card.CardStack;
import game.player.Player;
import game.player.PlayerList;

import java.util.Collection;
import java.util.Set;

public class Party {

	final PlayerList playerList = new PlayerList();
	final CardStack cardStack = new CardStack();
	final public Table table;

	public Party() throws Exception {
		cardStack.init();
		table = new Table(cardStack.getNewCard(4));
	}

	public void addPlayer(Player p1) throws Exception {
		playerList.addPlayer(p1);
		Hand hand = new Hand();
		for (int i = 1; i <= 10; i++) {
			hand.addCard(cardStack.getNewCard());
		}
		p1.setHand(hand);
	}

	public void play() {
		for (int i = 1; i <= 10; i++) {
			new Tour(this).start();
			System.out.println(playerList.displayScore());
		}
	}

	@Override
	public String toString() {
		return "game.rule.Party{\n" +
				"playerList = " + playerList +
				"\ncardStack = " + cardStack +
				"\n}";
	}

	public Collection<Card> addCard(Player p, Card c) {
		Set<Card> cards = table.addCard(p, c);
		System.out.println(table);
		return cards;
	}
}
