package proj_Ro;

public class main_Attaque {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int pv_mon=20;
		int pv_hero=150;
		Personnage monstre= new Personnage(pv_mon,10,3);
		Personnage hero= new Personnage(pv_hero,10,3);

		
		Attaque a=new Attaque(monstre, hero);
		
		
		System.out.println(a.contact());
		System.out.println(a.perte_de_pv(pv_mon));	
        pv_mon = a.perte_de_pv(pv_mon);
		hero.setNb_PV(pv_mon);
		System.out.println(a.perte_de_pv(pv_mon));
		hero.setNb_PV(pv_mon);
		System.out.println(hero);//marche pas
		System.out.println(monstre);//marche pas
		
	}

}
