package game.io;

import exception.NotEnoughtCardException;
import game.rule.Party;

public abstract class IOParty {

	public void createParty() {
		new Party(this);
	}

	public abstract void needPlayer(GetPlayerAction action) throws NotEnoughtCardException;

	public abstract void addPlayerOrPlay(AddPlayerOrPlayAction action) throws NotEnoughtCardException;

}
