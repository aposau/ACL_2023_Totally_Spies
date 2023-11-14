import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class LabyrintheGameGUI {
	private JFrame frame;
	 
	/*
	// labyrinthe exemple utilisé en attendant de relier a la classe Labyrinthe
	public int[][] labyrinthe = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 1, 0, 0, 0, 0, 0, 1},
            {1, 1, 0, 0, 0, 1, 0, 0, 0, 1},
            {1, 0, 4, 0, 1, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 1, 0, 1},	
            {1, 0, 1, 0, 0, 4, 0, 0, 0, 1},
            {1, 0, 0, 0, 1, 0, 0, 0, 4, 1},
            {1, 0, 0, 0, 0, 4, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
	};
	*/
	
	public int [][] labyrinthe;
    
    public LabyrintheGameGUI(int nv) {
        chargerLabyrinthe(nv);
    }
    
    private void chargerLabyrinthe(int nv) {
        Labyrinthe labyrintheLoader = new Labyrinthe(nv);
        this.labyrinthe = labyrintheLoader.lireFichier();
    } 

    public void createAndShowGUI() {
        frame = new JFrame("Je suis le labyrinthe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
       

        LabyrinthePanel labyrinthePanel = new LabyrinthePanel(this);
        frame.add(labyrinthePanel);
        labyrinthePanel.setVisible(true);

        labyrinthePanel.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                moveHero(e.getKeyCode());
                System.out.println("Key pressed: " + e.getKeyCode());
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

        });
        // rend le labyrinthe visible
        labyrinthePanel.setVisible(true);
        labyrinthePanel.requestFocusInWindow();

        // rend le JFrame visible
        frame.setVisible(true);
    }
    
    private void moveHero(int keyCode) {
    	int dx=0;
    	int dy=0;
    	
    	switch(keyCode) {
    	case KeyEvent.VK_LEFT:
    		dx=-1;
    		break;
    	case KeyEvent.VK_RIGHT:
    		dx=1;
    		break;
    	case KeyEvent.VK_UP:
    		dy=-1;
    		break;
    	case KeyEvent.VK_DOWN:
    		dy=1;
    		break;
    		
    	}
    	
    	LabyrinthePanel labyrinthePanel= (LabyrinthePanel) frame.getContentPane().getComponent(0);
    	
    	if (isValidMove(labyrinthePanel.getHeroX()+dx,labyrinthePanel.getHeroY()+dy)) {
    		labyrinthePanel.setHeroX(labyrinthePanel.getHeroX() + dx);
    		labyrinthePanel.setHeroY(labyrinthePanel.getHeroY() + dy);
    		labyrinthePanel.repaint();
    	}
    }
    //tt les cas dans lequel le héros peut avancer
    private boolean isValidMove(int newX, int newY) {
    	return newX>=0 && newX<labyrinthe[0].length 
    			&& newY>=0 && newY<labyrinthe.length 
    			&& labyrinthe[newY][newX]==0;
    }
}

class LabyrinthePanel extends JPanel {
	private int heroX=1;
	private int heroY=1;
	//initialise mon héros a la case 1,1
	//position à prendre de guillian après pour avoir sa vrai position 
	
    //ref à l'instance parente sinon ca ne marchait plus  
    private LabyrintheGameGUI parent; 
    private BufferedImage Brique;
    private BufferedImage Heros;
    private BufferedImage Herbe;
    
	public int getHeroX() {
		return heroX;
	}

	public void setHeroX(int heroX) {
		this.heroX = heroX;
	}
	
	public int getHeroY() {
		return heroY;
	}

	public void setHeroY(int heroY) {
		this.heroY = heroY;
	}
    
    
    //ajout constructeur avec la ref à l'instance
    public LabyrinthePanel(LabyrintheGameGUI parent) {
    	this.parent=parent;
    	setFocusable(true);
    	
        try {
            Brique = ImageIO.read(new File("\Users\saussard2u\ACL_2023_Totally_Spies\Code\Interface_graphique\src\Brique.png")); 
            Heros = ImageIO.read(new File("\Users\saussard2u\ACL_2023_Totally_Spies\Code\Interface_graphique\src\Heros.png"));
            Herbe = ImageIO.read(new File("\Users\saussard2u\ACL_2023_Totally_Spies\Code\Interface_graphique\src\Herbe.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override //c'est pour lui dire qu'on remplace la methode qui est dans JPanel
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int cellSize = 50; // taille d'une cellule en pixels
        for (int i = 0; i < parent.labyrinthe.length; i++) {
            for (int j = 0; j < parent.labyrinthe[i].length; j++) {
                if (parent.labyrinthe[i][j] == 1 || parent.labyrinthe[i][j] == 4) {
                	g.drawImage(Brique, j * cellSize, i * cellSize, cellSize, cellSize, null);
                } 
                else if (i == getHeroY() && j == getHeroX()) {
                	g.drawImage(Heros, j * cellSize, i * cellSize, cellSize, cellSize, null);
                }
                else {
                	g.drawImage(Herbe, j * cellSize, i * cellSize, cellSize, cellSize, null);
                }

                // dessine une bordure autour de la cellule pour mieux voir
                g.setColor(Color.GRAY);
                g.drawRect(j * cellSize, i * cellSize, cellSize, cellSize);
            }
        }

    }

}