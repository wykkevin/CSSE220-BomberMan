/**
 * The main class for your arcade game.
 * 
 * You can design your game any way you like, but make the game start by running
 * main here.
 * 
 * Also don't forget to write javadocs for your classes and functions!
 * 
 * @author Buffalo
 *
 */
public class Main {

	/**
	 * It first generate a window of start game. When press the button, it gets
	 * another window and start the actual game.
	 */
	public static void main(String[] args) {
		System.out.println("Welcome to KSYY Bomberman!\n"
				+ "Click start to start a new game or Click continue to continue the saved game.");
		Frames mainFrames = new Frames();
		mainFrames.frames();
	}
}
