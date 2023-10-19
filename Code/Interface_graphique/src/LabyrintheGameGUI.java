import javax.swing.*;
import java.awt.*;


public class LabyrintheGameGUI {
	
    private JFrame frame;

    public void createAndShowGUI() {
        frame = new JFrame("Je suis le labyrinthe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        LabyrinthePanel labyrinthePanel = new LabyrinthePanel();
        frame.add(labyrinthePanel);

        frame.setVisible(true);
    }
}

class LabyrinthePanel extends JPanel {
	private int heroX = 50; // Coordonn�e X du h�ros
    private int heroY = 50; // Coordonn�e Y du h�ros

    @Override //c'est pour lui dire qu'on remplace la methode qui est dans JPanel
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.BLUE);
        g.fillOval(heroX, heroY, 20, 20); // Dessiner le h�ros sous forme d'un point bleu
    }
}

