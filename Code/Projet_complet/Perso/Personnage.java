package projet_totally_spies;

public class Personnage {
	int nb_PV;
	int positionX;
	int ant_positionX;
	int positionY;
	int ant_positionY;
	int[][] tableau;
	public Personnage(int nb_PV ,int positionX,int positionY,int ant_positionX,int ant_positionY) {
		this.positionX=positionX;
		this.positionY=positionY;
		this.ant_positionX=ant_positionX;
		this.ant_positionY=ant_positionY;
		this.nb_PV=nb_PV;
		this.tableau=new Labyrinthe(1).lireFichier();
		
	}
	public int getNb_PV() {
		return nb_PV;
	}
	public void setNb_PV(int nb_PV) {
		this.nb_PV = nb_PV;
	}
	public int getPositionX() {
		return positionX;
	}
	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}
	public int getPositionY() {
		return positionY;
	}
	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
	
	
	public int getAnt_positionX() {
		return ant_positionX;
	}
	public void setAnt_positionX(int ant_positionX) {
		this.ant_positionX = ant_positionX;
	}
	public int getAnt_positionY() {
		return ant_positionY;
	}
	public void setAnt_positionY(int ant_positionY) {
		this.ant_positionY = ant_positionY;
	}
	public void move_up() {
		
		int a=this.getPositionY();
		
		a-=1;
		this.tableau[this.getAnt_positionX()][this.getAnt_positionY()]=0
		this.setPositionY(a);
	}
	
	public void move_down() {
		int a=this.getPositionY();
		a+=1;
		this.setPositionY(a);
	}
	
	public void move_left() {
		int a=this.getPositionX();
		a-=1;
		this.setPositionX(a);
	}
	
	public void move_right() {
		int a=this.getPositionX();
		a+=1;
		this.setPositionX(a);
	}
}
