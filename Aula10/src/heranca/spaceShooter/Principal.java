package heranca.spaceShooter;

import java.awt.event.KeyAdapter;

import br.senai.sc.engine.Game;

public class Principal extends Game{

	private static final long serialVersionUID = 1L;

	public Principal() {
		addKeyListener(new KeyInputHandler());
	}
	
	public static void main(String[] args) {
		Principal p = new Principal();
		p.startGame();
	}
	
	@Override
	public void init() {
		
	}
	
	@Override
	public void gameLoop() {
		
	}
	
	@Override
	public void aposTermino() {
		
	}
	
	public class KeyInputHandler extends KeyAdapter {
		
	}
}
