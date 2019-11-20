package apoUrlaubsPlaner;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Hauptfenster extends JPanel
{
	JPanel menu = new JPanel(new GridLayout(9,1));
	JPanel panelMA = new JPanel(new GridLayout(0,1));		
	JPanel panelMo = new JPanel(new GridLayout(0,2));		
	JPanel panelDi = new JPanel(new GridLayout(0,2));
	JPanel panelMi = new JPanel(new GridLayout(0,2));
	JPanel panelDo = new JPanel(new GridLayout(0,2));
	JPanel panelFr = new JPanel(new GridLayout(0,2));
	JPanel woche = new JPanel(new GridLayout(1,6));
	JPanel scrollbereich = new JPanel(new GridLayout(0,1));
	JPanel main = new JPanel(new BorderLayout());
	JFrame fenster = new JFrame("Apotheken Urlaubsplaner");
	JButton test;
	
	Datum datum = new Datum();
	Dienstplan dp = new Dienstplan();
	ButtonSpeicher buttonSpeicher;
	Speichern speichern;
	public int[][][][] dienstplan = new int[12][2][5][2]; //Mitarbeiter, gerade oder ungerade, Wochentag, vormittag oder nachmittag
	
	public Hauptfenster() 
	{
		fenster.setSize(1300, 900);
		fenster.setLocationRelativeTo(null);
		buttonSpeicher = new ButtonSpeicher();
		speichern = new Speichern(buttonSpeicher, datum);
		dienstplan = dp.gibDienstplan();
		baueFensterNeu();
		fenster.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) 
			{
//				try 
//				{
//					fenster.setVisible(false);
//					speichern.speichereDatei();
//					speichern.speichereJPG();
//				} catch (IOException ex) 
//				{
//					ex.printStackTrace();
//				}
				System.exit(0);
			}
		});
		fenster.setVisible(true);
	}
	
	public void baueFensterNeu() 
	{
		baueScrollBereichNeu();
		JScrollPane scrollPane = new JScrollPane(scrollbereich);
		// Menübereich
		JLabel menuLabel = new JLabel("Menü", JLabel.CENTER);
		menuLabel.setOpaque(true);
		menuLabel.setBackground(new Color(190, 190, 190));
		menuLabel.setFont(new Font("Arial", 1, 14));
		menu.add(menuLabel);
		JButton mitarbeiter = new JButton("Mitarbeiter bearbeiten");
		mitarbeiter.setOpaque(true);
		mitarbeiter.setBackground(new Color(120,210,85));
		mitarbeiter.setBorderPainted(true);
		mitarbeiter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				scrollbereich.removeAll();
				panelMA.removeAll();		
				panelMo.removeAll();		
				panelDi.removeAll();
				panelMi.removeAll();
				panelDo.removeAll();
				panelFr.removeAll();
				woche.removeAll();
				
//				menu.removeAll();
//				fenster.validate();
				buttonSpeicher.mitarbeiterArrayList.add(new Mitarbeiter("Test3"));
				buttonSpeicher.buttonSpeicherArrayList.clear();
				buttonSpeicher.vergroessereUrlaubsTageSpeicher();
				for (Mitarbeiter m : buttonSpeicher.mitarbeiterArrayList) m.kontrollausgabe();
//				JPane7l neu = new JPanel();
//				test = new JButton("Test");
//				neu.add(test);
//				menu.add(neu);
//				menu.revalidate();
//				scrollbereich.add(test);
//				baueFensterNeu();
				baueScrollBereichNeu();
				scrollbereich.revalidate();
//				scrollbereich = new JPanel(new GridLayout(0,1));
				fenster.repaint();
			}
		});
		menu.add(mitarbeiter);
		JButton dienstplan = new JButton("Dienstplan bearbeiten");
		dienstplan.setOpaque(true);
		dienstplan.setBackground(new Color(120,210,85));
		dienstplan.setBorderPainted(true);
		menu.add(dienstplan);
		main.add(menu, BorderLayout.WEST);
		main.add(scrollPane, BorderLayout.CENTER);
		fenster.add(main);
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
	
	public void baueScrollBereichNeu() {
		for (int wochen = 1; wochen <= 52; wochen++)
		{
			panelMA.add(new JLabel("Woche " + wochen));
			JLabel datumLabel = new JLabel(datum.gibMontagVonWocheX(wochen) + "  -  " + datum.gibFreitagVonWocheX(wochen));
			datumLabel.setBackground(new Color(255,236,139));
			datumLabel.setOpaque(true);
			panelMA.add(datumLabel);
	//		https://stackoverflow.com/questions/5654208/making-a-jbutton-invisible-but-clickable
			for (int i = 1; i <= buttonSpeicher.mitarbeiterArrayList.size(); i++)
			{
				JButton b = new JButton(buttonSpeicher.mitarbeiterArrayList.get(i-1).name + "  (" + buttonSpeicher.gibUrlaubsTageSpeicher()[i-1] + ")");
				panelMA.add(b);
				b.setName(i + ";" + wochen +";" + 10);// 10 heisst: kein spezieller Tag
				b.setOpaque(true);
				b.setBackground(new Color(255, 255, 255));
				b.setBorderPainted(true);
				b.addActionListener(new ButtonListener(this, buttonSpeicher));
				b.setRolloverEnabled(false); // wenn Maus drüberfährt keine Hervorhebung
				buttonSpeicher.speichereButton(b);
			}
			
			panelMo.add(new JLabel("MONTAG"));
			JLabel datumLabelMontag = new JLabel(" " + datum.gibMontagVonWocheX(wochen));
			if (datum.ferien[wochen - 1] == 1) datumLabelMontag.setBackground(new Color(179,238,58));
			datumLabelMontag.setOpaque(true);
			panelMo.add(datumLabelMontag);
			panelMo.add(new JLabel("vormittag"));
			panelMo.add(new JLabel("nachmittag"));
	//		https://stackoverflow.com/questions/5654208/making-a-jbutton-invisible-but-clickable
			for (int i = 1; i <= buttonSpeicher.mitarbeiterArrayList.size()*2; i++)
			{
				JButton b = new JButton();
				panelMo.add(b);
				b.setName((i+1)/2 + ";" + wochen + ";" + 0 + ";" + (i-1)%2); // 0 ist Montag und (i-1)%2 ist vorm/nachm
				b.setOpaque(true);
				b.setBackground(gibFarbeFuerDienstplan(i-1, 0, wochen));
				b.setBorderPainted(true);
				b.setRolloverEnabled(false); // wenn Maus drüberfährt keine Hervorhebung
				b.addActionListener(new ButtonListener(this, buttonSpeicher));
				buttonSpeicher.speichereButton(b);
			}
			panelMo.setBorder(new EmptyBorder(0, 10, 0, 10));
			
			panelDi.add(new JLabel("DIENSTAG"));
			JLabel datumLabelDienstag = new JLabel(" " + datum.gibDienstagVonWocheX(wochen));
			if (datum.ferien[wochen - 1] == 1) datumLabelDienstag.setBackground(new Color(179,238,58));
			datumLabelDienstag.setOpaque(true);
			panelDi.add(datumLabelDienstag);
			panelDi.add(new JLabel("vormittag"));
			panelDi.add(new JLabel("nachmittag"));
	//		https://stackoverflow.com/questions/5654208/making-a-jbutton-invisible-but-clickable
			for (int i = 1; i <= buttonSpeicher.mitarbeiterArrayList.size()*2; i++)
			{
				JButton b = new JButton();
				panelDi.add(b);
				b.setName((i+1)/2 + ";" + wochen + ";" + 1 + ";" + (i-1)%2);
				b.setOpaque(true);
				b.setBackground(gibFarbeFuerDienstplan(i-1, 1, wochen));
				b.setBorderPainted(true);
				b.setRolloverEnabled(false); // wenn Maus drüberfährt keine Hervorhebung
				b.addActionListener(new ButtonListener(this, buttonSpeicher));
				buttonSpeicher.speichereButton(b);
			}
			panelDi.setBorder(new EmptyBorder(0, 0, 0, 10));
			
			panelMi.add(new JLabel("MITTWOCH"));
			JLabel datumLabelMittwoch = new JLabel(" " + datum.gibMittwochVonWocheX(wochen));
			if (datum.ferien[wochen - 1] == 1) datumLabelMittwoch.setBackground(new Color(179,238,58));
			datumLabelMittwoch.setOpaque(true);
			panelMi.add(datumLabelMittwoch);
			panelMi.add(new JLabel("vormittag"));
			panelMi.add(new JLabel("nachmittag"));
	//		https://stackoverflow.com/questions/5654208/making-a-jbutton-invisible-but-clickable
			for (int i = 1; i <= buttonSpeicher.mitarbeiterArrayList.size()*2; i++)
			{
				JButton b = new JButton();
				panelMi.add(b);
				b.setName((i+1)/2 + ";" + wochen + ";" + 2 + ";" + (i-1)%2);
				b.setOpaque(true);
				b.setBackground(gibFarbeFuerDienstplan(i-1, 2, wochen));
				b.setBorderPainted(true);
				b.setRolloverEnabled(false); // wenn Maus drüberfährt keine Hervorhebung
				b.addActionListener(new ButtonListener(this, buttonSpeicher));
				buttonSpeicher.speichereButton(b);
			}
			panelMi.setBorder(new EmptyBorder(0, 0, 0, 10));
			
			panelDo.add(new JLabel("DONNERSTAG"));
			JLabel datumLabelDonnerstag = new JLabel(" " + datum.gibDonnerstagVonWocheX(wochen));
			if (datum.ferien[wochen - 1] == 1) datumLabelDonnerstag.setBackground(new Color(179,238,58));
			datumLabelDonnerstag.setOpaque(true);
			panelDo.add(datumLabelDonnerstag);
			panelDo.add(new JLabel("vormittag"));
			panelDo.add(new JLabel("nachmittag"));
			//		https://stackoverflow.com/questions/5654208/making-a-jbutton-invisible-but-clickable
			for (int i = 1; i <= buttonSpeicher.mitarbeiterArrayList.size()*2; i++)
			{
				JButton b = new JButton();
				panelDo.add(b);
				b.setName((i+1)/2 + ";" + wochen + ";" + 3 + ";" + (i-1)%2);
				b.setOpaque(true);
				b.setBackground(gibFarbeFuerDienstplan(i-1, 3, wochen));
				b.setBorderPainted(true);
				b.setRolloverEnabled(false); // wenn Maus drüberfährt keine Hervorhebung
				b.addActionListener(new ButtonListener(this, buttonSpeicher));
				buttonSpeicher.speichereButton(b);
			}
			panelDo.setBorder(new EmptyBorder(0, 0, 0, 10));
			
			panelFr.add(new JLabel("FREITAG"));
			JLabel datumLabelFreitag = new JLabel(" " + datum.gibFreitagVonWocheX(wochen));
			if (datum.ferien[wochen - 1] == 1) datumLabelFreitag.setBackground(new Color(179,238,58));
			datumLabelFreitag.setOpaque(true);
			panelFr.add(datumLabelFreitag);
			panelFr.add(new JLabel("vormittag"));
			panelFr.add(new JLabel("nachmittag"));
			//		https://stackoverflow.com/questions/5654208/making-a-jbutton-invisible-but-clickable
			for (int i = 1; i <= buttonSpeicher.mitarbeiterArrayList.size()*2; i++)
			{
				JButton b = new JButton();
				panelFr.add(b);
				b.setName((i+1)/2 + ";" + wochen + ";" + 4 + ";" + (i-1)%2);
				b.setOpaque(true);
				b.setBackground(gibFarbeFuerDienstplan(i-1, 4, wochen));
				b.setBorderPainted(true);
				b.setRolloverEnabled(false); // wenn Maus drüberfährt keine Hervorhebung
				b.addActionListener(new ButtonListener(this, buttonSpeicher));
				buttonSpeicher.speichereButton(b);
			}
			panelFr.setBorder(new EmptyBorder(0, 0, 0, 10));
			
			woche.add(panelMA);
			woche.add(panelMo);
			woche.add(panelDi);
			woche.add(panelMi);
			woche.add(panelDo);
			woche.add(panelFr);

			scrollbereich.add(woche);
		}
	}

}
