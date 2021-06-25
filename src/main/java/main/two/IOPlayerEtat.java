package main.two;

import game.io.Action;
import game.io.GetCardAction;
import game.io.GetLineAction;
import game.io.IOPlayer;

public class IOPlayerEtat implements IOPlayer {

	Action action;

	@Override
	public void selectCard(GetCardAction action) {
		this.action = action;
	}

	@Override
	public void selectLine(GetLineAction action) {
		this.action = action;
	}

	public void selectCard(int c) {
		if (action instanceof GetCardAction) {
			((GetCardAction) action).selectCard(c);
		}
	}
	public void selectLine(int c) {
		if (action instanceof GetLineAction) {
			((GetLineAction) action).selectLine(c);
		}
	}

}
