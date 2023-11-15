package projet_totally_spies;
import java.util.Random;

public class Monstre_normal extends Monstre{
	public Monstre_normal(int nb_PV ,int positionX,int positionY,int ant_positionX,int ant_positionY,int matricule) {
		super(nb_PV ,positionX,positionY,ant_positionX, ant_positionY, matricule);
	}
	public void deplacement_random() {
		this.ant_positionX = this.positionX ;
		this.ant_positionY = this.positionY ;
		while ( this.nb_PV!=0 ) { // 
			Random r = new Random();
			int direction = r.nextInt(4);
			if (direction==0) { //haut
				if (this.tableau[this.positionX][this.positionY-1]!=1) {
					this.move_up();
				}
			}
			if (direction==1) { //bas
				if (this.tableau[this.positionX][this.positionY+1]!=1) {
					this.move_down();
				}
			}
			if (direction==2) { //gauche
				if (this.tableau[this.positionX-1][this.positionY]!=1) {
					this.move_left();
				}
			}
			if (direction==3) { //droite
				if (this.tableau[this.positionX+1][this.positionY]!=1) {
					this.move_right();
				}
			}
		}

	}
}
