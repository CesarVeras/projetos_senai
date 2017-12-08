package jogo;

import java.awt.Graphics2D;
import java.awt.Image;

import br.senai.sc.engine.Utils;

public class TelaEstatica {
	private Image background;
	private Image header;
	private boolean visivel;
	private Botao[] botoes;
	private int widthHeader;
	private int heightHeader;

	public TelaEstatica(Image background, Image header, Botao[] botoes, boolean visivel) {
		this.background = background;
		this.header = header;
		this.botoes = botoes;
		this.visivel = visivel;
		this.widthHeader = 600;
		this.heightHeader = 150;
	}

	public void draw(Graphics2D g) {
		g.drawImage(background, 0, -400, Utils.getInstance().getWidth() + 400, Utils.getInstance().getWidth(), null);
		if (header != null) {
			g.drawImage(header, Utils.getInstance().getWidth()/2 - widthHeader/2, 30, widthHeader, heightHeader, null);
		}
		if (botoes != null) {
			for (Botao b : botoes) {
				b.draw(g);
			}
		}
	}

	public Image getBackground() {
		return background;
	}

	public void setBackground(Image background) {
		this.background = background;
	}

	public Image getHeader() {
		return header;
	}

	public void setHeader(Image header) {
		this.header = header;
	}

	public boolean isVisivel() {
		return visivel;
	}

	public void setVisivel(boolean visivel) {
		this.visivel = visivel;
	}

	public Botao[] getBotoes() {
		return botoes;
	}

	public void setBotoes(Botao[] botoes) {
		this.botoes = botoes;
	}
	
	public Botao getBotao(int posicao) {
		Botao b = null;
		if (botoes != null) {
			b = botoes[posicao];
		}
		return b;
	}
}
