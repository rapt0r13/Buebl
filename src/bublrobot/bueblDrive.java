package bublrobot;

import lejos.hardware.Sound;
import java.util.Random;
import lejos.hardware.motor.EV3LargeRegulatedMotor;

import lejos.robotics.chassis.Chassis;
import lejos.robotics.chassis.Wheel;
import lejos.robotics.chassis.WheeledChassis;

import lejos.robotics.navigation.MovePilot;
import lejos.utility.Delay;


public class bueblDrive {

	MovePilot pilot = initializeDrive();
	
	
	public MovePilot initializeDrive() {
		EV3LargeRegulatedMotor rightMotor = new EV3LargeRegulatedMotor(Constants.DRIVE_MOTOR_RIGHT);
		EV3LargeRegulatedMotor leftMotor = new EV3LargeRegulatedMotor(Constants.DRIVE_MOTOR_LEFT);
		//rightMotor.setSpeed(20);
		//leftMotor.setSpeed(20);
		 Wheel wheel1 = WheeledChassis.modelWheel(rightMotor, 23.2).offset(-72);
		 Wheel wheel2 = WheeledChassis.modelWheel(leftMotor, 23.2).offset(72);
		 Chassis chassis = new WheeledChassis(new Wheel[]{wheel1, wheel2}, WheeledChassis.TYPE_DIFFERENTIAL); 
		 MovePilot pilot = new MovePilot(chassis);
		 Sound.beepSequenceUp();
		 pilot.setLinearSpeed(80);
		 pilot.setLinearAcceleration(7);
		 return pilot;
		 
	}
	
	/**
	 * Move straight 0.5m
	 */
	
	public void moveSequence() {
		 Sound.beepSequenceUp();
		 pilot.travel(1000);         // cm
		 pilot.rotate(-90);        // degree clockwise
		 pilot.travel(-100,true);  //  move backward for 50 cm
		 while(pilot.isMoving())Thread.yield();
		 pilot.rotate(-720);
		 pilot.rotate(270);
		 pilot.stop();
		
		 
		 
	}
	
	public void moveStraightForever() {
		pilot.forward();
		}
	
	public void moveStraight(double distance) {
		pilot.travel(distance);
	}
		
	public void moveTurn(double degree) {
		pilot.rotate(degree);
		}
	
	public void flt() {
		pilot.setLinearSpeed(0.0001);
		
	}
	
	public void stop() {
		pilot.stop();
	}

	public void rotateDiffAngle() {
		
		Random rand = new Random();
		
		int x = rand.nextInt(180);
		int y =rand.nextInt(2);
		int angle;
		if (y ==2) {
			angle = x;
		}
		else if (x==0) {
			angle = 45;
		}
		else {
			angle = 0 -x;
		}
		
		pilot.rotate(angle);
		
	}
	
	
			

		
	
}