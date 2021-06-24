package main;

import game.player.Player;
import game.rule.Party;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

	private static final Logger logger = LoggerFactory.getLogger(Main.class);


	public static void main(String[] args) throws Exception {
		var party = new Party();
		try {
			logger.atDebug().log(party.getTable().toString());
			var p1 = new Player("Georges");
			party.addPlayer(p1);
			var p2 = new Player("Lucas");
			party.addPlayer(p2);
			var p3 = new Player("Bidule");
			party.addPlayer(p3);
			party.play();
		} catch (Exception e) {
			logger.atError().setCause(e).log("Il y a un problème");
		}
	}
}
