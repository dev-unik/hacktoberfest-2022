package gameobject;import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
public class dino extends Enemy {
 
 public static final int Y_LAND = 125;
 
 private int posX;
 private int w;
 private int h;
 
 private BufferedImage image;
 private MainCharacter mainCharacter;
 
 private Rectangle rectBound;
 
 public Cactus(MainCharacter mainCharacter, int posX, int w, int h, BufferedImage image) {
  this.posX = posX;
  this.w = w;
  this.h = h;
  this.image = image;
  this.mainCharacter = mainCharacter;
  rectBound = new Rectangle();
 }
 
 public void update() {
  posX -= mainCharacter.getSpeedX();
 }
 
 public void draw(Graphics g) {
  g.drawImage(image, posX, Y_LAND - image.getH(), null);
  g.setColor(Color.red);
//  Rectangle bound = getBound();
//  g.drawRect(bound.x, bound.y, bound.w, bound.h);
 }
 
 public Rectangle getBound() {
  rectBound = new Rectangle();
  rectBound.x = (int) posX + (image.getW() - w)/2;
  rectBound.y = Y_LAND - image.getH() + (image.getH() - h)/2;
  rectBound.w = w;
  rectBound.h = h;
  return rectBound;
 }@Override
 public boolean isOutOfScreen() {
  if(posX < -image.getW()) {
   return true;
  }
  return false;
 }
 
}

