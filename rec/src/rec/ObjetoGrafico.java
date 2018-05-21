package rec;

import java.awt.Graphics2D;

public abstract class ObjetoGrafico {
	protected int altura;
	protected int largura;
	protected int posX;
	protected int posY;
	protected int velocidadeX;
	protected int velocidadeY;

	public ObjetoGrafico(int posX, int posY, int velocidadeX, int velocidadeY, int largura, int altura) {
		this.altura = altura;
		this.largura = largura;
		this.posX = posX;
		this.posY = posY;
		this.velocidadeX = velocidadeX;
		this.velocidadeY = velocidadeY;
	}

	public abstract void update();
	
	public abstract void draw(Graphics2D g);

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getLargura() {
		return largura;
	}

	public void setLargura(int largura) {
		this.largura = largura;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getVelocidadeX() {
		return velocidadeX;
	}

	public void setVelocidadeX(int velocidadeX) {
		this.velocidadeX = velocidadeX;
	}

	public int getVelocidadeY() {
		return velocidadeY;
	}

	public void setVelocidadeY(int velocidadeY) {
		this.velocidadeY = velocidadeY;
	}
}
