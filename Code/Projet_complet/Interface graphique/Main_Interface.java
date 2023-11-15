package projet_totally_spies;
import javax.swing.*;
public class Main_Interface {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			int niveau=1;
			LabyrintheGameGUI labyrinthe = new LabyrintheGameGUI(niveau);
			labyrinthe.createAndShowGUI();
		});
	}
}