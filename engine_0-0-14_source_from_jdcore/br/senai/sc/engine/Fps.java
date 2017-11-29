package br.senai.sc.engine;

import java.io.PrintStream;

public class Fps { private int targetFps = 30;
  private long optimalTime = 1000 / targetFps;
  private long lastFrameTime;
  private int fps;
  private long lastFPSMs;
  
  public Fps()
  {
    getDelta();
    lastFPSMs = getTime();
  }
  
  public Fps(int fps) {
    targetFps = fps;
    optimalTime = (1000 / targetFps);
    getDelta();
    lastFPSMs = getTime();
  }
  
  public int getTargetFps() {
    return targetFps;
  }
  
  public void setTargetFps(int targetFps) {
    this.targetFps = targetFps;
  }
  
  public long getOptimalTime() {
    return optimalTime;
  }
  
  public void setOptimalTime(long optimalTime) {
    this.optimalTime = optimalTime;
  }
  
  public long getLastFrameTime() {
    return lastFrameTime;
  }
  
  public void setLastFrameTime(long lastFrameTime) {
    this.lastFrameTime = lastFrameTime;
  }
  
  public int getFps() {
    return fps;
  }
  
  public void setFps(int fps) {
    this.fps = fps;
  }
  
  public long getLastFPSMs() {
    return lastFPSMs;
  }
  
  public void setLastFPSMs(long lastFPSMs) {
    this.lastFPSMs = lastFPSMs;
  }
  



  private long getTime()
  {
    return System.nanoTime() / 1000000L;
  }
  


  public int getDelta()
  {
    long time = getTime();
    int delta = (int)(time - lastFrameTime);
    lastFrameTime = time;
    return delta;
  }
  
  public void updateFPS() {
    if (lastFPSMs > 1000L)
    {
      fps = 0;
      lastFPSMs = 0L;
    }
    lastFPSMs += getDelta();
    fps += 1;
  }
  
  public void synchronize() {
    long ms = lastFrameTime - getTime() + optimalTime;
    try {
      if (ms > 0L) {
        Thread.sleep(ms);
      }
    } catch (InterruptedException ex) {
      System.err.println(ex.getMessage());
      System.exit(-1);
    }
  }
}
