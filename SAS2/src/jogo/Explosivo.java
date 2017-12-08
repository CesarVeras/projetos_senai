package jogo;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JOptionPane;

import br.senai.sc.engine.Utils;

public class Explosivo extends Inimigo {
	private boolean explodindo;
	private int contadorExplosao;
	private int viradoPara;
	private Personagem trump;
	private int contadorSprite;

	public Explosivo(Personagem personagem) {
		super(Utils.getInstance().getWidth() / 2 + 100, 678, 100, 120, 5, 2,
				Utils.getInstance().loadImage("imagens/Explosivo.png"), 2, 3, 2);
		this.trump = personagem;
		contadorSprite = 0;
	}

	public boolean colidindoComTrump() {
		return getRectangle().intersects(trump.getRectangle());
	}

	@Override
	public void draw(Graphics2D g) {
		g.drawImage(getSprite(), getPosX(), getPosY(), getPosX() + getWidth(),
				getPosY() + getHeight(), getFrameX() * 64, getFrameY() * 64,
				getFrameX() * 64 + 64, getFrameY() * 64 + 64, null);
	}

	public void explodir() {
		if (!colidindoComTrump()) {
			contadorExplosao = 0;
			explodindo = false;
			setFrameY(viradoPara);
			setFrameX(0);
			return;
		}

		if (!explodindo) {
			explodindo = true;
			contadorExplosao = 0;
		} else if (contadorExplosao == 26) {
			if (viradoPara == 0) {
				setPosX(getPosX() + 50);
			} else {
				setPosX(getPosX() - 50);
			}
			trump.reset();
			explodindo = false;
			contadorExplosao = 0;
		} else {
			contadorExplosao++;
			switch (contadorExplosao) {
			case 6:
				setFrameX(3);
				setFrameY(viradoPara);
				break;
			case 12:
				setFrameX(4);
				setFrameY(viradoPara);
				break;
			case 18:
				setFrameX(5);
				setFrameY(viradoPara);
				break;
			case 24:
				setFrameX(6);
				setFrameY(viradoPara);
				break;
			case 26:
				setFrameX(7);
				setFrameY(viradoPara);
				break;
			}
		}
	}

	private void passarSprite() {
		if (contadorSprite == 5) {
			contadorSprite = 0;
			setFrameY(viradoPara);
			setFrameX(getFrameX() + 1);
			if (getFrameX() > 2) {
				setFrameX(0);
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
					viradoPara = 0;
					setFrameY(0);
				} else {
					viradoPara = 1;
					setFrameY(1);
				}
			} else if (moving == 1) {
				viradoPara = 0;
				setFrameY(viradoPara);
			} else {
				viradoPara = 1;
				setFrameY(viradoPara);
			}
			super.setMoving(moving);
		}
	}

	@Override
	public void update() {
		// Caso trump não esteja parado mas pareça estar em movimento
		if (!trump.isColidindoComCaixa()
				|| (!trump.isIndoPraDireita() && !trump.isIndoPraEsquerda())) {
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
				explodir();
			}
		} else {
			passarSprite();
			if (getFrameX() == getColunas()) {
				setFrameX(0);
			}
		}
		if (!colidindoComTrump() && explodindo) {
			contadorExplosao = 0;
			explodindo = false;
			setFrameY(viradoPara);
			setFrameX(0);
		}
	}

	public boolean isExplodindo() {
		return explodindo;
	}

	public void setExplodindo(boolean explodindo) {
		this.explodindo = explodindo;
	}

	public int getContadorExplosao() {
		return contadorExplosao;
	}

	public void setContadorExplosao(int contadorExplosao) {
		this.contadorExplosao = contadorExplosao;
	}
}
