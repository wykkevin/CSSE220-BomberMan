import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Class used to switch levels.
 */
public class MapListener implements KeyListener {
	private GameComponent component;

	public MapListener(GameComponent component) {
		this.component = component;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_U) {
			this.component.mapChange("up");
			this.component.repaint();
		}
		if (key == KeyEvent.VK_D) {
			this.component.mapChange("down");
			this.component.repaint();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// no move
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// no move
	}

}
