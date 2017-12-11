package jogo;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JOptionPane;

import br.senai.sc.engine.Utils;

public class Chefe extends Inimigo {
	private boolean atacando;
	private int contadorAtaque;
	private int viradoPara;
	private Personagem trump;
	private int contadorSprite;
	private boolean morreu;

	public Chefe(Personagem personagem) {
		super(Utils.getInstance().getWidth(), (int) (Utils.getInstance().getHeight() * 0.85) - 110, 152, 152, 5, 2,
				Utils.getInstance().loadImage("imagens/kim.png"), 2, 7, 500);
		this.trump = personagem;
		contadorSprite = 0;
	}

	public boolean colidindoComTrump() {
		return getRectangle().intersects(trump.getRectangle());
	}

	@Override
	public void draw(Graphics2D g) {
		g.drawImage(getSprite(), getPosX(), getPosY(), getPosX() + getWidth(), getPosY() + getHeight(),
				getFrameX() * 96, getFrameY() * 96, getFrameX() * 96 + 96, getFrameY() * 96 + 96, null);
	}

	public void atacar() {
		if (!colidindoComTrump()) {
			contadorAtaque = 0;
			atacando = false;
			setFrameY(viradoPara);
			setFrameX(0);
			return;
		}

		if (!atacando) {
			atacando = true;
			contadorAtaque = 0;
		} else if (contadorAtaque == 25) {
			if (viradoPara == 0) {
				setPosX(getPosX() + 50);
			} else {
				setPosX(getPosX() - 50);
			}
			trump.reset();
			atacando = false;
			contadorAtaque = 0;
		} else {
			contadorAtaque++;
			switch (contadorAtaque) {
			case 6:
				setFrameX(1);
				setFrameY(viradoPara);
				break;
			case 12:
				setFrameX(6);
				setFrameY(viradoPara);
				setPosY(getPosY() - 20);
				break;
			case 18:
				setFrameX(6);
				setFrameY(viradoPara);
				setPosY(getPosY() - 10);
				break;
			case 24:
				setFrameX(0);
				setFrameY(viradoPara);
				setPosY(getPosY() + 30);
				break;
			}
		}
	}

	private void passarSprite() {
		if (contadorSprite == 3) {
			contadorSprite = 0;
			setFrameY(viradoPara);
			setFrameX(getFrameX() - 1);
			if (getFrameX() < 2) {
				setFrameX(4);
			}
		} else {
			contadorSprite++;
		}
	}

	@Override
	public void setMoving(int moving) {
		if (moving != getMoving()) {
			if (moving == 0) {
				setFrameX(0);
				if (getMoving() == 1) {
					viradoPara = 1;
					setFrameY(1);
				} else {
					viradoPara = 0;
					setFrameY(0);
				}
			} else if (moving == 1) {
				viradoPara = 1;
				setFrameY(viradoPara);
			} else {
				viradoPara = 0;
				setFrameY(viradoPara);
			}
			super.setMoving(moving);
		}
	}

	@Override
	public void update() {
		
		if (colidindoComTrump() && trump.isDandoSoco()) {
			this.setVidas(getVidas() - 1);  
			if (getVidas() <= 0) {
				morreu = true;
			}
		}
		
		// Caso trump não esteja parado mas pareça estar em movimento
		if (!trump.isColidindoComCaixa() || (!trump.isIndoPraDireita() && !trump.isIndoPraEsquerda())) {
			// Se o explosivo estiver mais a direita que o ponto direito do
			// Trump
			if (getPosX() > trump.getPosX() + trump.getWidth()) {
				setMoving(-1);
				passarSprite();
				setPosX(getPosX() - getVelX());
			} else if (getPosX() + getWidth() < trump.getPosX() + 25) {
				// Se o explosivo estiver mais a esquerda que o ponto esquerdo
				// Trump
				setMoving(1);
				passarSprite();
				setPosX(getPosX() + getVelX());
			} else if (colidindoComTrump()) {
				// Se o explosivo colidir com Trump
				atacar();
			}
		} else {
			passarSprite();
			if (getFrameX() == getColunas()) {
				setFrameX(0);
			}
		}
		if (!colidindoComTrump() && atacando) {
			contadorAtaque = 0;
			atacando = false;
			setFrameY(viradoPara);
			setFrameX(0);
			setPosY((int) (Utils.getInstance().getHeight() * 0.85) - 110);
		}
	}

	public boolean isExplodindo() {
		return atacando;
	}

	public void setExplodindo(boolean explodindo) {
		this.atacando = explodindo;
	}

	public int getContadorExplosao() {
		return contadorAtaque;
	}

	public void setContadorExplosao(int contadorExplosao) {
		this.contadorAtaque = contadorExplosao;
	}

	public boolean isMorreu() {
		return morreu;
	}

	public void setMorreu(boolean morreu) {
		this.morreu = morreu;
	}
}
