package bublrobot;

import lejos.hardware.port.MotorPort;
import lejos.hardware.port.Port;
import lejos.hardware.port.SensorPort;

public class Constants {
	
	final static Port FRONT_MOTOR = MotorPort.B;

	public static double WHEEL_DIAMETER = 6.9;
	public static double TRACK_WIDTH = 11.6;
	public static double WHEEL_THICK = 3.5;
	final static int DRIVE_MOTOR_ACCELERATION = 200;
	final static int DRIVE_MOTOR_SPEED = 100;
	final static int REGULATED_MOTOR_POWER = 75;
	final static Port DRIVE_MOTOR_RIGHT = MotorPort.D; //steering Motor C
	final static Port DRIVE_MOTOR_LEFT = MotorPort.A;
	
	
	//ultrasonic sensor and listener
	public static final float MAX_DISTANCE =100f;
	public static final int DETECTOR_DELAY = 1000;
	final static Port ULTRA_SONIC_SENSOR_PORT = SensorPort.S2;
		 
	}


