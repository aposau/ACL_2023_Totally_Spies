package projet_totally_spies;

public class Personnage {
	int nb_PV;
	int positionX;
	int positionY;
	public Personnage(int nb_PV ,int positionX,int positionY) {
		this.positionX=positionX;
		this.positionY=positionY;
		this.nb_PV=nb_PV;
		
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
	
	public void move_up() {
		int a=this.getPositionY();
		a-=1;
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
