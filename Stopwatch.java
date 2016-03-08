package Amazing_Car_Race;

import java.util.Timer;
import java.util.TimerTask;
 
public class Stopwatch {
  static int interval;
  static Timer timer;
 
  public Stopwatch(){
 
    int delay = 1000;
    int period = 1000;
    timer = new Timer();
    interval = 1;
    timer.scheduleAtFixedRate(new TimerTask() {
      @Override
      public void run() {
         System.out.println(setInterval());
      }
    }, delay, period);
  }
 
  private static final int setInterval(){
    if( interval == 10000) timer.cancel();
      return ++interval;
  }
}