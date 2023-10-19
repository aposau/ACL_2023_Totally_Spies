import javax.swing.*;

public class main {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			LabyrintheGameGUI labyrinthe = new LabyrintheGameGUI();
			labyrinthe.createAndShowGUI();
	        });
	    }
}
 