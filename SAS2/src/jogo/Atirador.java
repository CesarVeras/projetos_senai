package jogo;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JOptionPane;

import br.senai.sc.engine.Utils;

public class Atirador extends Inimigo {
	private boolean explodindo;
	private int contadorExplosao;
	private int contadorAbaixar;
//	private boolean baixarArma;
	private int viradoPara;
	private Personagem trump;

	public Atirador(Personagem personagem) {
		super(Utils.getInstance().getWidth() / 2 + 100, 705, 75, 90, 5, 2,
				Utils.getInstance().loadImage("imagens/Explosivo.png"), 2,
				3, 2);
		this.trump = personagem;
	}

	@Override
	public void update() {
		if (!trump.isColidindoComCaixa()
				|| (!trump.isIndoPraDireita() && !trump.isIndoPraEsquerda())) {
			if (getPosX() > trump.getPosX() + trump.getWidth()) {
				setMoving(-1);
				setFrameY(viradoPara);
				setFrameX(getFrameX() + 1);
				if (getFrameX() >= 2) {
					setFrameX(0);
				}
				setPosX(getPosX() - getVelX());
			} else if (getPosX() + getWidth() < trump.getPosX()) {
				setMoving(1);
				setFrameY(viradoPara);
				setFrameX(getFrameX() + 1);
				if (getFrameX() >= 2) {
					setFrameX(0);
				}
				setPosX(getPosX() + getVelX());
			} else if (colidindoComTrump()) {
				explodir();
			} else if (!colidindoComTrump() && explodindo) {
				explodindo = false;
				contadorExplosao = 0;
				setFrameY(viradoPara);
				setFrameX(0);
			}
		} else {
			if (viradoPara == 0) {
				setFrameY(viradoPara);
				setFrameX(getFrameX() + 1);
			}
			if (getFrameX() == getColunas()) {
				setFrameX(0);
			}
		}

		if (getFrameX() == getColunas()) {
			setFrameX(0);
		}
		// if (atirando) {
		// atirar();
		// }
		// if (baixarArma) {
		// baixarArma();
		// }
	}

	public boolean colidindoComTrump() {
		return getPosX() < trump.getPosX() + trump.getWidth() 
		|| getPosX() + getWidth() > trump.getPosX()
		&& getPosY() + 40 >= trump.getPosY();
	}

	public void explodir() {
		if (!explodindo) {
//			if (viradoPara == -1) {
//				// definindo animação 1/2 de atirar para esquerda
//				setFrameY(2);
//				setFrameX(0);
//			} else {
//				// definindo animação 1/2 de atirar para direita
//				setFrameY(1);
//				setFrameX(0);
//			}
			explodindo = true;
			contadorExplosao = 0;
		} else if (contadorExplosao == 51) {
			if (viradoPara == 0) {
				setPosX(getPosX() + 50);
			} else {
				setPosX(getPosX() - 50);
			}
			trump.reset();
			explodindo = false;
//			if (viradoPara == -1) {
//				// definindo animação 2/2 de atirar para esquerda
//				setFrameY(2);
//				setFrameX(1);
//			} else {
//				// definindo animação 2/2 de atirar para direita
//				setFrameY(1);
//				setFrameX(1);
//			}
//			explodindo = false;
//			contadorAtirar = 0;
			contadorExplosao = 0;
//			baixarArma = true;
		} else {
			contadorExplosao++;
			switch (contadorExplosao) {
			case 12:
				setFrameX(3);
				setFrameY(viradoPara);					
				break;
			case 24:
				setFrameX(getFrameX() + 1);
				break;
			case 36:
				setFrameX(getFrameX() + 1);
				break;
			case 48:
				setFrameX(getFrameX() + 1);
				break;
			case 50:
				setFrameX(getFrameX() + 1);
				break;
			}
		}
	}
	
	@Override
	public void draw(Graphics2D g) {
		g.drawImage(getSprite(), getPosX(), getPosY(), getPosX() + getWidth(),
				getPosY() + getHeight(), getFrameX() * 64,
				getFrameY() * 64, getFrameX() * 64 + 64,
				getFrameY() * 64 + 64, null);
	}

	private void baixarArma() {
		contadorAbaixar++;
		if (contadorAbaixar == 30) {
			setFrameY(viradoPara);
			setFrameX(0);
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
		// if (getMoving() != moving) {
		// if (this.getMoving() == 1) {
		// setFrameX(0);
		// } else {
		// setFrameX(1);
		// }
		// super.setMoving(moving);
		// setFrameY(moving);
		// }
	}
}
