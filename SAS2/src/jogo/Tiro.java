package jogo;

import java.awt.Graphics2D;

import br.senai.sc.engine.Utils;

public class Tiro extends ObjetoAnimado {

	private boolean praEsquerda;
	private boolean saiuDaTela;
	private Personagem trump;

	public Tiro(int posX, int posY, int velX, boolean praEsquerda, Personagem trump) {
		super(posX, posY, 12, 8, velX, 0, null, 0, 0);
		this.praEsquerda = praEsquerda;
		this.trump = trump;
		saiuDaTela = false;
	}

	@Override
	public void draw(Graphics2D g) {
		// g.setColor(Color.RED);
		// g.fillRect(getPosX(), getPosY(), 10, 10);
		if (praEsquerda) {
			g.drawImage(Utils.getInstance().loadImage("imagens/tiroEsquerda.png"), getPosX(), getPosY(), getWidth(),
					getHeight(), null);
		} else {
			g.drawImage(Utils.getInstance().loadImage("imagens/tiro.png"), getPosX(), getPosY(), getWidth(),
					getHeight(), null);
		}
	}

	@Override
	public void update() {
		if (praEsquerda) {
			setPosX(getPosX() - getVelX());
			if (getPosX() <= 0) {
				saiuDaTela = true;
			}
		} else {
			setPosX(getPosX() + getVelX());
			if (getPosX() >= Utils.getInstance().getWidth()) {
				saiuDaTela = true;
			}
		}
		if (this.getRectangle().intersects(trump.getRectangle())) {
			saiuDaTela = true;
			trump.reset();
		}
	}

	public boolean isPraEsquerda() {
		return praEsquerda;
	}

	public void setPraEsquerda(boolean praEsquerda) {
		this.praEsquerda = praEsquerda;
	}

	public boolean isSaiuDaTela() {
		return saiuDaTela;
	}

	public void setSaiuDaTela(boolean saiuDaTela) {
		this.saiuDaTela = saiuDaTela;
	}
}
