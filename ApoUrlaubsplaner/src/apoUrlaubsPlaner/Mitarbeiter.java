package apoUrlaubsPlaner;

import java.io.Serializable;

public class Mitarbeiter implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	int urlaubstageAnzahl; 
	int[][][] dienstplan = new int[2][5][2]; // gerade oder ungerade, Wochentag, vormittag oder nachmittag
	int[][] tageImJahr = new int[52][5]; // 52 Wochen, 5 Tage, 0 f�r kein Dienst, 1 f�r Dienst, 2 f�r Urlaub
	
	public Mitarbeiter(String name) {
		this.name = name;
	}
	
	public void kontrollausgabe() {
		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(tageImJahr[i][j] + " ");
			}
			System.out.println();
		}
	}

}

