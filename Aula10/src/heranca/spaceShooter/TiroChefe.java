package heranca.spaceShooter;

public class TiroChefe extends Disparo{

	public TiroChefe() {
		super();
	}

	public TiroChefe(int posX, int posY) {
		super(posX - 3, posY, 6, 12, 8);
	}
	
	public void update() {
		super.update(false);
	}
}
