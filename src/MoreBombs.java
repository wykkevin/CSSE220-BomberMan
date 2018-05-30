import java.awt.Point;

/**
 * This is a kind of power up that will increase the remain bombs of hero by 1.
 */

public class MoreBombs extends Powerup {

	public MoreBombs(Point position, GameComponent gameComponent) {
		super(position, gameComponent);
	}

	@Override
	public void newPower(Hero hero) {
		// Maximum bomb is 5.
		if ((hero.getRemainBombs() + this.getGameComponent().getBombList().size()) < 5) {
			hero.setRemainBombs(hero.getRemainBombs() + 1);

		}
	}

	@Override
	public String getName() {
		return ("More Bombs");
	}
}
