package game.board.card;

import exception.NotEnoughtCardException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CardStack {

	private static final Logger logger = LoggerFactory.getLogger(CardStack.class);
	private static final int CARDS_NUMBER = 104;


	List<Card> cardList = new ArrayList<>(CARDS_NUMBER);
	Iterator<Card> iterator;


	public void init() {
		for (var i = 1; i <= CARDS_NUMBER; i++) {
			cardList.add(createCards(i));
		}
		mix();
		iterator = cardList.iterator();
	}

	private void mix() {
		// Est ce qu'il faudrait pas synchroniser cette partie ? Il ne fuadrait pas essayer de piocher à ce moment !!!
		List<Card> oldaCrdsList = cardList;
		cardList = new ArrayList<>(CARDS_NUMBER);
		oldaCrdsList.forEach(c -> cardList.add(getRandom()% (cardList.size() + 1), c));
	}

	private int getRandom() {
		return new SecureRandom().nextInt(CARDS_NUMBER);
	}

	private Card createCards(int i) {
		return new Card(i, getNbCowsForValue(i));
	}

	private int getNbCowsForValue(int i) {
		return i;
	}

	public Card getNewCard() throws NotEnoughtCardException {
		if(iterator.hasNext()){
			return iterator.next();
		} else {
			throw new NotEnoughtCardException("Plus de cartes dans la pioche");
		}
	}

	@Override
	public String toString() {
		return "game.board.card.CardStack{" +
				"cardsList=" + cardList +
				'}';
	}

	public static void main(String[] args) {
		var stack = new CardStack();
		stack.init();
		logger.atDebug().log(stack.toString());
	}


	public List<Card> getNewCard(int nb) throws NotEnoughtCardException {
		List<Card> result = new ArrayList<>(nb);
		for (var i = 0; i < nb; i++) {
			result.add(getNewCard());
		}
		return result;
	}
}
