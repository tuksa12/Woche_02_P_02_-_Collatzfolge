package pgdp.math;

import static pgdp.MiniJava.*;

public class Collatz {
	public static void main(String[] args) {
		int n = readInt("Bitte Zahl eingeben:");

		if (n <= 0) {
			writeConsole("Fehler: n>0 erwartet!");
		}
	}
}
