package apoUrlaubsPlaner;

import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.JButton;

public class Speichern {
	
	ButtonSpeicher buttonSpeicherKlasse;
	ButtonSpeicher buttonSpeicherKlasseGeladen = new ButtonSpeicher();
	String pfad = System.getProperty("user.home") + "/Dropbox/HP Laptop/Urlaubsplaner2020Test.tmp";
	String pfadJPG = System.getProperty("user.home") + "/Dropbox/HP Laptop/UrlaubsplanerJPG2020Test.jpg";
	FileWriter fileWriter;
	FileReader fileReader;
	File file;
	Datum datum;
	ErstellenJPG erstellenJPG;
	
	public Speichern (ButtonSpeicher buttonSpeicherKlasse, Datum datum)
	{
		this.buttonSpeicherKlasse = buttonSpeicherKlasse;
		this.datum = datum;
		erstellenJPG = new ErstellenJPG(buttonSpeicherKlasse, datum);
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
	
	public void speichereJPG() throws IOException
	{
		BufferedImage fertigesJPG = erstellenJPG.renderFertigesJPG();
		File jpgFile = new File(pfadJPG);
		ImageIO.write(fertigesJPG, "png", jpgFile);
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

