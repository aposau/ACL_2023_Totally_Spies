package proj_Ro;



public class Attaque {
	int X_mon;
	int Y_mon;
	int pv_mon;

	int X_hero;
	int Y_hero;
	int pv_hero;

	public Attaque ( Personnage monmon, Personnage charles) {
		this.X_mon= monmon.getPositionX();
		this.Y_mon= monmon.getPositionY();
		this.pv_mon=monmon.getNb_PV();

		this.X_hero= charles.getPositionX();
		this.Y_hero= charles.getPositionY();
		this.pv_hero=charles.getNb_PV();

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

	public int perte_de_pv(int pv) {
		int touche = contact();
		if (touche==1) {
			pv=pv-10;
		}
		return(pv);
	}
}
