import java.awt.Point;

/**
 * This class is for monster 2.
 */
public class MonsterTwo extends Monster {
	private Hero hero;

	public MonsterTwo(GameComponent component, Hero hero) {
		super(component, hero);
		this.hero = hero;
		this.life = 1;
	}

	@Override
	public String getName() {
		return "monster2";
	}

	// This monster follow the hero.
	@Override
	public void run() {
		while (true) {
			int x = 0;
			int y = 0;
			if (this.component.getPaused() == false) {

				if (this.position.x < this.hero.getPosition().x && this.movable("right")) {
					x = this.speed;
				} else if (this.position.x > this.hero.getPosition().x && this.movable("left")) {
					x = -this.speed;
				} else if (this.position.y < this.hero.getPosition().y && this.movable("down")) {
					y = this.speed;
				} else if (this.position.y > this.hero.getPosition().y && this.movable("up")) {
					y = -this.speed;
				}
			}
			this.setPosition(new Point(this.position.x + x, this.position.y + y));
			try {
				Thread.sleep(751);
			} catch (InterruptedException exception) {
				System.out.println("monstertwo is killed");
			}
		}
	}
}
