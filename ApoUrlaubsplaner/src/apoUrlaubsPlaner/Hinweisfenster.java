package apoUrlaubsPlaner;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Hinweisfenster extends JPanel{
	
	JPanel hinweisPanel = new JPanel();
	JFrame hinweisFrame = new JFrame("");
	String text;
	Timer blinken;
	
	public Hinweisfenster(String text) 
	{
		this.text = text;
		hinweisFrame.setSize(200, 100);
		hinweisFrame.setLocationRelativeTo(null);
		hinweisPanel.setLayout(new BorderLayout());
		JLabel label = new JLabel(text, SwingConstants.CENTER);
		label.setFont(new Font("Arial", Font.BOLD, 16));
		label.setForeground(Color.RED);
		hinweisPanel.add(label, BorderLayout.CENTER);
		hinweisFrame.add(hinweisPanel);
		hinweisFrame.setUndecorated(true); // Fenster ohne Titelleiste
		hinweisFrame.setVisible(true);
	}
	

}
