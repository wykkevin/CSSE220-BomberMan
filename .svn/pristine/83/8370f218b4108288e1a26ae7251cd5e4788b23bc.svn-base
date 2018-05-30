import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;

public class GameListener implements KeyListener, ActionListener {
	private GameComponent component;
	private JFrame frame;
	private GamePanel panel;

	public GameListener(GameComponent myGame, JFrame frame, GamePanel panel) {
		this.component = myGame;
		this.frame = frame;
		this.panel = panel;
	}

	public void pause() {
		if (this.component.getPaused() == true) {
			this.component.setPaused(false);
			this.frame.requestFocus();
			System.out.println("continue game");
		} else {
			this.component.setPaused(true);
			this.frame.requestFocus();
			System.out.println("The game now is paused.");
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_P) {
			pause();
		}
		if (key == KeyEvent.VK_K) {
			this.component.setMonsterList(new ArrayList<Monster>());
			System.out.println("You throw a nuclear bomb to the monsters.");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// No move
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// No move
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		pause();

	}

}
