import java.awt.Point;

/**
 * This class is for monster 3.
 */
public class MonsterThree extends Monster {
	private Hero hero;
	private boolean getClosed;

	public MonsterThree(GameComponent component, Hero hero) {
		super(component, hero);
		this.hero = hero;
		this.speed = 25;
		this.getClosed = false;
	}

	@Override
	public String getName() {
		return "monster3";
	}

	// This monster moves away from hero and has 3 lives.
	@Override
	public void run() {
		while (true) {
			if (!this.component.getPaused()) {
				int x = 0;
				int y = 0;
				if (Math.abs(this.hero.getPosition().x - this.getPosition().x)
						+ Math.abs(this.hero.getPosition().y - this.getPosition().y) <= 200) {
					if (this.component.getPaused() == false) {
						this.getClosed = true;
						if (this.position.x > this.hero.getPosition().x && this.movable("right")
								&& this.getPosition().x < 650) {
							x = this.speed;
						} else if (this.position.x < this.hero.getPosition().x && this.movable("left")
								&& this.getPosition().x > 0) {
							x = -this.speed;
						} else if (this.position.y > this.hero.getPosition().y && this.movable("down")
								&& this.getPosition().y < 650) {
							y = this.speed;
						} else if (this.position.y < this.hero.getPosition().y && this.movable("up")
								&& this.getPosition().y > 0) {
							y = -this.speed;
						}
						if (this.position.x > this.hero.getPosition().x && this.getPosition().x == 650
								&& this.component.getGameMap().getGameMap()[0][this.getPosition().y / 50] == 0) {
							x = -650;
						} else if (this.position.x < this.hero.getPosition().x && this.getPosition().x == 0
								&& this.component.getGameMap().getGameMap()[13][this.getPosition().y / 50] == 0) {
							x = 650;
						} else if (this.position.y > this.hero.getPosition().y && this.getPosition().y == 650
								&& this.component.getGameMap().getGameMap()[this.getPosition().x / 50][0] == 0) {
							y = -650;
						} else if (this.position.y < this.hero.getPosition().y && this.getPosition().y == 0
								&& this.component.getGameMap().getGameMap()[this.getPosition().x / 50][13] == 0) {
							y = 650;
						}
					}
				} else {
					this.getClosed = false;
					double random0To4 = (int) (Math.random() * 4);
					if (random0To4 == 0 && this.movable("up") && this.getPosition().y > 0) {// up
						Point newPosition = new Point(this.position.x, this.position.y - this.speed);
						this.setPosition(newPosition);
					}
					if (random0To4 == 1 && this.movable("down") && this.getPosition().y < 650) {// down
						Point newPosition = new Point(this.position.x, this.position.y + this.speed);
						this.setPosition(newPosition);
					}
					if (random0To4 == 2 && this.movable("left") && this.getPosition().x > 0) {// left
						Point newPosition = new Point(this.position.x - this.speed, this.position.y);
						this.setPosition(newPosition);
					}
					if (random0To4 == 3 && this.movable("right") && this.getPosition().x < 650) {// right
						Point newPosition = new Point(this.position.x + this.speed, this.position.y);
						this.setPosition(newPosition);
					}
				}
				this.setPosition(new Point(this.position.x + x, this.position.y + y));
				if (!this.getClosed) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException exception) {
						System.out.println("boss monster is killed");
					}
				}
			}
		}
	}
}
