package proj_Ro;
import javax.swing.*;

 
public class main_Attaque {

	
	public static void main(String[] args) {
		int pv_mon=150;
		int pv_hero=150;
		int plein=1;
		Personnage monstre= new Personnage(pv_mon,10,3,9,2);
		Personnage hero= new Personnage(pv_hero,20,10,19,9);
		Objet_spe potion=new Objet_spe(plein,3,4);
		Objet_spe trou=new Objet_spe(plein,15,4);
		Objet_spe pic=new Objet_spe(plein,20,10);
		Objet_spe fin=new Objet_spe(plein,20,10);

		Attaque a=new Attaque(monstre, hero);
		Special s=new Special(hero,potion,trou,pic,fin);
		
		//System.out.println(a.contact());
		//a.attaque_contact(hero,monstre);
		a.attaque_epe_contact(hero, monstre);
		s.Potion(hero,potion);
		s.Trou(hero,trou);
		s.Pic(hero, pic);
		a.attaque_epe(hero, monstre);
		a.attaque_contact(hero, monstre);
		System.out.println(hero);//marche
		System.out.println(monstre);//marche
		System.out.println(potion);
		System.out.println(pic);
		System.out.println(trou);
		
		SwingUtilities.invokeLater(() -> {
			int niveau=1;
			LabyrintheGameGUI labyrinthe = new LabyrintheGameGUI(niveau);
			labyrinthe.createAndShowGUI();
	        });
	}
}
