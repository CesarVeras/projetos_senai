package jogo;

import java.awt.Color;
import java.awt.Graphics2D;

import br.senai.sc.engine.Utils;

public class Barra {
	private int posicaoX;
	private int posicaoY;
	private int altura;
	private int largura;
	private int velocidadeY;
	private boolean subir;
	private boolean descer;

	public Barra(int posicaoX, int posicaoY, int altura, int largura,
			int velocidadeY) {
		this.posicaoX = posicaoX;
		this.posicaoY = posicaoY;
		this.altura = altura;
		this.largura = largura;
		this.velocidadeY = velocidadeY;
	}

	public int getPosicaoX() {
		return posicaoX;
	}

	public void setPosicaoX(int posicaoX) {
		if (posicaoX >= 0
				&& posicaoX <= Utils.getInstance().getWidth() - largura) {
			this.posicaoX = posicaoX;
		}
	}

	public int getPosicaoY() {
		return posicaoY;
	}

	public void setPosicaoY(int posicaoY) {
		if (posicaoY < 0) {
			this.posicaoY = 0;
		} else if (posicaoY + altura > Utils.getInstance().getHeight()) {
			this.posicaoY = Utils.getInstance().getHeight() - altura;
		} else {
			this.posicaoY = posicaoY;
		}
	}

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

	public int getVelocidadeY() {
		return velocidadeY;
	}

	public void setVelocidadeY(int velocidadeY) {
		this.velocidadeY = velocidadeY;
	}
	
	public boolean isSubir() {
		return subir;
	}

	public void setSubir(boolean subir) {
		this.subir = subir;
	}

	public boolean isDescer() {
		return descer;
	}

	public void setDescer(boolean descer) {
		this.descer = descer;
	}

	public void draw(Graphics2D g) {
		g.setColor(Color.GREEN);
		g.fillRect(posicaoX, posicaoY, largura, altura);
	}
	
	public void update() {
		if (subir) {
			setPosicaoY(posicaoY - velocidadeY);
		}
		if (descer) {
			setPosicaoY(posicaoY + velocidadeY);
		}
	}
}
