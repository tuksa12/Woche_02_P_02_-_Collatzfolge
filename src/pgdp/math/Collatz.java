package pgdp.math;

import static pgdp.MiniJava.*;

public class Collatz {
	public static void main(String[] args) {
		int n = readInt("Bitte Zahl eingeben:");
		int t = 1;
		if (n == 0) {
			write("Fehler: n>0 erwartet!");
		}else{
			while (n > 1){
				writeConsole(n+" ");
				if (n%2==0){
					n = n/2;
				}
				else {
					n = (3 * n) + 1;
				}
				t++;

			}
			writeLineConsole("1");
			write("Länge: " +t);}
	}
}
