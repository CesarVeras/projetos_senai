package br.senai.sc.engine;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JPanel;







public abstract class Game  extends Canvas {
  private static final long serialVersionUID = 6058040659371962305L;
  private JFrame container;
  private BufferStrategy strategy;
  private boolean gameRunning = true;
  private boolean sairAoTermino = false;
  
  private Graphics2D graphics2D;
  private Fps fps;
  private Map<String, Mp3> musicas;
  private Map<String, CustomFont> customFonts;
  
  public Game()
  {
	this.requestFocus();
    Dimension fullscreen = Toolkit.getDefaultToolkit().getScreenSize();
    
    Utils.getInstance().setHeight(height);
    Utils.getInstance().setWidth(width);
    

    container = new JFrame(Utils.getInstance().getNomeJogo());
    
    container.setUndecorated(true);
    


    JPanel panel = (JPanel)container.getContentPane();
    


    panel.setPreferredSize(
      new Dimension(Utils.getInstance().getWidth(), Utils.getInstance().getHeight()));
    

    panel.setLayout(null);
    


    setBounds(0, 0, Utils.getInstance().getWidth(), Utils.getInstance().getHeight());
    
    panel.add(this);
    



    setIgnoreRepaint(true);
    

    container.pack();
    
    container.setResizable(false);
    

    container.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);


      }
      



    });
    fps = new Fps();
    musicas = new HashMap();
    customFonts = new HashMap();
    

    init();
    



    container.setVisible(true);
    

    requestFocus();
    
    createBufferStrategy(2);
    strategy = getBufferStrategy();
  }
  
  public Game(String nomeJogo, int width, int height)
  {
    Utils.getInstance().setNomeJogo(nomeJogo);
    Utils.getInstance().setHeight(height);
    Utils.getInstance().setWidth(width);
    

    container = new JFrame(Utils.getInstance().getNomeJogo());
    


    JPanel panel = (JPanel)container.getContentPane();
    


    panel.setPreferredSize(
      new Dimension(Utils.getInstance().getWidth() - 10, Utils.getInstance().getHeight() - 10));
    

    panel.setLayout(null);
    


    setBounds(0, 0, Utils.getInstance().getWidth(), Utils.getInstance().getHeight());
    
    panel.add(this);
    



    setIgnoreRepaint(true);
    

    container.pack();
    
    container.setResizable(false);
    

    container.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);


      }
      



    });
    fps = new Fps();
    musicas = new HashMap();
    customFonts = new HashMap();
    

    init();
    

    container.setLocationRelativeTo(null);
    
    container.setVisible(true);
    

    requestFocus();
    
    createBufferStrategy(2);
    strategy = getBufferStrategy();
  }
  




  public abstract void init();
  



  public void startGame()
  {
    while (gameRunning)
    {

      graphics2D = ((Graphics2D)strategy.getDrawGraphics());
      
      fps.updateFPS();
      
      graphics2D.setColor(Color.white);
      graphics2D.fillRect(0, 0, Utils.getInstance().getWidth(), Utils.getInstance().getHeight());
      
      gameLoop();
      



      graphics2D.dispose();
      
      strategy.show();
      
      fps.synchronize();
    }
    
    aposTermino();
    if (sairAoTermino) {
      System.exit(0);
    }
  }
  
  public void desenharGif(Image image, int x, int y) {
    graphics2D.drawImage(image, x, y, container);
  }
  
  public void desenharImagem(Image image, int x, int y) {
    graphics2D.drawImage(image, x, y, null);
  }
  
  public void desenharString(String mensagem, int x, int y) {
    graphics2D.drawString(mensagem, x, y);
  }
  
  public void desenharString(String mensagem, int x, int y, Color color) {
    graphics2D.setColor(color);
    graphics2D.drawString(mensagem, x, y);
  }
  
  public void desenharString(String mensagem, int x, int y, Color color, int fontSize) {
    graphics2D.setColor(color);
    graphics2D.setFont(new Font("Arial", 1, fontSize));
    graphics2D.drawString(mensagem, x, y);
  }
  
  public void desenharString(String mensagem, int x, int y, Color color, int fontSize, String fontName) {
    graphics2D.setColor(color);
    graphics2D.setFont(new Font(fontName, 1, fontSize));
    graphics2D.drawString(mensagem, x, y);
  }
  
  public void desenharString(String mensagem, int x, int y, Color color, int fontSize, String fontName, int fontStyle)
  {
    graphics2D.setColor(color);
    graphics2D.setFont(new Font(fontName, fontStyle, fontSize));
    graphics2D.drawString(mensagem, x, y);
  }
  
  public Image carregarImagem(String path) {
    return Utils.getInstance().loadImage(path);
  }
  
  public void finalizarJogo() {
    gameRunning = false;
  }
  
  public abstract void aposTermino();
  
  public abstract void gameLoop();
  
  public void sairAoTerminar() {
    sairAoTermino = true;
  }
  
  public void alterarFramesPorSegundos(int fps) {
    this.fps = new Fps(fps);
  }
  
  public void adicionarAudio(String nome, String path) {
    Mp3 mp3 = new Mp3();
    mp3.carregar(path);
    if (musicas.get(nome) != null) {
      musicas.remove(nome);
    }
    musicas.put(nome, mp3);
  }
  
  public void tocarAudio(String nome) {
    String audioName = ((Mp3)musicas.get(nome)).getAudioName();
    musicas.remove(nome);
    Mp3 mp3 = new Mp3();
    mp3.carregar(audioName);
    musicas.put(nome, mp3);
    ((Mp3)musicas.get(nome)).iniciar();
  }
  
  public void pararAudio(String nome) {
    ((Mp3)musicas.get(nome)).finalizar();
  }
  
  public boolean audioIsCompleted(String nome) {
    if (musicas.get(nome) != null) {
      return ((Mp3)musicas.get(nome)).isCompleted();
    }
    return true;
  }
  
  public void removerAudio(String nome)
  {
    musicas.remove(nome);
  }
  
  public void desenharRetangulo(int x, int y, int width, int height, Color color) {
    graphics2D.setColor(color);
    graphics2D.fillRect(x, y, width, height);
  }
  
  public void desenharCirculo(int x, int y, int width, int height, Color color) {
    graphics2D.setColor(color);
    graphics2D.fillOval(x, y, width, height);
  }
  
  public void addNewFont(String name, String path, float size, int style) {
    CustomFont cf = new CustomFont(path, size, style);
    customFonts.put(name, cf);
  }
  
  public void setFont(String name) {
    graphics2D.setFont(((CustomFont)customFonts.get(name)).getCustomFont());
  }
  
  public Graphics2D getGraphics2D() {
    return graphics2D;
  }
  
  public int getWidth() {
    return Utils.getInstance().getWidth();
  }
  
  public int getHeight() {
    return Utils.getInstance().getHeight();
  }
}
