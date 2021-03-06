import java.awt.Point;

/**
 * This is an abstract class of powerups. BombUpgrade, ExtraLife, LongerRange
 * and MoreBombs extends it.
 */
public abstract class Powerup {

	private Point position;
	private GameComponent gameComponent;
	protected int limit;

	public Powerup(Point position, GameComponent gameComponent) {
		this.position = position;
		this.gameComponent = gameComponent;
	}

	public abstract void newPower(Hero hero);

	public Point getPosition() {
		return this.position;
	}

	public abstract String getName();

	public GameComponent getGameComponent() {
		return this.gameComponent;
	}

	public int getLimit() {
		return this.limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}
}
