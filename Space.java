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
import java.awt.event.KeyEvent;
import java.util.Arrays;
import javax.swing.JPanel;
import java.util.Timer;
import java.util.TimerTask;


/**
 *
 * @author jword
 */
public class Space extends JPanel {

    final int marginX;
    final int marginY;
    private Hero hero;
    private Enemy enemy;
    private Timer timer;
    int score;
    private Enemy enemy2;
    private Enemy enemy3;
    private Enemy enemy4;
    private Enemy enemy5;
        
    public Space() {
        super();
        marginX = 10;
        marginY = 10;
        hero = new Hero(600, 480, Color.YELLOW, 20, "Dude");
        enemy = new Enemy(50, 50, Color.RED, 20, "Enemy");
        enemy2 = new Enemy(100, 50, Color.RED, 20, "Enemy");
        enemy3 = new Enemy(200, 50, Color.RED, 20, "Enemy");
        enemy4 = new Enemy(50, 100, Color.RED, 20, "Enemy");
        enemy5 = new Enemy(50, 200, Color.RED, 20, "Enemy");
        
        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), 100, 1000/20);
        score = 0;
        
        
        
        
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.BLACK);
            
        g.setColor(Color.YELLOW);
        drawStars(g);
        
        hero.draw(g);
        enemy.draw(g);
        enemy2.draw(g);
        enemy3.draw(g);
        enemy4.draw(g);
        enemy5.draw(g);
        
        //g.dispose();     
    }
   
    
    private class ScheduleTask extends TimerTask {
    
        @Override
        public void run() {
            wallCollisions(hero);
           //wallCollisions(enemy);
           //wallCollisions(enemy2);
           //wallCollisions(enemy3);
           //wallCollisions(enemy4);
           //wallCollisions(enemy5);
            wallCollisionsCircle(enemy);
            wallCollisionsCircle(enemy2);
            wallCollisionsCircle(enemy3);
            wallCollisionsCircle(enemy4);
            wallCollisionsCircle(enemy5);
            heroVSEnemy();
            heroVSEnemy2();
            heroVSEnemy3();
            heroVSEnemy4();
            heroVSEnemy5();
            hero.update();
            enemy.update();
            enemy2.update();
            enemy3.update();
            enemy4.update();
            enemy5.update();
            repaint();
        }
    }
    
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            hero.setDX(4);
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            hero.setDX(-4);
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP) {
            hero.setDY(-4);
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            hero.setDY(4);
        }
        
    }
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            hero.setDX(0);
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            hero.setDX(0);
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP) {
            hero.setDY(0);
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            hero.setDY(0);
        }
        
    }
    
    
    private void drawStars(Graphics g) {
        int x = 0;
        int y = 0;
        //int score = 0;
        score += 1;
        g.drawString("Score: "+ score, 25, 25);
        for (int i = 0; i < 1000; i++) {
          y = (int) (Math.random()*960);
          x = (int) (Math.random()*1200);
          Color curr = g.getColor();
          if (x % 2 == 0) 
              g.setColor(curr.brighter());
          else
              g.setColor(curr.darker());
          g.fillOval(x, y, 3, 3);
          
          System.out.println(x+" "+y);
          //if ( x > 1100 || y > 860) {
           //  break;
          //}
            
        }
    }
    private void heroVSEnemy() {
        if (hero.getX()+ 40 >= enemy.getX() && hero.getY() +40 >= enemy.getY()) {
            if (hero.getX() <= enemy.getX() + 40 && hero.getY() <= enemy.getY() + 40) {
                enemy.kill(hero);
                enemy.setX(-2000);
        }
     }
}
        private void heroVSEnemy2() {
        if (hero.getX()+ 40 >= enemy2.getX() && hero.getY() +40 >= enemy2.getY()) {
            if (hero.getX() <= enemy2.getX() + 40 && hero.getY() <= enemy2.getY() + 40) {
                enemy2.kill(hero);
                enemy2.setX(-2000);
        }
     }
}
        private void heroVSEnemy3() {
        if (hero.getX()+ 40 >= enemy3.getX() && hero.getY() +40 >= enemy3.getY()) {
            if (hero.getX() <= enemy3.getX() + 40 && hero.getY() <= enemy3.getY() + 40) {
                enemy3.kill(hero);
                enemy3.setX(-2000);
        }
     }
}
        private void heroVSEnemy4() {
        if (hero.getX()+ 40 >= enemy4.getX() && hero.getY() +40 >= enemy4.getY()) {
            if (hero.getX() <= enemy4.getX() + 40 && hero.getY() <= enemy4.getY() + 40) {
                enemy4.kill(hero);
                enemy4.setX(-2000);
        }
     }
}
        private void heroVSEnemy5() {
        if (hero.getX()+ 40 >= enemy5.getX() && hero.getY() +40 >= enemy5.getY()) {
            if (hero.getX() <= enemy5.getX() + 40 && hero.getY() <= enemy5.getY() + 40) {
                enemy5.kill(hero);
                enemy5.setX(-2000);
        }
     }
}
    
private void wallCollisions (Character c) {
    //walls = this.getWidth(), this.getHeight(), 0
    //where the hero is = hero.getX(), hero.getY()
    if (c.getX() + c.getdx()< 0 || c.getX() + 20 >= this.getWidth() ) {
        c.reverseX();
    }
    if (c.getY() + c.getdy()< 0 || c.getY() + 20 >= this.getHeight() ) {
        c.reverseY();
    }
//TODO Implement this method


}
private boolean wallCollisionsCircle (Character c) {
    //walls = this.getWidth(), this.getHeight(), 0
    //where the hero is = hero.getX(), hero.getY()
    //left
    if (c.getX() + c.getdx() < 0){
        c.reverseX();
    }
    //right
        if (c.getX() + 20 >= this.getWidth() ) {           
        c.reverseX();
}
    //top
    if (c.getY() + c.getdy() < 0) {
c.reverseY();
}
//bottom
if (c.getY() + 20 >= this.getHeight() ) {
        c.reverseY();
    }
return true;
//TODO Implement this method


}
}