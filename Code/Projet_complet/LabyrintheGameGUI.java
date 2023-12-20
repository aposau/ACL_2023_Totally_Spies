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
	int fin_du_monde=0;

	
	int niveau=3;
	

	private JFrame frame;

	public int [][] labyrinthe;

	public LabyrintheGameGUI(int nv) {
		this.p=0;
		this.niveau=nv;
		chargerLabyrinthe(nv);		
	}
	
	Labyrinthe labyrintheLoader = new Labyrinthe(niveau);
	
	int [][] listpic = labyrintheLoader.getPic();
	int [][] 	listtrou =labyrintheLoader.getTrou();
	int [][] listPotion = labyrintheLoader.getPotion();
	int [][] listfin=labyrintheLoader.getFin();
	



	Objet_spe potion1=new Objet_spe(plein,this.listPotion[0][1],this.listPotion[0][0]);
	Objet_spe potion2=new Objet_spe(plein,this.listPotion[1][1],this.listPotion[1][0]);
	Objet_spe trou1=new Objet_spe(plein,this.listtrou[0][1],this.listtrou[0][0]);
	Objet_spe trou2=new Objet_spe(plein,this.listtrou[1][1],this.listtrou[1][0]);
	Objet_spe trou3=new Objet_spe(plein,this.listtrou[2][1],this.listtrou[2][0]);
	Objet_spe trou4=new Objet_spe(plein,this.listtrou[3][1],this.listtrou[3][0]);
	Objet_spe pic1=new Objet_spe(plein,this.listpic[0][1],this.listpic[0][0]);
	Objet_spe pic2=new Objet_spe(plein,this.listpic[1][1],this.listpic[1][0]);
	Objet_spe pic3=new Objet_spe(plein,this.listpic[2][1],this.listpic[2][0]);
	Objet_spe pic4=new Objet_spe(plein,this.listpic[3][1],this.listpic[3][0]);
	Objet_spe pic5=new Objet_spe(plein,this.listpic[4][1],this.listpic[4][0]);




	Personnage monstre= new Personnage(pv_mon,3,3);
	Monstre_normal monmon=new Monstre_normal(pv_mon,2,5,1);
	Fantome fonfon = new Fantome(pv_mon,10,12,2);
	Personnage hero= new Personnage(pv_hero,2,2);
	Objet_spe fin=new Objet_spe(plein,listfin[0][1],listfin[0][0]);
	
	public int getP() {
		return p;
	}
	public void setP(int p) {
		this.p = p;
	}
	

	public int getFin_du_monde() {
		return fin_du_monde;
	}

	public void setFin_du_monde(int fin_du_monde) {
		this.fin_du_monde = fin_du_monde;
	}

	private void chargerLabyrinthe(int nv) {
		Labyrinthe labyrintheLoader = new Labyrinthe(nv);
		this.labyrinthe = labyrintheLoader.lireFichier();

				
	} 
	

	public void createAndShowGUI() {
		frame = new JFrame("Je suis le labyrinthe");


			
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);


		LabyrinthePanel labyrinthePanel = new LabyrinthePanel(this,hero,monmon,fonfon);
		frame.add(labyrinthePanel);
		labyrinthePanel.setVisible(true);
		
	

		labyrinthePanel.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				moveHero(e.getKeyCode());
				/*System.out.println("Key pressed: " + e.getKeyCode());
				System.out.println("Hero:");
				System.out.println(hero);
				System.out.println("Monstre");
				System.out.println(monmon);*/
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
		setP(0);
		setFin_du_monde(0);

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
			break;
		}

		//private void move_monstre() {

		//}
		monmon.deplacement_random();

		fonfon.deplacement_random_mur();

		Attaque a=new Attaque(monmon,hero);
		Attaque a2=new Attaque(fonfon,hero);
		
		
		Special s=new Special(hero,potion1,trou1,pic1,fin);
		Special s2=new Special(hero,potion2,trou2,pic2,fin);
		Special s3=new Special(hero,potion1,trou3,pic3,fin);
		Special s4=new Special(hero,potion1,trou4,pic4,fin);
		Special s5=new Special(hero,potion1,trou1,pic5,fin);
		


		int touche=a.contact();
		if (touche==1){
			if (getP()==1) {
				if (monmon.getNb_PV()>=30 && hero.getNb_PV()>=20) {
					int pv_hero=hero.getNb_PV();
					int pv_monstre=monmon.getNb_PV();
					hero.setNb_PV(pv_hero-20);
					monmon.setNb_PV(pv_monstre-30);
					System.out.println("Bam");
				}
				else if(monmon.getNb_PV()<30 && hero.getNb_PV()>=20){
					int pv_hero=hero.getNb_PV();

					hero.setNb_PV(pv_hero-20);
					monmon.setNb_PV(0);
					System.out.println("Bam");

				}
				else if(hero.getNb_PV()<20 && monmon.getNb_PV()>=30){
					int pv_monstre=monmon.getNb_PV();
					hero.setNb_PV(0);
					monmon.setNb_PV(pv_monstre-30);
					System.out.println("Bam");
				}
				else {
					monmon.setNb_PV(0);
					hero.setNb_PV(0);
					System.out.println("2 morts");
				}
			}
		}
		int touche2=a2.contact();
		if (touche2==1){
			if (getP()==1) {
				if (fonfon.getNb_PV()>=30 && hero.getNb_PV()>=20) {
					int pv_hero=hero.getNb_PV();
					int pv_monstre=fonfon.getNb_PV();
					hero.setNb_PV(pv_hero-20);
					fonfon.setNb_PV(pv_monstre-30);
					System.out.println("Bam");
				}
				else if(fonfon.getNb_PV()<30 && hero.getNb_PV()>=20){
					int pv_hero=hero.getNb_PV();

					hero.setNb_PV(pv_hero-20);
					fonfon.setNb_PV(0);
					System.out.println("Bam");

				}
				else if(hero.getNb_PV()<20 && fonfon.getNb_PV()>=30){
					int pv_monstre=fonfon.getNb_PV();
					hero.setNb_PV(0);
					fonfon.setNb_PV(pv_monstre-30);
					System.out.println("Bam");
				}
				else {
					fonfon.setNb_PV(0);
					hero.setNb_PV(0);
					System.out.println("2 morts");
				}
			}
		}


		a.attaque_contact(hero, monmon);
		a2.attaque_contact(hero, fonfon);
		
		
	
		s.Trou(hero, trou1);
		s.Pic(hero, pic1);
		s.Potion(hero, potion1);
		s2.Trou(hero, trou2);
		s2.Pic(hero, pic2);
		s2.Potion(hero, potion2);
		s3.Trou(hero, trou3);
		s3.Pic(hero, pic3);
		s4.Trou(hero, trou4);
		s4.Pic(hero, pic4);
		s5.Pic(hero, pic5);
		s.Fin(hero, fin);
		
		
		s.Mort(hero);


		int cout=a.cout_epe();
		if (cout==1){
			if (monmon.nb_PV>1) {
			if (getP()==1) {
				if (monmon.getNb_PV()>30){
					int pv_monstre=monmon.getNb_PV();
					monmon.setNb_PV(pv_monstre-30);
					System.out.println("Bim");
				}
				else {
					System.out.println("Le monstre est mort !");
					monmon.setNb_PV(0);
					System.out.println("Bim");

				}
			}
			}
		}
		int cout2=a2.cout_epe();
		if (cout2==1){
			if (fonfon.nb_PV>1) {
			if (getP()==1) {
				if (fonfon.getNb_PV()>30){
					int pv_monstre=fonfon.getNb_PV();
					fonfon.setNb_PV(pv_monstre-30);
					System.out.println("Bim");
				}
				else {
					System.out.println("Le monstre est mort !");
					fonfon.setNb_PV(0);
					System.out.println("Bim");

				}
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
		labyrinthePanel.setFonfonX(fonfon.getPositionX());

		labyrinthePanel.setFonfonY(fonfon.getPositionY());
		int newmonstreX=monmon.getPositionX();
		int newmonstreY=monmon.getPositionY();
		if (isValidMove(newmonstreX,newmonstreY)) {
			labyrinthePanel.setMonstreX(newmonstreX);
			labyrinthePanel.setMonstreY(newmonstreY);
		}
		if (isValidMove(labyrinthePanel.getHeroX()+dx,labyrinthePanel.getHeroY()+dy)) {
			labyrinthePanel.setHeroX(labyrinthePanel.getHeroX() + dx);
			labyrinthePanel.setHeroY(labyrinthePanel.getHeroY() + dy);
			/*labyrinthePanel.setMonstreX(labyrinthePanel.getMonstreX());
			labyrinthePanel.setMonstreY(labyrinthePanel.getMonstreY());*/
			labyrinthePanel.repaint();
		}
	

		JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(labyrinthePanel);

		if (hero.nb_PV==0) {
			showFinDialog(frame, "Vous avez perdu !", "C:\\Users\\r0man\\OneDrive\\Documents\\Ensem\\2A\\Info\\javoute\\Projet\\Gameover.png");
			}
		
		if (s.Fin(hero, fin)==1) {
			showFinDialog(frame, "Vous avez gagnez !", "C:\\Users\\r0man\\OneDrive\\Documents\\Ensem\\2A\\Info\\javoute\\Projet\\Win.png");		
		}
		
		findumonde();
		}

		private void showFinDialog(JFrame parentFrame, String message, String imagePath) {
		    ImageIcon icon = new ImageIcon(imagePath);
		    Image image = icon.getImage().getScaledInstance(800, 800, Image.SCALE_SMOOTH);
		    ImageIcon resizedIcon = new ImageIcon(image);

		    JPanel panel = new JPanel();
		    panel.setPreferredSize(new Dimension(800, 800)); //meme taille que la fenetre de jeu 


		    panel.add(new JLabel(resizedIcon));
		    panel.add(new JLabel(message));

		    JOptionPane.showMessageDialog(parentFrame, panel, "Fin du labyrinthe", JOptionPane.INFORMATION_MESSAGE);
		}

	
	public int findumonde() {
		if (monmon.getNb_PV()<1) {
			setFin_du_monde(1);
		}
		if (getFin_du_monde()==1) {
			createAndShowGUI();
			monmon.setNb_PV(1);
		}
		if (fonfon.getNb_PV()<1) {
			setFin_du_monde(2);
			
		}
		if (getFin_du_monde()==2) {
			createAndShowGUI();
			fonfon.setNb_PV(1);
		}
		return(1);
		
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
	private int fonfonX;
	private int fonfonY;
	int pv_monmon;
	int pv_fontome;
	
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
	private BufferedImage Fantome;

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
	

	public int getFonfonX() {
		return fonfonX;
	}

	public void setFonfonX(int fonfonX) {
		this.fonfonX = fonfonX;
	}

	public int getFonfonY() {
		return fonfonY;
	}

	public void setFonfonY(int fonfonY) {
		this.fonfonY = fonfonY;
	}

	public void setMonstreX(int monstreX) {
		this.monstreX = monstreX;
	}

	public void setMonstreY(int monstreY) {
		this.monstreY = monstreY;
	}

	public int getMonstreX() {
		return monstreX;
	}

	public int getMonstreY() {
		return monstreY;
	}
	public int getFantomeX() {
		return fonfonX;
	}

	public int getFantomeY() {
		return fonfonY;
	}
	

	//ajout constructeur avec la ref à l'instance
	public LabyrinthePanel(LabyrintheGameGUI parent,Personnage hero,Monstre_normal monmon, Fantome fonfon) {
		this.parent=parent;
		setFocusable(true);
		System.out.println(hero);
		this.heroX=hero.getPositionX();
		this.heroY=hero.getPositionY();
		this.monstreX=monmon.getPositionX();
		this.monstreY=monmon.getPositionY();
		this.fonfonX=fonfon.getPositionX();
		this.fonfonY=fonfon.getPositionY();
		this.pv_monmon=monmon.getNb_PV();
		this.pv_fontome=fonfon.getNb_PV();

		try {
			Brique = ImageIO.read(new File("C:\\Users\\r0man\\OneDrive\\Documents\\Ensem\\2A\\Info\\javoute\\Projet\\Brique.png")); 
			Heros = ImageIO.read(new File("C:\\Users\\r0man\\OneDrive\\Documents\\Ensem\\2A\\Info\\javoute\\Projet\\Heros.png"));
			Herbe = ImageIO.read(new File("C:\\Users\\r0man\\OneDrive\\Documents\\Ensem\\2A\\Info\\javoute\\Projet\\Herbe.png"));
			Pic = ImageIO.read(new File("C:\\\\Users\\\\r0man\\\\OneDrive\\\\Documents\\\\Ensem\\\\2A\\\\Info\\\\javoute\\\\Projet\\\\Pic.png"));
			Potion = ImageIO.read(new File("C:\\\\Users\\\\r0man\\\\OneDrive\\\\Documents\\\\Ensem\\\\2A\\\\Info\\\\javoute\\\\Projet\\\\Potion.png"));
			Trou = ImageIO.read(new File("C:\\\\Users\\\\r0man\\\\OneDrive\\\\Documents\\\\Ensem\\\\2A\\\\Info\\\\javoute\\\\Projet\\\\Trou.png"));
			Fin = ImageIO.read(new File("C:\\\\Users\\\\r0man\\\\OneDrive\\\\Documents\\\\Ensem\\\\2A\\\\Info\\\\javoute\\\\Projet\\\\Fin.png"));
			Monstre = ImageIO.read(new File("C:\\\\Users\\\\r0man\\\\OneDrive\\\\Documents\\\\Ensem\\\\2A\\\\Info\\\\javoute\\\\Projet\\\\Monstre.png"));
			Fantome = ImageIO.read(new File("C:\\\\Users\\\\r0man\\\\OneDrive\\\\Documents\\\\Ensem\\\\2A\\\\Info\\\\javoute\\\\Projet\\\\Fantome.png"));
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
				else if (i == getMonstreY() && j == getMonstreX() && this.pv_monmon>1) {
					g.drawImage(Monstre, j * cellSize, i * cellSize, cellSize, cellSize, null);
				}
				else if (i == getFantomeY() && j == getFantomeX() && this.pv_fontome >1 ) {
					g.drawImage(Fantome, j * cellSize, i * cellSize, cellSize, cellSize, null);
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