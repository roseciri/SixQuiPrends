package main.one;

import exception.NotEnoughtCardException;
import game.io.*;
import game.player.Player;
import game.rule.Party;

import java.util.HashMap;
import java.util.Map;

public class IOPartyEvent implements IOParty {

	Map<String, IOPlayer> playerCommunicator = new HashMap<>();

	@Override
	public void createParty()  {
		new Party(this);
	}

	public void needPlayer(GetPlayerAction action) throws NotEnoughtCardException {
		String name = Main.quiJoue();
		action.addPlayer(name);
	}

	public void addPlayerOrPlay(AddPlayerOrPlayAction action) throws NotEnoughtCardException {
		String choice = Main.ajouterUnJoueurOuJouer();
		if("add".equals(choice)) {
			String name = Main.quiJoue();
			action.getAddPlayerAction().addPlayer(name);
		} else if("play".equals(choice)) {
			action.getPlayAction().play();
		}
	}

	@Override
	public IOPlayer addPlayerCommunicator(Player player) {
		IOPlayer ioPlayer = new IOPlayerEvent(player);
		playerCommunicator.put(player.getName(), ioPlayer);
		return ioPlayer;
	}
}
