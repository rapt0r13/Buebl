package bublrobot;

import lejos.hardware.motor.UnregulatedMotor;
import lejos.utility.Delay;

public class FrontMotor {

	

	
		UnregulatedMotor frontMotor = new UnregulatedMotor(Constants.FRONT_MOTOR);
		
	
	
	
	public void clean() {
		frontMotor.forward();
		Delay.msDelay(1000);
		frontMotor.flt();
	}
	public void motorIntervall() {
		while (1==1) {
			frontMotor.forward();
			Delay.msDelay(4000);
			frontMotor.flt();
			Delay.msDelay(4000);
			frontMotor.backward();
			Delay.msDelay(4000);
			frontMotor.flt();
			Delay.msDelay(4000);
			break;
		}
	}
}
