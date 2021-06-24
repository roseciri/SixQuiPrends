package main.two;

import exception.NotEnoughtCardException;
import game.io.Action;
import game.io.AddPlayerOrPlayAction;
import game.io.GetPlayerAction;
import game.io.IOParty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IOPartyEtat implements IOParty {

	private static final Logger logger = LoggerFactory.getLogger(IOPartyEtat.class);

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
}
