/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package survival.game;

/**
 *
 * @author 629865
 */
import java.awt.Color;
import java.awt.Graphics;

/**
 * @author 629865
 */
public class Enemy extends Character {
    public Enemy(){
    super();
}
    
    public Enemy(int x, int y, Color color, int size, String name){
        super(x,y,color,size,name);
        dx = 2;
        dy = 2;
            }
    
    @Override
    public void update() {
            
            super.move(dx,dy);
    }
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(super.getX(), super.getY(), super.getSize()+80, super.getSize()+80);
        
    }
    
}
