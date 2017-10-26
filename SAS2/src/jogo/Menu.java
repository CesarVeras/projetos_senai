package jogo;

import java.awt.Graphics2D;
import java.awt.Image;

public class Menu extends TelaEstatica {

	public Menu(Image background, Image header, Botao[] botoes, boolean visivel) {
		super(background, header, botoes, visivel);
	}

	@Override
	public void draw(Graphics2D g) {
		//TODO alterar para definir o padrão de desenho da tela, baseado na ideia de menu do André White.
	}
}
