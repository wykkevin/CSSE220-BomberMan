import java.awt.Point;

/**
 * This is a kind of power up that will increase the life of hero by 1.
 */

public class ExtraLife extends Powerup {

	public ExtraLife(Point position, GameComponent gameComponent) {
		super(position, gameComponent);
	}

	@Override
	public void newPower(Hero hero) {
		hero.setLife(hero.getLife() + 1);
	}

	@Override
	public String getName() {
		return ("Extra Life");
	}
}
