
import javax.swing.*;
import java.util.Scanner;

 
public class main_Attaque {

	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			Scanner sc = new Scanner(System.in);
			System.out.println("Veuillez choisir un niveau (1, 2 ou 3) :");
		    int niveau = sc.nextInt();
			LabyrintheGameGUI labyrinthe = new LabyrintheGameGUI(niveau);
			labyrinthe.createAndShowGUI();
	        });

	}
}
