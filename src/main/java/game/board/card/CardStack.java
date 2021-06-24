package game.board.card;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class CardStack {

	List<Card> cardList = new ArrayList<>(104);
	Iterator<Card> iterator;

	public void init() {
		for (int i = 1; i <= 104; i++) {
			cardList.add(createCards(i));
		}
		mix();
		iterator = cardList.iterator();
	}

	private void mix() {
		// Est ce qu'il faudrait pas synchroniser cette partie ? Il ne fuadrait pas essayer de piocher à ce moment !!!
		List<Card> oldaCrdsList = cardList;
		cardList = new ArrayList<>(104);
		oldaCrdsList.stream().forEach(c -> cardList.add(getRandom()% (cardList.size() + 1), c));
	}

	private int getRandom() {
		//return ((int) Math.abs(Math.random() * 1000)) ;
		return new Random().nextInt(104);
	}

	private Card createCards(int i) {
		return new Card(i, getNbCowsForValue(i));
	}

	private int getNbCowsForValue(int i) {
		//TODO retrouver la règle de calcul des vaches sur les cartes
		return i;
	}

	public Card getNewCard() throws Exception {
		if(iterator.hasNext()){
			return iterator.next();
		} else {
			throw new Exception("Plus de cartes dans la pioche");
		}
	}

	@Override
	public String toString() {
		return "game.board.card.CardStack{" +
				"cardsList=" + cardList +
				'}';
	}

	public static void main(String[] args) {
		CardStack stack = new CardStack();
		stack.init();
		System.out.println(stack);
	}


	public List<Card> getNewCard(int nb) throws Exception {
		List<Card> result = new ArrayList<>(nb);
		for (int i = 0; i < nb; i++) {
			result.add(getNewCard());
		}
		return result;
	}
}
