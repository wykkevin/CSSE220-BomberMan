/**
 * Class for the hero
 */
public class Hero extends Creature {

	private boolean bombUpgrade = false;

	public Hero(GameComponent component) {
		super(component);
		this.speed = 25;
	}

	@Override
	public String getName() {
		return "hero";
	}

	public void setBombUpgrade(boolean upgrade) {
		this.bombUpgrade = upgrade;
	}

	public boolean getBombUpgrade() {
		return this.bombUpgrade;
	}

	public boolean dropBomb() {
		if (this.remainBombs > 0) {
			this.remainBombs--;
			return true;
		}
		return false;
	}

	public void reset() {
		this.remainBombs = 1;
		this.life = 3;
		this.component.setRange(1);
		this.setBombUpgrade(false);
	}
}
