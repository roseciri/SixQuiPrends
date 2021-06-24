package main.two;

import exception.NotEnoughtCardException;
import main.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Main {

	private static final Logger logger = LoggerFactory.getLogger(main.one.Main.class);

	@SuppressWarnings("squid:S106")
	public static void main(String[] args) throws NotEnoughtCardException {
		logger.atDebug().log("C'est parti mon quiqui");
		Map<UUID, IOPartyEtat> parties = new HashMap<>();
		var end = false;
		while (!end) {
			String instruction = IOUtils.read();
			if (instruction.equals("create")) {
				var identifiantParty = UUID.randomUUID();
				var ioParty = new IOPartyEtat();
				ioParty.createParty();
				parties.put(identifiantParty, ioParty);
				System.out.println("Vous venez de créer la partie " + identifiantParty);
			} else if (instruction.startsWith("addp")) {
				var words = instruction.split(" ");
				if (words.length == 3) {
					try {
						parties.get(UUID.fromString(words[1])).addPlayer(words[2]);
					} catch (NotEnoughtCardException e) {
						System.out.println("Il n'est plus possible d'ajouter de joueur (pas assez de cartes, il faudrait faire plus de cartes...)");
					}
				} else {
					System.out.println("L'instruction addp a 2 arguments le num de la partie et le nom du joueur");
				}
			} else if (instruction.startsWith("play")) {
				var words = instruction.split(" ");
				if (words.length == 2) {
					parties.get(UUID.fromString(words[1])).addPlay();
				} else {
					System.out.println("L'instruction addp a 2 arguments le num de la partie et le nom du joueur");
				}
			} else if (instruction.equals("end")) {
				end = true;
			}
		}
	}
}
