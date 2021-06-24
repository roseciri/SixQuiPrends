package main.one;

import exception.NotEnoughtCardException;
import game.io.IOParty;
import main.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintStream;

public class Main {

	private static final Logger logger = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) throws NotEnoughtCardException {
		logger.atDebug().log("start");
		IOParty ioParty = new IOPartyEvent();
		ioParty.createParty();
	}

	@SuppressWarnings("squid:S106")
	public static String quiJoue() {
		new PrintStream(System.out).println("Quel joueur joue ?");
		return IOUtils.read();
	}

	public static String ajouterUnJoueurOuJouer() {
		new PrintStream(System.out).println("Jouer(play) ou Ajouter un joueur (add) ?");
		return IOUtils.read();
	}
}
