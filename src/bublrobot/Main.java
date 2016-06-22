package bublrobot;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Main main = new Main();
		main.run();
		
		

	}
	
	public void run() {
		bueblDrive driveRun = new bueblDrive();
		driveRun.moveSequence();
		
	}

}
