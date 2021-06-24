package game.rule;

import game.board.Line;

public class SelectionLinePhase {

	public Line line;

	public void select(Line line) {
		this.line = line;
	}

	public Line getLine() {
		return line;
	}
}
