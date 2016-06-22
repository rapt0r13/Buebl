package bublrobot;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;

public class LED {

   public static void main(String[] args) {
      new LED().start();
   }

   private boolean finished;
   private int pattern;

   public void start() {
      finished = false;
      pattern = 0;
      refreshDisplay();
      Thread buttonListener = new Thread() {
         public void run() {
            while(!finished) {
               buttonPressed(Button.waitForAnyPress());
            }
            Button.LEDPattern(0); // don't forget to turn off light before exit
         }
      };
      buttonListener.setDaemon(true);
      buttonListener.start();
      while(!finished) {
         Thread.yield();
      }
   }

   private void buttonPressed(int buttonId) {
      switch (buttonId) {
      case Button.ID_ESCAPE:
         finished = true;
         break;
      case Button.ID_UP:
         ++pattern;
         refreshDisplay();
         break;
      case Button.ID_DOWN:
         if (pattern > 0) {
            --pattern;
            refreshDisplay();
         }
         break;
      }
   }
   
   private void refreshDisplay() {
      LCD.clear();
      LCD.drawString("BUTTON LIGHTS", 0, 0);
      LCD.drawString(" UP:     next", 0, 1);
      LCD.drawString(" DOWN:   back", 0, 2);
      LCD.drawString(" ESCAPE: exit", 0, 3);
      LCD.drawString("-------------", 0, 4);
      LCD.drawString("Pattern: " + pattern, 0, 5);
      Button.LEDPattern(pattern);
   }
}