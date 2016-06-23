package bublrobot;



import lejos.hardware.Sound;
import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.RangeFinderAdapter;
import lejos.robotics.objectdetection.Feature;
import lejos.robotics.objectdetection.FeatureDetector;
import lejos.robotics.objectdetection.FeatureListener;
import lejos.robotics.objectdetection.RangeFeatureDetector;


public class UltraDistance {
	
	bueblDrive bueblDrive;
	
	/**
	 * Initialize ultraDistance with prepared bueblDrive objects
	 * @param bueblDrive
	 */
	
	public UltraDistance (bueblDrive bueblDrive) {
		this.bueblDrive = bueblDrive;
		
	}

	/**
	 * Enables a Feature of the Ultrasonic Sensor
	 * @param port of the touch Sensor like SensorPort.S1
	 * @return a feature detector of touch
	 */
	public FeatureDetector enableUltraSonicFeature (Port port) {
		@SuppressWarnings ("ressource")
		EV3UltrasonicSensor us = new EV3UltrasonicSensor (port);
		return new RangeFeatureDetector (
				new RangeFinderAdapter(us.getDistanceMode()), Constants.MAX_DISTANCE, Constants.DETECTOR_DELAY);
	}
	
	/**
	 * Initialize desired features
	 */
public void initializeFeatures () {
	
	UltraSonicFeatureListener  usl =new UltraSonicFeatureListener();
	enableUltraSonicFeature(Constants.ULTRA_SONIC_SENSOR_PORT).addListener(usl);
}
	

	


/**
*when a ultra sonic feature is detected, play a tone and display
*the distance from the ultrasonic sensor on the EV3 screen
*/
private class UltraSonicFeatureListener implements FeatureListener {
	/**
	 this will be called when a sensitive Ultrasonic sensor
	 is in a range of a feature, playing a tone and displaying how far
	 away that feature is
	 <p> this method is required for the featureListener interface </p>
	 
	 @param feature detected feature
	 @param detector ultrasonic sensor
	 
	 */
	
	public void featureDetected (Feature feature, FeatureDetector detector) {
		
		//how far away is the detected feature?
		float range = feature.getRangeReading().getRange();
		
		//play a tone and display detected feature's distance
		Sound.playTone((int)(200+(range * 1000)),100);
		System.out.println ("Range:"+ range);
		if (range <= 0.984251968503937) {
			bueblDrive.stop();
			bueblDrive.moveTurn(30);
		}
		else{
			bueblDrive.moveStraightForever();
		}
		
	}
	 
}


}
