package proj_Ro;

public class Objet_spe {

		int plein;
		int positionX;
		int positionY;
		public Objet_spe(int plein,int positionX,int positionY) {
			this.positionX=positionX;
			this.positionY=positionY;
			this.plein=plein;
		}
		public int getPlein() {
			return plein;
		}
		public void setPlein(int plein) {
			this.plein = plein;
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
	    public String toString() {
	        return "Objet spe [plein=" + plein + ", position X=" + positionX + ", Position Y=" + positionY + "]";
	    }
}
