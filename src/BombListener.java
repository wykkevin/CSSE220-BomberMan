import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * Class to control the bomb.
 */
public class BombListener implements KeyListener {

	private Hero hero;
	private GameComponent component;
	private GameMap map;
	private ArrayList<Monster> monsterList = new ArrayList<Monster>();

	public BombListener(Hero hero, GameComponent gameComponent, GameMap map, ArrayList<Monster> monsterList) {
		this.hero = hero;
		this.component = gameComponent;
		this.map = map;
		this.monsterList = monsterList;
	}

	/*
	 * Can only drop a bomb when there is no bomb in the position and the hero
	 * has bomb to drop.
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_SPACE && this.component.getPaused() == false) {
			if (this.component.getMap().getGameMap()[(this.hero.getPosition().x + 25)
					/ 50][(this.hero.getPosition().y + 25) / 50] != 3) {
				if (this.hero.dropBomb()) {
					this.component.addBomb();
				}
			}
		}
		if (key == KeyEvent.VK_E && this.component.getPaused() == false && this.hero.getBombUpgrade() == true) {
			for (Bomb bomb : this.component.getBombList()) {
				bomb.explode();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// No move.
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// No move.
	}

}
