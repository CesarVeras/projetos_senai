package br.senai.sc.engine;

import java.awt.Font;
import java.net.URL;

public class CustomFont
{
  private Font customFont;
  
  public CustomFont(String path, float size, int style)
  {
    try
    {
      URL uc = getClass().getClassLoader().getResource(path);
      customFont = Font.createFont(0, new java.io.File(uc.getPath())).deriveFont(style, size);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public Font getCustomFont() {
    return customFont;
  }
  
  public void setCustomFont(Font customFont) {
    this.customFont = customFont;
  }
}
