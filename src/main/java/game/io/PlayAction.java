package game.io;

import exception.NotEnoughtCardException;

@FunctionalInterface
public interface PlayAction extends Action {
	void play();
}

