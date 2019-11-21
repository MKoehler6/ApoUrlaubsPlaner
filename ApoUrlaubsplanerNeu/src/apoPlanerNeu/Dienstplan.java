package apoPlanerNeu;

public class Dienstplan {
	
	private int[][][][] dienstplan = new int[11][2][5][2]; 
	//Mitarbeiter, gerade oder ungerade, Wochentag, vormittag oder nachmittag
	
	public Dienstplan()
	{
		mähler();
		schröter();
		bauß();
		denner();
		krampf();
		fuss();
		hess();
		meingast();
		schmidt();
		schwalbe();
		lueckert();
	}
	
	public int[][][][] gibDienstplan()
	{
		return dienstplan;
	}
	
	void mähler()
	{
		int mitarbeiterNummer = 0;
		//gerade
		dienstplan[mitarbeiterNummer][0][0][0] = 1;
		dienstplan[mitarbeiterNummer][0][0][1] = 0;
		dienstplan[mitarbeiterNummer][0][1][0] = 0;
		dienstplan[mitarbeiterNummer][0][1][1] = 1;
		dienstplan[mitarbeiterNummer][0][2][0] = 1;
		dienstplan[mitarbeiterNummer][0][2][1] = 0;
		dienstplan[mitarbeiterNummer][0][3][0] = 1;
		dienstplan[mitarbeiterNummer][0][3][1] = 1;
		dienstplan[mitarbeiterNummer][0][4][0] = 0;
		dienstplan[mitarbeiterNummer][0][4][1] = 1;
		//ungerade
		dienstplan[mitarbeiterNummer][1][0][0] = 1;
		dienstplan[mitarbeiterNummer][1][0][1] = 0;
		dienstplan[mitarbeiterNummer][1][1][0] = 0;
		dienstplan[mitarbeiterNummer][1][1][1] = 1;
		dienstplan[mitarbeiterNummer][1][2][0] = 1;
		dienstplan[mitarbeiterNummer][1][2][1] = 0;
		dienstplan[mitarbeiterNummer][1][3][0] = 1;
		dienstplan[mitarbeiterNummer][1][3][1] = 1;
		dienstplan[mitarbeiterNummer][1][4][0] = 1;
		dienstplan[mitarbeiterNummer][1][4][1] = 0;
	}
	void schröter()
	{
		int mitarbeiterNummer = 1;
		//gerade
		dienstplan[mitarbeiterNummer][0][0][0] = 1;
		dienstplan[mitarbeiterNummer][0][0][1] = 0;
		dienstplan[mitarbeiterNummer][0][1][0] = 1;
		dienstplan[mitarbeiterNummer][0][1][1] = 0;
		dienstplan[mitarbeiterNummer][0][2][0] = 1;
		dienstplan[mitarbeiterNummer][0][2][1] = 1;
		dienstplan[mitarbeiterNummer][0][3][0] = 1;
		dienstplan[mitarbeiterNummer][0][3][1] = 1;
		dienstplan[mitarbeiterNummer][0][4][0] = 1;
		dienstplan[mitarbeiterNummer][0][4][1] = 0;
		//ungerade
		dienstplan[mitarbeiterNummer][1][0][0] = 1;
		dienstplan[mitarbeiterNummer][1][0][1] = 0;
		dienstplan[mitarbeiterNummer][1][1][0] = 1;
		dienstplan[mitarbeiterNummer][1][1][1] = 0;
		dienstplan[mitarbeiterNummer][1][2][0] = 1;
		dienstplan[mitarbeiterNummer][1][2][1] = 1;
		dienstplan[mitarbeiterNummer][1][3][0] = 1;
		dienstplan[mitarbeiterNummer][1][3][1] = 0;
		dienstplan[mitarbeiterNummer][1][4][0] = 1;
		dienstplan[mitarbeiterNummer][1][4][1] = 1;
	}
	void bauß()
	{
		int mitarbeiterNummer = 2;
		//gerade
		dienstplan[mitarbeiterNummer][0][0][0] = 0;
		dienstplan[mitarbeiterNummer][0][0][1] = 1;
		dienstplan[mitarbeiterNummer][0][1][0] = 1;
		dienstplan[mitarbeiterNummer][0][1][1] = 0;
		dienstplan[mitarbeiterNummer][0][2][0] = 1;
		dienstplan[mitarbeiterNummer][0][2][1] = 0;
		dienstplan[mitarbeiterNummer][0][3][0] = 1;
		dienstplan[mitarbeiterNummer][0][3][1] = 1;
		dienstplan[mitarbeiterNummer][0][4][0] = 1;
		dienstplan[mitarbeiterNummer][0][4][1] = 0;
		//ungerade
		dienstplan[mitarbeiterNummer][1][0][0] = 0;
		dienstplan[mitarbeiterNummer][1][0][1] = 1;
		dienstplan[mitarbeiterNummer][1][1][0] = 1;
		dienstplan[mitarbeiterNummer][1][1][1] = 0;
		dienstplan[mitarbeiterNummer][1][2][0] = 1;
		dienstplan[mitarbeiterNummer][1][2][1] = 0;
		dienstplan[mitarbeiterNummer][1][3][0] = 1;
		dienstplan[mitarbeiterNummer][1][3][1] = 1;
		dienstplan[mitarbeiterNummer][1][4][0] = 0;
		dienstplan[mitarbeiterNummer][1][4][1] = 1;
	}
	void denner()
	{
		int mitarbeiterNummer = 3;
		//gerade
		dienstplan[mitarbeiterNummer][0][0][0] = 0;
		dienstplan[mitarbeiterNummer][0][0][1] = 1;
		dienstplan[mitarbeiterNummer][0][1][0] = 0;
		dienstplan[mitarbeiterNummer][0][1][1] = 1;
		dienstplan[mitarbeiterNummer][0][2][0] = 1;
		dienstplan[mitarbeiterNummer][0][2][1] = 0;
		dienstplan[mitarbeiterNummer][0][3][0] = 1;
		dienstplan[mitarbeiterNummer][0][3][1] = 0;
		dienstplan[mitarbeiterNummer][0][4][0] = 0;
		dienstplan[mitarbeiterNummer][0][4][1] = 1;
		//ungerade
		dienstplan[mitarbeiterNummer][1][0][0] = 0;
		dienstplan[mitarbeiterNummer][1][0][1] = 1;
		dienstplan[mitarbeiterNummer][1][1][0] = 0;
		dienstplan[mitarbeiterNummer][1][1][1] = 1;
		dienstplan[mitarbeiterNummer][1][2][0] = 1;
		dienstplan[mitarbeiterNummer][1][2][1] = 0;
		dienstplan[mitarbeiterNummer][1][3][0] = 0;
		dienstplan[mitarbeiterNummer][1][3][1] = 1;
		dienstplan[mitarbeiterNummer][1][4][0] = 1;
		dienstplan[mitarbeiterNummer][1][4][1] = 0;
	}
	void krampf()
	{
		int mitarbeiterNummer = 4;
		//gerade
		dienstplan[mitarbeiterNummer][0][0][0] = 1;
		dienstplan[mitarbeiterNummer][0][0][1] = 1;
		dienstplan[mitarbeiterNummer][0][1][0] = 1;
		dienstplan[mitarbeiterNummer][0][1][1] = 1;
		dienstplan[mitarbeiterNummer][0][2][0] = 0;
		dienstplan[mitarbeiterNummer][0][2][1] = 1;
		dienstplan[mitarbeiterNummer][0][3][0] = 1;
		dienstplan[mitarbeiterNummer][0][3][1] = 1;
		dienstplan[mitarbeiterNummer][0][4][0] = 1;
		dienstplan[mitarbeiterNummer][0][4][1] = 0;
		//ungerade
		dienstplan[mitarbeiterNummer][1][0][0] = 1;
		dienstplan[mitarbeiterNummer][1][0][1] = 1;
		dienstplan[mitarbeiterNummer][1][1][0] = 1;
		dienstplan[mitarbeiterNummer][1][1][1] = 0;
		dienstplan[mitarbeiterNummer][1][2][0] = 1;
		dienstplan[mitarbeiterNummer][1][2][1] = 1;
		dienstplan[mitarbeiterNummer][1][3][0] = 1;
		dienstplan[mitarbeiterNummer][1][3][1] = 0;
		dienstplan[mitarbeiterNummer][1][4][0] = 1;
		dienstplan[mitarbeiterNummer][1][4][1] = 1;
	}
	void fuss()
	{
		int mitarbeiterNummer = 5;
		//gerade
		dienstplan[mitarbeiterNummer][0][0][0] = 1;
		dienstplan[mitarbeiterNummer][0][0][1] = 0;
		dienstplan[mitarbeiterNummer][0][1][0] = 1;
		dienstplan[mitarbeiterNummer][0][1][1] = 0;
		dienstplan[mitarbeiterNummer][0][2][0] = 1;
		dienstplan[mitarbeiterNummer][0][2][1] = 0;
		dienstplan[mitarbeiterNummer][0][3][0] = 0;
		dienstplan[mitarbeiterNummer][0][3][1] = 0;
		dienstplan[mitarbeiterNummer][0][4][0] = 1;
		dienstplan[mitarbeiterNummer][0][4][1] = 1;
		//ungerade
		dienstplan[mitarbeiterNummer][1][0][0] = 1;
		dienstplan[mitarbeiterNummer][1][0][1] = 0;
		dienstplan[mitarbeiterNummer][1][1][0] = 1;
		dienstplan[mitarbeiterNummer][1][1][1] = 0;
		dienstplan[mitarbeiterNummer][1][2][0] = 1;
		dienstplan[mitarbeiterNummer][1][2][1] = 0;
		dienstplan[mitarbeiterNummer][1][3][0] = 1;
		dienstplan[mitarbeiterNummer][1][3][1] = 1;
		dienstplan[mitarbeiterNummer][1][4][0] = 0;
		dienstplan[mitarbeiterNummer][1][4][1] = 0;
	}
	void hess()
	{
		int mitarbeiterNummer = 6;
		//gerade
		dienstplan[mitarbeiterNummer][0][0][0] = 1;
		dienstplan[mitarbeiterNummer][0][0][1] = 1;
		dienstplan[mitarbeiterNummer][0][1][0] = 1;
		dienstplan[mitarbeiterNummer][0][1][1] = 0;
		dienstplan[mitarbeiterNummer][0][2][0] = 1;
		dienstplan[mitarbeiterNummer][0][2][1] = 0;
		dienstplan[mitarbeiterNummer][0][3][0] = 0;
		dienstplan[mitarbeiterNummer][0][3][1] = 0;
		dienstplan[mitarbeiterNummer][0][4][0] = 1;
		dienstplan[mitarbeiterNummer][0][4][1] = 1;
		//ungerade
		dienstplan[mitarbeiterNummer][1][0][0] = 1;
		dienstplan[mitarbeiterNummer][1][0][1] = 0;
		dienstplan[mitarbeiterNummer][1][1][0] = 1;
		dienstplan[mitarbeiterNummer][1][1][1] = 1;
		dienstplan[mitarbeiterNummer][1][2][0] = 1;
		dienstplan[mitarbeiterNummer][1][2][1] = 1;
		dienstplan[mitarbeiterNummer][1][3][0] = 0;
		dienstplan[mitarbeiterNummer][1][3][1] = 0;
		dienstplan[mitarbeiterNummer][1][4][0] = 1;
		dienstplan[mitarbeiterNummer][1][4][1] = 0;
	}
	void meingast()
	{
		int mitarbeiterNummer = 7;
		//gerade
		dienstplan[mitarbeiterNummer][0][0][0] = 1;
		dienstplan[mitarbeiterNummer][0][0][1] = 1;
		dienstplan[mitarbeiterNummer][0][1][0] = 1;
		dienstplan[mitarbeiterNummer][0][1][1] = 0;
		dienstplan[mitarbeiterNummer][0][2][0] = 1;
		dienstplan[mitarbeiterNummer][0][2][1] = 1;
		dienstplan[mitarbeiterNummer][0][3][0] = 1;
		dienstplan[mitarbeiterNummer][0][3][1] = 0;
		dienstplan[mitarbeiterNummer][0][4][0] = 1;
		dienstplan[mitarbeiterNummer][0][4][1] = 1;
		//ungerade
		dienstplan[mitarbeiterNummer][1][0][0] = 1;
		dienstplan[mitarbeiterNummer][1][0][1] = 1;
		dienstplan[mitarbeiterNummer][1][1][0] = 1;
		dienstplan[mitarbeiterNummer][1][1][1] = 1;
		dienstplan[mitarbeiterNummer][1][2][0] = 0;
		dienstplan[mitarbeiterNummer][1][2][1] = 1;
		dienstplan[mitarbeiterNummer][1][3][0] = 1;
		dienstplan[mitarbeiterNummer][1][3][1] = 1;
		dienstplan[mitarbeiterNummer][1][4][0] = 1;
		dienstplan[mitarbeiterNummer][1][4][1] = 0;
	}
	void schmidt()
	{
		int mitarbeiterNummer = 8;
		//gerade
		dienstplan[mitarbeiterNummer][0][0][0] = 0;
		dienstplan[mitarbeiterNummer][0][0][1] = 0;
		dienstplan[mitarbeiterNummer][0][1][0] = 1;
		dienstplan[mitarbeiterNummer][0][1][1] = 1;
		dienstplan[mitarbeiterNummer][0][2][0] = 0;
		dienstplan[mitarbeiterNummer][0][2][1] = 0;
		dienstplan[mitarbeiterNummer][0][3][0] = 1;
		dienstplan[mitarbeiterNummer][0][3][1] = 0;
		dienstplan[mitarbeiterNummer][0][4][0] = 1;
		dienstplan[mitarbeiterNummer][0][4][1] = 0;
		//ungerade
		dienstplan[mitarbeiterNummer][1][0][0] = 0;
		dienstplan[mitarbeiterNummer][1][0][1] = 0;
		dienstplan[mitarbeiterNummer][1][1][0] = 1;
		dienstplan[mitarbeiterNummer][1][1][1] = 0;
		dienstplan[mitarbeiterNummer][1][2][0] = 0;
		dienstplan[mitarbeiterNummer][1][2][1] = 0;
		dienstplan[mitarbeiterNummer][1][3][0] = 1;
		dienstplan[mitarbeiterNummer][1][3][1] = 0;
		dienstplan[mitarbeiterNummer][1][4][0] = 1;
		dienstplan[mitarbeiterNummer][1][4][1] = 1;
	}
	void schwalbe()
	{
		int mitarbeiterNummer = 9;
		//gerade
		dienstplan[mitarbeiterNummer][0][0][0] = 1;
		dienstplan[mitarbeiterNummer][0][0][1] = 0;
		dienstplan[mitarbeiterNummer][0][1][0] = 1;
		dienstplan[mitarbeiterNummer][0][1][1] = 1;
		dienstplan[mitarbeiterNummer][0][2][0] = 1;
		dienstplan[mitarbeiterNummer][0][2][1] = 1;
		dienstplan[mitarbeiterNummer][0][3][0] = 0;
		dienstplan[mitarbeiterNummer][0][3][1] = 1;
		dienstplan[mitarbeiterNummer][0][4][0] = 1;
		dienstplan[mitarbeiterNummer][0][4][1] = 0;
		//ungerade
		dienstplan[mitarbeiterNummer][1][0][0] = 1;
		dienstplan[mitarbeiterNummer][1][0][1] = 1;
		dienstplan[mitarbeiterNummer][1][1][0] = 1;
		dienstplan[mitarbeiterNummer][1][1][1] = 1;
		dienstplan[mitarbeiterNummer][1][2][0] = 1;
		dienstplan[mitarbeiterNummer][1][2][1] = 0;
		dienstplan[mitarbeiterNummer][1][3][0] = 1;
		dienstplan[mitarbeiterNummer][1][3][1] = 0;
		dienstplan[mitarbeiterNummer][1][4][0] = 0;
		dienstplan[mitarbeiterNummer][1][4][1] = 1;
	}
	void lueckert()
	{
		int mitarbeiterNummer = 10;
		//gerade
		dienstplan[mitarbeiterNummer][0][0][0] = 1;
		dienstplan[mitarbeiterNummer][0][0][1] = 1;
		dienstplan[mitarbeiterNummer][0][1][0] = 0;
		dienstplan[mitarbeiterNummer][0][1][1] = 1;
		dienstplan[mitarbeiterNummer][0][2][0] = 1;
		dienstplan[mitarbeiterNummer][0][2][1] = 1;
		dienstplan[mitarbeiterNummer][0][3][0] = 1;
		dienstplan[mitarbeiterNummer][0][3][1] = 1;
		dienstplan[mitarbeiterNummer][0][4][0] = 1;
		dienstplan[mitarbeiterNummer][0][4][1] = 0;
		//ungerade
		dienstplan[mitarbeiterNummer][1][0][0] = 1;
		dienstplan[mitarbeiterNummer][1][0][1] = 1;
		dienstplan[mitarbeiterNummer][1][1][0] = 0;
		dienstplan[mitarbeiterNummer][1][1][1] = 1;
		dienstplan[mitarbeiterNummer][1][2][0] = 1;
		dienstplan[mitarbeiterNummer][1][2][1] = 1;
		dienstplan[mitarbeiterNummer][1][3][0] = 1;
		dienstplan[mitarbeiterNummer][1][3][1] = 0;
		dienstplan[mitarbeiterNummer][1][4][0] = 1;
		dienstplan[mitarbeiterNummer][1][4][1] = 1;
	}
	

}
