package apoUrlaubsPlaner;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JButton;

public class ButtonSpeicher implements Serializable {

	private static final long serialVersionUID = 1L;
	ArrayList<JButton> buttonSpeicherArrayList;
	int[] urlaubsTageSpeicher;
	JButton buttonGefunden;
	ArrayList<Mitarbeiter> mitarbeiterArrayList;
	
	public ButtonSpeicher()
	{
		buttonSpeicherArrayList = new ArrayList<JButton>();
		mitarbeiterArrayList = new ArrayList<>();
		mitarbeiterArrayList.add(new Mitarbeiter("Test1"));
		mitarbeiterArrayList.add(new Mitarbeiter("Test2"));
		urlaubsTageSpeicher = new int[mitarbeiterArrayList.size()];
		for (int i = 0; i < mitarbeiterArrayList.size(); i++)
		{
			urlaubsTageSpeicher[i] = 0;
		}
	}
	
	public void vergroessereUrlaubsTageSpeicher() {
		int[] temp = new int[urlaubsTageSpeicher.length + 1];
		for (int i = 0; i < urlaubsTageSpeicher.length; i++) {
			temp[i] = urlaubsTageSpeicher[i];
		}
		urlaubsTageSpeicher = temp;
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
			if(buttonGefunden != null) buttonGefunden.setText(mitarbeiterArrayList.get(mitarbeiter-1).name 
					+ "  (" + gibUrlaubsTageSpeicher()[mitarbeiter-1] + ")");
		}
	}
	public void aktualisiereUrlaubAufButtonAlleMitarbeiter()
	{
		for (int i = 0; i < 12; i++) // die ersten 10 Buttons: alle MA
		{
			if (Integer.parseInt(buttonSpeicherArrayList.get(i).getName().split(";")[2]) == 10)
			{
				int mitarbeiter = Integer.parseInt(buttonSpeicherArrayList.get(i).getName().split(";")[0]);
				for (int j = 1; j <= 52; j++) // alle Wochen
				{				
					buttonGefunden = sucheButtonNachNamen(mitarbeiter + ";" 
							+ j + ";" + 10);
					if(buttonGefunden != null) buttonGefunden.setText(mitarbeiterArrayList.get(mitarbeiter-1).name 
							+ "  (" + gibUrlaubsTageSpeicher()[mitarbeiter-1] + ")");
				}
			}
		}
	}
	
	public void aktualisiereButtonSpeicherArrayList() 
	{
		ArrayList<JButton> buttonSpeicherArrayListTemp = new ArrayList<JButton>();
		int zaehler = 0;
		while (zaehler < buttonSpeicherArrayList.size()) {
			for (int j = 0; j < mitarbeiterArrayList.size()-1; j++) { // alle MA außer dem zuletzt hinzugefügten
				buttonSpeicherArrayListTemp.add(buttonSpeicherArrayList.get(zaehler));
				zaehler++;
			}
			
		}
	}
}
