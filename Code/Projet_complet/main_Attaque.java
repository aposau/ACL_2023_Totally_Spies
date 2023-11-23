package proj_Ro;
import javax.swing.*;

 
public class main_Attaque {

	
	public static void main(String[] args) {

		SwingUtilities.invokeLater(() -> {
			int niveau=1;
			LabyrintheGameGUI labyrinthe = new LabyrintheGameGUI(niveau);
			labyrinthe.createAndShowGUI();
	        });

	}
}
