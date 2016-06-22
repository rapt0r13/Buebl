package bublrobot;

import lejos.hardware.Sound;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.robotics.navigation.*;
import lejos.utility.Delay;

public class bueblDrive {

	
	
	
	/**
	 * Move straight 0.5m
	 */
	
	public void moveForward() {
		EV3LargeRegulatedMotor rightMotor = new EV3LargeRegulatedMotor(Constants.DRIVE_MOTOR_RIGHT);
		EV3LargeRegulatedMotor leftMotor = new EV3LargeRegulatedMotor(Constants.DRIVE_MOTOR_LEFT);
		Sound.beepSequence(); 
		DifferentialPilot pilot = new DifferentialPilot(Constants.WHEEL_DIAMETER, 
				Constants.WHEEL_DIAMETER, Constants.TRACK_WIDTH, leftMotor, rightMotor, true);
		Sound.beepSequence(); 
		 pilot.travel(50);         // cm
		 pilot.rotate(-90);        // degree clockwise
		 pilot.travel(-50,true);  //  move backward for 50 cm
		 while(pilot.isMoving())Thread.yield();
		 pilot.rotate(-90);
		 pilot.rotate(270);
		 pilot.steer(-50,180,true); // turn 180 degrees to the right

		 pilot.steer(100);          // turns with left wheel stationary
		 Delay.msDelay(1000);
		 pilot.stop();
		 
	}
	
}