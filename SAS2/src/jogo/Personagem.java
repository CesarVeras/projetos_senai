package jogo;

import java.awt.Graphics2D;
import java.awt.Image;

import br.senai.sc.engine.Utils;

public class Personagem extends ObjetoGraficoMovelaAnimado{
	private int vidas;
	private boolean gravidade;
	private int movendo; 
	private boolean pulando;
	
	public Personagem() {
		super(Utils.getInstance().getWidth()/2, 600, 119, 112, Utils.getInstance().loadImage("imagens/sonic.png"), 10, 0, 0, 0, 8, 3);
	}

	@Override
	public void update() {
		if (movendo != 0) {
			setFrameX(getFrameX() + 1);
			if (getFrameX() > getColunas()) {
				setFrameX(0);
			}
		}
		if (movendo == 1) {
			if (!isColidindoComCaixaDireita()) {
				setPosX(getPosX() + getVelX()); 
			}
		} else if (movendo == -1) {
			if (!isColidindoComCaixaEsquerda()) {
				setPosX(getPosX() + getVelX());
			}
		}
	}
	
	public boolean isColidindoComCaixaDireita() {
		return (getPosX() + getWidth() >= 3 * (Utils.getInstance().getWidth() / 4));
	}
	public boolean isColidindoComCaixaEsquerda() {
		return (getPosX() <= Utils.getInstance().getWidth() / 4);
	}
	
	public boolean isColidindoComCaixa() {
		return (getPosX() + getWidth() >= 3 * (Utils.getInstance().getWidth() /4)) || (getPosX() <= Utils.getInstance().getWidth()/4);
	}

	public void setMovendo(int movendo) {
		if (movendo != this.movendo) {
			if (movendo == 0) {
				setFrameY(0);
				if (this.movendo == 1) {
					setFrameX(0);
				} else {
					setFrameX(1);
				}
			} else if (movendo == 1) {
				setFrameY(1);
				setVelX(Math.abs(getVelX()));
			} else {
				setFrameY(2);
				setVelX(Math.abs(getVelX())*-1);
			}
			this.movendo = movendo;
		}
	}
	
	public int getMovendo() {
		return movendo;
	}

	public int getVidas() {
		return vidas;
	}

	public void setVidas(int vidas) {
		this.vidas = vidas;
	}

	public boolean isGravidade() {
		return gravidade;
	}

	public void setGravidade(boolean gravidade) {
		this.gravidade = gravidade;
	}

	public boolean isPulando() {
		return pulando;
	}

	public void setPulando(boolean pulando) {
		this.pulando = pulando;
	}
}