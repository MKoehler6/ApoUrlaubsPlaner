package apoUrlaubsPlaner;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JButton;

public class ButtonSpeicher implements Serializable {

	private static final long serialVersionUID = 1L;
	ArrayList<JButton> buttonSpeicherArrayList;
	int[] urlaubsTageSpeicher;
	JButton buttonGefunden;
	ArrayList<String> mitarbeiter = new ArrayList<>();
	int anzahlMA;
	
	public ButtonSpeicher()
	{
		buttonSpeicherArrayList = new ArrayList<JButton>();
		mitarbeiter.add("Mähler");
		mitarbeiter.add("Schröter");
		mitarbeiter.add("Bauß");
		mitarbeiter.add("Denner");
		mitarbeiter.add("Krampf");
		mitarbeiter.add("Heß");
		mitarbeiter.add("Meingast");
		mitarbeiter.add("Schmidt");
		mitarbeiter.add("Schwalbe");
		mitarbeiter.add("Stüber");
		mitarbeiter.add("Bräuning");
		mitarbeiter.add("Lückert");
		mitarbeiter.add("Köhler");
		
		anzahlMA = mitarbeiter.size();
		urlaubsTageSpeicher = new int[anzahlMA];
		for (int i = 0; i < anzahlMA; i++)
		{
			urlaubsTageSpeicher[i] = 0;
		}
	}
	
	public int[] gibUrlaubsTageSpeicher()
	{
		return urlaubsTageSpeicher;
	}
	
	public void fuegeUrlaubHinzu(int anzahl, int mitarbeiter)
	{
		urlaubsTageSpeicher[mitarbeiter-1] += anzahl;
	}
	public void zieheUrlaubAb(int anzahl, int mitarbeiter)
	{
		urlaubsTageSpeicher[mitarbeiter-1] -= anzahl;
	}
	public void speichereButton(JButton b)
	{
		buttonSpeicherArrayList.add(b);
	}
	
	public JButton sucheButtonNachNamen(String name)
	{
		for (JButton b : buttonSpeicherArrayList)
		{
			if (b.getName().equals(name)){
				return b;
			}
		}
		return null;
	}
	
	public void aktualisiereUrlaubAufButton(JButton b)
	{
		int mitarbeiterInt = Integer.parseInt(b.getName().split(";")[0]);
		for (int i = 1; i <= 52; i++) // alle Wochen
		{				
			buttonGefunden = sucheButtonNachNamen(mitarbeiterInt + ";" 
					+ i + ";" + 10);
			if(buttonGefunden != null) buttonGefunden.setText(mitarbeiter.get(mitarbeiterInt-1) 
					+ "  (" + gibUrlaubsTageSpeicher()[mitarbeiterInt-1] + ")");
		}
	}
	public void aktualisiereUrlaubAufButtonAlleMitarbeiter()
	{
		for (int i = 0; i < anzahlMA; i++) // die ersten 10 Buttons: alle MA
		{
			if (Integer.parseInt(buttonSpeicherArrayList.get(i).getName().split(";")[2]) == 10)
			{
				int mitarbeiterInt = Integer.parseInt(buttonSpeicherArrayList.get(i).getName().split(";")[0]);
				for (int j = 1; j <= 52; j++) // alle Wochen
				{				
					buttonGefunden = sucheButtonNachNamen(mitarbeiterInt + ";" 
							+ j + ";" + 10);
					if(buttonGefunden != null) buttonGefunden.setText(mitarbeiter.get(mitarbeiterInt-1)
							+ "  (" + gibUrlaubsTageSpeicher()[mitarbeiterInt-1] + ")");
				}
			}
		}
	}
}
