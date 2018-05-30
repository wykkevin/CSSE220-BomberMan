import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Class for the control of the hero.
 */
public class MoveListener implements KeyListener {

	private Hero hero;
	private GameComponent component;

	public MoveListener(Hero hero, GameComponent gameComponent) {
		this.hero = hero;
		this.component = gameComponent;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (this.component.getPaused() == false) {
			if (this.hero.getPosition().y > 0 && key == KeyEvent.VK_UP) {

				int checkCol = this.hero.getPosition().y / 50 - 1;
				if (checkCol < 0) {
					checkCol = 0;
				}

				boolean movable = this.hero.movable("up");
				Point upPoint;
				if (this.hero.getPosition().y % 50 <= this.hero.getSpeed() && !movable) {

					{
						upPoint = new Point(this.hero.getPosition().x, (checkCol + 1) * 50);
					}
				} else {

					upPoint = new Point(this.hero.getPosition().x, this.hero.getPosition().y - this.hero.getSpeed());
				}

				this.hero.setPosition(upPoint);

			}

			else if (this.hero.getPosition().y < 650 && key == KeyEvent.VK_DOWN) {

				int checkCol = this.hero.getPosition().y / 50 + 2;
				if (this.hero.getPosition().y % 50 == 0) {
					checkCol--;
				}
				if (checkCol > 13) {
					checkCol = 13;
				}

				boolean movable = this.hero.movable("down");
				Point downPoint;
				if (((checkCol - 1) * 50 - this.hero.getPosition().y) <= this.hero.getSpeed() && !movable) {
					downPoint = new Point(this.hero.getPosition().x, (checkCol - 1) * 50);
				} else {
					downPoint = new Point(this.hero.getPosition().x, this.hero.getPosition().y + this.hero.getSpeed());
				}
				this.hero.setPosition(downPoint);

			}

			else if (this.hero.getPosition().x > 0 && key == KeyEvent.VK_LEFT) {
				int checkRow = this.hero.getPosition().x / 50 - 1;

				if (checkRow < 0) {
					checkRow = 0;
				}

				boolean movable = this.hero.movable("left");
				Point leftPoint;
				if (this.hero.getPosition().x % 50 <= this.hero.getSpeed() && !movable) {

					{
						leftPoint = new Point((checkRow + 1) * 50, this.hero.getPosition().y);
					}
				} else {
					leftPoint = new Point(this.hero.getPosition().x - this.hero.getSpeed(), this.hero.getPosition().y);
				}
				this.hero.setPosition(leftPoint);

			}

			else if (this.hero.getPosition().x < 650 && key == KeyEvent.VK_RIGHT) {
				int checkRow = this.hero.getPosition().x / 50 + 2;

				if (this.hero.getPosition().x % 50 == 0) {
					checkRow--;
				}
				if (checkRow > 13) {
					checkRow = 13;
				}

				boolean movable = this.hero.movable("right");
				Point rightPoint;
				if (((checkRow - 1) * 50 - this.hero.getPosition().x) <= this.hero.getSpeed() && !movable) {
					rightPoint = new Point((checkRow - 1) * 50, this.hero.getPosition().y);
				} else {
					rightPoint = new Point(this.hero.getPosition().x + this.hero.getSpeed(), this.hero.getPosition().y);
				}
				this.hero.setPosition(rightPoint);

			}
			// System.out.println(this.hero.getPosition());
			this.component.repaint();
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// No move
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// No move
	}

}
