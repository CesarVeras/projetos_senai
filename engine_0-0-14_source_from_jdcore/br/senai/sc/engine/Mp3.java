package br.senai.sc.engine;

import java.io.File;
import java.net.URL;
import javazoom.jl.player.Player;

public class Mp3 extends Thread
{
  private File mp3;
  private Player player;
  private String audioName;
  
  public Mp3() {}
  
  public void carregar(String caminho)
  {
    audioName = caminho;
    
    URL path = getClass().getClassLoader().getResource(caminho);
    mp3 = new File(path.getFile());
  }
  
  public String getAudioName() {
    return audioName;
  }
  
  public void setAudioName(String audioName) {
    this.audioName = audioName;
  }
  
  public File getMp3() {
    return mp3;
  }
  
  public void setMp3(File mp3) {
    this.mp3 = mp3;
  }
  
  public Player getPlayer() {
    return player;
  }
  
  public void setPlayer(Player player) {
    this.player = player;
  }
  
  public void run() {
    try {
      java.io.FileInputStream fis = new java.io.FileInputStream(mp3);
      java.io.BufferedInputStream bis = new java.io.BufferedInputStream(fis);
      
      player = new Player(bis);
      
      player.play();
      if (player.isComplete()) {
        player.close();
        interrupt();
      }
    } catch (Exception e) {
      System.out.println("Problemas ao tocar a música");
      e.printStackTrace();
    }
  }
  
  public void iniciar() {
    start();
  }
  
  public void finalizar() {
    player.close();
    interrupt();
  }
  
  public boolean isCompleted() {
    if ((player != null) && ((player.isComplete()) || (!isAlive()))) {
      return true;
    }
    return false;
  }
}
