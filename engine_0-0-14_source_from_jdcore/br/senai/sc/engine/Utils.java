package br.senai.sc.engine;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.swing.ImageIcon;

public class Utils
{
  private static Utils instance;
  private int width;
  private int height;
  private String nomeJogo;
  
  public Utils() {}
  
  public static Utils getInstance()
  {
    if (instance == null) {
      instance = new Utils();
    }
    return instance;
  }
  










  public Image loadImage(String fileName)
  {
    URL imgUrl = getClass().getClassLoader().getResource(fileName);
    
    if (imgUrl == null) {
      System.out.println("Erro ao carregar a imagem!");
    }
    else
    {
      try
      {
        String[] split = fileName.split("\\.");
        if (split[(split.length - 1)].equalsIgnoreCase("gif")) {
          return new ImageIcon(imgUrl).getImage();
        }
        return javax.imageio.ImageIO.read(imgUrl);
      }
      catch (IOException e) {
        e.printStackTrace();
      }
    }
    return null;
  }
  
  public int getWidth() {
    return width;
  }
  
  public void setWidth(int width) {
    this.width = width;
  }
  
  public int getHeight() {
    return height;
  }
  
  public void setHeight(int height) {
    this.height = height;
  }
  
  public String getNomeJogo() {
    return nomeJogo;
  }
  
  public void setNomeJogo(String nomeJogo) {
    this.nomeJogo = nomeJogo;
  }
}
