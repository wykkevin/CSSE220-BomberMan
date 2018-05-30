import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Class for the panel of buttons with some inner classes that work for button.
 */
public class GamePanel extends JPanel {
	private GameComponent component;
	private JFrame frame;

	public GamePanel(GameComponent myGame, JFrame frame) {
		super();
		this.component = myGame;
		this.frame = frame;
		addButtons();
	}

	public void addButtons() {

		JButton saveButton = new JButton("save");
		saveButton.setLocation(0, 550);
		saveButton.addActionListener(new SaveListener(this.component, this.frame));
		this.add(saveButton);

		JButton pauseButton = new JButton("Pause");

		pauseButton.addActionListener(new GameListener(this.component, this.frame, this));
		this.add(pauseButton);
		// button to start a new game of the same level
		JButton restartButton = new JButton("Restart");
		restartButton.addActionListener(new ActionListener() {

			@SuppressWarnings("synthetic-access")
			@Override
			public void actionPerformed(ActionEvent arg0) {
				GamePanel.this.component.mapChange("restart");
				GamePanel.this.frame.requestFocus();
			}

		});
		this.add(restartButton);

		JButton newGameButton = new JButton("New Game");
		newGameButton.addActionListener(new ActionListener() {

			@SuppressWarnings("synthetic-access")
			@Override
			public void actionPerformed(ActionEvent e) {
				GamePanel.this.component.getHero().setLife(0);
				GamePanel.this.frame.requestFocus();
			}

		});
		this.add(newGameButton);

		JButton quitButton = new JButton("quit");
		quitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}

		});
		this.add(quitButton);
	}
}
