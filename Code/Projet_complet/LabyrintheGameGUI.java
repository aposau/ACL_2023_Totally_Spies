package proj_Ro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LabyrintheGameGUI {
	
	int p;
	int pv_mon=150;
	int pv_hero=150;
	int plein=1;
	int nv=1;


	Personnage monstre= new Personnage(pv_mon,4,4,1,1);
	Personnage hero= new Personnage(pv_hero,2,2,9,9);
	Objet_spe potion=new Objet_spe(plein,3,4);
	Objet_spe trou=new Objet_spe(plein,15,4);
	Objet_spe pic=new Objet_spe(plein,20,10);
	Objet_spe fin=new Objet_spe(plein,40,10);





	Special s=new Special(hero,potion,trou,pic,fin);
	int finfin = s.Fin(hero, fin);

	private JFrame frame;



	public int [][] labyrinthe;

	public LabyrintheGameGUI(int nv) {
		this.p=0;
		chargerLabyrinthe(nv);
	}
	
	public int getP() {
		return p;
	}
	public void setP(int p) {
		this.p = p;
	}


	private void chargerLabyrinthe(int nv) {
		Labyrinthe labyrintheLoader = new Labyrinthe(nv);
		this.labyrinthe = labyrintheLoader.lireFichier();
	} 

	public void createAndShowGUI() {
		frame = new JFrame("Je suis le labyrinthe");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);


		LabyrinthePanel labyrinthePanel = new LabyrinthePanel(this,hero);
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
				System.out.println(hero);
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
	 public int detecter_entrer() {
	        int p=1;
	        return(p);
	 }
		public int contact () {
			int p =0;
			if (monstre.getPositionX() == hero.getPositionY()) {
				if (monstre.getPositionY() == hero.getPositionX()) {
					p = 1;
				}
			}
			return(p);
		}
	private void moveHero(int keyCode) {
		int dx=0;
		int dy=0;
		setP(0);

		switch(keyCode) {
		case KeyEvent.VK_LEFT:
			hero.move_left();
			dx=-1;
			break;
		case KeyEvent.VK_RIGHT:
			hero.move_right();
			dx=1;
			break;
		case KeyEvent.VK_UP:
			hero.move_up();
			dy=-1;
			break;
		case KeyEvent.VK_DOWN:
			hero.move_down();
			dy=1;
			break;
		case KeyEvent.VK_ENTER:
			setP(1);
			System.out.println("proute");
			break;
		}
		
		Attaque a=new Attaque(monstre,hero);
			int touche=a.contact();
			if (touche==1){
				if (getP() ==1) {
					int pv_hero=hero.getNb_PV();
					int pv_monstre=monstre.getNb_PV();
					hero.setNb_PV(pv_hero-20);
					monstre.setNb_PV(pv_monstre-50);
	                System.out.println("Bam");
				}
			}
			
			int cout=a.cout_epe();
			if (cout==1){
				if (getP()==1) {
					int pv_monstre=monstre.getNb_PV();
					monstre.setNb_PV(pv_monstre-50);
	                System.out.println("Bim");
				}
			}
		
		

		LabyrinthePanel labyrinthePanel= (LabyrinthePanel) frame.getContentPane().getComponent(0);
		/*
		if (isValidMove(hero.getPositionX()+dx,hero.getPositionY()+dy)) {
			hero.setPositionX(hero.getPositionX()+ dx);
			hero.setPositionY(hero.getPositionY()+ dy);

			labyrinthePanel.repaint();
		}
	}*/
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
	public LabyrinthePanel(LabyrintheGameGUI parent,Personnage hero) {
		this.parent=parent;
		setFocusable(true);
		System.out.println(hero);
		this.heroX=hero.getPositionX();
		this.heroY=hero.getPositionY();
		

		try {
			Brique = ImageIO.read(new File("C:\\\\Users\\\\r0man\\\\OneDrive\\\\Documents\\\\Ensem\\\\2A\\\\Info\\javoute\\Projet\\Brique.png")); 
			Heros = ImageIO.read(new File("C:\\\\Users\\\\r0man\\\\OneDrive\\\\Documents\\\\Ensem\\\\2A\\\\Info\\\\javoute\\\\Projet\\\\Heros.png"));
			Herbe = ImageIO.read(new File("C:\\Users\\r0man\\OneDrive\\Documents\\Ensem\\2A\\Info\\javoute\\Projet\\Herbe.png"));
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


