package JavaSnake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.ImagingOpException;

public class Gameplay extends JPanel implements KeyListener, ActionListener {
    private int[] snakexlength = new int[750];
    private int[] snakeYlength = new int [750];

    private boolean left = false;
    private boolean right = false;
    private boolean up = false;
    private boolean down = false;

    private ImageIcon rightmouth;
    private ImageIcon upmouth;
    private ImageIcon downmouth;
    private ImageIcon leftmouth;

    private int lengthofsnake = 3;
    private int moves = 0;

    private Timer timer;
    private int delay = 100;
    private ImageIcon snakeimage;



    private ImageIcon titleImage;

public Gameplay(){
addKeyListener(this);
setFocusable(true);
setFocusTraversalKeysEnabled(false);
timer= new Timer(delay, this);
timer.start();


}
public void paint(Graphics g){

    if(moves==0){
        snakexlength[2]=50;
        snakexlength[1]=75;
        snakexlength[0]=100;

        snakeYlength[2]=100;
        snakeYlength[1]=100;
        snakeYlength[0]=100;

    }

    //draw title image border
    g.setColor(Color.white);
    g.drawRect(24,10,851,55);

    //draw the title image
    titleImage = new ImageIcon("snaketitle.jpg");
    titleImage.paintIcon(this,g,25,11);

    //draw border for gameplay
    g.setColor(Color.white);
    g.drawRect(24,74,851,577);

    //draw background for gameplay
    g.setColor(Color.black);
    g.fillRect(25,75,850,575);

    rightmouth = new ImageIcon("rightmouth.png");
    rightmouth.paintIcon(this, g, snakexlength[0], snakeYlength[0]);


    for(int a=0; a< lengthofsnake; a++){
        if(a==0 && right){
            rightmouth = new ImageIcon("rightmouth.png");
            rightmouth.paintIcon(this,g,snakexlength[a],snakeYlength[a]);
        }
        if(a==0 && left){
            leftmouth = new ImageIcon("leftmouth.png");
            leftmouth.paintIcon(this,g,snakexlength[a],snakeYlength[a]);
        }
        if(a==0 && down){
            downmouth = new ImageIcon("downmouth.png");
            downmouth.paintIcon(this,g,snakexlength[a],snakeYlength[a]);
        }
        if(a==0 && up){
            upmouth = new ImageIcon("upmouth.png");
            upmouth.paintIcon(this,g,snakexlength[a],snakeYlength[a]);
        }
        if(a!=0){
            snakeimage = new ImageIcon("snakeimage.png");
            snakeimage.paintIcon(this,g,snakexlength[a],snakeYlength[a]);
            }
        }
    g.dispose();
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        if(right){
            for(int r = lengthofsnake-1; r>=0; r--){
                snakeYlength[r+1] = snakeYlength[r];
            }
            for(int r = lengthofsnake; r>=0; r--){
                if(r==0){
                    snakexlength[r]=snakexlength[r]+25;
            }
            else
            {
                snakexlength[r]=snakexlength[r-1];
            }
            if(snakexlength[r]>850) {
                snakexlength[r] = 25;
            }
            }
            repaint();
        }
        if(left){

        }
        if(up){

        }
        if(down){

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
    if(e.getKeyCode()==KeyEvent.VK_RIGHT){
        moves++;
        right = true;
        if(!left){
            right=true;
        }
        else
        {
            right=false;
            left= true;

        }


        up=false;
        down=false;

    }


        if(e.getKeyCode()==KeyEvent.VK_LEFT){
            moves++;
            left = true;
            if(!right){
                left=true;
            }
            else
            {
                left=false;
                right= true;

            }


            up=false;
            down=false;

        }


        if(e.getKeyCode()==KeyEvent.VK_UP){
            moves++;
            up = true;
            if(!down){
                up=true;
            }
            else
            {
                up=false;
                down= true;

            }


            left=false;
            right=false;

        }
        if(e.getKeyCode()==KeyEvent.VK_DOWN){
            moves++;
            down = true;
            if(!up){
                down=true;
            }
            else
            {
                up=true;
                down= false;

            }


            left=false;
            right=false;

        }




    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
