package main;

import java.io.IOException;

public class IOUtils {

	public static String read() {
		String tmp = "";
		char C = '\0';
		try {
			while ((C = (char) System.in.read()) != '\n') {
				if (C != '\r') tmp = tmp + C;
			}
		} catch (IOException e) {
			System.out.println("Erreur de frappe");
			System.exit(0);
		}
		return tmp;
	}
}
