package proj_Ro;

public class Special {

		int X_pic;
		int Y_pic;
		
		int X_trou;
		int Y_trou;

		int X_hero;
		int Y_hero;
		
		int X_potion;
		int Y_potion;


		public Special ( Personnage charles,Objet_spe potion,Objet_spe trou,Objet_spe pic) {

			this.X_hero= charles.getPositionX();
			this.Y_hero= charles.getPositionY();
			
			this.X_potion= potion.getPositionX();
			this.Y_potion= potion.getPositionY();
			
			this.X_trou= trou.getPositionX();
			this.Y_trou= trou.getPositionY();
			
			this.X_pic= pic.getPositionX();
			this.Y_pic= pic.getPositionY();

		}
		public void Potion(Personnage charles,Objet_spe popo) {
			if (this.X_potion == this.X_hero) {
				if (this.Y_potion == this.Y_hero) {
					int pv_hero=charles.getNb_PV();
					charles.setNb_PV(pv_hero+50);
					popo.setPlein(0);
				}
			}
		}
		public void Pic(Personnage charles,Objet_spe pic) {
			if (this.X_pic == this.X_hero) {
				if (this.Y_pic == this.Y_hero) {
					int pv_hero=charles.getNb_PV();
					charles.setNb_PV(pv_hero-100);
					pic.setPlein(0);
				}
			}
		}
		public void Trou(Personnage charles,Objet_spe trou) {
			if (this.X_trou == this.X_hero) {
				if (this.Y_trou == this.Y_hero) {
					charles.setNb_PV(0);
					trou.setPlein(0);
				}
			}
		}
}
