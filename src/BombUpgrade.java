import java.awt.Point;

/**
 * Class for a powerup that can let hero set a bomb and press "e" to let it
 * explode
 */
public class BombUpgrade extends Powerup {

	public BombUpgrade(Point position, GameComponent gameComponent) {
		super(position, gameComponent);
	}

	@Override
	public void newPower(Hero hero) {
		hero.setBombUpgrade(true);
	}

	@Override
	public String getName() {
		return ("Explode Bomb when E is pressed");
	}

}
