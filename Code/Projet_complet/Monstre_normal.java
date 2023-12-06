package projet_totally_spies;
import java.util.Arrays;
import java.util.Random;

public class Monstre_normal extends Monstre{
	public Monstre_normal(int nb_PV ,int positionX,int positionY,int matricule) {
		super(nb_PV ,positionX,positionY,matricule);
	}
	

	@Override
	public String toString() {
		return "Monstre_normal [matricule=" + matricule + ", nb_PV=" + nb_PV + ", positionX=" + positionX + ", positionY=" + positionY + "]";
	}


	public void deplacement_random() {
		while ( this.nb_PV!=0 ) { // 
			Random r = new Random();
			int direction = r.nextInt(4);
			if (direction==0) { //haut
				if (this.tableau[this.positionX][this.positionY-1]!=1 && this.positionX>0 && this.positionX<16 && this.positionY >0 && this.positionY<16) {
					this.move_up();
				}
			}
			if (direction==1) { //bas
				if (this.tableau[this.positionX][this.positionY+1]!=1 && this.positionX>0 && this.positionX<16 && this.positionY >0 && this.positionY<16) {
					this.move_down();
				}
			}
			if (direction==2) { //gauche
				if (this.tableau[this.positionX-1][this.positionY]!=1 && this.positionX>0 && this.positionX<16 && this.positionY >0 && this.positionY<16 ) {
					this.move_left();
				}
			}
			if (direction==3) { //droite
				if (this.tableau[this.positionX+1][this.positionY]!=1 && this.positionX>0 && this.positionX<16 && this.positionY >0 && this.positionY<16) {
					this.move_right();
				}
			}
		}

	}
}

