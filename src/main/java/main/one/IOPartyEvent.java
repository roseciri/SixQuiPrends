package main.one;

import exception.NotEnoughtCardException;
import game.io.AddPlayerOrPlayAction;
import game.io.GetPlayerAction;
import game.io.IOParty;
import game.rule.Party;

public class IOPartyEvent extends IOParty {

	public void createParty()  {
		new Party(this);
	}

	public void needPlayer(GetPlayerAction action) throws NotEnoughtCardException {
		String name = Main.quiJoue();
		action.addPlayer(name);
	}

	public  void addPlayerOrPlay(AddPlayerOrPlayAction action) throws NotEnoughtCardException {
		String choice = Main.ajouterUnJoueurOuJouer();
		if("add".equals(choice)) {
			String name = Main.quiJoue();
			action.getAddPlayerAction().addPlayer(name);
		} else if("play".equals(choice)) {
			action.getPlayAction().play();
		}
	}
}
