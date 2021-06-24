package game.io;

import exception.NotEnoughtCardException;
import game.rule.Party;

public interface IOParty {

	 default void createParty() {
		new Party(this);
	}

	void needPlayer(GetPlayerAction action) throws NotEnoughtCardException;

	void addPlayerOrPlay(AddPlayerOrPlayAction action) throws NotEnoughtCardException;

}
