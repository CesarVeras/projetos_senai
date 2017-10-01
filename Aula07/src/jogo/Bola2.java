package jogo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

import br.senai.sc.engine.Utils;

public class Bola2 {
	private int posX;
	private int posY;
	private int velX;
	private int velY;
	private int width;
	private int height;

	public Bola2(int velX, int velY) {
		this.width = 20;
		this.height = 20;
		this.velX = velX;
		this.velY = velY;
		this.posX = Utils.getInstance().getWidth() / 2 - width / 2;
		this.posY = Utils.getInstance().getHeight() / 2 - height / 2;
		definirInicio();
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

	public int getVelX() {
		return velX;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public int getVelY() {
		return velY;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void draw(Graphics2D g) {
		g.setColor(Color.GREEN);
		g.fillOval(posX, posY, width, height);
	}

	public void update() {
		setPosY(posY + velY);
		setPosX(posX + velX);
	}
	
	public void definirInicio() {
		Random r = new Random();
		switch(r.nextInt(4)) {
		case 0:
			break;
		case 1:
			velX *= -1;
			break;
		case 2:
			velY *= -1;
			break;
		case 3: 
			velX *= -1;
			velY *= -1;
			break;
		}
	}

	public void colisao(Jogador p1, Jogador p2) {
		if (posX == 0) {
			p2.setPontos(p2.getPontos()+1);
			setPosX(Utils.getInstance().getWidth()/2 - width/2);
			setPosY(Utils.getInstance().getHeight()/2 - height/2);
			definirInicio();
		}
		if (posX + width == Utils.getInstance().getWidth()) {
			p1.setPontos(p1.getPontos()+1);
			setPosX(Utils.getInstance().getWidth()/2 - width/2);
			setPosY(Utils.getInstance().getHeight()/2 - height/2);
			definirInicio();
		}
		if (posY == 0 || posY + height == Utils.getInstance().getHeight()) {
			velY *= -1;
		}
	}

	public void colisaoDificil(Barra barra) {
		if (barra.getPosicaoX() < Utils.getInstance().getWidth() / 2) {
			// esquerda
			if ((velX < 0 && posX <= barra.getPosicaoX() + barra.getLargura())
					&& (posY + height >= barra.getPosicaoY() && posY <= barra
							.getPosicaoY() + barra.getAltura())) {
				velX *= -1;
			}
		} else {
			// direita
			if ((velX > 0 && posX + width >= barra.getPosicaoX())
					&& (posY + height >= barra.getPosicaoY() && posY <= barra
							.getPosicaoY() + barra.getAltura())) {
				velX *= -1;
			}
		}
	}

	public void colisao(Barra barra) {
		Rectangle barraRetangulo = new Rectangle(barra.getPosicaoX(),
				barra.getPosicaoY(), barra.getLargura(), barra.getAltura());
		Rectangle bolaRetangulo = new Rectangle(posX, posY, width, height);
		if (barra.getPosicaoX() < Utils.getInstance().getWidth() / 2) {
			if (velX < 0 && barraRetangulo.intersects(bolaRetangulo)) {
				velX *= -1;
			}			
		} else {
			if (velX > 0 && barraRetangulo.intersects(bolaRetangulo)) {
				velX *= -1;
			}
		}
		
	}
}
