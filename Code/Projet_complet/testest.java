package test;
import projproj.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testest {

	@Test
	void testValidMove() {
		LabyrintheGameGUI lab = new LabyrintheGameGUI(1);
		int[][]labyrinthe = {
				{0,0,0},
				{0,1,0},
				{0,0,0}
		};
		lab.labyrinthe=labyrinthe;
		
		assertTrue(lab.isValidMove(0,0));
		assertFalse(lab.isValidMove(1,1)); //verifie que il peut pas aller sur la brique
		assertFalse(lab.isValidMove(3, 3)); //verifie qu'il peut pas sortir du labyrinthe 
	}
	@Test
	void testMortHeros() {
		Personnage hero=new Personnage(50,1,1);
		Personnage monstre=new Personnage(50,1,1);
		
		Attaque attaque = new Attaque(monstre, hero); 
		
		attaque.attaque_contact(hero, monstre);
		
		assertEquals(hero.getNb_PV(),0);
	}
	
	@Test
	void testPVneg() {
		Personnage hero=new Personnage(30,1,1);
		Personnage monstre=new Personnage(50,1,1);
		
		Attaque attaque = new Attaque(monstre, hero); 
		
		attaque.attaque_epe_contact(hero, monstre); //10 PV pour heros 
		attaque.attaque_epe_contact(hero, monstre);
		
		
		assertTrue(hero.getNb_PV()>=0);
	}
}
