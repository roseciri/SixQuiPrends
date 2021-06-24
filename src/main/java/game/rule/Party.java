package game.rule;

import exception.NotEnoughtCardException;
import game.board.Hand;
import game.board.Table;
import game.board.card.Card;
import game.board.card.CardStack;
import game.player.Player;
import game.player.PlayerList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Set;

public class Party {

	private static final Logger logger = LoggerFactory.getLogger(Party.class);

	final PlayerList playerList = new PlayerList();
	final CardStack cardStack = new CardStack();
	private final Table table;

	public Party() throws NotEnoughtCardException {
		cardStack.init();
		table = new Table(cardStack.getNewCard(4));
	}

	public void addPlayer(Player p1) throws NotEnoughtCardException {
		playerList.addPlayer(p1);
		var hand = new Hand();
		for (var i = 1; i <= 10; i++) {
			hand.addCard(cardStack.getNewCard());
		}
		p1.setHand(hand);
	}

	public void play() {
		for (var i = 1; i <= 10; i++) {
			new Tour(this).start();
			logger.atDebug().log(playerList.displayScore());
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
		logger.atDebug().log(table.toString());
		return cards;
	}

	public Table getTable() {
		return table;
	}
}
