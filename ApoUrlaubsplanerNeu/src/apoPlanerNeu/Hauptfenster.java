package apoPlanerNeu;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

public class Hauptfenster extends JPanel
{
	JPanel panelMA = new JPanel(new GridLayout(0,1));		
	JPanel panelMo = new JPanel(new GridLayout(0,2));		
	JPanel panelDi = new JPanel(new GridLayout(0,2));
	JPanel panelMi = new JPanel(new GridLayout(0,2));
	JPanel panelDo = new JPanel(new GridLayout(0,2));
	JPanel panelFr = new JPanel(new GridLayout(0,2));
	JPanel woche = new JPanel(new GridLayout(1,6));
	JPanel main = new JPanel(new GridLayout(0,1));
	JFrame fenster = new JFrame("Apotheken Urlaubsplaner");
	Datum datum = new Datum();
	Dienstplan dp = new Dienstplan();
	ButtonSpeicher buttonSpeicher = new ButtonSpeicher();
	Speichern speichern = new Speichern(buttonSpeicher);
	public int[][][][] dienstplan = new int[11][2][5][2]; //Mitarbeiter, gerade oder ungerade, Wochentag, vormittag oder nachmittag
	
	public Hauptfenster() 
	{
		dienstplan = dp.gibDienstplan();
		fenster.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) 
			{
				try 
				{
					fenster.setVisible(false);
					speichern.speichereDatei();
				} catch (IOException ex) 
				{
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		fenster.setSize(1200, 900);
		fenster.setLocationRelativeTo(null);
		baueFensterNeu();
		Hinweisfenster hinweisFenster1 = new Hinweisfenster("Lade Datei...");
		hinweisFenster1.hinweisFrame.setVisible(true);
		try {
			speichern.ladeDatei();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		hinweisFenster1.hinweisFrame.setVisible(false);
		fenster.setVisible(true);
	}
	
	public void baueFensterNeu() 
	{
		for (int wochen = 1; wochen <= 52; wochen++)
		{
			panelMA.add(new JLabel("Woche " + wochen));
			JLabel datumLabel = new JLabel(datum.gibMontagVonWocheX(wochen) + "  -  " + datum.gibFreitagVonWocheX(wochen));
			datumLabel.setBackground(new Color(255,236,139));
			datumLabel.setOpaque(true);
			panelMA.add(datumLabel);
	//		https://stackoverflow.com/questions/5654208/making-a-jbutton-invisible-but-clickable
			for (int i = 1; i <=11; i++)
			{
				JButton b = new JButton(Mitarbeiter.values()[i-1] + "  (" + buttonSpeicher.gibUrlaubsTageSpeicher()[i-1] + ")");
				panelMA.add(b);
				b.setName(i + ";" + wochen +";" + 10);// 10 heisst: kein spezieller Tag
				b.setOpaque(true);
				b.setBackground(new Color(255, 255, 255));
				b.setBorderPainted(true);
				b.addActionListener(new ButtonListener(this, buttonSpeicher));
				buttonSpeicher.speichereButton(b);
			}
			
			panelMo.add(new JLabel("MONTAG"));
			panelMo.add(new JLabel(" "));
			panelMo.add(new JLabel("vormittag"));
			panelMo.add(new JLabel("nachmittag"));
	//		https://stackoverflow.com/questions/5654208/making-a-jbutton-invisible-but-clickable
			for (int i = 1; i <=22; i++)
			{
				JButton b = new JButton();
				panelMo.add(b);
				b.setName((i+1)/2 + ";" + wochen + ";" + 0 + ";" + (i-1)%2); // 0 ist Montag und (i-1)%2 ist vorm/nachm
				b.setOpaque(true);
				b.setBackground(gibFarbeFuerDienstplan(i-1, 0, wochen));
				b.setBorderPainted(true);
				b.addActionListener(new ButtonListener(this, buttonSpeicher));
				buttonSpeicher.speichereButton(b);
			}
			
			panelDi.add(new JLabel("DIENSTAG"));
			panelDi.add(new JLabel(" "));
			panelDi.add(new JLabel("vormittag"));
			panelDi.add(new JLabel("nachmittag"));
	//		https://stackoverflow.com/questions/5654208/making-a-jbutton-invisible-but-clickable
			for (int i = 1; i <=22; i++)
			{
				JButton b = new JButton();
				panelDi.add(b);
				b.setName((i+1)/2 + ";" + wochen + ";" + 1 + ";" + (i-1)%2);
				b.setOpaque(true);
				b.setBackground(gibFarbeFuerDienstplan(i-1, 1, wochen));
				b.setBorderPainted(true);
				b.addActionListener(new ButtonListener(this, buttonSpeicher));
				buttonSpeicher.speichereButton(b);
			}
			
			panelMi.add(new JLabel("MITTWOCH"));
			panelMi.add(new JLabel(" "));
			panelMi.add(new JLabel("vormittag"));
			panelMi.add(new JLabel("nachmittag"));
	//		https://stackoverflow.com/questions/5654208/making-a-jbutton-invisible-but-clickable
			for (int i = 1; i <=22; i++)
			{
				JButton b = new JButton();
				panelMi.add(b);
				b.setName((i+1)/2 + ";" + wochen + ";" + 2 + ";" + (i-1)%2);
				b.setOpaque(true);
				b.setBackground(gibFarbeFuerDienstplan(i-1, 2, wochen));
				b.setBorderPainted(true);
				b.addActionListener(new ButtonListener(this, buttonSpeicher));
				buttonSpeicher.speichereButton(b);
			}
			panelDo.add(new JLabel("DONNERSTAG"));
			panelDo.add(new JLabel(" "));
			panelDo.add(new JLabel("vormittag"));
			panelDo.add(new JLabel("nachmittag"));
			//		https://stackoverflow.com/questions/5654208/making-a-jbutton-invisible-but-clickable
			for (int i = 1; i <=22; i++)
			{
				JButton b = new JButton();
				panelDo.add(b);
				b.setName((i+1)/2 + ";" + wochen + ";" + 3 + ";" + (i-1)%2);
				b.setOpaque(true);
				b.setBackground(gibFarbeFuerDienstplan(i-1, 3, wochen));
				b.setBorderPainted(true);
				b.addActionListener(new ButtonListener(this, buttonSpeicher));
				buttonSpeicher.speichereButton(b);
			}
			panelFr.add(new JLabel("FREITAG"));
			panelFr.add(new JLabel(" "));
			panelFr.add(new JLabel("vormittag"));
			panelFr.add(new JLabel("nachmittag"));
			//		https://stackoverflow.com/questions/5654208/making-a-jbutton-invisible-but-clickable
			for (int i = 1; i <=22; i++)
			{
				JButton b = new JButton();
				panelFr.add(b);
				b.setName((i+1)/2 + ";" + wochen + ";" + 4 + ";" + (i-1)%2);
				b.setOpaque(true);
				b.setBackground(gibFarbeFuerDienstplan(i-1, 4, wochen));
				b.setBorderPainted(true);
				b.addActionListener(new ButtonListener(this, buttonSpeicher));
				buttonSpeicher.speichereButton(b);
			}
			woche.add(panelMA);
			woche.add(panelMo);
			woche.add(panelDi);
			woche.add(panelMi);
			woche.add(panelDo);
			woche.add(panelFr);
			main.add(woche);
		}
		JScrollPane scrollPane = new JScrollPane(main);
		fenster.add(scrollPane);
	}
	
	public Color gibFarbeFuerDienstplan(int mitarbeiter, int tag, int woche)
	{
		int geradeUngerade = woche%2;
		if (dienstplan[mitarbeiter/2][geradeUngerade][tag][mitarbeiter%2] == 1)
		{
			return new Color(80, 150, 230); //blau
		}
		if (dienstplan[mitarbeiter/2][geradeUngerade][tag][mitarbeiter%2] == 0)
		{
			return new Color(255, 255, 255);
		}
		return new Color(255, 255, 255);
	}

}
