import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Class for the starting frame.
 */
public class Frames {
	private boolean ifContinue = false;

	public void frames() {
		final JFrame startFrame = new JFrame();
		JButton startGame = new JButton("Start Game");
		JButton continueGame = new JButton("Continue");

		startFrame.add(new JLabel(new ImageIcon("src/image/TitleScreen.png")), BorderLayout.NORTH);
		startFrame.add(startGame);
		startFrame.add(continueGame, BorderLayout.SOUTH);

		startFrame.pack();
		startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		startFrame.setVisible(true);

		class startGameListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				startFrame.setVisible(false);
				addFrame();
			}
		}
		class continueGameListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				setIfContinue(true);
				startFrame.setVisible(false);
				addFrame();
			}
		}
		startGame.addActionListener(new startGameListener());
		continueGame.addActionListener(new continueGameListener());

	}

	public boolean isIfContinue() {
		return this.ifContinue;
	}

	public void setIfContinue(boolean ifContinue) {
		this.ifContinue = ifContinue;
	}

	public void addFrame() {
		System.out.println("Now you can click u to go to a higher level or clich d to fo to a lower level\n"
				+ "You can also press s or click save to save your current game.\n"
				+ "Use arrows to move the hero and use space to set bomb. Your goal is to kill all the monsters.\n"
				+ "Never try to press K.");

		final JFrame frame = new JFrame();
		GameComponent myGame = new GameComponent(this);
		GamePanel buttons = new GamePanel(myGame, frame);
		GameMap myMap = new GameMap();
		Hero myHero = new Hero(myGame);
		ArrayList<Monster> monster = new ArrayList<>();
		myGame.addCharacter(myHero, monster);

		KeyListener moveHero = new MoveListener(myHero, myGame);
		KeyListener setBomb = new BombListener(myHero, myGame, myMap, monster);
		KeyListener mapChange = new MapListener(myGame);
		KeyListener pause = new GameListener(myGame, frame, buttons);
		KeyListener save = new SaveListener(myGame, frame);

		frame.addKeyListener(moveHero);
		frame.addKeyListener(setBomb);
		frame.addKeyListener(mapChange);
		frame.addKeyListener(pause);
		frame.addKeyListener(save);

		frame.add(buttons, BorderLayout.SOUTH);
		frame.add(myGame, BorderLayout.CENTER);
		frame.setSize(719, 820);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setVisible(true);
		frame.requestFocusInWindow();
		frame.requestFocusInWindow();
	}
}
