package game.io;

import game.player.Player;
import main.one.Main;

public class IOPlayerEvent implements IOPlayer {

	Player player;

	public IOPlayerEvent(Player p) {
		this.player = p;
	}

	@Override
	public void selectCard(GetCardAction action) {
		String card = Main.quelCarte(player.getName(), player.getHand());
		action.selectCard(Integer.parseInt(card));
	}

	@Override
	public void selectLine(GetLineAction action) {
		String ligne = Main.quelLigne(player.getName());
		action.selectLine(Integer.parseInt(ligne));
	}
}
