package apoPlanerNeu;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JButton;

public class ButtonSpeicher implements Serializable {

	private static final long serialVersionUID = 1L;
	ArrayList<JButton> buttonSpeicherArrayList;
	int[] urlaubsTageSpeicher = new int[11];
	JButton buttonGefunden;
	Dienstplan dienstplan;
	
	public ButtonSpeicher()
	{
		buttonSpeicherArrayList = new ArrayList<JButton>();
		for (int i = 0; i <= 10; i++)
		{
			urlaubsTageSpeicher[i] = 0;
		}
	}
	
	public void uebergibDienstplan(Dienstplan dienstplan) {
		this.dienstplan = dienstplan;
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
		int mitarbeiter = Integer.parseInt(b.getName().split(";")[0]);
		for (int i = 1; i <= 52; i++) // alle Wochen
		{				
			buttonGefunden = sucheButtonNachNamen(mitarbeiter + ";" 
					+ i + ";" + 10);
			if(buttonGefunden != null) buttonGefunden.setText(Mitarbeiter.values()[mitarbeiter-1] 
					+ "  (" + gibUrlaubsTageSpeicher()[mitarbeiter-1] + ")");
		}
	}
	public void aktualisiereUrlaubAufButtonAlleMitarbeiter()
	{
		for (int i = 0; i < 11; i++) // die ersten 10 Buttons: alle MA
		{
			if (Integer.parseInt(buttonSpeicherArrayList.get(i).getName().split(";")[2]) == 10)
			{
				int mitarbeiter = Integer.parseInt(buttonSpeicherArrayList.get(i).getName().split(";")[0]);
				for (int j = 1; j <= 52; j++) // alle Wochen
				{				
					buttonGefunden = sucheButtonNachNamen(mitarbeiter + ";" 
							+ j + ";" + 10);
					if(buttonGefunden != null) buttonGefunden.setText(Mitarbeiter.values()[mitarbeiter-1] 
							+ "  (" + gibUrlaubsTageSpeicher()[mitarbeiter-1] + ")");
				}
			}
		}
	}
}
