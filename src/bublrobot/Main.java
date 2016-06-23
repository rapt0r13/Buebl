package bublrobot;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;

public class Main {



	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Main main = new Main();
		main.run();



	}

	public void run() {
		bueblDrive pilot = new bueblDrive();
		FrontMotor frontMotor = new FrontMotor();
		UltraDistance us = new UltraDistance(pilot);
		LCD.drawString("Initializing", 0, 0);
		us.initializeFeatures();

		//pilot.moveStraight(2000);
		//pilot.moveTurn(45);
		//pilot.moveStraight(1000);
		//us.enableDetection (false);
		Button.waitForAnyPress(0);
		pilot.stop();
	}




}

