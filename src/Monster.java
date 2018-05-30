import java.awt.Point;

/**
 * Class for monster
 */
public abstract class Monster extends Creature implements Runnable {
	private Thread thread;
	private Hero hero;
	private boolean monsterIsBombed;

	public Monster(GameComponent component, Hero hero) {
		super(component);
		setInitialPoint();
		this.speed = 25;
		this.thread = null;
		this.hero = hero;
	}

	public void setThread(Thread thread) {
		this.thread = thread;
	}

	public Thread getThread() {
		return this.thread;
	}

	public boolean isMonsterIsBombed() {
		return this.monsterIsBombed;
	}

	public void setMonsterIsBombed(boolean monsterIsBombed) {
		this.monsterIsBombed = monsterIsBombed;
	}

	@Override
	public abstract String getName();

	// monsters are born at random positions.
	public void setInitialPoint() {
		int x = (int) (Math.random() * 7 + 6);
		int y = (int) (Math.random() * 7 + 6);
		if (this.component.getMap().isWall(x, y) == false) {
			this.position = new Point(x * 50, y * 50);
			return;
		}
		setInitialPoint();
	}

	public void killHero() {
		if (Math.abs(this.getPosition().x - this.hero.getPosition().x) < 50
				&& Math.abs(this.getPosition().y - this.hero.getPosition().y) < 50) {
			System.out.println("hero position" + this.hero.getPosition());
			System.out.println(this.getName() + " position" + this.getPosition());
			this.hero.setLife(this.hero.getLife() - 1);
			this.hero.setPosition(new Point(0, 0));
			System.out.println("I am killed by " + this.getName());
		}
	}

}
