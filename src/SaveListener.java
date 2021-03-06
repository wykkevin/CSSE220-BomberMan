import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
/**
 * Class for the saving action.
 */
public class SaveListener implements KeyListener, ActionListener {
	private GameComponent component;
	private JFrame frame;

	public SaveListener(GameComponent myGame, JFrame frame) {
		this.component = myGame;
		this.frame = frame;
	}

	public void writeFile() {
		BufferedWriter bw = null;
		FileWriter fw = null;
		String content = "content";
		try {
			fw = new FileWriter("src/image/continue");
			bw = new BufferedWriter(fw);
			int[][] map = this.component.getMap().getGameMap();
			for (int i = 0; i < 14; i++) {
				for (int j = 0; j < 14; j++) {
					int numberNow = map[j][i];
					if (numberNow == 3) {
						numberNow = 0;
					}
					bw.write(Integer.toString(numberNow));
				}
				bw.write("\n");
			}
			bw.write(this.component.getHero().getLife() + "," + this.component.getHero().getPosition().x + ","
					+ this.component.getHero().getPosition().y + ","
					+ (this.component.getHero().getRemainBombs() + this.component.getBombList().size()) + ","
					+ this.component.getRange() + "\n");
			ArrayList<Monster> monsters = this.component.getMonsterList();
			for (int i = 0; i < monsters.size(); i++) {
				bw.write(monsters.get(i).getName());
				if (i != monsters.size() - 1) {
					bw.write(",");
				}
				if (monsters.get(i).getName().equals("monster3")) {
					bw.write(",");
					bw.write(Integer.toString(monsters.get(i).getLife()));
					if (i != monsters.size() - 1) {
						bw.write(",");
					} else {
						bw.write("\n");
					}
				}
			}

			for (int i = 0; i < monsters.size(); i++) {
				bw.write(monsters.get(i).getPosition().x + "," + monsters.get(i).getPosition().y);
				if (i != monsters.size() - 1) {
					bw.write(",");
				} else {
					bw.write("\n");
				}
			}
			bw.write(Boolean.toString(this.component.getHero().getBombUpgrade()) + "\n");
			bw.write(Integer.toString(this.component.getMap().getMapNum()));
			System.out.println("saved");
		} catch (IOException exception) {
			// TODO Auto-generated catch-block stub.
			exception.printStackTrace();
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
				if (fw != null) {
					fw.close();
				}
			} catch (IOException exception) {
				// TODO Auto-generated catch-block stub.
				exception.printStackTrace();
			}

		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_S) {
			writeFile();
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub.

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub.

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		writeFile();
		this.frame.requestFocus();
	}

}
