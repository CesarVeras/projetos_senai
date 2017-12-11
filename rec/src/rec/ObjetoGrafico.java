package rec;

import java.awt.Graphics2D;

public abstract class ObjetoGrafico {
	int x;
	int y;
	int velocidadex;
	int velocidadey;
	int largura;
	int altura;
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	
	public int getVelocidadex() {
		return velocidadex;
	}
	public void setVelocidadex(int velocidadex) {
		this.velocidadex = velocidadex;
	}
	public int getVelocidadey() {
		return velocidadey;
	}
	public void setVelocidadey(int velocidadey) {
		this.velocidadey = velocidadey;
	}
	
	

	public int getLargura() {
		return largura;
	}
	public void setLargura(int largura) {
		this.largura = largura;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public ObjetoGrafico(int x, int y, int velocidadex, int velocidadey, int largura, int altura) {
		this.x = x;
		this.y = y;
		this.velocidadex = velocidadex;
		this.velocidadey = velocidadey;
		this.largura = largura;
		this.altura = altura;
	}
	public abstract void update();
	
	
	public abstract void draw(Graphics2D g);

}
