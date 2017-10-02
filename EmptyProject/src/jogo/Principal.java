package jogo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import br.senai.sc.engine.Game;
import br.senai.sc.engine.Utils;

public class Principal extends Game{
	// variáveis pré-geradas:
	private boolean menu;
	private boolean jogo;
	private boolean opcoes;
	private String mensagem;
	
	// variáveis pós-geradas:
	
	public Principal() {
		addMouseMotionListener(new MouseMotionHandler());
		addMouseListener(new MouseInputHandler());
		addKeyListener(new KeyInputHandler());
	}
	
	public static void main(String[] args) {
		Principal p = new Principal();
		p.startGame();
	}
	
	public void init() {
		// inicialização das variáveis pré-geradas:
		menu = false;
		jogo = true;
		opcoes = false;
		mensagem = "";
		
		// inicialização das variáveis pós-geradas:
	}

	public void gameLoop() {
		if (menu && !jogo && !opcoes) {
			
		} else if (!menu && jogo && !opcoes) {
			
			desenharString(mensagem, 60, 60, Color.RED, 60);
		} else {
			
		}
		
	}

	public void aposTermino() {
		
	}
	
	public class MouseMotionHandler extends MouseMotionAdapter {
		public void mouseMoved(MouseEvent e) {
			mensagem = "Mouse em movimento";
		}
	}
	
	public class MouseInputHandler extends MouseAdapter {
		
		@Override
		public void mousePressed(MouseEvent e) {
			if (e.getButton() == e.BUTTON1) {
				mensagem = "Mouse BEsquerdo sendo clicado"; 
			} else if (e.getButton() == e.BUTTON2) {
				mensagem = "Mouse Wheel sendo clicado"; 
			} else {
				mensagem = "Mouse BDireito sendo clicado"; 
			}
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
			mensagem = "Mouse parado";
		}
//		
//		public void mouseClicked(MouseEvent e) {
//			if (e.getButton() == e.BUTTON1) {
//				mensagem = "Mouse BEsquerdo sendo clicado"; 
//			} else if (e.getButton() == e.BUTTON2) {
//				mensagem = "Mouse Wheel sendo clicado"; 
//			} else {
//				mensagem = "Mouse BDireito sendo clicado"; 
//			}
// 		}
		
		public void mouseDragged(MouseEvent e) {
			mensagem = "Mouse sendo arrastado";
		}
	}
	
	public class KeyInputHandler extends KeyAdapter {
		
	}
}
