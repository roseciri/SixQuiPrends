import game.board.Table;
import game.rule.Party;
import game.player.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

	private static final Logger logger = LoggerFactory.getLogger(Main.class);


	public static void main(String[] args) throws Exception {
		var party = new Party();
		try {
			logger.debug(party.table.toString());
			var p1 = new Player("Georges");
			party.addPlayer(p1);
			var p2 = new Player("Lucas");
			party.addPlayer(p2);
			var p3 = new Player("Bidule");
			party.addPlayer(p3);
			party.play();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
