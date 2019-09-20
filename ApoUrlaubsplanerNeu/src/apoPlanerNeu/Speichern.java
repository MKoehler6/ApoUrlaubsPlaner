package apoPlanerNeu;

import java.io.*;

import javax.swing.JButton;

public class Speichern {
	
	ButtonSpeicher buttonSpeicherKlasse;
	ButtonSpeicher buttonSpeicherKlasseGeladen = new ButtonSpeicher();
//	String pfad = System.getProperty("user.home") + "/Dropbox/HP Laptop/Urlaubsplaner2.tmp";
	String pfad = "./Urlaubsplaner.tmp";
	FileWriter fileWriter;
	FileReader fileReader;
	File file;
	
	public Speichern (ButtonSpeicher buttonSpeicherKlasse)
	{
		this.buttonSpeicherKlasse = buttonSpeicherKlasse;
	}

	public void ladeDatei() throws IOException
	{
		file = new File(pfad);
		if (file.exists())
		{
			
			FileInputStream fis = new FileInputStream(pfad);
			ObjectInputStream ois = new ObjectInputStream(fis);
			try {
				buttonSpeicherKlasseGeladen = (ButtonSpeicher) ois.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ois.close();
			kopiereDatenAusFileInsProgramm();
		}
	}
	
	public void speichereDatei() throws IOException
	{
		FileOutputStream fos = new FileOutputStream(pfad);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(buttonSpeicherKlasse);
		oos.close();
	}
	
	public void kopiereDatenAusFileInsProgramm()
	{
		for (int i = 0; i < buttonSpeicherKlasse.buttonSpeicherArrayList.size(); i++)
		{
			buttonSpeicherKlasse.buttonSpeicherArrayList.get(i).setBackground(buttonSpeicherKlasseGeladen.buttonSpeicherArrayList.get(i).getBackground());
		}
		for (int i = 0; i < buttonSpeicherKlasse.urlaubsTageSpeicher.length; i++)
		{
			buttonSpeicherKlasse.urlaubsTageSpeicher[i] = buttonSpeicherKlasseGeladen.urlaubsTageSpeicher[i];
		}
		buttonSpeicherKlasse.aktualisiereUrlaubAufButtonAlleMitarbeiter();
	}
}

