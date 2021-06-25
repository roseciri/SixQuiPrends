package main.two;

import exception.NotEnoughtCardException;
import game.io.*;
import game.player.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class IOPartyEtat implements IOParty {

	private static final Logger logger = LoggerFactory.getLogger(IOPartyEtat.class);

	Map<String, IOPlayer> playerCommunicator = new HashMap<>();

	Action action;

	public void needPlayer(GetPlayerAction action)  {
		logger.atDebug().log("L'action ajouter un joueur est disponible");
		this.action = action;
	}

	@Override
	public void addPlayerOrPlay(AddPlayerOrPlayAction action) {
		logger.atDebug().log("Maintenant on peut soit ajouter un joueur, soit commencer la partie");
		this.action = action;
	}


	public void addPlayer(String playerName) throws NotEnoughtCardException {
		if(action instanceof GetPlayerAction) {
			((GetPlayerAction) action).addPlayer(playerName);
		} else if(action instanceof AddPlayerOrPlayAction) {
			((AddPlayerOrPlayAction) action).getAddPlayerAction().addPlayer(playerName);
		} else {
			throw new ActionImpossibleException();
		}
	}


	public void addPlay() {
		if(action instanceof AddPlayerOrPlayAction) {
			((AddPlayerOrPlayAction) action).getPlayAction().play();
		} else {
			throw new ActionImpossibleException();
		}
	}

	@Override
	public IOPlayer addPlayerCommunicator(Player p) {
		IOPlayer ioPlayer = new IOPlayerEtat();
		playerCommunicator.put(p.getName(), ioPlayer);
		return ioPlayer;
	}
}
