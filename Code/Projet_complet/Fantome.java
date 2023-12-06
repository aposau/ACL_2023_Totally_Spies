package projet_totally_spies;

import java.util.Random;

public class Fantome extends Monstre {
	public Fantome(int nb_PV ,int positionX,int positionY, int matricule) {
		super(nb_PV ,positionX,positionY, matricule);
	}
	public void deplacement_random_mur() {
		while ( this.nb_PV!=0 ) { // 
			Random r = new Random();
			int direction = r.nextInt(4);
			if (direction==0) { //haut
				if (this.positionX>0 && this.positionX<16 && this.positionY >0 && this.positionY<16 ) {
					this.move_up();
				}
			}
			if (direction==1) { //bas
				if (this.positionX>0 && this.positionX<16 && this.positionY >0 && this.positionY<16) {
					this.move_down();
				}
			}
			if (direction==2) { //gauche
				if (this.positionX>0 && this.positionX<16 && this.positionY >0 && this.positionY<16) {
					this.move_left();
				}
			}
			if (direction==3) { //droite
				if (this.positionX>0 && this.positionX<16 && this.positionY >0 && this.positionY<16) {
					this.move_right();
				}
			}
		}

	}
}
