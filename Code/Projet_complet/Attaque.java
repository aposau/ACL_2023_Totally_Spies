package proj_Ro;




public class Attaque {
	int X_mon;
	int Y_mon;

	int X_hero;
	int Y_hero;
	
	int epe;

	public Attaque ( Personnage monmon, Personnage charles,LabyrintheGameGUI labyby) {
		this.X_mon= monmon.getPositionX();
		this.Y_mon= monmon.getPositionY();

		this.X_hero= charles.getPositionX();
		this.Y_hero= charles.getPositionY();
		
		this.epe=labyby.getP();

    }
	 public int detecter_entrer() {
	        return(this.epe);
	 }
	        
	public int perte_de_pv(int pv) {
		pv=pv-10;
		return(pv);
	}
	
	public int contact () {
		int p =0;
		if (this.X_mon == this.X_hero) {
			if (this.Y_mon == this.Y_hero) {
				p = 1;
			}
		}
		return(p);
	}

	public void attaque_contact(Personnage hero, Personnage monstre ) {
		int touche = contact();
		if (touche==1) {
			int pv_monstre=monstre.getNb_PV();
			hero.setNb_PV(0);
			monstre.setNb_PV(perte_de_pv(pv_monstre));
            System.out.println("Boum");
		}
	}


	public void attaque_epe_contact(Personnage hero, Personnage monstre) {
		int touche=contact();
		if (touche==1){
			if (epe==1) {
				int pv_hero=hero.getNb_PV();
				int pv_monstre=monstre.getNb_PV();
				hero.setNb_PV(pv_hero-20);
				monstre.setNb_PV(pv_monstre-50);
                System.out.println("Bam");
			}
		}
	}
	
	public int cout_epe() {
		int p=0;
		if (this.X_mon+1==this.X_hero) {
			if(this.Y_hero==this.Y_mon) {
				p=1;
			}
			if (this.Y_hero==this.Y_mon+1) {
				p=1;
			}
			if (this.Y_hero==this.Y_mon-1) {
				p=1;
			}
		}
		if (this.X_hero==this.X_mon) {
			if (this.Y_hero==this.Y_mon+1) {
				p=1;
			}
			if (this.Y_hero==this.Y_mon-1) {
				p=1;
			}
		}
		if (this.X_hero==this.X_mon-1) {
			if(this.Y_hero==this.Y_mon) {
				p=1;
			}
			if (this.Y_hero==this.Y_mon+1) {
				p=1;
			}
			if (this.Y_hero==this.Y_mon-1) {
				p=1;
			}
		}
		return(p);
	}
	
	public void attaque_epe(Personnage hero, Personnage monstre) {
		int cout=cout_epe();
		if (cout==1){
			if (this.epe==1) {
				int pv_monstre=monstre.getNb_PV();
				monstre.setNb_PV(pv_monstre-50);
                System.out.println("Bim");
			}
		}
	}
	
}
