package rec;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

import br.senai.sc.engine.Utils;

public abstract class Coletavel extends ObjetoGrafico{

	protected boolean saiu;
	
	public Coletavel() {
		super(0, -25, 0, 15, 25, 25);
		gerarPosicaoX();
	}

	private void gerarPosicaoX() {
		Random sorteio = new Random();
		posX = sorteio.nextInt(Utils.getInstance().getWidth());
	}
	
	public boolean foiColetado(Jogador j) {
		if (new Rectangle(posX, posY, largura, altura).intersects(new Rectangle(j.posX, j.posY, j.largura, j.altura))) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void update() {
		if (posY < Utils.getInstance().getHeight()) {
			posY = posY + velocidadeY;
		} else {
			saiu = true;
		}
	}	
}
