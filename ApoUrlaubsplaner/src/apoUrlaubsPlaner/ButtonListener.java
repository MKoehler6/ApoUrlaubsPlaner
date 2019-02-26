package apoUrlaubsPlaner;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ButtonListener implements ActionListener{
	
	JButton b;
	JButton buttonGefunden;
	Hauptfenster hf;
	ButtonSpeicher buttonSpeicher;
	
	public ButtonListener(Hauptfenster hauptfenster, ButtonSpeicher bs)
	{
		hf = hauptfenster;
		buttonSpeicher = bs;
	}

	@Override
	public void actionPerformed(ActionEvent event) 
	{
		b = (JButton) event.getSource();
		int mitarbeiter = Integer.parseInt(b.getName().split(";")[0]);
		int woche = Integer.parseInt(b.getName().split(";")[1]);
		int tag = Integer.parseInt(b.getName().split(";")[2]);
		
		if (tag == 10) // Mitarbeiter-Button ist gedrückt
		{			
			if (!istWocheRot(b)) 
			{
				setzeGanzeWocheUrlaub(b);
			} 
			else 
			{
				setzeGanzeWocheDienst(b);
			}
		}
		else // ein Tages-Button wurde gedrueckt
		{
			if (!istTagRot(b))
			{
				setzeTagUrlaub(b);
			}
			else
			{
				setzeTagDienst(b);
			}
		}
		
	}
	
	public void setzeGanzeWocheUrlaub(JButton b)
	{
		int mitarbeiter = Integer.parseInt(b.getName().split(";")[0]);
		int woche = Integer.parseInt(b.getName().split(";")[1]);
		int tageUrlaubInDieserWoche = tageUrlaubInDieserWoche(b);

		for (int i = 0; i <= 4; i++) // alle Tage
		{				
			buttonGefunden = buttonSpeicher.sucheButtonNachNamen(mitarbeiter + ";" 
					+ woche + ";" + i + ";" + 0); // vormittag
			if(buttonGefunden != null) buttonGefunden.setBackground(new Color(255,69,0));
			buttonGefunden = buttonSpeicher.sucheButtonNachNamen(mitarbeiter + ";" 
					+ woche + ";" + i + ";" + 1); // nachmittag
			if(buttonGefunden != null) buttonGefunden.setBackground(new Color(255,69,0));
		}
		int urlaubstage = 5 - tageUrlaubInDieserWoche;
		buttonSpeicher.fuegeUrlaubHinzu(urlaubstage, mitarbeiter);
		buttonSpeicher.aktualisiereUrlaubAufButton(b);
	}
	
	public void setzeGanzeWocheDienst(JButton b)
	{
		int mitarbeiter = Integer.parseInt(b.getName().split(";")[0]);
		int woche = Integer.parseInt(b.getName().split(";")[1]);
		int tageUrlaubInDieserWoche = tageUrlaubInDieserWoche(b);
		
		for (int i = 0; i <= 4; i++) // alle Tage
		{				
			buttonGefunden = buttonSpeicher.sucheButtonNachNamen(mitarbeiter + ";" 
					+ woche + ";" + i + ";" + 0); // vormittag
			if(buttonGefunden != null) buttonGefunden.setBackground(hf.gibFarbeFuerDienstplan((mitarbeiter-1)*2, i, woche));
			buttonGefunden = buttonSpeicher.sucheButtonNachNamen(mitarbeiter + ";" 
					+ woche + ";" + i + ";" + 1); // nachmittag
			if(buttonGefunden != null) buttonGefunden.setBackground(hf.gibFarbeFuerDienstplan((mitarbeiter-1)*2+1, i, woche));
		}
		buttonSpeicher.zieheUrlaubAb(tageUrlaubInDieserWoche, mitarbeiter);
		buttonSpeicher.aktualisiereUrlaubAufButton(b);
	}
	
	public void setzeTagUrlaub(JButton b)
	{
		int mitarbeiter = Integer.parseInt(b.getName().split(";")[0]);
		int woche = Integer.parseInt(b.getName().split(";")[1]);
		int tag = Integer.parseInt(b.getName().split(";")[2]);

		for (int i = 0; i <= 1; i++) // vormittag und nachmittag
		{				
			buttonGefunden = buttonSpeicher.sucheButtonNachNamen(mitarbeiter + ";" 
					+ woche + ";" + tag + ";" + i);
			if(buttonGefunden != null) buttonGefunden.setBackground(new Color(255,69,0));
		}
		buttonSpeicher.fuegeUrlaubHinzu(1, mitarbeiter);
		buttonSpeicher.aktualisiereUrlaubAufButton(b);
	}
	
	public void setzeTagDienst(JButton b)
	{
		int mitarbeiter = Integer.parseInt(b.getName().split(";")[0]);
		int woche = Integer.parseInt(b.getName().split(";")[1]);
		int tag = Integer.parseInt(b.getName().split(";")[2]);

						
		buttonGefunden = buttonSpeicher.sucheButtonNachNamen(mitarbeiter + ";" 
				+ woche + ";" + tag + ";" + 0);
		if(buttonGefunden != null) buttonGefunden.setBackground(hf.gibFarbeFuerDienstplan((mitarbeiter-1)*2, tag, woche));
		buttonGefunden = buttonSpeicher.sucheButtonNachNamen(mitarbeiter + ";" 
				+ woche + ";" + tag + ";" + 1);
		if(buttonGefunden != null) buttonGefunden.setBackground(hf.gibFarbeFuerDienstplan((mitarbeiter-1)*2+1, tag, woche));
		
		buttonSpeicher.zieheUrlaubAb(1, mitarbeiter);
		buttonSpeicher.aktualisiereUrlaubAufButton(b);
	}
	
	public boolean istWocheRot(JButton b)
	{
		int mitarbeiter = Integer.parseInt(b.getName().split(";")[0]);
		int woche = Integer.parseInt(b.getName().split(";")[1]);

		for (int i = 0; i <= 4; i++) // alle Tage
		{
			buttonGefunden = buttonSpeicher.sucheButtonNachNamen(mitarbeiter + ";" 
					+ woche + ";" + i + ";" + 0);
			if(buttonGefunden.getBackground().toString().equals("java.awt.Color[r=255,g=69,b=0]"))
			{
				return true;
			}
		}
		return false;
	}
	public boolean istTagRot(JButton b)
	{
		int mitarbeiter = Integer.parseInt(b.getName().split(";")[0]);
		int woche = Integer.parseInt(b.getName().split(";")[1]);
		int tag = Integer.parseInt(b.getName().split(";")[2]);

		buttonGefunden = buttonSpeicher.sucheButtonNachNamen(mitarbeiter + ";" 
				+ woche + ";" + tag + ";" + 0);
		if(buttonGefunden.getBackground().toString().equals("java.awt.Color[r=255,g=69,b=0]"))
		{
			return true;
		}
		return false;
	}
	
	public int tageUrlaubInDieserWoche(JButton b)
	{
		int mitarbeiter = Integer.parseInt(b.getName().split(";")[0]);
		int woche = Integer.parseInt(b.getName().split(";")[1]);
		int urlaubstage = 0;
		for (int i = 0; i <= 4; i++) // alle Tage
		{				
			buttonGefunden = buttonSpeicher.sucheButtonNachNamen(mitarbeiter + ";" 
					+ woche + ";" + i + ";" + 0); // vormittag
			if(buttonGefunden.getBackground().toString().equals("java.awt.Color[r=255,g=69,b=0]"))
			{
				urlaubstage++;
			}
		}
		return urlaubstage;
	}

}
