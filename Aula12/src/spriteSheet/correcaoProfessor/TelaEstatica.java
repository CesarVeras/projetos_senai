package spriteSheet.correcaoProfessor;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import br.senai.sc.engine.Utils;

public class TelaEstatica {
	private String titulo;
	private int tamanhoTitulo;
	private Color corFundo;
	private Botao[] botoes;

	public TelaEstatica(String titulo, int tamanhoTitulo, Color corFundo, Botao[] botoes) {
		super();
		this.titulo = titulo;
		this.tamanhoTitulo = tamanhoTitulo;
		this.corFundo = corFundo;
		this.botoes = botoes;
	}

	public void draw(Graphics2D g) {
		g.setColor(corFundo);
		g.fillRect(0, 0, Utils.getInstance().getWidth(), Utils.getInstance()
				.getHeight());
		g.setColor(Color.BLACK);
		g.setFont(new Font("Arial", Font.BOLD, tamanhoTitulo));
		g.drawString(titulo, Utils.getInstance().getWidth() / 2 - Utils.getInstance().getWidth()/9 , Utils
				.getInstance().getHeight() / 2 - 300);
		for (int i = 0; i < botoes.length; i++) {
			botoes[i].draw(g);
		}
	}

	public Botao getBotao(int posicao) {
		return botoes[posicao];
	}
}
