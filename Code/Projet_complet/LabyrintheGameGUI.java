package projproj;

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


	Personnage monstre= new Personnage(pv_mon,3,3);
	Personnage hero= new Personnage(pv_hero,2,2);
	Objet_spe potion=new Objet_spe(plein,3,4);
	Objet_spe trou=new Objet_spe(plein,15,4);
	Objet_spe pic=new Objet_spe(plein,20,10);
	Objet_spe fin=new Objet_spe(plein,40,10);


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


		LabyrinthePanel labyrinthePanel = new LabyrinthePanel(this,hero,monstre);
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
				System.out.println("Hero:");
				System.out.println(hero);
				System.out.println("Monstre");
				System.out.println(monstre);
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
			/*
			if (monstre instanceof Monstre_normal) {
				Monstre_normal monstrenormal = (Monstre_normal) monstre;
				monstrenormal.deplacement_random();
			}
			*/
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
		
		//private void move_monstre() {
			
		//}
		
		Attaque a=new Attaque(monstre,hero);
		Special s=new Special(hero,potion,trou,pic,fin);
		
		
		int touche=contact();
		int epe=1;
		if (touche==1){
			if (epe==1) {
				if (monstre.getNb_PV()>=30 && hero.getNb_PV()>=20) {
					int pv_hero=hero.getNb_PV();
					int pv_monstre=monstre.getNb_PV();
					hero.setNb_PV(pv_hero-20);
					monstre.setNb_PV(pv_monstre-30);
					System.out.println("Bam");
				}
				else if(monstre.getNb_PV()<30 && hero.getNb_PV()>=20){
					int pv_hero=hero.getNb_PV();

					hero.setNb_PV(pv_hero-20);
					monstre.setNb_PV(0);
					System.out.println("Bam");

				}
				else if(hero.getNb_PV()<20 && monstre.getNb_PV()>=30){
					int pv_monstre=monstre.getNb_PV();
					hero.setNb_PV(0);
					monstre.setNb_PV(pv_monstre-30);
					System.out.println("Bam");
				}
				else {
					monstre.setNb_PV(0);
					hero.setNb_PV(0);
					System.out.println("2 morts");
				}
			}
		}

			
			a.attaque_contact(hero, monstre);
			s.Trou(hero, trou);
			s.Pic(hero, pic);
			s.Potion(hero, potion);
			s.Fin(hero, fin);
			
			
			int cout=a.cout_epe();
			if (cout==1){
				if (getP()==1) {
					if (monstre.getNb_PV()>30){
						int pv_monstre=monstre.getNb_PV();
						monstre.setNb_PV(pv_monstre-30);
						System.out.println("Bim");
					}
					else {
						System.out.println("Le monstre est mort !");
						monstre.setNb_PV(0);
						System.out.println("Bim");

					}
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
			/*labyrinthePanel.setMonstreX(labyrinthePanel.getMonstreX());
			labyrinthePanel.setMonstreY(labyrinthePanel.getMonstreY());*/
			labyrinthePanel.repaint();
		}
	}
	
	//tt les cas dans lequel le héros peut avancer
	public boolean isValidMove(int newX, int newY) {
		return newX>=0 && newX<labyrinthe[0].length 
				&& newY>=0 && newY<labyrinthe.length 
				&& labyrinthe[newY][newX]!=1; 

	}
}

class LabyrinthePanel extends JPanel {
	
	private int heroX;
	private int heroY;
	private int monstreX;
	private int monstreY;
	//initialise mon héros a la case 1,1
	//position à prendre de guillian après pour avoir sa vrai position 

	//ref à l'instance parente sinon ca ne marchait plus  
	private LabyrintheGameGUI parent; 
	private BufferedImage Brique;
	private BufferedImage Heros;
	private BufferedImage Herbe;
	private BufferedImage Trou;
	private BufferedImage Pic;
	private BufferedImage Fin;
	private BufferedImage Potion;
	private BufferedImage Monstre;

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
	
	public int getMonstreX() {
		return monstreX;
	}

	public void setMonstreX(int monstreX) {
		this.monstreX = monstreX;
	}

	public int getMonstreY() {
		return monstreY;
	}

	public void setMonstreY(int monstreY) {
		this.monstreY = monstreY;
	}


	//ajout constructeur avec la ref à l'instance
	public LabyrinthePanel(LabyrintheGameGUI parent,Personnage hero,Personnage monstre) {
		this.parent=parent;
		setFocusable(true);
		System.out.println(hero);
		this.heroX=hero.getPositionX();
		this.heroY=hero.getPositionY();
		this.monstreX=monstre.getPositionX();
		this.monstreY=monstre.getPositionY();
		

		try {
			Brique = ImageIO.read(new File("/Users/apollinesaussard/eclipse-workspace/projet_jeu/Proj/Brique.png")); 
			Heros = ImageIO.read(new File("/Users/apollinesaussard/eclipse-workspace/projet_jeu/Proj/Heros.png"));
			Herbe = ImageIO.read(new File("/Users/apollinesaussard/eclipse-workspace/projet_jeu/Proj/Herbe.png"));
			Pic = ImageIO.read(new File("/Users/apollinesaussard/eclipse-workspace/projet_jeu/Proj/Pic.png"));
			Potion = ImageIO.read(new File("/Users/apollinesaussard/eclipse-workspace/projet_jeu/Proj/Potion.png"));
			Trou = ImageIO.read(new File("/Users/apollinesaussard/eclipse-workspace/projet_jeu/Proj/Trou.png"));
			Fin = ImageIO.read(new File("/Users/apollinesaussard/eclipse-workspace/projet_jeu/Proj/Fin.png"));
			Monstre = ImageIO.read(new File("/Users/apollinesaussard/eclipse-workspace/projet_jeu/Proj/Monstre.png"));
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
				if (parent.labyrinthe[i][j] == 1) {
					g.drawImage(Brique, j * cellSize, i * cellSize, cellSize, cellSize, null);
				} 
				else if (parent.labyrinthe[i][j] == 4) {
					g.drawImage(Trou, j * cellSize, i * cellSize, cellSize, cellSize, null);
				}
				else if (i == getHeroY() && j == getHeroX()) {
					g.drawImage(Heros, j * cellSize, i * cellSize, cellSize, cellSize, null);
				}
				else if (i == getMonstreY() && j == getMonstreX()) {
					g.drawImage(Monstre, j * cellSize, i * cellSize, cellSize, cellSize, null);
				}
				else if (parent.labyrinthe[i][j] == 2) {
					g.drawImage(Pic, j * cellSize, i * cellSize, cellSize, cellSize, null);
				}
				else if (parent.labyrinthe[i][j] == 3) {
					g.drawImage(Potion, j * cellSize, i * cellSize, cellSize, cellSize, null);
				}
				else if (parent.labyrinthe[i][j] == 5) {
					g.drawImage(Fin, j * cellSize, i * cellSize, cellSize, cellSize, null);
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


