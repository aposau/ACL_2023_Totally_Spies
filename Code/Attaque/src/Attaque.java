package proj_Ro;

public class Attaque {
/*
	public Attaque ( Monstre monmon, Heros charles) {
		int X_mon= monmon.getPositionX();
		int Y_mon= monmon.getPositionY();

		int X_hero= charles.getPositionX();
		int Y_hero= charles.getPositionY();}
*/
	public int contact (int X_mon,int Y_mon,int X_hero, int Y_hero) {
		int p =0;
		if (X_mon == X_hero) {
			if (Y_mon == Y_hero) {
				p = 1;
			}
		}
		return(p);
	}
	public int perte_de_pv(int X_mon,int Y_mon,int X_hero, int Y_hero) {
		int pv=150;
		int touche = contact(X_mon, Y_mon, X_hero, Y_hero);
		if (touche==1) {
			pv=pv-10;
		}
		return(pv);
		}
	}
}
