package bublrobot;

import lejos.hardware.Sound;
import lejos.hardware.motor.EV3LargeRegulatedMotor;

import lejos.robotics.chassis.Chassis;
import lejos.robotics.chassis.Wheel;
import lejos.robotics.chassis.WheeledChassis;

import lejos.robotics.navigation.MovePilot;


public class bueblDrive {

	
	
	
	/**
	 * Move straight 0.5m
	 */
	
	public void moveForward() {
		EV3LargeRegulatedMotor rightMotor = new EV3LargeRegulatedMotor(Constants.DRIVE_MOTOR_RIGHT);
		EV3LargeRegulatedMotor leftMotor = new EV3LargeRegulatedMotor(Constants.DRIVE_MOTOR_LEFT);
		 Wheel wheel1 = WheeledChassis.modelWheel(rightMotor, 43.2).offset(-72);
		 Wheel wheel2 = WheeledChassis.modelWheel(leftMotor, 43.2).offset(72);
		 Chassis chassis = new WheeledChassis(new Wheel[]{wheel1, wheel2}, WheeledChassis.TYPE_DIFFERENTIAL); 
		 MovePilot pilot = new MovePilot(chassis);
		 Sound.beepSequenceUp();
		 pilot.travel(1000);         // cm
		 pilot.rotate(-90);        // degree clockwise
		 pilot.travel(-100,true);  //  move backward for 50 cm
		 while(pilot.isMoving())Thread.yield();
		 pilot.rotate(-720);
		 pilot.rotate(270);
		 pilot.stop();
	}
	
}