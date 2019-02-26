package apoUrlaubsPlaner;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ErstellenJPG {

	BufferedImage fertigesJPG;
	int[] pixels;
	ButtonSpeicher buttonSpeicher;
	Datum datum;
	int woche = 0;
	int zaehlerButtons = 0;
	String[] wochenTage = {"Mo", "Di", "Mi", "Do", "Fr"};
	
	public ErstellenJPG(ButtonSpeicher buttonSpeicher, Datum datum)
	{
		this.buttonSpeicher = buttonSpeicher;
		this.datum = datum;
		fertigesJPG = new BufferedImage(3100, 4070, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt) fertigesJPG.getRaster().getDataBuffer()).getData();
	}
	
	public BufferedImage renderFertigesJPG()
	{
		renderBackground();
		for (int zeile = 1; zeile <= 11; zeile++)
			for (int spalte = 1; spalte <= 5; spalte++)
				if (!(zeile == 11 && spalte > 2))
				{
					woche++;
					zaehlerButtons = zaehlerButtons + 12;
					for (int i = 0; i < 12; i++) // Mitarbeiter
						renderImage(createImageWithText(Mitarbeiter.values()[i].toString(), 100, 25, Font.BOLD, 10), 10 + 620*(spalte-1), 36 + 26 * i + 370*(zeile-1));
					for (int i = 0; i < 12; i++) // Urlaubstage
						renderImage(createImageWithText(buttonSpeicher.urlaubsTageSpeicher[i] + "", 25, 25, Font.PLAIN, 3), 112 + 620*(spalte-1), 36 + 26 * i + 370*(zeile-1));
					for (int i = 0; i < 5; i++) // Wochentage
					{ 
						String datum = gibDatumDesTages(i, woche);
						renderImage(createImageWithText(wochenTage[i] + "    " + datum, 91, 25, Font.BOLD, 5), 139 + 93 * i + 620*(spalte-1), 36 - 26 + 370*(zeile-1));
						for (int ma = 0; ma < 12; ma++) 
							for (int j = 0; j < 2; j++) // vormittag/nachmittag
							{
								renderImage(erstelleDienstplanFeld(45, 25), 139 + 93*i + 620*(spalte-1) + j*46, 36 + 26*ma + 370*(zeile-1));
								zaehlerButtons++;
							}
					}
				}
			
		return fertigesJPG;
	}
	
	public void renderBackground()
	{
		for (int i = 0; i < pixels.length; i++)
			pixels[i] = 0x5e5e5e;
	}
	
	public void renderImage(BufferedImage image, int xPos, int yPos)
	{
		int [] imagePixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
		renderArray(imagePixels, image.getWidth(), image.getHeight(), xPos, yPos);
	}
	
	private void renderArray(int[] renderPixels, int renderWidth, int renderHeight, int xPos, int yPos)
	{
		for (int y = 0; y < renderHeight; y++)
			for (int x = 0; x < renderWidth; x++)
				setPixel(renderPixels[y * renderWidth + x], x + xPos, y + yPos);
	}
	
	private void setPixel(int pixel, int x, int y)
	{
		int pixelIndex = x + y * fertigesJPG.getWidth();
		if (pixels.length > pixelIndex)
			pixels[pixelIndex] = pixel;						
	}

	private BufferedImage createImageWithText(String text, int width, int height, int thickness, int textbeginn)
	{
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		int[] imagePixel = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
		if ((datum.ferien[woche - 1] == 1) && width == 91)
		{
			for (int i = 0; i < imagePixel.length; i++)
				imagePixel[i] = 0xb3ee3a; // grün			
		} else {
			for (int i = 0; i < imagePixel.length; i++)
				imagePixel[i] = 0xffffff;
		}
		Graphics2D imgG2D = image.createGraphics();
		imgG2D.setFont(new Font("TimesRoman", thickness, 16));
		imgG2D.setColor(new Color(0x000000));
		imgG2D.drawChars(text.toCharArray(), 0,  text.length(), textbeginn, 18);
		return image;
	}
	private BufferedImage erstelleDienstplanFeld(int width, int height)
	{
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		int[] imagePixel = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
		if (buttonSpeicher.buttonSpeicherArrayList.get(zaehlerButtons).getBackground().toString().equals("java.awt.Color[r=255,g=69,b=0]"))
		{
			for (int i = 0; i < imagePixel.length; i++)
				imagePixel[i] = 0xff3030; // rot			
		} else if(buttonSpeicher.buttonSpeicherArrayList.get(zaehlerButtons).getBackground().toString().equals("java.awt.Color[r=80,g=150,b=230]"))
		{
			for (int i = 0; i < imagePixel.length; i++)
				imagePixel[i] = 0x5096e6; // blau
		} else {
			for (int i = 0; i < imagePixel.length; i++)
				imagePixel[i] = 0xffffff;
		}
		
		return image;
	}
	private String gibDatumDesTages(int tag, int week)
	{
		switch (tag)
		{
		case 0 : return datum.gibMontagVonWocheX(week);
		case 1 : return datum.gibDienstagVonWocheX(week);
		case 2 : return datum.gibMittwochVonWocheX(week);
		case 3 : return datum.gibDonnerstagVonWocheX(week);
		case 4 : return datum.gibFreitagVonWocheX(week);
		}
		return null;
	}
}
