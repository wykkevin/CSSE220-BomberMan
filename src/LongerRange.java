import java.awt.Point;

/**
 * This is a kind of power up that will increase the range of bomb by 1.
 */

public class LongerRange extends Powerup {

	public LongerRange(Point position, GameComponent gameComponent) {
		super(position, gameComponent);
	}

	@Override
	public void newPower(Hero hero) {
		// Maximum range is 6
		if (this.getGameComponent().getRange() < 6) {
			this.getGameComponent().setRange(this.getGameComponent().getRange() + 1);
		}
	}

	@Override
	public String getName() {
		return ("Longer Range");
	}
}
