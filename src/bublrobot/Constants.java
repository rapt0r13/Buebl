package bublrobot;

import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.Port;
import lejos.hardware.port.SensorPort;

public class Constants {


	public static double WHEEL_DIAMETER = 6.85;
	public static double TRACK_WIDTH = 16.2;
	public static double WHEEL_THICK = 2.8;
	public static Port Port_UltrasonicSensor = SensorPort.S1;
	final static int DRIVE_MOTOR_ACCELERATION = 200;
	final static int DRIVE_MOTOR_SPEED = 100;
	final static int REGULATED_MOTOR_POWER = 75;
	final static Port DRIVE_MOTOR_RIGHT = MotorPort.D; //steering Motor C
	final static Port DRIVE_MOTOR_LEFT = MotorPort.A;
	
	public static final float MAX_DISTANCE = 100f;
	public static final int DETECTOR_DELAY = 1000;
	
	
	
	/*
	// get a port instance for the Ultrasonic Sensor
	final static Port port = LocalEV3.get().getPort("S2");
	
	// distance for the UltrasonicSensor
	final static double sensorlimit = (double) 3;
	*/
	
	
	}


